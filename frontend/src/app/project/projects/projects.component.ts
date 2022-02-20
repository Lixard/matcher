import { Component, OnInit } from '@angular/core';
import { ProjectModel } from '../../models/project/project.model';
import { ProjectService } from '../../services/project.service';
import { Picture } from '../../models/picture/picture.model';
import { PictureService } from '../../services/picture.service';
import {Router} from "@angular/router";
import {CreateProjectComponent} from "../create-project/create-project.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  projects: ProjectModel[];
  picture: Picture;

  constructor(private projectService: ProjectService,
              private pictureService: PictureService,
              public dialog: MatDialog,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllProjects();
  }

  getAllProjects() {
    this.projectService.getAllProjects().subscribe(
      res => {
        this.projects = res;
      }
    );
  }

  navigateToProject(projectId: number) {
    this.router.navigateByUrl(`/profile/project/${projectId}`);
  }

  createProject() {
    const dialogRef = this.dialog.open(CreateProjectComponent, {
      width: '80%',
      height: '80%'
    });

    dialogRef.afterClosed().subscribe((result) => {
      this.projectService.createProject(result).subscribe(() => {
        this.ngOnInit();
      })
    });
  }

  setPicture(project: ProjectModel): string {
    if (project.picture === null) {
      return this.pictureService.getDefaultPictureUrl();
    } else {
      return 'data:' + project.picture.type + ';base64,' + project.picture.data;
    }
  }
}
