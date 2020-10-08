export class PhongBan{
  id: number ;
  tenPhongBan: string;
  dienThoai: string;
  ghiChu: string;
  img: string;
  action: boolean;
  constructor(name: string, sdt: string, ghiChu: string , img: string ){
    this.tenPhongBan = name;
    this.dienThoai = sdt;
    this.ghiChu = ghiChu;
    this.img = img;
  }
}
