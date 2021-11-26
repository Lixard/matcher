import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {PictureService} from "../../services/picture.service";
import {ProjectCreateModel} from "../../models/project/project-create.model";


@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit {
  projectForm: FormGroup;
  file: boolean = false;
  fileName!: string;
  pictureId: number;
  userId!: number;

  constructor(private fb: FormBuilder,
              private picturesService: PictureService,
              private readonly authService: AuthService) {
  }

  ngOnInit(): void {
    this.authService.loadProfile().subscribe((user) => {
      this.userId = user.id
    })
    this.buildForm();
  }

  private buildForm(): void {
    this.projectForm = this.fb.group({
      name: this.fb.control('', [Validators.required]),
      description: this.fb.control('', [Validators.required, Validators.minLength(8)]),
      lifecycle: this.fb.control('', [Validators.pattern('[a-zA-Z0-9,]*')])
    });
  }

  public noWhitespaceValidator(control: FormControl) {
    const isWhitespace = (control.value || '').trim().length === 0;
    const isValid = !isWhitespace;
    return isValid ? null : {'whitespace': true};
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

  _project(projectForm: FormGroup): ProjectCreateModel {
    const project = projectForm.value as unknown as ProjectCreateModel;
    if (this.pictureId) {
      project.pictureId = this.pictureId;
    }
    project.lifecycle = project.lifecycle.replace(/\s/g, "");
    project.userId = this.userId;
    return project
  }
}
