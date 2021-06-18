import { Component, Input } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-user-menu',
  templateUrl: './user-menu.component.html',
  styleUrls: ['./user-menu.component.sass'],
})
export class UserMenuComponent {
  @Input()
  readonly user;

  constructor(private readonly currentUserService: AuthService) {}

  handleLogoutClick(): void {
    this.currentUserService
      .logout()
      .pipe(switchMap(() => this.currentUserService.loadProfile()))
      .subscribe((user) => this.currentUserService.user$.next(user));
  }
}
