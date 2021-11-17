import {Component, Inject, OnInit} from '@angular/core';
import {FileService} from "../../services/file.service";
import {MAT_DIALOG_DATA, MatDialog} from "@angular/material/dialog";
import {FileModel} from "../../models/file/file.model";
import {formatDate} from "@angular/common";
import {saveAs} from 'file-saver';

@Component({
  selector: 'app-files-page',
  templateUrl: './files-page.component.html',
  styleUrls: ['./files-page.component.css']
})
export class FilesPageComponent implements OnInit {

  isAdmin: boolean;
  filesCreation: File[];
  file: boolean = false;
  fileName: string;
  fileId: number;
  files: FileModel[];
  errorMessage: string;
  isError: boolean;

  constructor(@Inject(MAT_DIALOG_DATA) public data,
              private fileService: FileService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    console.log(this.data.projectData.id);
    this.fileService.getFilesByProject(this.data.projectData.id).subscribe((result) => {
      result.forEach(value => {
        value.createdAt = formatDate(value.createdAt, "d.MM.yyyy в HH:mm", 'en_US');
      });
      this.files = result;
    }, error => {
      console.log(error)
    });
    this.isAdmin = this.data.isUserAdmin;
  }

  getReadableFileSizeString(fileSizeInBytes: number) {
    let i = -1;
    const byteUnits = [' КБ', ' МБ', ' ГБ'];
    do {
      fileSizeInBytes = fileSizeInBytes / 1024;
      i++;
    } while (fileSizeInBytes > 1024);
    return Math.max(fileSizeInBytes, 0.1).toFixed(1) + byteUnits[i];
  };

  public onFileInput(event: any) {
    this.filesCreation = event.target.files;
    if (event.body != undefined) {
      this.fileId = event.body.id;
    }
    this.file = true;
    this.fileName = "";
    for (let i = 0; i < event.target.files.length; i++) {
      this.fileName += event.target.files.item(i).name + "\n";
    }
  }

  public createFile() {
    this.fileService.createFile(this.filesCreation, this.data.projectData.id).subscribe(() => {
      this.file = false;
        this.isError = false;
        this.ngOnInit();
      },
      (error) => {

        console.log(error);
        this.isError = true;
        this.errorMessage = "Не удалось загрузить файл!";
      });
  }

  public deleteFile(projectId: number, fileId: number) {
    this.fileService.deleteFile(projectId, fileId).subscribe(() => {
      this.ngOnInit();
    }, (error) => {
      console.log(error);
    });
  }

  public downloadFile(projectId: number, fileId: number, fileName: string) {
    this.fileService.downloadFileById(projectId, fileId).subscribe((blob) => {
      saveAs(blob, fileName);
    }, (error) => {
      console.log(error)
    });
  }

}
