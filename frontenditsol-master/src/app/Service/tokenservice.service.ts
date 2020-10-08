import { Injectable } from '@angular/core';
const USERNAME_KEY = 'AuthUserName';
const NhanVienId = 'NhanVienId';
const AUTHORITIES_KEY = 'AuthAuthorities';
const TOKEN_KEY = 'AuthToken';
@Injectable({
  providedIn: 'root'
})
export class TokenserviceService {

  roles: Array<string> = [];

  constructor() { }
  public getToken(): string {
    return localStorage.getItem(TOKEN_KEY);
  }

  public setToken(token: string): void {
    localStorage.removeItem(TOKEN_KEY);
    localStorage.setItem(TOKEN_KEY, token);
  }

  logOut(): void {
    localStorage.clear();
  }

  public setUserName(userName: string): void {
    localStorage.removeItem(USERNAME_KEY);
    localStorage.setItem(USERNAME_KEY, userName);
  }
  public setUserName2(userName: string): void {
    localStorage.removeItem(USERNAME_KEY);
    localStorage.setItem(USERNAME_KEY, userName);
  }
  public getUserName(): string {
    return localStorage.getItem(USERNAME_KEY);
  }
  public getNhanVienid(): string {
    return localStorage.getItem(NhanVienId);
  }
  public setNhanVienid(nhanVienId: string): void {
    localStorage.removeItem(NhanVienId);
    localStorage.setItem(NhanVienId, nhanVienId);
  }

  public setAuthorities(authorities: string[]): void {
    localStorage.removeItem(AUTHORITIES_KEY);
    localStorage.setItem(AUTHORITIES_KEY, JSON.stringify(authorities));
  }

  public getAuthorities(): string[] {
    this.roles = [];
    if (localStorage.getItem(AUTHORITIES_KEY)) {
      JSON.parse(localStorage.getItem(AUTHORITIES_KEY)).forEach(authority => {
        this.roles.push(authority.authority);
      });
    }
    return this.roles;
  }
}
