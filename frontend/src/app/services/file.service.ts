import {Injectable} from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {Picture} from "../models/picture/picture.model";
import {FileModel} from "../models/file/file.model";

@Injectable({
  providedIn: 'root'
})
export class FileService {

  constructor(private http: HttpClient) {
  }

  createFile(file: File): Observable<HttpEvent<Picture>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', `api/files/create`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);

  }

  getFile(fileId: number): Observable<FileModel> {
    return this.http.get<FileModel>(`api/files/file/${fileId}`);
  }

  getFilesByProject(projectId: number): Observable<FileModel[]> {
    return this.http.get<FileModel[]>(`api/files/project/${projectId}`);
  }
}
