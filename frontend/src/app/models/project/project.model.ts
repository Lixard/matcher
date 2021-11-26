import { Picture } from '../picture/picture.model';

export interface ProjectModel {
  id: number;
  picture: Picture;
  name: string;
  description: string;
  lifecycle: string;
  currentLifecycle: string;
  active: boolean;
  organizationId: number;
}
