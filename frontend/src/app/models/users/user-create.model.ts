export interface UserCreate {
  login: string;
  password: string;
  firstName: string;
  lastName: string;
  secondName?: string;
  email?: string;
  phone?: string;
  employment: string;
  place: string;
  startDate: string;
  endDate?: string;
  isAdmin: boolean;
}
