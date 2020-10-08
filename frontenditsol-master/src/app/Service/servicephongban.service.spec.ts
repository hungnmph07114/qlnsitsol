import { TestBed } from '@angular/core/testing';
import { ServicephongbanService } from './servicephongban.service';

describe('ServicephongbanService', () => {
  let service: ServicephongbanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServicephongbanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
