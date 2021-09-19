import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ProjectModel} from "../models/project/project.model";
import {Observable} from "rxjs";
import {UserProject} from "../models/users/user-project.model";

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

  subscribe(projectId: number, userId: number): Observable<void> {
    return this.http.get<void>(`api/projects/${projectId}/subscribe/${userId}`)
  }

  admin(projectId: number, userId: number): Observable<void> {
    return this.http.get<void>(`api/projects/${projectId}/admin/${userId}`)
  }
}
