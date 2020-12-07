import { Component, OnInit } from '@angular/core';
import { ManagerServiceService } from '../Services/manager-service.service';
import { Manager } from '../ModelClasses/Manager';

@Component({
  selector: 'app-manager-register',
  templateUrl: './manager-register.component.html',
  styleUrls: ['./manager-register.component.css']
})
export class ManagerRegisterComponent implements OnInit {

  manager:Manager = new Manager();
  submitted:boolean = false;
  constructor(private managerService:ManagerServiceService) { }
 
  ngOnInit(): void {
  }
  
 
  save(){
    this.managerService.createManager(this.manager)
    .subscribe(
      data => {
        console.log(data);
        this.submitted = true;
      },
      error => console.log(error)
    );
    this.manager = new Manager();
  }
  onSubmit(){
    this.save();
  }


}
