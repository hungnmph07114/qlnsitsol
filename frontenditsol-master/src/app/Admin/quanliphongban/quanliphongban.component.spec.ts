import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuanliphongbanComponent } from './quanliphongban.component';

describe('QuanliphongbanComponent', () => {
  let component: QuanliphongbanComponent;
  let fixture: ComponentFixture<QuanliphongbanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuanliphongbanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuanliphongbanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
