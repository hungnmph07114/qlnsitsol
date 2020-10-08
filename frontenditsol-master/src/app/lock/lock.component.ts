import { UserDTO } from './../model/userdto';
import { ServicenhanvienService } from 'src/app/Service/servicenhanvien.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-lock',
  templateUrl: './lock.component.html',
  styleUrls: ['./lock.component.css']
})
export class LockComponent implements OnInit {
tkid: number;
user: UserDTO; 

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: ServicenhanvienService
  ) { }

  ngOnInit(): void {
    this. getoneuser();
  }
  blockuser(){
    this.user.hoatDong = false;
    const tkid = this.route.snapshot.params.id;
    this.service.updateUser(tkid, this.user).subscribe(data =>{
      this.user = data;
      console.log(this.user);
      this.router.navigate(['/admin/taikhoan']);
    })
  }
  unlockuser(){
    this.user.hoatDong = true;
    const tkid = this.route.snapshot.params.id;
    this.service.updateUser(tkid, this.user).subscribe(data =>{
      this.user = data;
      this.router.navigate(['/admin/taikhoan']);
    })
  }
  getoneuser(){
  const tkid = this.route.snapshot.params.id;
  this.service.getOneuser(tkid).subscribe(data =>{
    this.user = data;
    console.log(this.user);
  })
 }
}
