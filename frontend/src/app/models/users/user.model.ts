export interface User {
  id: number;
  pictureId?: number;
  login: string;
  password: string;
  firstName: string;
  lastName: string;
  secondName?: string;
  email?: string;
  phone?: string;
}
