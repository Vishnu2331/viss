import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignHangerComponent } from './assign-hanger.component';

describe('AssignHangerComponent', () => {
  let component: AssignHangerComponent;
  let fixture: ComponentFixture<AssignHangerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignHangerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignHangerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
