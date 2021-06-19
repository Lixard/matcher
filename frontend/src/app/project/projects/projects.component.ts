import {Component, OnInit} from '@angular/core';
import {Project} from "../../models/project/project.model";
import {ProjectService} from "../../services/project.service";
import {Picture} from "../../models/picture/picture.model";
import {PictureService} from "../../services/picture.service";

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

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

  getProjectImage(project: Project): string {
    return "data:" + project.picture.type + ";base64," + project.picture.data;
  }
}
