import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {UserService} from "../../services/user.service";
import {User} from "../../models/users/user.model";
import {ActiveDescendantKeyManager} from "@angular/cdk/a11y";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-student-profile-page',
  templateUrl: './student-profile-page.component.html',
  styleUrls: ['./student-profile-page.component.css'],
})
export class StudentProfilePageComponent implements OnInit {

  userId!: any;
  user!: User;
  change: boolean = false;

  constructor(private authService: AuthService, private userService: UserService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.authService.loadProfile().subscribe((u) => {
      if (this.route.snapshot.params.userId == u.id) {
        this.change = true;
      }
      this.userService.getUserData(this.route.snapshot.params.userId).subscribe((userNow) => {
        console.log(userNow);
        this.user = userNow;
        if (this.user.userType == "STUDENT") {
          this.user.userType = "Студент";
        }
        else if (this.user.userType == "EMPLOYEE") {
          this.user.userType = "Работник"
        }
      })
    },error => {
      console.log(error)
      });
  }
}
