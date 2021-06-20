export interface UserUpdate {
  id: number;
  pictureId?: number;
  firstName: string;
  lastName: string;
  secondName?: string;
  email?: string;
  phone?: string;
  userType: string;
  place: string;
}
