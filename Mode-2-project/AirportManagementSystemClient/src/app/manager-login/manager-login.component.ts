import { Component, OnInit } from '@angular/core';
import { Manager } from '../ModelClasses/Manager';
import { ManagerServiceService } from '../Services/manager-service.service';
import { Router } from '@angular/router';
import { AuthServiceService } from '../Services/auth-service.service';

@Component({
  selector: 'app-manager-login',
  templateUrl: './manager-login.component.html',
  styleUrls: ['./manager-login.component.css']
})
export class ManagerLoginComponent implements OnInit {

  manager:Manager=new Manager();
  constructor(private managerService:ManagerServiceService,private router:Router,private _authService:AuthServiceService) { }
submitted:boolean=true;
message:string;
  ngOnInit(): void {
  }
  findByEmail(){
    this.managerService.findByEmail(this.manager.managerEmail)
    .subscribe(
      manager1=> {
        if(manager1!=null)
        {
          if(manager1.managerStatus=="ACCEPTED")
          {
        if(manager1.managerPassword == this.manager.managerPassword)
        {
          this._authService.login();
          this.router.navigate(["managerHome"]);
          
        }
        else{
          this.submitted=false;
          this.message="Invalid Credentials";
        }
      }
      else{
        this.submitted=false;
        this.message="Admin Rejected Your Request";
      }
      }
      else{
        this.submitted=false;
        this.message="Please Register First";
      }
      },
      error => console.log(error)
    );
    
  }
  onSubmit(){
    this.findByEmail();
  }
  navigate()
  {

  }

}
