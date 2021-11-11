import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {RequestService} from "../../services/request.service";
import {RequestForLookModel} from "../../models/request/request-for-look.model";
import {PictureService} from "../../services/picture.service";
import {Picture} from "../../models/picture/picture.model";

@Component({
  selector: 'app-look-request',
  templateUrl: './look-request.component.html',
  styleUrls: ['./look-request.component.css']
})
export class LookRequestComponent implements OnInit {
  requests: RequestForLookModel[] = [];
  picture: Picture;

  constructor(@Inject(MAT_DIALOG_DATA) public data: number,
              private requestService: RequestService,
              private pictureService: PictureService) { }

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

  setPicture(pictureId: number): string {
    if (pictureId === null) {
      return this.pictureService.getDefaultPictureUrl();
    } else {
      this.pictureService.getPicture(pictureId).subscribe((picture) => {
        this.picture = picture;
      })
      return 'data:' + this.picture.type + ';base64,' + this.picture.data;
    }
  }
}
