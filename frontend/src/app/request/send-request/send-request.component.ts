import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {RequestModel} from "../../models/request/request.model";

@Component({
  selector: 'app-send-request',
  templateUrl: './send-request.component.html',
  styleUrls: ['./send-request.component.css']
})
export class SendRequestComponent implements OnInit {
  requestForm: FormGroup;
  request: RequestModel;

  constructor(private fb: FormBuilder,
              @Inject(MAT_DIALOG_DATA) public data: RequestModel) { }

  ngOnInit(): void {
    this.buildForm();
  }

  private buildForm(): void {
    this.requestForm = this.fb.group({
      message: this.fb.control(''),
    });
  }

  _request(requestForm: FormGroup): RequestModel {
    this.data.message = requestForm.controls.message.value;
    return this.data;
  }
}
