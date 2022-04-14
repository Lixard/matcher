import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {User} from "../models/users/user.model";
import {Picture} from "../models/picture/picture.model";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getUserData(userId: number): Observable<User> {
    return this.http.get<User>(`/api/users/${userId}`)
  }

  updateUser(user: User): Observable<void> {
    return this.http.put<void>(`api/users/${user.id}`, user);
  }

  getPicture(pictureId: number): Observable<Picture> {
    return this.http.get<Picture>(`api/pictures/picture/${pictureId}`);
  }

  updateUserOrganization(userId: number, place: string): Observable<void> {
    return this.http.post<void>(`api/users/organization`, {userId, place});
  }

  addCompetenciesToUser(userId: number, competencies: string[]): Observable<void> {
    return this.http.post<void>(`api/users/${userId}/competencies`, competencies);
  }

  deleteCompetenceFromUser(userId: number, competenceId: number): Observable<void> {
    return this.http.delete<void>(`api/users/${userId}/competencies/${competenceId}`);
  }

  getAllUserCompetencies(userId: number): Observable<string[]> {
    return this.http.get<string[]>(`api/users/${userId}/competencies`);
  }
}
