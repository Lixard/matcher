import { Picture } from '../picture/picture.model';

export interface ProjectModel {
  id: number;
  picture: Picture;
  name: string;
  description: string;
  active: boolean;
}
