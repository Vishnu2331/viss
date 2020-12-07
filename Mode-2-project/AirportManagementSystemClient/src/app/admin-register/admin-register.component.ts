import { Component, OnInit } from '@angular/core';
import { Admin } from '../ModelClasses/Admin';
import { AdminServiceService } from '../Services/admin-service.service';

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.css']
})
export class AdminRegisterComponent implements OnInit {

  admin:Admin = new Admin();
  submitted:boolean = false;
  constructor(private adminService:AdminServiceService) { }
 
  ngOnInit(): void {
  }
  
 
  save(){
    this.adminService.createAdmin(this.admin)
    .subscribe(
      data => {
        console.log(data);
        this.submitted = true;
      },
      error => console.log(error)
    );
    this.admin = new Admin();
  }
  onSubmit(){
    this.save();
  }

}
