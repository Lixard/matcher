import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {ProjectsComponent} from "./projects/projects.component";
import {AuthGuard} from "../guards/auth.guard";
import {ProjectPageComponent} from "./project-page/project-page.component";

const routes: Routes = [
  {
    path: 'projects',
    component: ProjectsComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'profile/project/:projectId',
    component: ProjectPageComponent,
    canActivate: [AuthGuard]
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjectRoutingModule {
}
