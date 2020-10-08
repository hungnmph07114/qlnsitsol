import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree,Router } from '@angular/router';
import { Observable } from 'rxjs';
import { TokenserviceService } from './../Service/tokenservice.service';
@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  realRole: string;

  constructor(
    private tokenService: TokenserviceService,
    private router: Router
  ) { };

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
      const expectedRole =  route.data.expectedRole;
      const roles = this.tokenService.getAuthorities();
      this.realRole = 'user';
      roles.forEach(role => {
        if(role === 'ROLE_ADMIN'){
          this.realRole = 'admin';
        }else if(role === 'ROLE_MANAGER'){
          this.realRole = 'manager';
        }
      });
      
      if(!this.tokenService.getToken() || expectedRole.indexOf(this.realRole) === -1){
        this.router.navigate(['/']);
        return false;
      }
    if (!this.tokenService.getToken()) {
      this.router.navigate(['/']);
      return false;
    }
    return true;
  }
  // canActivate(
  //   next: ActivatedRouteSnapshot,
  //   state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
  //   return true;
  // }
  
}
