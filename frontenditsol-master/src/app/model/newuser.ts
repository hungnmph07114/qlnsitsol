export class NewUser{
    userName:string;
    password:string;
    nhanvienid: number;
    role: string;
    
    constructor(userName:string, password:string,nhanvienid: number,role:string){
        this.userName=userName;
        this.password=password;
        this.nhanvienid = nhanvienid;
        this.role = role;
    }
    
}