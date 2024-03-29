import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ProjectModel} from "../models/project/project.model";
import {Observable} from "rxjs";
import {UserProject} from "../models/users/user-project.model";
import {OrganizationModel} from "../models/organizations/organization.model";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private http: HttpClient) {
  }

  createProject(project: ProjectModel): Observable<ProjectModel> {
    return this.http.post<ProjectModel>(`/api/projects`, project);
  }

  updateProject(projectId: number, project: ProjectModel): Observable<ProjectModel> {
    return this.http.put<ProjectModel>(`api/projects/${projectId}`, project);
  }

  deleteProject(projectId: ProjectModel) {
    this.http.delete(`api/projects/${projectId}`);
  }

  getAllProjects(): Observable<ProjectModel[]> {
    return this.http.get<ProjectModel[]>(`api/projects`);
  }

  getProject(projectId: number): Observable<ProjectModel> {
    return this.http.get<ProjectModel>(`api/projects/${projectId}`);
  }

  getParticipantsByProjectId(projectId: number): Observable<UserProject[]>{
    return this.http.get<UserProject[]>(`api/projects/participants/${projectId}`)
  }

  setEndDateIfCompleteProject(projectId: number): Observable<void> {
    return this.http.get<void>(`api/projects/complete/participants/${projectId}`)
  }

  admin(projectId: number, userId: number): Observable<void> {
    return this.http.get<void>(`api/projects/${projectId}/admin/${userId}`)
  }

  delete(projectId: number, userId: number): Observable<void> {
    return this.http.delete<void>(`api/projects/${projectId}/${userId}`)
  }

  deleteAdmin(projectId: number, userId: number): Observable<void> {
    return this.http.delete<void>(`api/projects/${projectId}/admin/${userId}`)
  }

  getAdminOrganizations(projectId: number): Observable<OrganizationModel[]> {
    return this.http.get<OrganizationModel[]>(`api/projects/${projectId}/organizations/admin`)
  }

  getProjectsByUserId(userId: number): Observable<ProjectModel[]> {
    return this.http.get<ProjectModel[]>(`api/projects/user/${userId}`)
  }

  updateUserRoleByProjectIdAndUserId(projectId: number, userId: number, userProject: UserProject): Observable<void> {
    return this.http.put<void>(`api/projects/${projectId}/${userId}`, userProject);
  }

  getProjectsByOrganization(orgId: number): Observable<ProjectModel[]> {
    return this.http.get<ProjectModel[]>(`api/projects/organization/${orgId}`)
  }
}
