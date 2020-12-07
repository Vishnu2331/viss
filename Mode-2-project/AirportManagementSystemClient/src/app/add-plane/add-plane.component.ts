import { Component, OnInit } from '@angular/core';
import {  Pilot } from '../ModelClasses/Pilot';
import { PilotServiceService } from '../Services/pilot-service.service';

@Component({
  selector: 'app-add-plane',
  templateUrl: './add-plane.component.html',
  styleUrls: ['./add-plane.component.css']
})
export class AddPlaneComponent implements OnInit {

  pilot:Pilot = new Pilot();
  submitted:boolean = false;
  constructor(private pilotService:PilotServiceService) { }
 
  ngOnInit(): void {
  }
  
 
  save(){
    this.pilotService.createPilot(this.pilot)
    .subscribe(
      data => {
        console.log(data);
        this.submitted = true;
      },
      error => console.log(error)
    );
    this.pilot = new Pilot();
  }
  onSubmit(){
    this.save();
  }

}
