import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfilesRoutingModule } from './profiles-routing.module';
import { StudentProfilePageComponent } from './student-profile-page/student-profile-page.component';

@NgModule({
  declarations: [StudentProfilePageComponent],
  imports: [CommonModule, ProfilesRoutingModule],
})
export class ProfilesModule {}
