import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ProjectsComponent} from "./projects/projects.component";
import {ProjectRoutingModule} from "./project-routing.module";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {FlexLayoutModule} from "@angular/flex-layout";
import { ProjectPageComponent } from './project-page/project-page.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDialogModule} from "@angular/material/dialog";
import {ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import { EditProjectComponent } from './edit-project/edit-project.component';
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {MatOptionModule} from "@angular/material/core";
import { RolesInProjectComponent } from './roles-in-project/roles-in-project.component';
import {MatSelect, MatSelectModule} from "@angular/material/select";

@NgModule({
  declarations: [ProjectsComponent, ProjectPageComponent, CreateProjectComponent, EditProjectComponent, RolesInProjectComponent],
  entryComponents: [CreateProjectComponent, EditProjectComponent, RolesInProjectComponent],
  imports: [
    CommonModule,
    ProjectRoutingModule,
    MatCardModule,
    MatButtonModule,
    FlexLayoutModule,
    MatIconModule,
    MatFormFieldModule,
    MatDialogModule,
    ReactiveFormsModule,
    MatInputModule,
    MatSelectModule,
    MatAutocompleteModule,
    MatOptionModule
  ]
})
export class ProjectModule {
}
