import { TestBed } from '@angular/core/testing';

import { ServicenhanvienService } from './servicenhanvien.service';

describe('ServicenhanvienService', () => {
  let service: ServicenhanvienService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServicenhanvienService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
