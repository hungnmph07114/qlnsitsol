import { TokenserviceService } from 'src/app/Service/tokenservice.service';
import { NewUser } from './../model/newuser';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ServicenhanvienService } from '../Service/servicenhanvien.service';
import { UserDTO } from '../model/userdto';
import { ToastrService } from 'ngx-toastr';
import * as uuid from 'uuid';

@Component({
  selector: 'app-capnhattk',
  templateUrl: './capnhattk.component.html',
  styleUrls: ['./capnhattk.component.css']
})
export class CapnhattkComponent implements OnInit {
  user: UserDTO;
  userName: string;
  password = "123@abc";
  role: string;
  newUser : NewUser;

  constructor(    private router: Router,
    private route: ActivatedRoute,
    private service: ServicenhanvienService,
    private toastr: ToastrService,
    private tokenService: TokenserviceService) { }

  ngOnInit(): void {
    this. getoneuser();
    this.userName = this.tokenService.getUserName();
  }
  doimatkhau(){
    console.log(this.password)
    this.newUser = new NewUser(this.userName,this.password,null,this.role);
    this.service.updateUserpass(this.newUser).subscribe(data =>{
      this.user = data;
      this.toastr.success('cập nhật thành công', 'OK', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });  
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
