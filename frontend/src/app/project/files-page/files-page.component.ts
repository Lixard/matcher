import { Component, OnInit } from '@angular/core';
import {FileService} from "../../services/file.service";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-files-page',
  templateUrl: './files-page.component.html',
  styleUrls: ['./files-page.component.css']
})
export class FilesPageComponent implements OnInit {

  projectFileForm: FormGroup;
  file: boolean = false;
  fileName!: string;
  fileId: number;

  constructor(private fileService: FileService) { }

  ngOnInit(): void {
  }

  public onFileInput(event: any) {
    const file: File = event.target.files.item(0);
    this.fileService.createFile(file).subscribe((event: any) => {
        if (event.body != undefined) {
          this.fileId = event.body.id;
        }
        this.file = true;
        this.fileName = file.name;
      },
      () => {
        this.fileName = "Не удалось загрузить";
      });
  }

}
