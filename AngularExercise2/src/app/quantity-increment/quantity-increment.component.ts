import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-quantity-increment',
  templateUrl: './quantity-increment.component.html',
  styleUrls: ['./quantity-increment.component.css']
})
export class QuantityIncrementComponent implements OnInit {

  constructor() { }
   eventFire:string;
  ngOnInit(): void {
  }
  onButtonClick(){
   
   this.eventFire='Click me button clicked!'
  }
}
