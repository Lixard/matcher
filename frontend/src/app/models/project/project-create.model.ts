export interface ProjectCreateModel {
  id: number;
  pictureId: number;
  name: string;
  description: string;
  lifecycle: string;
  active: boolean;
  userId: number;
}
