import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {OrganizationModel} from "../models/organizations/organization.model";

@Injectable({
  providedIn: 'root'
})
export class OrganizationService {

  constructor(private http: HttpClient) { }

  getOrganizations(typeId: number): Observable<OrganizationModel[]> {
    return this.http.get<OrganizationModel[]>(`api/organizations/type/${typeId}`);
  }

  createOrganization(organization: OrganizationModel): Observable<void> {
    return this.http.post<void>(`api/organizations`, organization);
  }

  isAdmin (userId: number, orgId: number): Observable<boolean> {
    return this.http.get<boolean>(`api/organizations/admin/${userId}/${orgId}`)
  }

  getOrganization(orgId: number): Observable<OrganizationModel> {
    return this.http.get<OrganizationModel>(`api/organizations/${orgId}`);
  }

  updateOrganization(organization: OrganizationModel): Observable<void> {
    return this.http.put<void>(`api/organizations/${organization.id}`, organization);
  }
}
