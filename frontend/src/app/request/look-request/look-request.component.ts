import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {RequestService} from "../../services/request.service";
import {RequestForLookModel} from "../../models/request/request-for-look.model";

@Component({
  selector: 'app-look-request',
  templateUrl: './look-request.component.html',
  styleUrls: ['./look-request.component.css']
})
export class LookRequestComponent implements OnInit {
  requests: RequestForLookModel[] = [];

  constructor(@Inject(MAT_DIALOG_DATA) public data: number,
              private requestService: RequestService) { }

  ngOnInit(): void {
    this.requestService.getRequests(this.data).subscribe(result => {
        this.requests = result;
      }
    )
  }

  accept(requestId: number) {
    this.requestService.accept(requestId).subscribe(() =>
      this.ngOnInit()
    )
  }


  delete(requestId: number) {
    this.requestService.remove(requestId).subscribe(() =>
      this.ngOnInit()
    )
  }
}
