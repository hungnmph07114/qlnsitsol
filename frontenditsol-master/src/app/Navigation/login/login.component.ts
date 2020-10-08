import { OathService } from './../../Service/oath.service';
import { LoginUser } from './../../model/loginuser';
import { TokenserviceService } from './../../Service/tokenservice.service';
import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginUser: LoginUser;
  userName: string;
  email: string;
  password: string;
  // socialUser: socialUser;
  // userLogged: SocialUser;
  isLogged: boolean;
  isLoginFailed = false;
  errMsj: string;
  roles: string[] = [];
  constructor(
    // private authService: SocialAuthService,
              private  router: Router,
              private oauthService: OathService,
              private tokenService: TokenserviceService,
              private toastr: ToastrService
  ) { }


  ngOnInit(): void {


  }
  onLogin(): void {
   
    this.loginUser = new LoginUser(this.userName, this.password);
    console.log(this.loginUser);
    this.oauthService.login(this.loginUser).subscribe(
      data => {
        this.isLogged = true;
        this.tokenService.setToken(data.token);
        this.tokenService.setUserName(data.userName);
        this.tokenService.setNhanVienid(data.nhanVienId);
        this.tokenService.setAuthorities(data.authorities);
     
        this.roles = data.authorities;
        this.toastr.success('Xin Chao ' + data.userName, 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/admin/home']);
      },
      err => {
        this.isLogged = false;
        this.errMsj = err.error.messanger;
        this.toastr.error(this.errMsj, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        // console.log(err.error.message);
      }
    );
  }


  logout(): void{
    this.tokenService.logOut();
    this.isLogged = false;
    // this.authService.signOut();
  }
}
