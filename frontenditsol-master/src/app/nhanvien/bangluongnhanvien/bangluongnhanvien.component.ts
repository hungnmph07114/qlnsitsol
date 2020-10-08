import { OathService } from 'src/app/Service/oath.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ServicephongbanService } from 'src/app/Service/servicephongban.service';
import { Luong } from './../../model/luong';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { LuongService } from '../../Service/luong.service';
import { ToastrService } from 'ngx-toastr';
import { ServicenhanvienService } from '../../Service/servicenhanvien.service';
import { TokenserviceService } from '../../Service/tokenservice.service';

@Component({
  selector: 'app-bangluongnhanvien',
  templateUrl: './bangluongnhanvien.component.html',
  styleUrls: ['./bangluongnhanvien.component.css']
})
export class BangluongnhanvienComponent implements OnInit {
  luong: Luong[];
  date: string ="2020-09";
  title = 'mte-test';

  displayedColumns = ['tenNhanVien','tenPhongBan','ngayCong','kyLuat','heSoLuong','khenThuongKl','tamUng','phuCap','date','tongLuong'];
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  dataSource: MatTableDataSource<Luong>;

  constructor(  private service: ServicenhanvienService,
    private servicePhongBan: ServicephongbanService,
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService,
    private serviceluong: LuongService,
    private authService: OathService,
    private tokenService: TokenserviceService) { }

  ngOnInit(): void {
    this.getallluong();
  }
  onchaneDate() {
    this.getallluong();
  };
  getallluong(){
    const nhanvienid = this.route.snapshot.params.id;
    this.serviceluong.getAllByNhanVienId(nhanvienid).subscribe(data =>{
    this.luong = data;
    this.dataSource =data;
    }, err => {
      this.toastr.error(err.error.message,"fail",{
        timeOut: 3000,  positionClass: 'toast-top-center',
      });
    }
    );
      }
}
