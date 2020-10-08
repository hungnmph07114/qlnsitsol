import { id } from './luongid';
import { TamUng } from './tamung';
import { KhenThuongKl } from './khenthuong';
import { HeSoLuong } from './hesoluong';
import { KyLuat } from './kyluat';
import { PhuCap } from './phucap';
export class Luong{

id: id ;
ngayCong: number ;
GhiTru: string;
kyLuat: KyLuat;
heSoLuong: HeSoLuong;
khenThuongKl: KhenThuongKl;
tamUng: TamUng;
phuCap: PhuCap;
tongLuong: number;
}
