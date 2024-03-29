import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProjectsComponent} from "./projects/projects.component";
import {ProjectRoutingModule} from "./project-routing.module";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {FlexLayoutModule} from "@angular/flex-layout";
import {ProjectPageComponent} from './project-page/project-page.component';
import {CreateProjectComponent} from './create-project/create-project.component';
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDialogModule} from "@angular/material/dialog";
import {ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {EditProjectComponent} from './edit-project/edit-project.component';
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {MatLineModule,MatOptionModule} from "@angular/material/core";
import {RolesInProjectComponent} from './roles-in-project/roles-in-project.component';
import {MatSelect, MatSelectModule} from "@angular/material/select";
import {FilesPageComponent} from './files-page/files-page.component';
import {SendRequestComponent} from "../request/send-request/send-request.component";
import {LookRequestComponent} from "../request/look-request/look-request.component";
import {MatListModule} from "@angular/material/list";
import {AddCompetenceDialogComponent} from './add-competence-dialog/add-competence-dialog.component';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';

@NgModule({
  declarations: [
    ProjectsComponent,
    ProjectPageComponent,
    CreateProjectComponent,
    EditProjectComponent,
    RolesInProjectComponent,
    FilesPageComponent,
    SendRequestComponent,
    LookRequestComponent,
    AddCompetenceDialogComponent
  ],
  entryComponents: [
    CreateProjectComponent,
    EditProjectComponent,
    RolesInProjectComponent,
    SendRequestComponent,
    LookRequestComponent,
    FilesPageComponent,
    AddCompetenceDialogComponent
  ],
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
    MatOptionModule,
    MatListModule,
    MatLineModule,
    MatProgressSpinnerModule
  ]
})
export class ProjectModule {
}
