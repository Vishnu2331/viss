import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Aeroplane } from '../ModelClasses/Aeroplane';
import { AeroplaneServiceService } from '../Services/aeroplane-service.service';

@Component({
  selector: 'app-pilot-approval',
  templateUrl: './pilot-approval.component.html',
  styleUrls: ['./pilot-approval.component.css']
})
export class PilotApprovalComponent implements OnInit {

  aeroplanes: Observable<Aeroplane[]>;
  constructor(private aeroplaneService:AeroplaneServiceService) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData(){
    this.aeroplanes = this.aeroplaneService.getAeroplaneList3();
  }
}
