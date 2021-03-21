import { APP_INITIALIZER, Injectable, Provider } from '@angular/core';
import { Observable, ReplaySubject } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { CurrentUser } from '../models/users/current-user.model';
import { LoginData } from '../models/users/login-data.model';
import { UserCreate } from '../models/users/user-create.model';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  readonly user$ = new ReplaySubject<CurrentUser>(1);

  constructor(private http: HttpClient) {}

  initialize(): Promise<void> {
    return new Promise<void>((resolve) => {
      this.loadProfile().subscribe((profile) => {
        this.user$.next(profile);
        resolve();
      });
    });
  }

  loadProfile(): Observable<CurrentUser> {
    return this.http.get<CurrentUser>(`/api/auth/this`);
  }

  login(data: LoginData): Observable<void> {
    const params = new HttpParams({
      fromObject: {
        username: data.login,
        password: data.password,
      },
    });

    const myHeaders = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
    });
    return this.http.post<void>('/api/auth/login', params.toString(), {
      headers: myHeaders,
    });
  }

  logout(): Observable<void> {
    return this.http.get<void>('/api/auth/logout');
  }

  register(user: UserCreate): Observable<void> {
    return this.http.post<void>('/api/users', user);
  }
}

export function loadCurrentUser(authService: AuthService): () => Promise<void> {
  return () => authService.initialize();
}

export const LOAD_CURRENT_USER_INITIALIZER: Provider = {
  provide: APP_INITIALIZER,
  useFactory: loadCurrentUser,
  multi: true,
  deps: [AuthService],
};
