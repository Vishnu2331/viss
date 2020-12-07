import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Aeroplane } from '../ModelClasses/Aeroplane';
import { AeroplaneServiceService } from '../Services/aeroplane-service.service';

@Component({
  selector: 'app-planes',
  templateUrl: './planes.component.html',
  styleUrls: ['./planes.component.css']
})
export class PlanesComponent implements OnInit {

  aeroplanes:Observable<Aeroplane[]>;
  constructor(private aeroplaneService:AeroplaneServiceService) { }

  ngOnInit(): void {
    this.reloadData();  
  }
  reloadData(){  
    console.log("aeroplane");
    this.aeroplanes = this.aeroplaneService.getAeroplaneList9();
   
  }

}
