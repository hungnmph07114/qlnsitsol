import { TestBed } from '@angular/core/testing';

import { LuongService } from './luong.service';

describe('LuongService', () => {
  let service: LuongService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LuongService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
