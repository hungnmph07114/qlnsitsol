import { DiemDanhId } from "./diemdanhid";

export class DiemDanh{
  id: DiemDanhId;
  date: string;
  dilam: boolean;
  nhanvienid: number;
  constructor(date: string, dilam: boolean,nhanvienid: number){
    this.date = date;
    this.dilam = dilam;
    this.nhanvienid = nhanvienid;
  }
}
