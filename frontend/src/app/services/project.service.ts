import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Project} from "../models/project/project.model";
import {Observable} from "rxjs";

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
}
