import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TokenDto } from '../model/token-dto';
import { UserDTO } from '../model/userdto';
import { JwtDTO } from '../model/jwtDto';
import { LoginUser } from '../model/loginuser';
import { Observable } from 'rxjs';
import {NewUser} from 'src/app/model/newuser';
const USERNAME_KEY = 'AuthUserName';
const AUTHORITIES_KEY = 'AuthAuthorities';
const TOKEN_KEY = 'AuthToken';
const cabecera = {headers: new HttpHeaders({'Content-Type' : 'application/json'})};
@Injectable({
  providedIn: 'root'
})
export class OathService {
  authURL = 'http://localhost:8080/auth/';

  oauthURL = 'http://localhost:8080/oauth/';

  constructor(private httpClient: HttpClient) { }

  public add(newUser: NewUser): Observable<any> {
    return this.httpClient.post<any>(this.authURL + 'add', newUser);
  }

  public login(loginUser: LoginUser): Observable<JwtDTO> {
    return this.httpClient.post<JwtDTO>(this.authURL + 'login', loginUser);
  }
  public google(tokenDto: TokenDto): Observable<TokenDto> {
    sessionStorage.removeItem(USERNAME_KEY);
    return this.httpClient.post<TokenDto>(this.oauthURL + 'google', tokenDto, cabecera);
  }
  public facebook(tokenDto: TokenDto): Observable<TokenDto> {
    sessionStorage.removeItem(USERNAME_KEY);
    return this.httpClient.post<TokenDto>(this.oauthURL + 'facebook', tokenDto, cabecera);
  }
}
