import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Aeroplane } from '../ModelClasses/Aeroplane';
import { AeroplaneServiceService } from '../Services/aeroplane-service.service';

@Component({
  selector: 'app-hanger-approval',
  templateUrl: './hanger-approval.component.html',
  styleUrls: ['./hanger-approval.component.css']
})
export class HangerApprovalComponent implements OnInit {

  aeroplanes: Observable<Aeroplane[]>;
  constructor(private aeroplaneService:AeroplaneServiceService) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData(){
    this.aeroplanes = this.aeroplaneService.getAeroplaneList2();
  }
}
