import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Project} from "../models/project/project.model";
import {Observable} from "rxjs";
import {User} from "../models/users/user.model";
import {UserProject} from "../models/users/user-project.model";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private http: HttpClient) {
  }

  createProject(project: Project): Observable<Project> {
    return this.http.post<Project>(`/api/projects`, project);
  }

  updateProject(projectId: number, project: Project): Observable<Project> {
    return this.http.put<Project>(`api/projects/${projectId}`, project);
  }

  deleteProject(projectId: Project) {
    this.http.delete(`api/projects/${projectId}`);
  }

  getAllProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(`api/projects`);
  }

  getProject(projectId: number): Observable<Project> {
    return this.http.get<Project>(`api/projects/${projectId}`);
  }

  getParticipantsByProjectId(projectId: number): Observable<UserProject[]>{
    return this.http.get<UserProject[]>(`api/projects/participants/${projectId}`)
  }

  getProjectsByUserId(userId: number): Observable<Project[]> {
    return this.http.get<Project[]>(`api/projects/user/${userId}`)
  }
}
