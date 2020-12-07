import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAeroplaneComponent } from './add-aeroplane.component';

describe('AddAeroplaneComponent', () => {
  let component: AddAeroplaneComponent;
  let fixture: ComponentFixture<AddAeroplaneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddAeroplaneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAeroplaneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
