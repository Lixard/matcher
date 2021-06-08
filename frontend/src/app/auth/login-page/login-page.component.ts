import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginData } from '../../models/users/login-data.model';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'],
})
export class LoginPageComponent implements OnInit {

  form!: FormGroup;

  loginData!: LoginData;
  hidePassword = true;

  constructor(
    private formBuilder: FormBuilder,
    private auth: AuthService,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.buildForm();
  }

  login(form: LoginData) {
    this.auth
      .login(form)
      .pipe(switchMap(() => this.auth.loadProfile()))
      .subscribe(
        (profile) => {
          console.log(profile);
          this.auth.user$.next(profile);
          this.router.navigateByUrl('/profile');
        },
        () => {
          this.form.setErrors({
            server: true,
          });
          this.form.controls.login.reset();
          this.form.controls.login.setErrors({
            'login-incorrect': true,
          });
          this.form.controls.password.reset();
          this.form.controls.password.setErrors({
            'login-incorrect': true,
          });
        },
      );
  }

  private buildForm() {
    this.form = this.formBuilder.group({
      login: this.formBuilder.control(undefined, [Validators.required]),
      password: this.formBuilder.control(undefined, [Validators.required]),
    });
  }
}
