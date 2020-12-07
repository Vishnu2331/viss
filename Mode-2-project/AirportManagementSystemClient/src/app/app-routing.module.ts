import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { SiteLayoutComponent } from './layouts/site-layout/site-layout.component';
import { AdminRegisterComponent } from './admin-register/admin-register.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AppLayoutAdminComponent } from './layouts/app-layout-admin/app-layout-admin.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { ManagerRegisterComponent } from './manager-register/manager-register.component';
import { AdminApprovalsComponent } from './admin-approvals/admin-approvals.component';
import { ManagerApprovalComponent } from './manager-approval/manager-approval.component';
import { ManagerLoginComponent } from './manager-login/manager-login.component';
import { AddAeroplaneComponent } from './add-aeroplane/add-aeroplane.component';
import { AddHangerComponent } from './add-hanger/add-hanger.component';
import { AppLayoutManagerComponent } from './layouts/app-layout-manager/app-layout-manager.component';
import { ManagerHomeComponent } from './manager-home/manager-home.component';
import { AssignHangerComponent } from './assign-hanger/assign-hanger.component';
import { AddPlaneComponent } from './add-plane/add-plane.component';
import { AssignPilotComponent } from './assign-pilot/assign-pilot.component';
import { PilotApprovalComponent } from './pilot-approval/pilot-approval.component';
import { HangerApprovalComponent } from './hanger-approval/hanger-approval.component';
import { AuthGuardService } from './Services/auth-guard.service';
import { AuthGuard1Service } from './Services/auth-guard1.service';
import { PilotComponent } from './pilot/pilot.component';
import { HangerComponent } from './hanger/hanger.component';
import { PlanesComponent } from './planes/planes.component';


const routes: Routes = [

  {  
    path: '', 
    component: SiteLayoutComponent,
    children: [
      { path: '', component: HomePageComponent, pathMatch: 'full'},
     { path:'adminRegister', component:AdminRegisterComponent},
     { path:'adminLogin',component:AdminLoginComponent},
     {path:'managerRegister',component:ManagerRegisterComponent},
     {path:'managerLogin',component:ManagerLoginComponent}
    ]
},
{  
  path: '',  
  component: AppLayoutAdminComponent,canActivate:[AuthGuardService], 
  children: [
    { path: 'adminHome', component:AdminHomeComponent,
    children:[ 
      {path:'pilot',component:PilotComponent,},
      {path:'hanger',component:HangerComponent},
       {path:'plane',component:PlanesComponent}
    ]},
    {path:'adminApproval', component:AdminApprovalsComponent,
      children:[ 
        {path:'managerApproval',component:ManagerApprovalComponent,},
        {path:'pilotApproval',component:PilotApprovalComponent},
         {path:'hangerApproval',component:HangerApprovalComponent}
      ]
    },
      {path:'addPlane',component:AddAeroplaneComponent},
      {path:'addHanger',component:AddHangerComponent},
      {path:'addPilot',component:AddPlaneComponent}  
      
]   
},
{ 
  path: '', 
  component: AppLayoutManagerComponent,canActivate:[AuthGuard1Service],
  children: [
    { path:'managerHome', component: ManagerHomeComponent,
    children:[ 
      {path:'pilot',component:PilotComponent,},
      {path:'hanger',component:HangerComponent},
       {path:'plane',component:PlanesComponent}
    ]},
    {path:'assignHanger',component:AssignHangerComponent},
    {path:'assignPilot',component:AssignPilotComponent},
    {path:'**',component:HomePageComponent}
  ]
},
];   
 
@NgModule({  
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})    
export class AppRoutingModule { }
