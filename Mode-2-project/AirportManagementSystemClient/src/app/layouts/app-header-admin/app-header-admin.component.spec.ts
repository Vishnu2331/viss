import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppHeaderAdminComponent } from './app-header-admin.component';

describe('AppHeaderAdminComponent', () => {
  let component: AppHeaderAdminComponent;
  let fixture: ComponentFixture<AppHeaderAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppHeaderAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppHeaderAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
