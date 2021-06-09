import {Component, Input, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-user-menu',
  templateUrl: './user-menu.component.html',
  styleUrls: ['./user-menu.component.sass'],
})
export class UserMenuComponent implements OnInit {
  @Input()
  readonly user;

  constructor(private readonly currentUserService: AuthService) {}

  ngOnInit(): void {}

  handleLogoutClick(): void {
    this.currentUserService.logout().subscribe(
      () => {},
      (error) => console.error(error)
    );
  }
}
