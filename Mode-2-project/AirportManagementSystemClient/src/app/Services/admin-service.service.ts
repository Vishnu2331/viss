import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from '../ModelClasses/Admin';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {
  private baseUrl = 'http://localhost:8080/airport/admin';
  constructor(private http:HttpClient) { }
  createAdmin(admin:any):Observable<any>{
    return this.http.post(this.baseUrl, admin);
  }

  findByEmail(adminEmail: string): Observable<Admin> {
    return this.http.get<Admin>(`${this.baseUrl}/${adminEmail}`);
  }
}
