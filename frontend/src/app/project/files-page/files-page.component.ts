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
  target: any;

  constructor(@Inject(MAT_DIALOG_DATA) public data,
              private fileService: FileService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.fileService.getFilesByProject(this.data.projectData.id).subscribe((result) => {
      result.forEach(value => {
        value.createdAt = formatDate(value.createdAt, "d.MM.yyyy в HH:mm", 'en_US');
      });
      this.files = result;
    }, error => {
      console.log(error)
    });
    if (this.target) this.target.value = '';
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
    this.target = event.target || event.srcElement;
    this.filesCreation = event.target.files;
    if (event.body != undefined) {
      this.fileId = event.body.id;
    }
    this.file = true;
    this.fileName = "";
    Array.from(event.target.files).forEach((_files, id) => {
      this.fileName += event.target.files[id].name + '\n';
    });
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
        this.errorMessage = "Не удалось загрузить файл(ы)! Максимальный размер - 20МБ.";
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
