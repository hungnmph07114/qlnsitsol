import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuanlytaiquannhanvienComponent } from './quanlytaiquannhanvien.component';

describe('QuanlytaiquannhanvienComponent', () => {
  let component: QuanlytaiquannhanvienComponent;
  let fixture: ComponentFixture<QuanlytaiquannhanvienComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuanlytaiquannhanvienComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuanlytaiquannhanvienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
