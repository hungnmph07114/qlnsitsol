import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailTaikhoanComponent } from './detail-taikhoan.component';

describe('DetailTaikhoanComponent', () => {
  let component: DetailTaikhoanComponent;
  let fixture: ComponentFixture<DetailTaikhoanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailTaikhoanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailTaikhoanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
