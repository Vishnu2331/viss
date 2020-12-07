import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { SiteLayoutComponent } from './layouts/site-layout/site-layout.component';
import { SiteHeaderComponent } from './layouts/site-header/site-header.component';
import { AppLayoutAdminComponent } from './layouts/app-layout-admin/app-layout-admin.component';
import { AppLayoutManagerComponent } from './layouts/app-layout-manager/app-layout-manager.component';
import { AppHeaderAdminComponent } from './layouts/app-header-admin/app-header-admin.component';
import { AppHeaderManagerComponent } from './layouts/app-header-manager/app-header-manager.component';
import { AdminRegisterComponent } from './admin-register/admin-register.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { ManagerLoginComponent } from './manager-login/manager-login.component';
import { ManagerRegisterComponent } from './manager-register/manager-register.component';
import { AdminApprovalsComponent } from './admin-approvals/admin-approvals.component';
import { ManagerApprovalComponent } from './manager-approval/manager-approval.component';
import { ManagerApprovalListComponent } from './manager-approval-list/manager-approval-list.component';
import { AddAeroplaneComponent } from './add-aeroplane/add-aeroplane.component';
import { AddHangerComponent } from './add-hanger/add-hanger.component';
import { ManagerHomeComponent } from './manager-home/manager-home.component';
import { AssignHangerComponent } from './assign-hanger/assign-hanger.component';
import { AddPlaneComponent } from './add-plane/add-plane.component';
import { AssignPilotComponent } from './assign-pilot/assign-pilot.component';
import { PilotApprovalComponent } from './pilot-approval/pilot-approval.component';
import { HangerApprovalComponent } from './hanger-approval/hanger-approval.component';
import { PilotApprovalListComponent } from './pilot-approval-list/pilot-approval-list.component';
import { HangerApprovalListComponent } from './hanger-approval-list/hanger-approval-list.component';
import { PlanesComponent } from './planes/planes.component';
import { HangerComponent } from './hanger/hanger.component';
import { PilotComponent } from './pilot/pilot.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';


@NgModule({  
  declarations: [   
    AppComponent,
    HomePageComponent,
    SiteLayoutComponent,
    SiteHeaderComponent,
    AppLayoutAdminComponent,
    AppLayoutManagerComponent,
    AppHeaderAdminComponent,
    AppHeaderManagerComponent,  
    AdminRegisterComponent,
    AdminLoginComponent, 
    ManagerLoginComponent,    
    ManagerRegisterComponent, 
    AdminApprovalsComponent, 
    ManagerApprovalComponent,
    ManagerApprovalListComponent,  
    AddAeroplaneComponent,
    AddHangerComponent,  
    ManagerHomeComponent,
    AssignHangerComponent,
    AddPlaneComponent,
    AssignPilotComponent,
    PilotApprovalComponent,
    HangerApprovalComponent,  
    PilotApprovalListComponent,
    HangerApprovalListComponent,
    PlanesComponent,
    HangerComponent,    
    PilotComponent ,
    AdminHomeComponent,
    ManagerHomeComponent   
  ],
  imports: [
    BrowserModule, 
    AppRoutingModule,  
    FormsModule,    
    HttpClientModule    
  ],  
  providers: [],     
  bootstrap: [AppComponent] 
})   
export class AppModule { }  
    