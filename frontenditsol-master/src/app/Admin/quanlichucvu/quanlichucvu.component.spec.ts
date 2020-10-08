import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuanlichucvuComponent } from './quanlichucvu.component';

describe('QuanlichucvuComponent', () => {
  let component: QuanlichucvuComponent;
  let fixture: ComponentFixture<QuanlichucvuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuanlichucvuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuanlichucvuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
