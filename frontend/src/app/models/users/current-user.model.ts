export interface AuthenticatedUser {
  id: number;
  username: string;
  authenticated: true;
}

export interface AnonymousUser {
  id: null;
  username: null;
  authenticated: false;
}

export type CurrentUser = AuthenticatedUser | AnonymousUser;
