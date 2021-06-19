import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {ProjectsComponent} from "./projects/projects.component";
import {AuthGuard} from "../guards/auth.guard";

const routes: Routes = [
  {
    path: 'projects',
    component: ProjectsComponent,
    canActivate: [AuthGuard]
  },
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjectRoutingModule {
}
