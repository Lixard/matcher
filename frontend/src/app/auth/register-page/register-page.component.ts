import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import {map, startWith, switchMap} from 'rxjs/operators';
import { UserCreate } from '../../models/users/user-create.model';
import {Observable} from "rxjs";
import {OrganizationService} from "../../services/organization.service";
import {OrganizationModel} from "../../models/organizations/organization.model";

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css'],
})
export class RegisterPageComponent implements OnInit {
  form!: FormGroup;
  employments: string[] = ['Студент', 'Работник'];
  isEmployment = false;
  places!: OrganizationModel[];
  hidePassword = true;
  filteredPlace!: Observable<OrganizationModel[]>;
  placeCtrl = new FormControl()

  constructor(private fb: FormBuilder, private auth: AuthService, private router: Router,
              private organizationService: OrganizationService) {}

  ngOnInit(): void {
    this.buildForm();
  }

  register(form: UserCreate) {
    this.auth.register(form).subscribe(
      () => {
        this.auth
          .login(form)
          .pipe(switchMap(() => this.auth.loadProfile()))
          .subscribe(() => {
            this.auth.loadProfile().subscribe((profile) => {
              this.auth.user$.next(profile);
              this.router.navigateByUrl(`/profile`);
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
      login: this.fb.control('', [Validators.required, Validators.maxLength(50)]),
      password: this.fb.control('', [Validators.required, Validators.minLength(8)]),
      firstName: this.fb.control('', [Validators.required, Validators.maxLength(50)]),
      lastName: this.fb.control('', [Validators.required, Validators.maxLength(50)]),
      secondName: this.fb.control('', [Validators.maxLength(50)]),
      email: this.fb.control('', [Validators.maxLength(50), Validators.email]),
      employment: this.fb.control(''),
      place: this.fb.control('')
    });
  }

  selectEmployment() {
    this.isEmployment = true;
    if (this.form.controls.employment.value == 'Студент'){
      this.organizationService.getOrganization(1).subscribe(universities => {
        this.places = universities;
      });
    } else {
      this.organizationService.getOrganization(2).subscribe(companies => {
        this.places = companies;
      });
    }
    this.filteredPlace = this.placeCtrl.valueChanges.pipe(
    startWith(''),
    map(value => this._filter(value))
    );
  }

  private _filter(value: string) {
    const filterValue = value.toLowerCase();
    return this.places.filter(place => place.name.toLowerCase().includes(filterValue));
  }
}
