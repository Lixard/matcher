import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ProfilesRoutingModule} from './profiles-routing.module';
import {StudentProfilePageComponent} from './student-profile-page/student-profile-page.component';
import {EditStudentProfilePageComponent} from './edit-student-profile-page/edit-student-profile-page.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatStepperModule} from "@angular/material/stepper";
import {MatSelectModule} from "@angular/material/select";
import {MatCardModule} from "@angular/material/card";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";

@NgModule({
  declarations: [StudentProfilePageComponent, EditStudentProfilePageComponent],
  imports: [
    CommonModule,
    MatFormFieldModule,
    ProfilesRoutingModule,
    MatToolbarModule,
    FormsModule,
    MatIconModule,
    MatStepperModule,
    MatSelectModule,
    MatCardModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule
  ],
})
export class ProfilesModule {
}
