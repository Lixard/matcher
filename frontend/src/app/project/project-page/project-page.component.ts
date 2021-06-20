import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ProjectService} from "../../services/project.service";
import {Project} from "../../models/project/project.model";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {User} from "../../models/users/user.model";
import {UserProject} from "../../models/users/user-project.model";

@Component({
  selector: 'app-project-page',
  templateUrl: './project-page.component.html',
  styleUrls: ['./project-page.component.css']
})
export class ProjectPageComponent implements OnInit {

  project: Project;
  projectId: number;
  activeProject: string;
  users: UserProject[] = [];
  userAdmins: UserProject[] = [];

  constructor(private projectService: ProjectService,
              private userService: UserService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.projectData();
  }

  projectData() {
    this.projectService.getProject(this.route.snapshot.params.projectId).subscribe((projectNow) => {
        this.project = projectNow;
        if (projectNow.isActive){
          this.activeProject = "Проект закрыт"
        }
        else {
          this.activeProject = "Проект актуален"
        }
        this.projectService.getParticipantsByProjectId(this.project.id).subscribe((usersNow)=>{
          for(let user of usersNow) {
            if(user.isAdmin) {
              this.userAdmins.push(user);
            } else {
              this.users.push(user);
            }
          }
        },
          (error) => {
            console.log(error);
          })
      },
      error => {
        console.log(error)
      })
  }

}
