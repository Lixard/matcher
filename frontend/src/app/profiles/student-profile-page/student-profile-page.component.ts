import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { UserService } from '../../services/user.service';
import { User } from '../../models/users/user.model';
import { ActivatedRoute } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { EditStudentProfilePageComponent } from '../edit-student-profile-page/edit-student-profile-page.component';
import { OrganizationModel } from '../../models/organizations/organization.model';
import { UserOrganizationService } from '../../services/user-organization.service';
import { PictureService } from '../../services/picture.service';
import { ProjectModel } from '../../models/project/project.model';
import { ProjectService } from '../../services/project.service';
import { Picture } from '../../models/picture/picture.model';

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
  projects: ProjectModel[];
  competencies: string[];
  pictureCache: Picture;
  isPictureProcessed = false;

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
        this.user.userType = this.convertUserType(this.user.userType)
        this.userOrgService.getUserOrganization(this.user.id).subscribe((organizationNow) => {
          this.organizations = organizationNow;
          this.user.place = organizationNow[0].name;
        });
        this.projectService.getProjectsByUserId(this.user.id).subscribe((projects) => {
          this.projects = projects;
        });
        this.userService.getAllUserCompetencies(this.user.id).subscribe((competencies) => {
          this.competencies = competencies;
        });

        if (this.user.pictureId) {
          this.pictureService.getPicture(this.user.pictureId).subscribe(picture => {
            this.pictureCache = picture;
            this.isPictureProcessed = true;
          });
        } else {
          this.isPictureProcessed = true;
        }
      });
    }, error => {
      console.log(error);
    });
  }

  edit() {
    const dialogRef = this.dialog.open(EditStudentProfilePageComponent, {
      width: '80%',
      height: '80%',
      data: this.user
    });

    dialogRef.afterClosed().subscribe((result) => {
      result.userType = this.convertUserType(result.userType)
      this.userService.updateUser(result).subscribe(() => {
        this.userService.updateUserOrganization(result.id, result.place).subscribe(() => {
          this.ngOnInit();
        });
      });
    });
  }

  setPicture(): string {
    if (this.pictureCache) {
      return this.pictureService.buildPictureSrcUrl(this.pictureCache);
    }
    if (!this.isPictureProcessed) {
      return '';
    }
    return this.pictureService.getDefaultPictureUrl();
  }

  convertUserType(orgType: string): string {
    if (orgType === 'STUDENT') {
      return 'Студент';
    } else if (orgType === 'EMPLOYEE') {
      return 'Работник';
    } else if (orgType === 'Студент') {
      return 'STUDENT';
    } else if (orgType === 'Работник') {
      return 'EMPLOYEE';
    } else {
      return ''
    }
  }
}
