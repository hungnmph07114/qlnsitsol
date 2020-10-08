import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailPhongbanComponent } from './detail-phongban.component';

describe('DetailPhongbanComponent', () => {
  let component: DetailPhongbanComponent;
  let fixture: ComponentFixture<DetailPhongbanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailPhongbanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailPhongbanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
