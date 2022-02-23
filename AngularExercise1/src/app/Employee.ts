import {Department} from './department';
import {Skill} from './skill';
export interface Employee
{
  employeeId:number;
  employeeName:string;
  employeeSalary:number;
  employeePermanent:boolean;
  department:Department;
  skill:Skill[];
  date:Date;

}