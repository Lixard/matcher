import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {ProjectService} from "../../services/project.service";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-add-competence-dialog',
  templateUrl: './add-competence-dialog.component.html',
  styleUrls: ['./add-competence-dialog.component.css']
})
export class AddCompetenceDialogComponent implements OnInit {

  competenceForm: FormGroup;

  constructor(private fb: FormBuilder,
              @Inject(MAT_DIALOG_DATA) public data,
              private userService: UserService) {
  }

  ngOnInit(): void {
    this.buildForm();
  }

  private buildForm(): void {
    this.competenceForm = this.fb.group({
      competence: this.fb.control('', [Validators.required, Validators.pattern('[a-zA-Zа-яА-Я0-9,]*')]),
    });
  }

  addCompetencies() {
    const split = this.competenceForm.value.competence.split(',');
    this.userService.addCompetenciesToUser(this.data.userData.id, split).subscribe(() => {
      window.location.reload()
    })
  }
}
