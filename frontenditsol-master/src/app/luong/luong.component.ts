import { Luong } from './../model/luong';
import { LuongService } from './../Service/luong.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { ToastrService } from 'ngx-toastr';
import * as fileSaver from 'file-saver';

@Component({
  selector: 'app-luong',
  templateUrl: './luong.component.html',
  styleUrls: ['./luong.component.css']
})
export class LuongComponent implements OnInit {
  luong: Luong[];
  date: string = "2020-09";
  title = 'mte-test';

  displayedColumns = ['tenNhanVien', 'tenPhongBan', 'ngayCong', 'kyLuat', 'heSoLuong', 'khenThuongKl', 'tamUng', 'phuCap', 'date', 'tongLuong'];
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  dataSource: MatTableDataSource<Luong>;

  constructor(private service: LuongService,
    private toastr: ToastrService,) { }

  ngOnInit(): void {
    this.getallluong();
    this.onchaneDate();

  }
  updateCong() {
    this.service.updateNgayCong(this.date).subscribe(data => {
      this.getallluong();
      this.dataSource = new MatTableDataSource<Luong>(this.luong);
      this.dataSource.paginator = this.paginator;
      this.toastr.success('Cập nhật thành công', 'OK', {
        timeOut: 3000, positionClass: 'toast-top-center'
      })
    }, err => {
      this.toastr.error(err.error.message, "fail", {
        timeOut: 3000, positionClass: 'toast-top-center',
      });
    }
    );
  }

  onchaneDate() {
    this.getallluong();
  };
  getallluong() {
    this.service.getAll(this.date).subscribe(data => {
      this.luong = data;
      this.dataSource = data;
    }, err => {
      this.toastr.error(err.error.message, "fail", {
        timeOut: 3000, positionClass: 'toast-top-center',
      });
    }
    );
  }
  exportExcel(){
    this.service.exportExcel2(this.date).subscribe(
      response => {
        let blob:any = new Blob([response], { type: 'text/json; charset=utf-8' });
        const url = window.URL.createObjectURL(blob);
        fileSaver.saveAs(blob, 'BangLuong.xlsx');
      }
    ),error => console.log('Error downloading the file'),
    () => console.info('File downloaded su ccessfully');
  }


}

