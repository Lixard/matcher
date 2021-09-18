import {Component, OnInit} from '@angular/core';
import {ProjectService} from "../../services/project.service";
import {ProjectModel} from "../../models/project/project.model";
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../../services/user.service";
import {UserProject} from "../../models/users/user-project.model";
import {PictureService} from "../../services/picture.service";

@Component({
  selector: 'app-project-page',
  templateUrl: './project-page.component.html',
  styleUrls: ['./project-page.component.css']
})
export class ProjectPageComponent implements OnInit {

  project: ProjectModel;
  projectId: number;
  activeProject: string;
  users: UserProject[] = [];
  userAdmins: UserProject[] = [];

  constructor(private projectService: ProjectService,
              private userService: UserService,
              private route: ActivatedRoute,
              private pictureService: PictureService) {
  }

  ngOnInit(): void {
    this.projectData();
  }

  projectData() {
    this.projectService.getProject(this.route.snapshot.params.projectId).subscribe((projectNow) => {
        this.project = projectNow;
        this.isActiveProject(projectNow);
        this.getParticipants();
      },
      error => {
        console.error(error)
      })
  }

  setPicture(): string {
    if (this.project.picture === null) {
      return this.pictureService.getDefaultPictureUrl();
    } else {
      return 'data:' + this.project.picture.type + ';base64,' + this.project.picture.data;
    }
  }

  isActiveProject(project: ProjectModel) {
    if (project.active) {
      this.activeProject = "Проект актуален"
    } else {
      this.activeProject = "Проект закрыт"
    }
  }

  getParticipants() {
    this.projectService.getParticipantsByProjectId(this.project.id).subscribe(
      usersNow => {
        for (let user of usersNow) {
          if (user.isAdmin) {
            this.userAdmins.push(user);
          } else {
            this.users.push(user);
          }
        }
      },
      (error) => {
        console.error(error);
      })
  }
}
