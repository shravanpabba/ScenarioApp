import { TestBed } from '@angular/core/testing';

import { DetailService } from './student.service';

describe('DetailService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DetailService = TestBed.get(DetailService);
    expect(service).toBeTruthy();
  });
});
