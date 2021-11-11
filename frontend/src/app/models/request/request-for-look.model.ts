import {User} from "../users/user.model";

export interface RequestForLookModel {
  id: number;
  user: User;
  message: string;
}
