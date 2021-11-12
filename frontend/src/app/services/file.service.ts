import {Injectable} from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {FileModel} from "../models/file/file.model";

@Injectable({
  providedIn: 'root'
})
export class FileService {

  constructor(private http: HttpClient) {
  }

  createFile(file: File, projectId: number): Observable<HttpEvent<FileModel>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', `api/files/project/${projectId}/create`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);

  }

  getFile(fileId: number): Observable<FileModel> {
    return this.http.get<FileModel>(`api/files/file/${fileId}`);
  }

  getFilesByProject(projectId: number): Observable<FileModel[]> {
    return this.http.get<FileModel[]>(`api/projects/${projectId}/files`);
  }

  deleteFile(fileId: number): Observable<FileModel> {
    return this.http.delete<FileModel>(`api/files/${fileId}`);
  }

  downloadFileById(projectId: number, fileId: number): Observable<Blob> {
    return this.http.get(`api/projects/${projectId}/files/${fileId}`, {responseType: 'blob'});
  }
}
