import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CapnhattkComponent } from './capnhattk.component';

describe('CapnhattkComponent', () => {
  let component: CapnhattkComponent;
  let fixture: ComponentFixture<CapnhattkComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CapnhattkComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CapnhattkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
