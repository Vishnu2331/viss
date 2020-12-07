import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Manager } from '../ModelClasses/Manager';

@Injectable({
  providedIn: 'root'
})
export class ManagerServiceService {

  private baseUrl = 'http://localhost:8080/airport/manager';
  constructor(private http:HttpClient) { }
  createManager(manager:any):Observable<any>{
    return this.http.post(this.baseUrl, manager);
  }

  findByEmail(adminEmail: string): Observable<Manager> {
    return this.http.get<Manager>(`${this.baseUrl}/${adminEmail}`);
  }
  getManagersList(): Observable<Manager[]> {
    return this.http.get<Manager[]>(this.baseUrl);
  }
  setManagerStatus(manager: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}` + `/update`, manager);
  }
}
