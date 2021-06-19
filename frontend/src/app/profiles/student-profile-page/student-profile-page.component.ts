import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {UserService} from "../../services/user.service";
import {User} from "../../models/users/user.model";

@Component({
  selector: 'app-student-profile-page',
  templateUrl: './student-profile-page.component.html',
  styleUrls: ['./student-profile-page.component.css'],
})
export class StudentProfilePageComponent implements OnInit {

  userId!: any;
  user!: User;

  constructor(private authService: AuthService, private userService: UserService) {
  }

  ngOnInit(): void {
    this.authService.loadProfile().subscribe((u) => {
      this.userService.getUserData(u.id!).subscribe((userNow) => {
        console.log(userNow);
        this.user = userNow;
        if (this.user.userType == "STUDENT") {
          this.user.userType = "Студент";
        }
        else if (this.user.userType == "WORKER") {
          this.user.userType = "Работник"
        }
      })
    },error => {
      console.log(error)
      });
  }
}
