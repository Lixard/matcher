import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { PictureService } from '../../services/picture.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ProjectModel } from '../../models/project/project.model';
import { Observable } from 'rxjs';
import { OrganizationModel } from '../../models/organizations/organization.model';
import { map, startWith } from 'rxjs/operators';
import { ProjectService } from '../../services/project.service';
import { OrganizationService } from '../../services/organization.service';

@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.css']
})
export class EditProjectComponent implements OnInit {
  projectForm: FormGroup;
  orgCtrl = new FormControl();
  filteredPlace!: Observable<OrganizationModel[]>;
  organizations!: OrganizationModel[];
  file = false;
  fileName!: string;
  pictureId: number;
  userId!: number;
  lifecycle: string[];
  newPicture: File;
  loader = false;

  constructor(private fb: FormBuilder,
              private dialogRef: MatDialogRef<EditProjectComponent>,
              @Inject(MAT_DIALOG_DATA) public data: ProjectModel,
              private picturesService: PictureService,
              private projectService: ProjectService,
              private organizationService: OrganizationService) {
  }

  ngOnInit(): void {
    this.buildForm();
    this.setData();
  }

  private buildForm(): void {
    this.projectForm = this.fb.group({
      name: this.fb.control('', [Validators.required]),
      description: this.fb.control('', [Validators.required, Validators.minLength(8)]),
      place: this.fb.control(''),
      lifecycle: this.fb.control(this.data.lifecycle),
      currentLifecycle: this.fb.control('')
    });
  }

  setData() {
    this.lifecycle = this.data.lifecycle.split(',')
    this.projectForm.controls.name.setValue(this.data.name);
    this.projectForm.controls.description.setValue(this.data.description);
    this.projectForm.controls.currentLifecycle.setValue(this.data.currentLifecycle);
    this.organizationService.getOrganization(this.data.organizationId).subscribe(organ => {
      this.orgCtrl.setValue(organ.name);
      this.projectService.getAdminOrganizations(this.data.id).subscribe(org => {
        this.organizations = [];
        this.organizations = org;
        this.filteredPlace = this.orgCtrl.valueChanges.pipe(
          startWith(''),
          map(value => this._filter(value))
        );
      });
    });
  }

  public noWhitespaceValidator(control: FormControl) {
    const isWhitespace = (control.value || '').trim().length === 0;
    const isValid = !isWhitespace;
    return isValid ? null : { 'whitespace': true };
  }

  public onFileInput(event: any) {
    this.fileName = undefined;
    this.newPicture = event.target.files.item(0);
    this.fileName = this.newPicture.name;
  }

  _saveProject(projectForm: FormGroup): void {
    const project = projectForm.value as unknown as ProjectModel;
    project.active = this.data.active;
    project.organizationId = this.data.organizationId;
    for (const organization of this.organizations) {
      if (organization.name === this.orgCtrl.value) {
        project.organizationId = organization.id;
      }
    }
    project.id = this.data.id;

    if (this.newPicture) {
      this.loader = true;
      const newPic = this.newPicture;
      this.newPicture = undefined;
      this.picturesService.createPicture(newPic).subscribe(picture => {
        this.loader = false;
        project.picture = picture;
        this.dialogRef.close(project);
      });
    } else {
      project.picture = this.data.picture;
      this.dialogRef.close(project);
    }
  }

  private _filter(value: string) {
    const filterValue = value.toLowerCase();
    return this.organizations.filter(place => place.name.toLowerCase().includes(filterValue));
  }
}
