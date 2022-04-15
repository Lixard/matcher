import {Component, OnInit} from '@angular/core';
import {OrganizationModel} from "../../models/organizations/organization.model";
import {OrganizationService} from "../../services/organization.service";
import {ActivatedRoute} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {PictureService} from "../../services/picture.service";
import {MatDialog} from "@angular/material/dialog";
import {EditOrganizationComponent} from "../edit-organization/edit-organization.component";
import {ListOfEmployeesPageComponent} from "../list-of-employees-page/list-of-employees-page.component";
import {UserOrganizationService} from "../../services/user-organization.service";
import {UserOrganizationModel} from "../../models/users/user-organization";
import {ProjectService} from "../../services/project.service";
import {ProjectModel} from "../../models/project/project.model";

@Component({
  selector: 'app-company-profile-page',
  templateUrl: './company-profile-page.component.html',
  styleUrls: ['./company-profile-page.component.css']
})
export class CompanyProfilePageComponent implements OnInit {

  organization!: OrganizationModel;
  user!: UserOrganizationModel[];
  projectsOrganization: ProjectModel[];

  change: boolean = false;
  pictureType!: string;
  pictureData!: string;
  firstName!: string;
  lastName!: string;

  constructor(private userOrganizationService: UserOrganizationService,
              private organizationService: OrganizationService,
              private pictureService: PictureService,
              private route: ActivatedRoute,
              private authService: AuthService,
              private projectService: ProjectService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.authService.loadProfile().subscribe((u) => {
      this.organizationService.isAdmin(u.id, this.route.snapshot.params.orgId).subscribe((isAdmin) => {
        this.change = isAdmin;
      })
    });

    this.organizationService.getOrganization(this.route.snapshot.params.orgId).subscribe((organization) => {
      this.organization = organization;
      if (organization.organizationType == 'COMPANY') {
        this.organization.organizationType = 'Компания'
      } else if (organization.organizationType == 'UNIVERSITY') {
        this.organization.organizationType = 'Университет'
      }
      this.projectService.getProjectsByOrganization(this.organization.id).subscribe((projects) => {
        this.projectsOrganization = projects;
        console.log(this.projectsOrganization)
      })
    })

  }

  edit() {
    const dialogRef = this.dialog.open(EditOrganizationComponent, {
      width: '65%',
      height: '65%',
      data: this.organization
    });

    dialogRef.afterClosed().subscribe((result: OrganizationModel) => {
      result.id = this.organization.id;
      this.organizationService.updateOrganization(result).subscribe(() => {
        this.ngOnInit();
      })
    });
  }

  setPicture(): string {
    if (this.organization.pictureId === null) {
      return this.pictureService.getDefaultPictureUrl();
    } else {
      this.pictureService.getPicture(this.organization.pictureId).subscribe((picture) => {
        this.pictureType = picture.type;
        this.pictureData = picture.data;
      })
      return 'data:' + this.pictureType + ';base64,' + this.pictureData;
    }
  }

  openListOfEmployees() {
    const dialogRef = this.dialog.open(ListOfEmployeesPageComponent, {
      width: '25%',
      height: '45%',
      data: this.organization
    });
  }
}
