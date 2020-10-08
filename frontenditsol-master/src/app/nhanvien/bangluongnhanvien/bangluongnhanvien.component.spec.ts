import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BangluongnhanvienComponent } from './bangluongnhanvien.component';

describe('BangluongnhanvienComponent', () => {
  let component: BangluongnhanvienComponent;
  let fixture: ComponentFixture<BangluongnhanvienComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BangluongnhanvienComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BangluongnhanvienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
