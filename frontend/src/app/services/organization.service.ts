import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {OrganizationModel} from "../models/organizations/organization.model";

@Injectable({
  providedIn: 'root'
})
export class OrganizationService {

  constructor(private http: HttpClient) { }

  getOrganization(typeId: number): Observable<OrganizationModel[]> {
    return this.http.get<OrganizationModel[]>(`api/organizations/type/${typeId}`);
  }
}
