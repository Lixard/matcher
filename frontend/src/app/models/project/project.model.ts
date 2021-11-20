import { Picture } from '../picture/picture.model';

export interface ProjectModel {
  id: number;
  picture: Picture;
  name: string;
  description: string;
  lifecycle: string;
  current_lifecycle: string;
  active: boolean;
  organizationId: number;
}
