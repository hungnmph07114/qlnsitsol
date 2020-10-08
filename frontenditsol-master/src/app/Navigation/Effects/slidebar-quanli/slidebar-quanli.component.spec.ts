import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlidebarQuanliComponent } from './slidebar-quanli.component';

describe('SlidebarQuanliComponent', () => {
  let component: SlidebarQuanliComponent;
  let fixture: ComponentFixture<SlidebarQuanliComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlidebarQuanliComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlidebarQuanliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
