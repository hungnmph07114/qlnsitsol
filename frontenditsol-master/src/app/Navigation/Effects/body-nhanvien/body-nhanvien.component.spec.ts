import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BodyNhanvienComponent } from './body-nhanvien.component';

describe('BodyNhanvienComponent', () => {
  let component: BodyNhanvienComponent;
  let fixture: ComponentFixture<BodyNhanvienComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BodyNhanvienComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BodyNhanvienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
