import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlidebarNhanvienComponent } from './slidebar-nhanvien.component';

describe('SlidebarNhanvienComponent', () => {
  let component: SlidebarNhanvienComponent;
  let fixture: ComponentFixture<SlidebarNhanvienComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlidebarNhanvienComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlidebarNhanvienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
