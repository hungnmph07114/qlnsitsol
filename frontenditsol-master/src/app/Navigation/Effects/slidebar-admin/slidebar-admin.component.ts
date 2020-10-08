import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NhanVien } from 'src/app/model/nhanvien';
import { ServicenhanvienService } from 'src/app/Service/servicenhanvien.service';
import { TokenserviceService } from './../../../Service/tokenservice.service';
@Component({
  selector: 'app-slidebar-admin',
  templateUrl: './slidebar-admin.component.html',
  styleUrls: ['./slidebar-admin.component.css']
})
export class SlidebarAdminComponent implements OnInit {
  isLogged: boolean;
  nhanvien: NhanVien;
  userName: string;
  nhanVienId: string;
  roles:string[];
  isAdmin:boolean= false;
  isManager:boolean= false;
  constructor(
    private tokenService: TokenserviceService,
              private  router: Router,
              private service: ServicenhanvienService,
              private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    
    this.userName = this.tokenService.getUserName();
    this.nhanVienId = this.tokenService.getNhanVienid();
    console.log(this.nhanVienId)
    this.roles = this.tokenService.getAuthorities();
    this.roles.forEach(
      rol => {
        if(rol === 'ROLE_ADMIN'){
          this.isAdmin = true;
        }else if(rol === 'ROLE_MANAGER'){
          this.isAdmin = true;
          this.isManager = true;

        }
      }
    )
    this.getone();
  }
  getone() {
   
    this.service.getOneNhanVien(this.nhanVienId).subscribe((data) => {
      this.nhanvien = data;
      // let phongban = JSON.parse();

    });
  }
  logout(): void{
    // tslint:disable-next-line: no-unused-expression
    if (this.userName){
      this.tokenService.logOut();
      this.router.navigate(['/']);
    }

  }
}
