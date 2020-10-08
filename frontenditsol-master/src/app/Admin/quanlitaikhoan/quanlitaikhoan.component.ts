import { NhanVien } from './../../model/nhanvien';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ServicenhanvienService } from 'src/app/Service/servicenhanvien.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-quanlitaikhoan',
  templateUrl: './quanlitaikhoan.component.html',
  styleUrls: ['./quanlitaikhoan.component.css']
})
export class QuanlitaikhoanComponent implements OnInit {
  name: string;
  totalPages: Array<number>;
  page = 0;
  size = 5;
  order = 'tenNhanVien';
  tenNhanVien = ""
  asc = true;
  isFirst = false;
  isLast = false;
  action= true;
  NhanViens: Array<any>;
  id: number;
  nhanvien: NhanVien[] = [];

  constructor(private httpClient: HttpClient ,
    private service: ServicenhanvienService,
    private route: ActivatedRoute,
    private router: Router,) { }

  ngOnInit(): void {
    this.listnhanvien();

  }
  timkiem(name){
    this.service.timkiemnhanvien(name).subscribe(data =>{
      this.nhanvien = data;
    });
  }
hienThiNhanVienLamViec(){
  this.action = !this.action
  this.listnhanvien()
}
 themnhanvien() {
    this.router.navigate([`/admin/themnv/${this.id}`]);
    console.log(this.id);
  }
  // tslint:disable-next-line: typedef
  listnhanvien() {
    this.route.params.subscribe(praram => {
      this.service.page(this.page, this.size, this.order,this.action, this.asc,praram.phongbanid,this.tenNhanVien ).subscribe(data =>{
        this.isFirst = data.first;
        this.isLast = data.last;
        this.totalPages = new Array(data.totalPages);
        this.nhanvien = data.content;
        this.id = praram.phongbanid;
      }, err => {
        console.log(err.error);
      });
    });
  }
  sort(): void {
    this.asc = !this.asc;
    this.listnhanvien();
  }
  rewind(): void {
    if (!this.isFirst) {
      this.page--;
      this.listnhanvien();
    }
  }

  forward(): void {
    if (!this.isLast) {
      this.page++;
      this.listnhanvien();
    }
  }

  setPage(page: number): void {
    this.page = page;
    this.listnhanvien();
  }

  setOrder(order: string): void {
    this.order = order;
    this.listnhanvien();
  }

}
