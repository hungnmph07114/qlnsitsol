import { NhanVien } from 'src/app/model/nhanvien';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { DiemDanh } from './../../model/diemdanh';
import { Component, OnInit } from '@angular/core';
import { ServicenhanvienService } from 'src/app/Service/servicenhanvien.service';
import * as moment from 'moment';

@Component({
  selector: 'app-cham-cong',
  templateUrl: './cham-cong.component.html',
  styleUrls: ['./cham-cong.component.css']
})
export class ChamCongComponent implements OnInit {
  name: string;
  nhanvien: NhanVien[];
  diemdanh: DiemDanh;
  diemdanhList: DiemDanh[];
  masterSelected: boolean;
  checklist: any;
  checkedList: any[];
  unCheckedList: any[];
date: string; dilam: boolean = true; nhanvienid: number;

  constructor(

    private service: ServicenhanvienService,

    private router: Router,
    private toastr: ToastrService,
  ) { }

  ngOnInit(): void {
    let momments = moment().format('YYYY-MM-DD');
    this.date = momments;
    this.masterSelected = false;
    this.getNhanVien();
  }
  timkiem(name){
this.service.timkiemnhanvien(name).subscribe(data =>{
  this.nhanvien = data;
});

  }

getNhanVien(){
  this.service.getDiemDanh(this.date).subscribe(data =>{
    this.diemdanhList = data;
    console.log(data);
  })
}
checkUncheckAll() {
  for (var i = 0; i < this.diemdanhList.length; i++) {
    this.diemdanhList[i].dilam = this.masterSelected;
  }
  this.getCheckedItemList();
}
isAllSelected() {
  this.masterSelected = this.diemdanhList.every(function(item:any) {
      return item.dilam == true;
    })
  this.getCheckedItemList();
}
getCheckedItemList(){
  this.checkedList = [{date:'17/09/2020',dilam:true,id:0}];
  this.checkedList.splice(0);
  this.unCheckedList =  [{date:'17/09/2020',dilam:false,id:0}];
  this.unCheckedList.splice(0);
  for (var i = 0; i < this.diemdanhList.length; i++) {
    if(this.diemdanhList[i].dilam){
   this.checkedList.push({date:this.date,dilam:true,nhanvienid:this.diemdanhList[i].id.nhanVien.id});
  }else if(!this.diemdanhList[i].dilam){
    this.unCheckedList.push({date:this.date,dilam:false,nhanvienid:this.diemdanhList[i].id.nhanVien.id})
  }
  }
}
  chamCongAll (list){
 for (var i = 0; i < this.checkedList.length; i++){
   if(this.checkedList[i]){
     this.nhanvienid = this.checkedList[i].nhanvienid;
     const diemdanh = new DiemDanh(this.date, this.dilam=true,this.nhanvienid = this.checkedList[i].nhanvienid);
     console.log(diemdanh)
      this.chamCong(diemdanh);
   }
 }
 for (var i = 0; i < this.unCheckedList.length; i++){
  if(this.unCheckedList[i]){
    this.nhanvienid = this.unCheckedList[i].nhanvienid;
    const diemdanh = new DiemDanh(this.date, this.dilam=false,this.nhanvienid = this.unCheckedList[i].nhanvienid);
     this.chamCong(diemdanh);
  }
}
 this.toastr.success('Điểm danh thành công', 'OK', {
  timeOut: 3000, positionClass: 'toast-top-center'
});
this.router.navigate(['/admin/phongban']);
}
chamCong(diemdanh): void{

  this.service.chamCong(diemdanh).subscribe(
    data => {

      this.router.navigate(['/admin/phongban']);
    },
    err => {
      this.toastr.error(err.error.mensaje, 'Fail', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });
      this.router.navigate(['/admin']);
    }
  );
}

}
