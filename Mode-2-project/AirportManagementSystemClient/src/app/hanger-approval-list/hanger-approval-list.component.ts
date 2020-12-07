import { Component, OnInit, Input } from '@angular/core';
import { Hanger } from '../ModelClasses/Hanger';
import { HangerServiceService } from '../Services/hanger-service.service';
import { Router } from '@angular/router';
import { Aeroplane } from '../ModelClasses/Aeroplane';
import { HangerApprovalComponent } from '../hanger-approval/hanger-approval.component';

@Component({
  selector: 'app-hanger-approval-list',
  templateUrl: './hanger-approval-list.component.html',
  styleUrls: ['./hanger-approval-list.component.css']
})
export class HangerApprovalListComponent implements OnInit {

  constructor(private hangerService:HangerServiceService,private listComponent:HangerApprovalComponent,private router:Router) { }
  @Input() 
  aeroplane:Aeroplane;
  
 ngOnInit(): void {
 }
 rejectHanger(aeroplaneHangerStatus:string,aeroplaneId:number) {
   aeroplaneHangerStatus="REJECTED";
  //  hanger.hangerAvailability=hanger.hangerAvailability+1;
  //    this.hangerService.updateHanger(hanger).subscribe();
   this.hangerService.setHangerStatus(aeroplaneHangerStatus,aeroplaneId)
        .subscribe(data => {
   console.log(data); 
  //  this.router.navigate(["customer"]);
  this.listComponent.reloadData();
  }, error => console.log(error));
      this.aeroplane=new Aeroplane();
  }

 acceptHanger(aeroplaneHangerStatus:string,aeroplaneId:number){
 aeroplaneHangerStatus="ACCEPTED";
  this.hangerService.setHangerStatus(aeroplaneHangerStatus,aeroplaneId)
  .subscribe(data => {
console.log(data); 
this.listComponent.reloadData();
}, error => console.log(error));
this.aeroplane=new Aeroplane();
}

}
