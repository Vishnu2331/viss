import { Component, OnInit, Input } from '@angular/core';
import { HangerServiceService } from '../Services/hanger-service.service';
import { HangerApprovalComponent } from '../hanger-approval/hanger-approval.component';
import { Aeroplane } from '../ModelClasses/Aeroplane';
import { Router } from '@angular/router';
import { PilotServiceService } from '../Services/pilot-service.service';
import { PilotApprovalComponent } from '../pilot-approval/pilot-approval.component';

@Component({
  selector: 'app-pilot-approval-list',
  templateUrl: './pilot-approval-list.component.html',
  styleUrls: ['./pilot-approval-list.component.css']
})
export class PilotApprovalListComponent implements OnInit {

  constructor(private pilotService:PilotServiceService,private listComponent:PilotApprovalComponent,private router:Router) { }
  @Input() 
  aeroplane:Aeroplane;
  
 ngOnInit(): void {
 }
 rejectPilot(aeroplanePilotStatus:string,aeroplaneId:number) {
  aeroplanePilotStatus="REJECTED";
  //  hanger.hangerAvailability=hanger.hangerAvailability+1;
  //    this.hangerService.updateHanger(hanger).subscribe();
   this.pilotService.setPilotStatus(aeroplanePilotStatus,aeroplaneId)
        .subscribe(data => {
   console.log(data); 
  //  this.router.navigate(["customer"]);
  this.listComponent.reloadData();
  }, error => console.log(error));
      this.aeroplane=new Aeroplane();
  }

 acceptPilot(aeroplanePilotStatus:string,aeroplaneId:number){
 aeroplanePilotStatus="ACCEPTED";
  this.pilotService.setPilotStatus(aeroplanePilotStatus,aeroplaneId)
  .subscribe(data => {
console.log(data); 
this.listComponent.reloadData();
}, error => console.log(error));
this.aeroplane=new Aeroplane();
}

}
