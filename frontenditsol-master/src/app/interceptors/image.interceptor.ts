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
export class ImageInterceptor implements HttpInterceptor {

  constructor(private tokenService: TokenserviceService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = request;
    const token = this.tokenService.getToken();
    if (token != null) {
      authReq = authReq.clone({url: request.url.replace("http://", "https://")});
    }
    return next.handle(authReq);
    
  }
}

export const imageInterceptor = [ {provide: HTTP_INTERCEPTORS, useClass: ImageInterceptor, multi: true}];
