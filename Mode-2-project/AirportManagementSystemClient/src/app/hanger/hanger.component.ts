import { Component, OnInit } from '@angular/core';
import { HangerServiceService } from '../Services/hanger-service.service';
import { Observable } from 'rxjs';
import { Hanger } from '../ModelClasses/Hanger';

@Component({
  selector: 'app-hanger',
  templateUrl: './hanger.component.html',
  styleUrls: ['./hanger.component.css']
})
export class HangerComponent implements OnInit {

  constructor(private hangerService:HangerServiceService) { }

  hangers:Observable<Hanger[]>;
  ngOnInit(): void {
    this.reloadData();
  }
  reloadData(){ 
 
    
    this.hangers = this.hangerService.getHangerList9(); 
     
  }
}
