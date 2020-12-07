import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignPilotComponent } from './assign-pilot.component';

describe('AssignPilotComponent', () => {
  let component: AssignPilotComponent;
  let fixture: ComponentFixture<AssignPilotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignPilotComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignPilotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
