import { ImageHotel } from './../../../../model/ImageHotel';
import { Image } from './../../../../model/image';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PhongBan } from 'src/app/model/phongban';

import { ServicephongbanService } from 'src/app/Service/servicephongban.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  phongban: PhongBan;
  imageHotel: ImageHotel = new ImageHotel();
  check = false;
  data: Image;
  img: any;
  constructor(private service: ServicephongbanService,
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    this.getone();
  }
  getone() {
    const id = this.route.snapshot.params.id;
    this.service.getonephongban(id).subscribe(data => {
      this.phongban = data;
    });
  }
  Editphongban(phongban) {
    if (!this.img === null) {
      this.phongban.img = this.img;
    }

    const id = this.route.snapshot.params.id;
    this.service.Editphongban(id, phongban).subscribe(data => {
      this.toastr.success('Sửa phòng ban', 'thành công', {
        positionClass: 'toast-top-center',
        timeOut: 3000,
      });
      this.router.navigate(['/admin/phongban']);
      console.log(phongban.status)
    },
      err => {
        this.toastr.error(err.error.message, 'sửa không thành công', {
          positionClass: 'toast-top-center',
          timeOut: 3000,
        });
      });
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
        this.phongban.img = this.data.data.link;
        this.img = this.data.data.link;
      });

  }
}
