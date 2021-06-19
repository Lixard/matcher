import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {userNameRegExp} from "../../features/validators/directives/username-validator.directive";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {OrganizationService} from "../../services/organization.service";
import {OrganizationModel} from "../../models/organizations/organization.model";
import {Observable} from "rxjs";

@Component({
  selector: 'app-edit-student-profile-page',
  templateUrl: './edit-student-profile-page.component.html',
  styleUrls: ['./edit-student-profile-page.component.css']
})
export class EditStudentProfilePageComponent implements OnInit {

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

  constructor(private fb: FormBuilder, private auth: AuthService, private router: Router,
              private organizationService: OrganizationService) { }

  ngOnInit(): void {
    this.buildForm()
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

}
