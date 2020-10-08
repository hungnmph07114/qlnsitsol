import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PhongBan } from 'src/app/model/phongban';
import { ServicephongbanService } from 'src/app/Service/servicephongban.service';


@Component({
  selector: 'app-quanliphongban',
  templateUrl: './quanliphongban.component.html',
  styleUrls: ['./quanliphongban.component.css']
})
export class QuanliphongbanComponent implements OnInit {
  phongbans : PhongBan[] ;
  totalPages: Array<number>;
  page = 0;
  size = 5;
  order = 'tenPhongBan';
  tenPhongBan = ""
  asc = true;
  isFirst = false;
  isLast = false;
  action= true;
  title = 'mte-test';

  displayedColumns = ['tenPhongBan', 'dienThoai', 'ghiChu', 'action','Actions'];
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  dataSource: MatTableDataSource<PhongBan>;

  constructor( private service: ServicephongbanService ) { }

  ngOnInit(): void {
  this.listPhongBan();
  
  }


  
  getphongphans(){
 this.service.getphongban().subscribe(data =>{
  this.phongbans = data;
  this.dataSource = new MatTableDataSource<PhongBan>(this.phongbans);
  this.dataSource.paginator = this.paginator;
})
  }
  listPhongBan() {
      this.service.page(this.page, this.size, this.order, this.asc,this.tenPhongBan ).subscribe(data =>{
        this.isFirst = data.first;
        this.isLast = data.last;
        this.totalPages = new Array(data.totalPages);
        this.phongbans = data.content;
        this.dataSource = new MatTableDataSource<PhongBan>(this.phongbans);
        this.dataSource.paginator = this.paginator;
        console.log(this.phongbans)
      }, err => {
        console.log(err.error);
      });
  }
  sort(): void {
    this.asc = !this.asc;
    this.listPhongBan();
  }
  rewind(): void {
    if (!this.isFirst) {
      this.page--;
      this.listPhongBan();
    }
  }

  forward(): void {
    if (!this.isLast) {
      this.page++;
      this.listPhongBan();
    }
  }

  setPage(page: number): void {
    this.page = page;
    this.listPhongBan();
  }

  setOrder(order: string): void {
    this.order = order;
    this.listPhongBan();
  }
}

