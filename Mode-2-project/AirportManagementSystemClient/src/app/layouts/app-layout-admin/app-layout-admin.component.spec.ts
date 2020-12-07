import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppLayoutAdminComponent } from './app-layout-admin.component';

describe('AppLayoutAdminComponent', () => {
  let component: AppLayoutAdminComponent;
  let fixture: ComponentFixture<AppLayoutAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppLayoutAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppLayoutAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
