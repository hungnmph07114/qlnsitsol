import { Injectable } from '@angular/core';
import { TokenserviceService } from '../Service/tokenservice.service';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HTTP_INTERCEPTORS
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AdminInterceptor implements HttpInterceptor {

  constructor(private tokenService: TokenserviceService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = request;
    const token = this.tokenService.getToken();
    if (token != null && !authReq.url.includes("https://api.imgur.com/3/image")) {
      authReq = authReq.clone({headers: request.headers.set('Authorization', 'Bearer ' + token)});
    }
    return next.handle(authReq);
    
  }
}

export const productoInterceptor = [ {provide: HTTP_INTERCEPTORS, useClass: AdminInterceptor, multi: true}];
