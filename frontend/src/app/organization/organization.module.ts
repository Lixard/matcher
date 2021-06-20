import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AddOrganizationComponent} from "./add-organization/add-organization.component";
import {MatDialogModule} from "@angular/material/dialog";
import {MatButtonModule} from "@angular/material/button";
import {MatSelectModule} from "@angular/material/select";
import {ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatCardModule} from "@angular/material/card";
import {CompanyProfilePageComponent} from "./company-profile-page/company-profile-page.component";
import {MatIconModule} from "@angular/material/icon";
import {OrganizationRoutingModule} from "./organization-routing.module";
import { EditOrganizationComponent } from './edit-organization/edit-organization.component';

@NgModule({
  declarations: [AddOrganizationComponent, CompanyProfilePageComponent, EditOrganizationComponent],
  entryComponents: [EditOrganizationComponent],
  imports: [
    CommonModule,
    MatDialogModule,
    OrganizationRoutingModule,
    MatButtonModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatInputModule,
    MatCardModule,
    MatIconModule
  ]
})
export class OrganizationModule { }
