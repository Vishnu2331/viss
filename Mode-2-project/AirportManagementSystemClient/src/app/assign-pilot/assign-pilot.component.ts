import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Aeroplane } from '../ModelClasses/Aeroplane';
import { Pilot } from '../ModelClasses/Pilot';
import { AeroplaneServiceService } from '../Services/aeroplane-service.service';
import { PilotServiceService } from '../Services/pilot-service.service';

@Component({
  selector: 'app-assign-pilot',
  templateUrl: './assign-pilot.component.html',
  styleUrls: ['./assign-pilot.component.css']
})
export class AssignPilotComponent implements OnInit {

  aeroplanes: Observable<Aeroplane[]>; 
  pilots:Observable<Pilot[]>
  aeroplaneId:number;
  constructor(private aeroplaneService:AeroplaneServiceService,private pilotService:PilotServiceService) { }

  ngOnInit(): void {
    this.reloadData();  
  }
  reloadData(){  
    console.log("aeroplane");
    this.aeroplanes = this.aeroplaneService.getAeroplaneList();
   
  }
  reloadDataClick(aeroplaneId:number){ 
    
    console.log("hanger");
    this.aeroplaneId=aeroplaneId;
    this.pilots = this.pilotService.getPilotList(); 
     
  }
  assignPilot(pilotId:number)
  {
    this.aeroplaneService.upadateAeroplane1(this.aeroplaneId,pilotId).subscribe();
    this.pilotService.upadatePilot(this.aeroplaneId,pilotId).subscribe();
  }

}
