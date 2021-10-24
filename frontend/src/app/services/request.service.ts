import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RequestModel} from "../models/request/request.model";

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor(private http: HttpClient) {

  }

   canSubscribe (userId: number, projectId: number): Observable<boolean> {
    return this.http.get<boolean>(`api/request/check/${userId}/${projectId}`);
  }

  subscribe(request: RequestModel): Observable<RequestModel> {
    return this.http.post<RequestModel>(`api/request/subscribe`, request);
  }
}
