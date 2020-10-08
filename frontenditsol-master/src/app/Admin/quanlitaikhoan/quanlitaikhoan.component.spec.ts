import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuanlitaikhoanComponent } from './quanlitaikhoan.component';

describe('QuanlitaikhoanComponent', () => {
  let component: QuanlitaikhoanComponent;
  let fixture: ComponentFixture<QuanlitaikhoanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuanlitaikhoanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuanlitaikhoanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
