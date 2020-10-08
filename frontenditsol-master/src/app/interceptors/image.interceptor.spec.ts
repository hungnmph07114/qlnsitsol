import { TestBed } from '@angular/core/testing';

import { ImageInterceptor } from './image.interceptor';

describe('ImageInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      ImageInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: ImageInterceptor = TestBed.inject(ImageInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
