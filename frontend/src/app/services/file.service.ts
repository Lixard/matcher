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

  createFile(files: File[], projectId: number): Observable<HttpEvent<FileModel>> {
    const formData: FormData = new FormData();
    for (let i = 0; i < files.length; i++) {
      const fileToUpload = files[i];
      formData.append('file', fileToUpload);
    }

    const req = new HttpRequest('POST', `api/projects/${projectId}/files`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);

  }

  getFilesByProject(projectId: number): Observable<FileModel[]> {
    return this.http.get<FileModel[]>(`api/projects/${projectId}/files`);
  }

  deleteFile(projectId: number, fileId: number): Observable<FileModel> {
    return this.http.delete<FileModel>(`api/projects/${projectId}/files/${fileId}`);
  }

  downloadFileById(projectId: number, fileId: number): Observable<Blob> {
    return this.http.get(`api/projects/${projectId}/files/${fileId}`, {responseType: 'blob'});
  }
}
