import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PilotApprovalListComponent } from './pilot-approval-list.component';

describe('PilotApprovalListComponent', () => {
  let component: PilotApprovalListComponent;
  let fixture: ComponentFixture<PilotApprovalListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PilotApprovalListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PilotApprovalListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
