import { NhanVien } from './../../model/nhanvien';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { ImageHotel } from './../../model/ImageHotel';
import { Component, OnInit } from '@angular/core';
import { ServicenhanvienService } from 'src/app/Service/servicenhanvien.service';
import { Image } from './../../model/image';
@Component({
  selector: 'app-themnhanvien',
  templateUrl: './themnhanvien.component.html',
  styleUrls: ['./themnhanvien.component.css']
})
export class ThemnhanvienComponent implements OnInit {
  id: number;
  nhanvien: NhanVien = new NhanVien();
  img: any;
  imageHotel: ImageHotel  = new ImageHotel();
  check = false;
  data: Image;
  constructor(private service: ServicenhanvienService,
              private router: Router,
              private toastr: ToastrService,
              private route: ActivatedRoute) { }

  ngOnInit(
  ): void {
    this.id = this.route.snapshot.params.id;
    console.log(this.id);
  }
  addnhanvien(nhanvien){
    this.nhanvien.phongbanid = this.id;
    this.nhanvien.action=true;
    this.nhanvien.img = this.img;
    console.log(nhanvien.ngayBatDau)
    this.service.themnhanvien(nhanvien).subscribe(data =>{
      this.toastr.success('Thêm nhân viên', 'thành công' , {
        positionClass: 'toast-top-center',
        timeOut: 3000,
       });

       this.router.navigate(['/admin/taikhoan/'+ this.id]);
    },err =>{
      this.toastr.error(err.error.message,'thêm không thành công',{
        positionClass: 'toast-top-center',
        timeOut: 3000,
      });
    }
    );

  }
  onChange(file) {
    if (file && file) {
      let reader = new FileReader();

      reader.readAsDataURL(file); // read file as data url

      reader.onload = (file) => { // called once readAsDataURL is completed

       // this.hotel.img = file.target.result;
      };
    }
    this.check = true;
    this.service.upload(file)
      .subscribe(res => {
        console.log(this.data = res);

       // this.product.img = this.data.data.link;
        this.imageHotel.imagePath = this.data.data.link;
        this.img = this.data.data.link;
      });

  }
}
