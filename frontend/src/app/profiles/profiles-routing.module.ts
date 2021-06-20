import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentProfilePageComponent } from './student-profile-page/student-profile-page.component';
import { AuthGuard } from '../guards/auth.guard';
import {EditStudentProfilePageComponent} from "./edit-student-profile-page/edit-student-profile-page.component";

const routes: Routes = [
  {
    path: 'user/:userId',
    component: StudentProfilePageComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'edit',
    component: EditStudentProfilePageComponent,
    canActivate: [AuthGuard],
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProfilesRoutingModule {}
