import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { ServicenhanvienService } from 'src/app/Service/servicenhanvien.service';

@Component({
  selector: 'app-themtaikhoan',
  templateUrl: './themtaikhoan.component.html',
  styleUrls: ['./themtaikhoan.component.css']
})
export class ThemtaikhoanComponent implements OnInit {


  constructor(private httpClient: HttpClient ,
              private service: ServicenhanvienService,
              private route: ActivatedRoute) { }
  ngOnInit(): void {
  }

}
