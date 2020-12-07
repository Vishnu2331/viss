import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PilotApprovalComponent } from './pilot-approval.component';

describe('PilotApprovalComponent', () => {
  let component: PilotApprovalComponent;
  let fixture: ComponentFixture<PilotApprovalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PilotApprovalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PilotApprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
