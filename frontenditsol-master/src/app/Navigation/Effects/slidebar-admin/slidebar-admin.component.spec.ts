import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlidebarAdminComponent } from './slidebar-admin.component';

describe('SlidebarAdminComponent', () => {
  let component: SlidebarAdminComponent;
  let fixture: ComponentFixture<SlidebarAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlidebarAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlidebarAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
