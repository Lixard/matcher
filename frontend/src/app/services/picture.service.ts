import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Picture } from '../models/picture/picture.model';

@Injectable({
  providedIn: 'root'
})
export class PictureService {

  constructor(private http: HttpClient) {
  }

  createPicture(file: File): Observable<Picture> {
    const formData: FormData = new FormData();
    formData.append('file', file);
    return this.http.post<Picture>(`api/pictures/create`, formData);
  }

  getPicture(pictureId: number): Observable<Picture> {
    return this.http.get<Picture>(`api/pictures/picture/${pictureId}`);
  }

  getDefaultPictureUrl(): string {
    return "https://sun9-6.userapi.com/impg/6Im8y-x7TNREGEyCmuOfonopIQoJXiGX8G6a5Q/xUFVT81Sz-8.jpg?size=256x256&quality=96&sign=2ad339c6d3b66f34103777c7a342ff59&type=album";
  }
}
