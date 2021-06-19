import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ProjectsComponent} from "./projects/projects.component";
import {ProjectRoutingModule} from "./project-routing.module";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {FlexLayoutModule} from "@angular/flex-layout";

@NgModule({
  declarations: [ProjectsComponent],
  imports: [CommonModule, ProjectRoutingModule, MatCardModule, MatButtonModule, FlexLayoutModule]
})
export class ProjectModule {
}
