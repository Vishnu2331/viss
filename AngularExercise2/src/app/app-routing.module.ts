import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';
import { EditEmployeeComponent } from './edit-employee/edit-employee.component';
import { PageNotFoundComponentComponent } from './page-not-found-component/page-not-found-component.component';
import { EmployeeComponent } from './employee/employee.component';
import { QuantityIncrementComponent } from './quantity-increment/quantity-increment.component';

const routes: Routes = [
  {path:'', component:EmployeeComponent},
  {path:'view-emp', component:ViewEmployeeComponent},
  {path:'edit-emp', component: EditEmployeeComponent},
  {path:'quantity-increment', component: QuantityIncrementComponent},
   {path:'not-found',component:PageNotFoundComponentComponent},
   {path:'**',redirectTo:'/not-found'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

}
