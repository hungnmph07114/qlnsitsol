import { DiemdanhComponent } from './nhanvien/diemdanh/diemdanh.component';
import { BangluongnhanvienComponent } from './nhanvien/bangluongnhanvien/bangluongnhanvien.component';
import { CapnhattkComponent } from './capnhattk/capnhattk.component';
import { LockComponent } from './lock/lock.component';
import { LuongComponent } from './luong/luong.component';
import { ThemnhanvienComponent } from './nhanvien/themnhanvien/themnhanvien.component';

import { ThemphongbanComponent } from './Admin/themphongban/themphongban.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './Navigation/login/login.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BodyAdminComponent } from './Navigation/Effects/body-admin/body-admin.component';
import { HomeComponent } from './Navigation/home/home.component';
import { QuanliphongbanComponent } from './Admin/quanliphongban/quanliphongban.component';
import { QuanlitaikhoanComponent } from './Admin/quanlitaikhoan/quanlitaikhoan.component';
import { ThemtaikhoanComponent } from './Admin/themtaikhoan/themtaikhoan.component';
import { DetailTaikhoanComponent } from './Admin/detail-taikhoan/detail-taikhoan.component';
import { DetailPhongbanComponent } from './Admin/detail-phongban/detail-phongban.component';
import {AdminGuard as guard  } from './guards/admin.guard'
//Quản lí
import { NavigatorComponent } from './Navigation/navigator/navigator.component';
import { ProfilesComponent } from './Navigation/Effects/profiles/profiles.component';
import { EditComponent } from './Admin/quanliphongban/edit/edit/edit.component';
import { ChamCongComponent } from './Admin/cham-cong/cham-cong.component';
import { QuanlytaiquannhanvienComponent } from './quanlytaiquannhanvien/quanlytaiquannhanvien.component';

const routes: Routes = [
  { path: '', redirectTo: 'navigator', pathMatch: 'full' },
  { path: 'navigator', component: NavigatorComponent },
  { path: 'admin/login', component: LoginComponent },
  { path: 'nhanvien/login', component: LoginComponent },
  { path: 'quanli/login', component: LoginComponent },

  {
    path: 'admin', component: BodyAdminComponent , children: [
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { path: 'home', component: HomeComponent , canActivate: [guard], data:{expectedRole: ['admin','manager','user']}},
      { path: 'taikhoan/:phongbanid', component: QuanlitaikhoanComponent, canActivate: [guard], data:{expectedRole: ['admin','manager']} },
      { path: 'phongban', component: QuanliphongbanComponent, canActivate: [guard], data:{expectedRole: ['admin','manager']} },
      { path: 'them', component: ThemphongbanComponent, canActivate: [guard], data:{expectedRole: ['admin','manager']} },
      { path: 'addtk', component: ThemtaikhoanComponent },
      { path: 'profile/:id', component: ProfilesComponent },
      { path: 'luongNhanVien/:id', component: BangluongnhanvienComponent , canActivate: [guard], data:{expectedRole: ['admin','manager','user']}},
      { path: 'diemDanh/:id', component: DiemdanhComponent , canActivate: [guard], data:{expectedRole: ['admin','manager','user']}},
      { path: 'addpb', component: ThemphongbanComponent},
      { path: 'taikhoan', component: QuanlytaiquannhanvienComponent, canActivate: [guard], data:{expectedRole: ['manager']}},
      { path: 'phongban/sua/:id', component: EditComponent, canActivate: [guard], data:{expectedRole: ['admin','manager']} },
      { path: 'themnv/:id', component: ThemnhanvienComponent, canActivate: [guard], data:{expectedRole: ['admin','manager']} },
      { path: 'chamcong', component: ChamCongComponent , canActivate: [guard], data:{expectedRole: ['admin','manager']} },
      { path: 'luong', component: LuongComponent , canActivate: [guard], data:{expectedRole: ['admin','manager']} },
      { path: 'lock/:id', component: LockComponent, canActivate: [guard], data:{expectedRole: ['manager']} },
      { path: 'updateuser/:id', component: CapnhattkComponent, canActivate: [guard], data:{expectedRole: ['admin','manager']} },
    ]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
