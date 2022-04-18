import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { PictureService } from '../../services/picture.service';
import { ProjectCreateModel } from '../../models/project/project-create.model';
import { MatDialogRef } from '@angular/material/dialog';


@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit {
  projectForm: FormGroup;
  fileName!: string;
  pictureId: number;
  userId!: number;
  newPicture: File;
  loader = false;
  imgError: boolean = false;

  constructor(private fb: FormBuilder,
              private picturesService: PictureService,
              private readonly authService: AuthService,
              private dialogRef: MatDialogRef<CreateProjectComponent>) {
  }

  ngOnInit(): void {
    this.authService.loadProfile().subscribe((user) => {
      this.userId = user.id;
    });
    this.buildForm();
  }

  private buildForm(): void {
    this.projectForm = this.fb.group({
      name: this.fb.control('', [Validators.required]),
      description: this.fb.control('', [Validators.required, Validators.minLength(8)]),
      lifecycle: this.fb.control('', [Validators.pattern('[a-zA-Zа-яА-Я0-9,]*')])
    });
  }

  public noWhitespaceValidator(control: FormControl) {
    const isWhitespace = (control.value || '').trim().length === 0;
    const isValid = !isWhitespace;
    return isValid ? null : {'whitespace': true};
  }

  public onFileInput(event: any) {
    this.fileName = undefined;
    this.newPicture = event.target.files.item(0);
    let mimeType = this.newPicture.type;
    if (!mimeType.startsWith("image/")) {
      this.imgError = true;
      this.newPicture = undefined;
    }
    else {
      this.fileName = this.newPicture.name;
      this.imgError = false;
    }
  }

  saveProject(projectForm: FormGroup): void {
    const project = projectForm.value as unknown as ProjectCreateModel;
    if (this.newPicture) {
      this.loader = true;
      const newPic = this.newPicture;
      this.newPicture = undefined;
      this.picturesService.createPicture(newPic).subscribe(picture => {
        this.loader = false;
        project.pictureId = picture.id;
        this.closeDialog(project);
      });
    } else {
      this.closeDialog(project);
    }
  }

  closeDialog(project): void {
    project.lifecycle = project.lifecycle.replace(/\s/g, '');
    project.userId = this.userId;
    this.dialogRef.close(project);
  }
}
