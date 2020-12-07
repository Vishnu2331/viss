import { Component, OnInit } from '@angular/core';
import { PilotServiceService } from '../Services/pilot-service.service';
import { Observable } from 'rxjs';
import { Pilot } from '../ModelClasses/Pilot';

@Component({
  selector: 'app-pilot',
  templateUrl: './pilot.component.html',
  styleUrls: ['./pilot.component.css']
})
export class PilotComponent implements OnInit {

  pilots:Observable<Pilot[]>
  constructor(private pilotService:PilotServiceService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){ 
    this.pilots = this.pilotService.getPilotList9(); 
  }

}
