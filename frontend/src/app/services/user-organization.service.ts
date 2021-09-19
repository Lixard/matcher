import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {OrganizationModel} from "../models/organizations/organization.model";
import {UserOrganizationModel} from "../models/users/user-organization";

@Injectable({
  providedIn: 'root'
})
export class UserOrganizationService {

  constructor(private http: HttpClient) { }

  getUserOrganization(userId: number): Observable<OrganizationModel[]> {
    return this.http.get<OrganizationModel[]>(`api/organizations/user/${userId}`);
  }

  getUsersByOrganization(organizationId: number): Observable<UserOrganizationModel[]> {
    return this.http.get<UserOrganizationModel[]>(`api/organizations/${organizationId}/users`);
  }
}
