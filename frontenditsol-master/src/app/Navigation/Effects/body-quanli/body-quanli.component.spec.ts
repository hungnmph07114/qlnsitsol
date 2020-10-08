import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BodyQuanliComponent } from './body-quanli.component';

describe('BodyQuanliComponent', () => {
  let component: BodyQuanliComponent;
  let fixture: ComponentFixture<BodyQuanliComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BodyQuanliComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BodyQuanliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
