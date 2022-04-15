import {Component, OnInit} from '@angular/core';
import {ProjectService} from '../../services/project.service';
import {ProjectModel} from '../../models/project/project.model';
import {ActivatedRoute} from '@angular/router';
import {UserService} from '../../services/user.service';
import {UserProject} from '../../models/users/user-project.model';
import {PictureService} from '../../services/picture.service';
import {OrganizationService} from '../../services/organization.service';
import {OrganizationModel} from '../../models/organizations/organization.model';
import {MatDialog} from '@angular/material/dialog';
import {EditProjectComponent} from '../edit-project/edit-project.component';
import {AuthService} from '../../services/auth.service';
import {UserOrganizationService} from '../../services/user-organization.service';
import {RolesInProjectComponent} from '../roles-in-project/roles-in-project.component';
import {FilesPageComponent} from '../files-page/files-page.component';
import {RequestService} from '../../services/request.service';
import {SendRequestComponent} from '../../request/send-request/send-request.component';
import {RequestModel} from '../../models/request/request.model';
import {LookRequestComponent} from '../../request/look-request/look-request.component';
import {AddCompetenceDialogComponent} from "../add-competence-dialog/add-competence-dialog.component";

@Component({
  selector: 'app-project-page',
  templateUrl: './project-page.component.html',
  styleUrls: ['./project-page.component.css']
})
export class ProjectPageComponent implements OnInit {

  project: ProjectModel;
  organization: OrganizationModel;
  userId: number;
  users: UserProject[] = [];
  userAdmins: UserProject[] = [];
  isAdmin: boolean = false;
  isLast: boolean = true;
  isParticipant: boolean = false;
  isSubscribe: boolean = false;
  userOrganization: OrganizationModel;

  constructor(
    private projectService: ProjectService,
    private userService: UserService,
    private route: ActivatedRoute,
    private pictureService: PictureService,
    private organizationService: OrganizationService,
    public dialog: MatDialog,
    private readonly authService: AuthService,
    private readonly userOrgService: UserOrganizationService,
    private readonly requestService: RequestService,
  ) {
  }

  ngOnInit(): void {
    this.authService.loadProfile().subscribe((user) => {
      this.userId = user.id
      this.projectData();
      this.canSubscribe(this.userId, this.route.snapshot.params.projectId);
    })
  }

  projectData() {
    this.projectService.getProject(this.route.snapshot.params.projectId).subscribe(
      (projectNow) => {
        this.project = projectNow;
        this.getParticipants();
        this.getOrganization();
        this.getUserOrganization();
      },
      (error) => {
        console.error(error);
      },
    );
  }

  setPicture(): string {
    if (this.project.picture === null) {
      return this.pictureService.getDefaultPictureUrl();
    } else {
      return 'data:' + this.project.picture.type + ';base64,' + this.project.picture.data;
    }
  }

  getParticipants() {
    this.projectService.getParticipantsByProjectId(this.project.id).subscribe(
      (usersNow) => {
        for (let user of usersNow) {
          if (user.isAdmin) {
            this.userAdmins.push(user);
            if (this.userId == user.id) {
              this.isAdmin = true;
            }
          } else {
            this.users.push(user);
            if (this.userId == user.id) {
              this.isParticipant = true;
            }
          }
        }
        this.checkLast();
      },
      (error) => {
        console.error(error);
      },
    );
  }

  getOrganization() {
    this.organizationService.getOrganization(this.project.organizationId).subscribe(
      organization => {
        this.organization = organization;
      },
      (error) => {
        console.error(error);
      }
    )
  }

  complete() {
    this.project.active = false;
    let lifecycles = this.project.lifecycle.split(",");
    this.project.currentLifecycle = lifecycles[lifecycles.length - 1];
    this.projectService.updateProject(this.route.snapshot.params.projectId, this.project).subscribe(() => {
      this.projectService.setEndDateIfCompleteProject(this.route.snapshot.params.projectId).subscribe(() => {
        this.ngOnInit();
      })
      }
    )
    this.projectService
      .updateProject(this.route.snapshot.params.projectId, this.project)
      .subscribe(() => {
        this.projectService
          .setEndDateIfCompleteProject(this.route.snapshot.params.projectId)
          .subscribe(() => {
            this.ngOnInit();
          });
      });
  }

  edit() {
    const dialogRef = this.dialog.open(EditProjectComponent, {
      width: '65%',
      height: '65%',
      data: this.project,
    });

    dialogRef.afterClosed().subscribe((result: ProjectModel) => {
      console.log("closed update")
      console.log(result);
      console.log(result.picture)
      this.projectService.updateProject(this.route.snapshot.params.projectId, result).subscribe(() => {
        this.ngOnInit();
      })
      if (result.picture) {
        this.pictureService.getPicture(result.picture.id).subscribe((picture) => {
          result.picture = picture;
        });
      }
      console.log(result.picture);
      this.projectService
        .updateProject(this.route.snapshot.params.projectId, result)
        .subscribe(() => {
          this.ngOnInit();
        });
    });
  }

  subscribe() {
    const dialogRef = this.dialog.open(SendRequestComponent, {
      width: '40%',
      height: '30%',
      data: {
        projectId: this.route.snapshot.params.projectId,
        userId: this.userId,
      },
    });

    dialogRef.afterClosed().subscribe((result: RequestModel) => {
      this.requestService.subscribe(result).subscribe(() => {
        this.ngOnInit();
      });
    });
  }

  getUserOrganization() {
    this.userOrgService.getUserOrganization(this.userId).subscribe((organization) => {
      this.userOrganization = organization[0];
    });
  }

  admin(user: UserProject) {
    this.projectService.admin(this.route.snapshot.params.projectId, user.id).subscribe(() => {
      this.ngOnInit();
    });
  }

  delete(user: UserProject) {
    this.projectService.delete(this.route.snapshot.params.projectId, user.id).subscribe(() => {
      this.ngOnInit();
    })
  }

  deleteAdmin(user: UserProject) {
    this.projectService.deleteAdmin(this.route.snapshot.params.projectId, user.id).subscribe(() => {
      this.ngOnInit();
    })
  }

  openRoleOfUser(user: UserProject) {
    console.log(user);
    // @ts-ignore
    const dialogRef = this.dialog.open(RolesInProjectComponent, {
      width: '15%',
      height: '20%',
      dataProject: this.project,
      data: {
        userData: user,
        projectData: this.project,
      },
    });
  }

  openFilesOfProject() {
    const dialogRef = this.dialog.open(FilesPageComponent, {
      width: '100%',
      height: '80%',
      data: {
        projectData: this.project,
        isUserAdmin: this.isAdmin,
      },
    });
  }

  canSubscribe(userId: number, projectId: number) {
    this.requestService.canSubscribe(userId, projectId).subscribe((canSub) => {
      this.isSubscribe = canSub;
    });
  }

  look() {
    const dialogRef = this.dialog.open(LookRequestComponent, {
      width: '70%',
      height: '70%',
      data: this.route.snapshot.params.projectId,
    });

    dialogRef.afterClosed().subscribe(() => {
      this.ngOnInit();
    });
  }

  checkLast() {
    this.isLast = this.userAdmins.length == 1;
  }

  addCompetence(user: UserProject) {
    // @ts-ignore
    const dialogRef = this.dialog.open(AddCompetenceDialogComponent, {
      width: '20%',
      height: '10%',
      dataProject: this.project,
      data: {
        userData: user,
        projectData: this.project,
      },
    });
  }
}
