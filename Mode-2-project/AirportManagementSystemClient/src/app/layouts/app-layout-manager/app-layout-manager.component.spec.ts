import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppLayoutManagerComponent } from './app-layout-manager.component';

describe('AppLayoutManagerComponent', () => {
  let component: AppLayoutManagerComponent;
  let fixture: ComponentFixture<AppLayoutManagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppLayoutManagerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppLayoutManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
