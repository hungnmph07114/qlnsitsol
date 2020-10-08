import { TestBed } from '@angular/core/testing';

import { OathService } from './oath.service';

describe('OathService', () => {
  let service: OathService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OathService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
