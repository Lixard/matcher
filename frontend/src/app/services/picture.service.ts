import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Picture} from "../models/picture/picture.model";

@Injectable({
  providedIn: 'root'
})
export class PictureService {

  constructor(private http: HttpClient) {
  }

  getPicture(pictureId: number): Observable<Picture> {
    return this.http.get<Picture>(`api/pictures/picture/${pictureId}`);
  }
}
