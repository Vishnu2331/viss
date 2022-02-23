import { Component, OnInit } from '@angular/core';
import { Employee } from '../Employee';
import { Department } from '../department';
import { Skill } from '../skill';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
  }
   department1:Department={departmentId:1000,departmentName:"FS"};
   skill1:Skill[]=[{skillId:101,skillName:"java"},{skillId:102,skillName:"Angular Js"},{skillId:103,skillName:"Spring"}];
   employee1:Employee={employeeId:1,employeeName:"Naveen",employeeSalary:1000,employeePermanent:true,department:this.department1,skill:this.skill1,date:new Date('06/18/1999')};
   department2:Department={departmentId:1000,departmentName:"FS"};
   skill2:Skill[]=[{skillId:101,skillName:"java"},{skillId:102,skillName:"Angular Js"},{skillId:103,skillName:"Spring"}];
   employee2:Employee={employeeId:2,employeeName:"Varun",employeeSalary:1000,employeePermanent:true,department:this.department2,skill:this.skill2,date:new Date('12/31/2001')};
   department3:Department={departmentId:1000,departmentName:"FS"};
   skill3:Skill[]=[{skillId:101,skillName:"java"},{skillId:102,skillName:"Angular Js"},{skillId:103,skillName:"Spring"}];
   employee3:Employee={employeeId:3,employeeName:"Surya",employeeSalary:1000,employeePermanent:false,department:this.department3,skill:this.skill3,date:new Date('10/25/2002')};
   department4:Department={departmentId:1000,departmentName:"FS"};
   skill4:Skill[]=[{skillId:101,skillName:"java"},{skillId:102,skillName:"Angular Js"},{skillId:103,skillName:"Spring"}];
   employee4:Employee={employeeId:4,employeeName:"Bhanu",employeeSalary:1000,employeePermanent:false,department:this.department4,skill:this.skill4,date:new Date('02/01/2020')};
   employees:Employee[]=[this.employee1,this.employee2,this.employee3,this.employee4];
}
