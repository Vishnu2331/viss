import { Component, OnInit } from '@angular/core';
import { Aeroplane } from '../ModelClasses/Aeroplane';
import { AeroplaneServiceService } from '../Services/aeroplane-service.service';

@Component({
  selector: 'app-add-aeroplane',
  templateUrl: './add-aeroplane.component.html',
  styleUrls: ['./add-aeroplane.component.css']
})
export class AddAeroplaneComponent implements OnInit {

  aeroplane:Aeroplane = new Aeroplane();
  submitted:boolean = false;
  message:string;
  constructor(private aeroplaneService:AeroplaneServiceService) { }
 
  ngOnInit(): void {
  }
  
 
  save(){
    this.aeroplaneService.createAeroplane(this.aeroplane)
    .subscribe(
      data => {
        console.log(data);
        this.submitted = true;
        this.message="Added Successfully";
      },
      error => console.log(error)
    );
    this.aeroplane = new Aeroplane();
  }
  onSubmit(){
    this.save();
  }


}
