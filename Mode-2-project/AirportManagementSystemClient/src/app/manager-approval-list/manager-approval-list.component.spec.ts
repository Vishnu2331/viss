import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerApprovalListComponent } from './manager-approval-list.component';

describe('ManagerApprovalListComponent', () => {
  let component: ManagerApprovalListComponent;
  let fixture: ComponentFixture<ManagerApprovalListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerApprovalListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerApprovalListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
