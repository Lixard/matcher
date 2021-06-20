import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AuthGuard} from "../guards/auth.guard";
import {CompanyProfilePageComponent} from "./company-profile-page/company-profile-page.component";

const routes: Routes = [
  {
    path: 'profile/organization/:orgId',
    component: CompanyProfilePageComponent,
    canActivate: [AuthGuard],
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class OrganizationRoutingModule { }
