import { Component, OnInit } from '@angular/core';
import { Manager } from '../ModelClasses/Manager';
import { Observable } from 'rxjs';
import { ManagerServiceService } from '../Services/manager-service.service';

@Component({
  selector: 'app-manager-approval',
  templateUrl: './manager-approval.component.html',
  styleUrls: ['./manager-approval.component.css']
})
export class ManagerApprovalComponent implements OnInit {
  managers: Observable<Manager[]>;
  constructor(private managerService:ManagerServiceService) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData(){
    this.managers = this.managerService.getManagersList();
  }
}
