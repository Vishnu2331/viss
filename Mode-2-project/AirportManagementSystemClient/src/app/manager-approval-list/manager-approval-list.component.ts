import { Component, OnInit, Input } from '@angular/core';
import { Manager } from '../ModelClasses/Manager';
import { ManagerServiceService } from '../Services/manager-service.service';
import { ManagerApprovalComponent } from '../manager-approval/manager-approval.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager-approval-list',
  templateUrl: './manager-approval-list.component.html',
  styleUrls: ['./manager-approval-list.component.css']
})
export class ManagerApprovalListComponent implements OnInit {

  constructor(private managerService:ManagerServiceService,private listComponent:ManagerApprovalComponent,private router:Router) { }
  @Input() 
  manager:Manager;
  
 ngOnInit(): void {
 }
 rejectManager() {
   this.manager.managerStatus="REJECTED";
   this.managerService.setManagerStatus(this.manager)
        .subscribe(data => {
   console.log(data); 
  //  this.router.navigate(["customer"]);
  this.listComponent.reloadData();
  }, error => console.log(error));
      this.manager=new Manager();
  }

 acceptManager(){
  this.manager.managerStatus="ACCEPTED";
  this.managerService.setManagerStatus(this.manager)
  .subscribe(data => {
console.log(data); 
this.listComponent.reloadData();
}, error => console.log(error));
this.manager=new Manager();  
}
}

 
