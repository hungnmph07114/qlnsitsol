import { Image } from './../../model/image';
import { ImageHotel } from './../../model/ImageHotel';
import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PhongBan } from 'src/app/model/phongban';
import { ServicephongbanService } from 'src/app/Service/servicephongban.service';

@Component({
  selector: 'app-themphongban',
  templateUrl: './themphongban.component.html',
  styleUrls: ['./themphongban.component.css']
})
export class ThemphongbanComponent implements OnInit {
  name  = '';
  ghiChu = '';
  sdt = '';
  img : any;
  imageHotel:ImageHotel  = new ImageHotel();
  check: boolean = false;
data: Image;
  constructor(private service: ServicephongbanService,
              private router: Router,
              private toastr: ToastrService, ) { }

  ngOnInit(): void {
  }
  Addphongban(){
    const phongban = new PhongBan (this.name, this.sdt, this.ghiChu, this.img);
    this.service.Addphongban(phongban).subscribe(data => {
     this.toastr.success('Thêm phòng Ban', 'thành công' , {
      positionClass: 'toast-top-center',
      timeOut: 3000,
     });
     this.router.navigate(['/admin/phongban']);
    },
    err =>{
      this.toastr.error(err.error.message,'thêm không thành công',{
        positionClass: 'toast-top-center',
        timeOut: 3000,
      });
    });
    }
    onChange(file) {
      if (file && file) {
        var reader = new FileReader();

        reader.readAsDataURL(file); // read file as data url

        reader.onload = (file) => { // called once readAsDataURL is completed

         // this.hotel.img = file.target.result;
        }
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
