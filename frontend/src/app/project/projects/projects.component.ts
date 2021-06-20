import { Component, OnInit } from '@angular/core';
import { Project } from '../../models/project/project.model';
import { ProjectService } from '../../services/project.service';
import { Picture } from '../../models/picture/picture.model';
import { PictureService } from '../../services/picture.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  defaultPictureUrl: string = "https://sun9-6.userapi.com/impg/6Im8y-x7TNREGEyCmuOfonopIQoJXiGX8G6a5Q/xUFVT81Sz-8.jpg?size=256x256&quality=96&sign=2ad339c6d3b66f34103777c7a342ff59&type=album";

  projects: Project[];
  picture: Picture;

  constructor(private projectService: ProjectService,
              private pictureService: PictureService) {
  }

  ngOnInit(): void {
    this.getAllProjects();
  }

  getAllProjects() {
    this.projectService.getAllProjects().subscribe(
      res => {
        this.projects = res;
      }
    );
  }

  setPicture(project: Project): string {
    if (project.picture === null) {
      return this.defaultPictureUrl;
    } else {
      return 'data:' + project.picture.type + ';base64,' + project.picture.data;
    }
  }
}
