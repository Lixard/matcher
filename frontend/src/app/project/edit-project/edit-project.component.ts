import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {PictureService} from "../../services/picture.service";
import {ProjectCreateModel} from "../../models/project/project-create.model";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {ProjectModel} from "../../models/project/project.model";
import {Picture} from "../../models/picture/picture.model";

@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.css']
})
export class EditProjectComponent implements OnInit {
  projectForm: FormGroup;
  file: boolean = false;
  fileName!: string;
  pictureId: number;
  userId!: number;

  constructor(private fb: FormBuilder,
              @Inject(MAT_DIALOG_DATA) public data: ProjectModel,
              private picturesService: PictureService) { }

  ngOnInit(): void {
    this.buildForm();
    this.setData();
  }

  private buildForm(): void {
    this.projectForm = this.fb.group({
      name: this.fb.control('', [Validators.required]),
      description: this.fb.control('', [Validators.required, Validators.minLength(8)])
    });
  }

  setData() {
    this.projectForm.controls.name.setValue(this.data.name);
    this.projectForm.controls.description.setValue(this.data.description);
  }

  public noWhitespaceValidator(control: FormControl) {
    const isWhitespace = (control.value || '').trim().length === 0;
    const isValid = !isWhitespace;
    return isValid ? null : { 'whitespace': true };
  }

  public onFileInput(event: any) {
    const file: File = event.target.files.item(0);
    this.picturesService.createPicture(file).subscribe((event: any) => {
        if (event.body != undefined) {
          this.pictureId = event.body.id;
        }
        this.file = true;
        this.fileName = file.name;
      },
      () => {
        this.fileName = "Не удалось загрузить";
      });
  }

  _project(projectForm: FormGroup): ProjectModel {
    const project = projectForm.value as unknown as ProjectModel;
    project.active = this.data.active;
    project.organizationId = this.data.organizationId;
    project.id = this.data.id;
    if (this.pictureId) {
      project.picture.id = this.pictureId;
    } else {
      project.picture = this.data.picture;
    }
    return project;
  }
}
