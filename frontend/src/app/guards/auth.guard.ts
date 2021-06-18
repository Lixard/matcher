import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';
import { CurrentUser } from '../models/users/current-user.model';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  user!: CurrentUser;
  private next: ActivatedRouteSnapshot;
  private state: RouterStateSnapshot;

  constructor(private router: Router, private auth: AuthService) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot,
  ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    this.next = next;
    this.state = state;
    this.auth.user$.subscribe((u) => (this.user = u));
    if (this.user.authenticated) {
      return true;
    } else {
      this.router.navigateByUrl('/login');
      return false;
    }
  }
}
