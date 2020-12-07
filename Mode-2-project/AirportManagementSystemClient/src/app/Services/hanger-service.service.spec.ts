import { TestBed } from '@angular/core/testing';

import { HangerServiceService } from './hanger-service.service';

describe('HangerServiceService', () => {
  let service: HangerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HangerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
