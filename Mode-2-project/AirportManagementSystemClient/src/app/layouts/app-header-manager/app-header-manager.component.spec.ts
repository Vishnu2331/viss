import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppHeaderManagerComponent } from './app-header-manager.component';

describe('AppHeaderManagerComponent', () => {
  let component: AppHeaderManagerComponent;
  let fixture: ComponentFixture<AppHeaderManagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppHeaderManagerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppHeaderManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
