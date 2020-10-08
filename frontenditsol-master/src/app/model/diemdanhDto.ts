
export class DiemDanhDto{

  date: string;
  dilam: boolean;
  nhanvienid: number;
  constructor(date: string, dilam: boolean,nhanvienid: number){
    this.date = date;
    this.dilam = dilam;
    this.nhanvienid = nhanvienid;
  }
}
