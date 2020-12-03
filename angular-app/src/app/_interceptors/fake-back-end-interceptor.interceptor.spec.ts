import { TestBed } from '@angular/core/testing';

import { FakeBackEndInterceptorInterceptor } from './fake-back-end-interceptor.interceptor';

describe('FakeBackEndInterceptorInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      FakeBackEndInterceptorInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: FakeBackEndInterceptorInterceptor = TestBed.inject(FakeBackEndInterceptorInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
