import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';
import { EditEmployeeComponent } from './edit-employee/edit-employee.component';
import { PageNotFoundComponentComponent } from './page-not-found-component/page-not-found-component.component';
import { QuantityIncrementComponent } from './quantity-increment/quantity-increment.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    ViewEmployeeComponent,
    EditEmployeeComponent,
    PageNotFoundComponentComponent,
    QuantityIncrementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
   