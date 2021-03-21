import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { switchMap } from 'rxjs/operators';
import { UserCreate } from '../../models/users/user-create.model';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css'],
})
export class RegisterPageComponent implements OnInit {
  form!: FormGroup;

  hidePassword = true;

  constructor(private fb: FormBuilder, private auth: AuthService, private router: Router) {}

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
      login: this.fb.control(undefined, [Validators.required, Validators.maxLength(50)]),
      password: this.fb.control(undefined, [Validators.required, Validators.minLength(8)]),
      firstName: this.fb.control(undefined, [Validators.required, Validators.maxLength(50)]),
      lastName: this.fb.control(undefined, [Validators.required, Validators.maxLength(50)]),
      secondName: this.fb.control(undefined, [Validators.maxLength(50)]),
      email: this.fb.control(undefined, [Validators.maxLength(50), Validators.email]),
    });
  }
}
