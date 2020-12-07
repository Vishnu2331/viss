import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor() { }
loggedIn=false;
 
logOut():void{​​​​​​​​
this.loggedIn=false;
  }​​​​​​​​

login():void{​​​​​​​​
this.loggedIn=true;
  }​​​​​​​​


}
