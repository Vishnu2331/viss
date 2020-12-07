import { Component, OnInit } from '@angular/core';
import { Aeroplane } from '../ModelClasses/Aeroplane';
import { Observable } from 'rxjs';
import { AeroplaneServiceService } from '../Services/aeroplane-service.service';
import { HangerServiceService } from '../Services/hanger-service.service';
import { Hanger } from '../ModelClasses/Hanger';

@Component({
  selector: 'app-assign-hanger',
  templateUrl: './assign-hanger.component.html',
  styleUrls: ['./assign-hanger.component.css']
})
export class AssignHangerComponent implements OnInit {

  aeroplanes: Observable<Aeroplane[]>; 
  hangers:Observable<Hanger[]>
  aeroplaneId:number;
  constructor(private aeroplaneService:AeroplaneServiceService,private hangerService:HangerServiceService) { }

  ngOnInit(): void {
    this.reloadData();  
  }
  reloadData(){  
  
    this.aeroplanes = this.aeroplaneService.getAeroplaneList1();
   
  }
  reloadDataClick(aeroplaneId:number){ 
 
    this.aeroplaneId=aeroplaneId;
    this.hangers = this.hangerService.getHangerList(); 
     
  }
  assignHanger(hangerId:number,hanger:Hanger)
  {
     hanger.hangerAvailability=hanger.hangerAvailability-1;
     this.hangerService.updateHanger(hanger).subscribe();
    this.aeroplaneService.upadateAeroplane(this.aeroplaneId,hangerId).subscribe();
    
  }
}
 