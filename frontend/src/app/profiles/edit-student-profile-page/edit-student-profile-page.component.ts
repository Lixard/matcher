import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {OrganizationService} from "../../services/organization.service";
import {OrganizationModel} from "../../models/organizations/organization.model";
import {Observable} from "rxjs";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {User} from "../../models/users/user.model";
import {UserService} from "../../services/user.service";
import {map, startWith} from "rxjs/operators";
import {PictureService} from "../../services/picture.service";

@Component({
  selector: 'app-edit-student-profile-page',
  templateUrl: './edit-student-profile-page.component.html',
  styleUrls: ['./edit-student-profile-page.component.css']
})
export class EditStudentProfilePageComponent implements OnInit {

  form!: FormGroup;
  employments: string[] = ['STUDENT', 'EMPLOYEE'];
  emailPattern = '^[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}$';
  namePattern = '^[a-zA-ZA-Яa-я]{1,}';
  places!: OrganizationModel[];
  filteredPlace!: Observable<OrganizationModel[]>;
  placeCtrl = new FormControl();
  student!: boolean;
  file: boolean = false;
  fileName!: string;
  pictureId: number;

  constructor(private fb: FormBuilder, private auth: AuthService,
              @Inject(MAT_DIALOG_DATA) public data: User,
              private organizationService: OrganizationService,
              private picturesService: PictureService,
              private userService: UserService) { }

  ngOnInit(): void {
    this.buildForm();
    this.setData();
    this.selectEmployment();
  }

  private buildForm(): void {
    this.form = this.fb.group({
      firstName: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.namePattern),Validators.maxLength(50)]),
      lastName: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.namePattern),Validators.maxLength(50)]),
      secondName: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.namePattern),Validators.maxLength(50)]),
      email: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.emailPattern), Validators.maxLength(50)]),
      userType: this.fb.control(''),
      place: this.fb.control(''),
      orgTypeId: this.fb.control(''),
      picture: this.fb.control('')
    });
  }

  private setData() {
    this.form.controls.firstName.setValue(this.data.firstName);
    this.form.controls.lastName.setValue(this.data.lastName);
    this.form.controls.secondName.setValue(this.data.secondName);
    this.form.controls.email.setValue(this.data.email);
    this.form.controls.employment.setValue(this.data.userType);
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
      (error: any) => {
      console.log(error);
        this.fileName = "Не удалось загрузить";
      });
  }

  selectEmployment() {
    if (this.form.controls.userType.value == 'STUDENT'){
      this.organizationService.getOrganization(1).subscribe(universities => {
        this.places = [];
        this.places = universities;
        this.filteredPlace = this.placeCtrl.valueChanges.pipe(
          startWith(''),
          map(value => this._filter(value))
        );
      });
    } else {
      this.organizationService.getOrganization(2).subscribe(companies => {
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

  updateUser(form: User) {
    form.id = this.data.id;
    if(this.pictureId) {
      form.pictureId = this.pictureId;
    }
    return form;
  }
}
