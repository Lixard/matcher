import {Component, Inject, OnInit} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {UserService} from '../../services/user.service';
import {User} from "../../models/users/user.model";
import {ActivatedRoute} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {EditStudentProfilePageComponent} from '../edit-student-profile-page/edit-student-profile-page.component';
import {OrganizationModel} from "../../models/organizations/organization.model";
import {UserOrganizationService} from '../../services/user-organization.service';

@Component({
  selector: 'app-student-profile-page',
  templateUrl: './student-profile-page.component.html',
  styleUrls: ['./student-profile-page.component.css'],
})
export class StudentProfilePageComponent implements OnInit {

  defaultPictureUrl: string = "https://sun9-6.userapi.com/impg/6Im8y-x7TNREGEyCmuOfonopIQoJXiGX8G6a5Q/xUFVT81Sz-8.jpg?size=256x256&quality=96&sign=2ad339c6d3b66f34103777c7a342ff59&type=album";

  userId!: number;
  user!: User;
  change: boolean = false;
  organizations: OrganizationModel[];
  pictureData: string;
  pictureType: string;

  constructor(private authService: AuthService, private userService: UserService, private userOrgService: UserOrganizationService, private route: ActivatedRoute,
              public dialog: MatDialog) {
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
      return this.defaultPictureUrl;
    } else {
      return 'data:' + this.pictureType + ';base64,' + this.pictureData;
    }
  }
}
