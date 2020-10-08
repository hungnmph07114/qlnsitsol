import { DiemDanh } from './../../model/diemdanh';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ServicenhanvienService } from '../../Service/servicenhanvien.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-diemdanh',
  templateUrl: './diemdanh.component.html',
  styleUrls: ['./diemdanh.component.css']
})
export class DiemdanhComponent implements OnInit {
diemdanh: DiemDanh;
listDiemDanh:DiemDanh;
date: string = "2020-09";
  constructor(private service: ServicenhanvienService,
    private router: Router,
    private toastr: ToastrService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getDiemDanhById();
 
  }
  getDiemDanhById(){
    const nhanvienid = this.route.snapshot.params.id;
  
    this.service.getDiemDanhById(this.date,nhanvienid).subscribe(data =>{
      this.listDiemDanh=data;
      console.log( this.listDiemDanh);
    },err =>{
      this.toastr.error(err.error.message,'Chưa có điểm danh tháng này',{
        positionClass: 'toast-top-center',
        timeOut: 3000,
      });
    }
    );
  }
  onchaneDate() {
    this.getDiemDanhById();
  };
}
