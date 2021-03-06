import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { LOAD_CURRENT_USER_INITIALIZER } from '../services/auth.service';
import { ReactiveFormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { RouterModule } from '@angular/router';
import {MatSelectModule} from "@angular/material/select";
import {MatNativeDateModule, MatOptionModule} from "@angular/material/core";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {UserMenuComponent} from "./user-menu/user-menu.component";
import {MatMenuModule} from "@angular/material/menu";
import {ValidationModule} from "../features/validators/validation.module";
import {MatStepperModule} from "@angular/material/stepper";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {AddOrganizationComponent} from "../organization/add-organization/add-organization.component";

@NgModule({
  declarations: [LoginPageComponent, RegisterPageComponent, UserMenuComponent],
  entryComponents: [AddOrganizationComponent],
  imports: [
    RouterModule,
    CommonModule,
    AuthRoutingModule,
    MatIconModule,
    MatFormFieldModule,
    MatCardModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    MatMenuModule,
    ValidationModule,
    MatSelectModule,
    MatOptionModule,
    MatAutocompleteModule,
    MatStepperModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers: [
    LOAD_CURRENT_USER_INITIALIZER,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  exports: [
    UserMenuComponent
  ]
})
export class AuthModule {}
