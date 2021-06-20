import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {OrganizationModel} from "../../models/organizations/organization.model";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {PictureService} from "../../services/picture.service";

@Component({
  selector: 'app-edit-organization',
  templateUrl: './edit-organization.component.html',
  styleUrls: ['./edit-organization.component.css']
})
export class EditOrganizationComponent implements OnInit {
  organizationForm: FormGroup;
  emailPattern = '^[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}$';
  types: string[] = ['UNIVERSITY', 'COMPANY'];
  file: boolean = false;
  fileName!: string;
  pictureId: number;

  constructor(private fb: FormBuilder,
              @Inject(MAT_DIALOG_DATA) public data: OrganizationModel,
              private picturesService: PictureService) { }

  ngOnInit(): void {
    this.buildForm();
    this.setData();
  }

  private buildForm(): void {
    this.organizationForm = this.fb.group({
      name: this.fb.control('', [Validators.required]),
      description: this.fb.control('', [Validators.required, Validators.minLength(8)]),
      url: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.maxLength(200)]),
      address: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.maxLength(150)]),
      email: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.emailPattern), Validators.maxLength(50)]),
      organizationType: this.fb.control('')
    });
  }

  private setData() {
    this.organizationForm.controls.name.setValue(this.data.name);
    this.organizationForm.controls.description.setValue(this.data.description);
    this.organizationForm.controls.url.setValue(this.data.url);
    this.organizationForm.controls.email.setValue(this.data.email);
    this.organizationForm.controls.address.setValue(this.data.address);
    this.organizationForm.controls.organizationType.setValue(this.data.organizationType);
  }

  public noWhitespaceValidator(control: FormControl) {
    const isWhitespace = (control.value || '').trim().length === 0;
    const isValid = !isWhitespace;
    return isValid ? null : { 'whitespace': true };
  }

  _organization(organizationForm: OrganizationModel): OrganizationModel {
    if(this.pictureId) {
      organizationForm.pictureId = this.pictureId;
    }
    return organizationForm;
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

}
