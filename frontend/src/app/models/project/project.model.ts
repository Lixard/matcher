import { Picture } from '../picture/picture.model';

export interface Project {
  id: number;
  picture: Picture;
  name: string;
  description: string;
  active: boolean;
}
