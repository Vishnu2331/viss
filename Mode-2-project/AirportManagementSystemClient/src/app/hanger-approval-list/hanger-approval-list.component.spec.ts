import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HangerApprovalListComponent } from './hanger-approval-list.component';

describe('HangerApprovalListComponent', () => {
  let component: HangerApprovalListComponent;
  let fixture: ComponentFixture<HangerApprovalListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HangerApprovalListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HangerApprovalListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
