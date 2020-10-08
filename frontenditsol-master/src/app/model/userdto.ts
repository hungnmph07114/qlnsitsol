import { NhanVien } from './nhanvien';

export class UserDTO {
  id:number;
  name: string;
  userName: string;
  hoatDong: boolean;
  email: string;
  password: string;
  nhanVien: NhanVien;
  role: string ;
  constructor(name: string, userName: string, email: string, password: string) {
      this.name = name;
      this.userName = userName;
      this.email = email;
      this.password = password;
  }
}
