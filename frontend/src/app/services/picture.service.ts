import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {Picture} from "../models/picture/picture.model";

@Injectable({
  providedIn: 'root'
})
export class PictureService {

  constructor(private http: HttpClient) { }

  createPicture(file: File): Observable<HttpEvent<Picture>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', `api/pictures/create`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);

  getPicture(pictureId: number): Observable<Picture> {
    return this.http.get<Picture>(`api/pictures/picture/${pictureId}`);
  }
}
