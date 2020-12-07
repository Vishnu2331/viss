import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../Services/admin-service.service';
import { Admin } from '../ModelClasses/Admin';
import { Router } from '@angular/router';
import { AuthServiceService } from '../Services/auth-service.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  admin:Admin=new Admin();
  constructor(private adminService:AdminServiceService,private router:Router,private _authService:AuthServiceService) { }
submitted:boolean=true;
message:string;
  ngOnInit(): void {
  }
  findByEmail(){
    this.adminService.findByEmail(this.admin.adminEmail)
    .subscribe(
      admin1=> {
        if(admin1!=null)
        {
        if(admin1.adminPassword == this.admin.adminPassword)
        {
         this._authService.login();
          this.router.navigate(["adminHome"]);
        }
        else{
          this.submitted=false;
          this.message="Invalid Credentials";
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
