import { Component, OnInit } from '@angular/core';
import { Hanger } from '../ModelClasses/Hanger';
import { HangerServiceService } from '../Services/hanger-service.service';

@Component({
  selector: 'app-add-hanger',
  templateUrl: './add-hanger.component.html',
  styleUrls: ['./add-hanger.component.css']
})
export class AddHangerComponent implements OnInit {

 hanger:Hanger = new Hanger();
  submitted:boolean = false;
  message:string;
  constructor(private hangerService:HangerServiceService) { }
 
  ngOnInit(): void {
  }
  
 
  save(){
    this.hangerService.createHanger(this.hanger)
    .subscribe(
      data => {
        console.log(data);
        this.submitted = true;
        this.message="Added Successfully";
      },
      error => console.log(error)
    );
    this.hanger = new Hanger();
  }
  onSubmit(){
    this.save();
  }


}
