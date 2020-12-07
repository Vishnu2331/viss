import { Injectable } from '@angular/core';
import { Router, ActivatedRouteSnapshot } from '@angular/router';
import { AuthServiceService } from './auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard1Service {

 
  isLoggedIn = false;
    
  constructor(private _router : Router, private _authService :AuthServiceService){
  }
  canActivate(route: ActivatedRouteSnapshot): boolean{        
      this.isLoggedIn = this._authService.loggedIn;
      console.log("isLoggedIn: " + this.isLoggedIn);
      if(this.isLoggedIn){
          return true;
      }
      else{
          this._router.navigate(['managerLogin']);
          return false;
      }        
  }
}
