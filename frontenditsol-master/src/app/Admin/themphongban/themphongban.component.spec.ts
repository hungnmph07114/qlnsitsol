import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemphongbanComponent } from './themphongban.component';

describe('ThemphongbanComponent', () => {
  let component: ThemphongbanComponent;
  let fixture: ComponentFixture<ThemphongbanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ThemphongbanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ThemphongbanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
