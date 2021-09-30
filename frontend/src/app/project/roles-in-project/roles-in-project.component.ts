import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {UserProject} from "../../models/users/user-project.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProjectModel} from "../../models/project/project.model";
import {ProjectService} from "../../services/project.service";

@Component({
  selector: 'app-roles-in-project',
  templateUrl: './roles-in-project.component.html',
  styleUrls: ['./roles-in-project.component.css']
})
export class RolesInProjectComponent implements OnInit {

  roleForm: FormGroup;

  constructor(private fb: FormBuilder,
              @Inject(MAT_DIALOG_DATA) public data,
              private projectService: ProjectService,) {
  }

  ngOnInit(): void {
    this.buildForm();
  }

  private buildForm(): void {
    this.roleForm = this.fb.group({
      role: this.fb.control('', [Validators.required]),
    });
  }

  updateUserRole() {
    let userUpdate = {
      userRole: this.roleForm.value.role,
    } as unknown as UserProject;
    console.log(userUpdate)
    this.projectService.updateUserRoleByProjectIdAndUserId(
      this.data.projectData.id,
      this.data.userData.id, userUpdate).subscribe(() => {
      window.location.reload()
    })
  }

}
