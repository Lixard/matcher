import { Component } from '@angular/core';
import {AuthService} from "./services/auth.service";
import {CurrentUser} from "./models/users/current-user.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  user: CurrentUser;

  constructor(private readonly currentUserService: AuthService) {
  }

  ngOnInit(): void {
    this.currentUserService.user$.subscribe(user => {
      this.user = user;
    });
  }


}
