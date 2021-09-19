import {Component, Inject, OnInit} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {UserService} from '../../services/user.service';
import {User} from "../../models/users/user.model";
import {ActivatedRoute} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {EditStudentProfilePageComponent} from '../edit-student-profile-page/edit-student-profile-page.component';
import {OrganizationModel} from "../../models/organizations/organization.model";
import {UserOrganizationService} from '../../services/user-organization.service';
import {PictureService} from "../../services/picture.service";
import {Project} from "../../models/project/project.model";
import {ProjectService} from "../../services/project.service";

@Component({
  selector: 'app-student-profile-page',
  templateUrl: './student-profile-page.component.html',
  styleUrls: ['./student-profile-page.component.css'],
})
export class StudentProfilePageComponent implements OnInit {

  userId!: number;
  user!: User;
  change: boolean = false;
  organizations: OrganizationModel[];
  pictureData: string;
  pictureType: string;
  projects: Project[];

  constructor(private authService: AuthService,
              private userService: UserService,
              private userOrgService: UserOrganizationService,
              private projectService: ProjectService,
              private route: ActivatedRoute,
              public dialog: MatDialog,
              private pictureService: PictureService) {
  }

  ngOnInit(): void {
    this.authService.loadProfile().subscribe((u) => {
      if (this.route.snapshot.params.userId == u.id) {
        this.change = true;
      }
      this.userService.getUserData(this.route.snapshot.params.userId).subscribe((userNow) => {
        this.user = userNow;
        if (this.user.userType == "STUDENT") {
          this.user.userType = "Студент";
        } else if (this.user.userType == "EMPLOYEE") {
          this.user.userType = "Работник"
        }
        this.userOrgService.getUserOrganization(this.user.id).subscribe((organizationNow) => {
          this.organizations = organizationNow;
        })
        this.userService.getPicture(this.user.pictureId).subscribe((picture) => {
          this.pictureType = picture.type;
          this.pictureData = picture.data;
        })
        this.projectService.getProjectsByUserId(this.user.id).subscribe((projects) => {
          this.projects = projects;
        })
      })
    }, error => {
      console.log(error)
    });
  }

  edit() {
    const dialogRef = this.dialog.open(EditStudentProfilePageComponent, {
      width: '80%',
      height: '80%',
      data: this.user
    });

    dialogRef.afterClosed().subscribe((result) => {
      this.userService.updateUser(result).subscribe(() => {
        this.userService.updateUserOrganization(result.id, result.place).subscribe(() => {
          window.location.reload();
        })
      })
    });
  }

  setPicture(): string {
    if (this.user.pictureId === null) {
      return this.pictureService.getDefaultPictureUrl();
    } else {
      return 'data:' + this.pictureType + ';base64,' + this.pictureData;
    }
  }
}
