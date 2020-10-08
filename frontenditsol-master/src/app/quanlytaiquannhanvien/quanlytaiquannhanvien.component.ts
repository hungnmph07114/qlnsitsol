
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ServicenhanvienService } from 'src/app/Service/servicenhanvien.service';
import { Router } from '@angular/router';
import { UserDTO } from '../model/userdto';

@Component({
  selector: 'app-quanlytaiquannhanvien',
  templateUrl: './quanlytaiquannhanvien.component.html',
  styleUrls: ['./quanlytaiquannhanvien.component.css']
})
export class QuanlytaiquannhanvienComponent implements OnInit {
  action= true;
  ten: string;
  user : UserDTO[] = []; 

  constructor(private httpClient: HttpClient ,
    private service: ServicenhanvienService,
    private route: ActivatedRoute,
    private router: Router,) { }

  ngOnInit(): void {
    this.listtknhanvien()
  }
  taikhoan(){
    this.action = !this.action
    this.listtknhanvien()
  }
  timkiemuser(){
    this.service.timkiemuser(this.ten).subscribe(data =>{
      this.user = data;
    }
    );
  }
  listtknhanvien() {
    this.route.params.subscribe(praram => {
      this.service.listuser(this.action).subscribe(data =>{
        this.user = data;
      }, err => {
      });
    });
  }
}
