import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { OrganizationService } from '../../services/organization.service';
import { OrganizationModel } from '../../models/organizations/organization.model';
import { Observable } from 'rxjs';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { User } from '../../models/users/user.model';
import { map, startWith } from 'rxjs/operators';
import { PictureService } from '../../services/picture.service';
import { UserUpdate } from '../../models/users/user-update.model';


@Component({
  selector: 'app-edit-student-profile-page',
  templateUrl: './edit-student-profile-page.component.html',
  styleUrls: ['./edit-student-profile-page.component.css']
})
export class EditStudentProfilePageComponent implements OnInit {

  userForm: FormGroup;
  employments: string[] = ['STUDENT', 'EMPLOYEE'];
  emailPattern = '^[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}$';
  namePattern = '^[a-zA-ZA-Яa-я]{1,}';
  places!: OrganizationModel[];
  filteredPlace!: Observable<OrganizationModel[]>;
  placeCtrl = new FormControl();
  student!: boolean;
  fileName!: string;
  pictureId: number;
  imgError: boolean;
  newPicture: File;
  loader = false;

  constructor(private fb: FormBuilder, private auth: AuthService,
              private dialogRef: MatDialogRef<EditStudentProfilePageComponent>,
              @Inject(MAT_DIALOG_DATA) public data: User,
              private organizationService: OrganizationService,
              private picturesService: PictureService) {
  }

  ngOnInit(): void {
    this.buildForm();
    this.setData();
    this.selectEmployment();
  }

  private buildForm(): void {
    this.userForm = this.fb.group({
      firstName: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.namePattern), Validators.maxLength(50)]),
      lastName: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.namePattern), Validators.maxLength(50)]),
      secondName: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.namePattern), Validators.maxLength(50)]),
      email: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.emailPattern), Validators.maxLength(50)]),
      userType: this.fb.control(''),
      place: this.fb.control(''),
      picture: this.fb.control('')
    });
  }

  private setData() {
    this.userForm.controls.firstName.setValue(this.data.firstName);
    this.userForm.controls.lastName.setValue(this.data.lastName);
    this.userForm.controls.secondName.setValue(this.data.secondName);
    this.userForm.controls.email.setValue(this.data.email);
    this.userForm.controls.userType.setValue(this.data.userType);
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

  selectEmployment() {
    if (this.userForm.controls.userType.value == 'STUDENT') {
      this.organizationService.getOrganizations(1).subscribe(universities => {
        this.places = [];
        this.places = universities;
        this.filteredPlace = this.placeCtrl.valueChanges.pipe(
          startWith(''),
          map(value => this._filter(value))
        );
      });
    } else {
      this.organizationService.getOrganizations(2).subscribe(companies => {
        this.places = [];
        this.places = companies;
        this.filteredPlace = this.placeCtrl.valueChanges.pipe(
          startWith(''),
          map(value => this._filter(value))
        );
      });
    }
  }


  private _filter(value: string) {
    const filterValue = value.toLowerCase();
    return this.places.filter(place => place.name.toLowerCase().includes(filterValue));
  }

  updateUser(form: FormGroup): void {
    const user = form.value as unknown as UserUpdate;
    user.place = this.placeCtrl.value;
    user.id = this.data.id;
    if (this.newPicture) {
      this.loader = true;
      const newPic = this.newPicture;
      this.newPicture = undefined;
      this.picturesService.createPicture(newPic).subscribe(picture => {
        this.loader = false;
        user.pictureId = picture.id;
        this.dialogRef.close(user);
      });
    } else {
      user.pictureId = this.data.pictureId;
      this.dialogRef.close(user);
    }
  }
}
