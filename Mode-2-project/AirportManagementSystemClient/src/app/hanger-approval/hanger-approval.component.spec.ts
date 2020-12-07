import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HangerApprovalComponent } from './hanger-approval.component';

describe('HangerApprovalComponent', () => {
  let component: HangerApprovalComponent;
  let fixture: ComponentFixture<HangerApprovalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HangerApprovalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HangerApprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
