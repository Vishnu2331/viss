import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddHangerComponent } from './add-hanger.component';

describe('AddHangerComponent', () => {
  let component: AddHangerComponent;
  let fixture: ComponentFixture<AddHangerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddHangerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddHangerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
