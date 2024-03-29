import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import {map, startWith, switchMap} from 'rxjs/operators';
import { UserCreate } from '../../models/users/user-create.model';
import {Observable} from "rxjs";
import {userNameRegExp} from "../../features/validators/directives/username-validator.directive";
import {OrganizationService} from "../../services/organization.service";
import {MatDialog} from "@angular/material/dialog";
import {OrganizationModel} from "../../models/organizations/organization.model";
import {AddOrganizationComponent} from "../../organization/add-organization/add-organization.component";

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css'],
})
export class RegisterPageComponent implements OnInit {
  form!: FormGroup;
  employments: string[] = ['Студент', 'Работник'];
  isEmployment = false;
  emailPattern = '^[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}$';
  namePattern = '^[a-zA-ZA-Яa-я]{1,}';
  places!: OrganizationModel[];
  hidePassword = true;
  filteredPlace!: Observable<OrganizationModel[]>;
  placeCtrl = new FormControl();
  student!: boolean;
  successfully: boolean = false;
  userId!: number
  isAdmin: boolean = false;
  organization!: OrganizationModel;
  addOrganization: boolean = false;

  constructor(private fb: FormBuilder, private auth: AuthService, private router: Router,
              public dialog: MatDialog, private organizationService: OrganizationService) {}

  ngOnInit(): void {
    this.buildForm();
  }

  register(form: UserCreate) {
    form.place = this.placeCtrl.value;
    form.isAdmin = this.isAdmin;

    switch (form.employment) {
      case "Студент":
        form.employment = "Student"
        break
      default:
        form.employment = "Employee"
    }

    this.auth.register(form).subscribe(
      () => {
        this.auth
          .login(form)
          .pipe(switchMap(() => this.auth.loadProfile()))
          .subscribe(() => {
            this.auth.loadProfile().subscribe((profile) => {
              this.userId = profile.id as number;
              this.auth.user$.next(profile);
              this.successfully = true;
            });
          });
      },
      () => {
        this.form.controls.login.setErrors({
          'unknown-error': true,
        });
      },
    );
  }

  private buildForm(): void {
    this.form = this.fb.group({
      login: this.fb.control('', [Validators.required, userNameRegExp, this.noWhitespaceValidator, Validators.min(4)]),
      password: this.fb.control('', [Validators.required, Validators.minLength(8)]),
      firstName: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.namePattern),Validators.maxLength(50)]),
      lastName: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.namePattern),Validators.maxLength(50)]),
      secondName: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.namePattern),Validators.maxLength(50)]),
      email: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.emailPattern), Validators.maxLength(50)]),
      employment: this.fb.control(''),
      place: this.fb.control(''),
      startDate: this.fb.control(''),
      endDate: this.fb.control('')
    });
  }

  public noWhitespaceValidator(control: FormControl) {
    const isWhitespace = (control.value || '').trim().length === 0;
    const isValid = !isWhitespace;
    return isValid ? null : { 'whitespace': true };
  }

  selectEmployment() {
    this.isEmployment = true;
    if (this.form.controls.employment.value == 'Студент'){
      this.student = true;
      this.organizationService.getOrganizations(1).subscribe(universities => {
        this.places = [];
        this.places = universities;
        this.filteredPlace = this.placeCtrl.valueChanges.pipe(
          startWith(''),
          map(value => this._filter(value))
        );
      });
    } else {
      this.student = false;
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

  addPlace() {
    this.addOrganization = true;
    const dialogRef = this.dialog.open(AddOrganizationComponent, {
      width: '60%',
      height: '60%'
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.isAdmin = true;
        this.organization = result.value;
        this.organization.organizationType = this.convertOrganizationType(this.organization.organizationType)
        this.organizationService.createOrganization(this.organization).subscribe(() => {
          this.form.controls.place.setValue(this.organization.name);
          this.placeCtrl.setValue(this.organization.name);
        },
          (error) => {
            console.log(error);
          });
      }
    },
      () => {
        this.addOrganization = false;
      });
  }

  convertOrganizationType(orgType: string): string {
    if (orgType === 'COMPANY') {
      return 'Компания';
    } else if (orgType === 'UNIVERSITY') {
      return 'Университет';
    } else if (orgType === 'Компания') {
      return 'COMPANY';
    } else if (orgType === 'Университет') {
      return 'UNIVERSITY';
    } else {
      return ''
    }
  }
}
