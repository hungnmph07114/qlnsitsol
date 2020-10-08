import { HeSoLuong } from './../model/hesoluong';
import { TamUng } from './../model/tamung';
import { KhenThuongKl } from './../model/khenthuong';
import { KyLuat } from './../model/kyluat';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PhuCap } from '../model/phucap';

@Injectable({
  providedIn: 'root'
})
export class LuongService {
  luongURL = 'http://localhost:8080/luong';
  luongURL1 = 'http://localhost:8080/luong?';
  constructor(private httpClient: HttpClient) { }

  
  getAll( date){
    return this.httpClient.get<any>(this.luongURL + `/bangluong?date=${date}`);
  }
  getAllByNhanVienId( id){
    return this.httpClient.get<any>(this.luongURL + `/LuongById?id=${id}`);
  }
  exportExcel(date){
    return this.httpClient.get<any>(this.luongURL + `/export/excel`);
  }
  exportExcel2(date): any{
    return this.httpClient.get(this.luongURL + `/export/excel?date=${date}`, {responseType: 'blob'});
  }
  updateNgayCong(date){
    return this.httpClient.get<any>(this.luongURL + `/chamcong?date=${date}`);
  }
 
  addkylua(kyLuat):Observable<KyLuat>{
   return this.httpClient.post<KyLuat>(this.luongURL + "/kyluat" , kyLuat);
  }
  addkhenthuong(KhenThuongKl):Observable<KhenThuongKl>{
    return this.httpClient.post<KhenThuongKl>(this.luongURL + "/khenthuong" , KhenThuongKl);
   }
   addphucap(phuCap):Observable<PhuCap>{
    return this.httpClient.post<PhuCap>(this.luongURL + "/phucap" , phuCap);
   }
   addtamung(tamUng):Observable<TamUng>{
    return this.httpClient.post<TamUng>(this.luongURL + "/tamung" , tamUng);
   }
   addhesoluong(heSoLuong):Observable<HeSoLuong>{
    return this.httpClient.post<HeSoLuong>(this.luongURL + "/hesoluong" , heSoLuong);
   }
   

}
