import {Component, Inject, OnInit} from '@angular/core';
import {UserOrganizationModel} from "../../models/users/user-organization";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {OrganizationModel} from "../../models/organizations/organization.model";
import {UserOrganizationService} from "../../services/user-organization.service";

@Component({
  selector: 'app-list-of-employees-page',
  templateUrl: './list-of-employees-page.component.html',
  styleUrls: ['./list-of-employees-page.component.css']
})
export class ListOfEmployeesPageComponent implements OnInit {

  users: UserOrganizationModel[] = [];

  constructor(private userOrganizationService: UserOrganizationService,
              @Inject(MAT_DIALOG_DATA) public data: OrganizationModel) {

  }

  ngOnInit(): void {
    this.userOrganizationService.getUsersByOrganization(this.data.id).subscribe(usersByOrganization => {
      this.users = usersByOrganization;
    }, error => {
      console.log(error)
    })
  }

}
