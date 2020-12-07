import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Hanger } from '../ModelClasses/Hanger';

@Injectable({
  providedIn: 'root'
})
export class HangerServiceService {

  private baseUrl = 'http://localhost:8080/airport/hanger';
  constructor(private http:HttpClient) { }
  createHanger(hanger:any):Observable<any>{
    return this.http.post(this.baseUrl,hanger);
  }
  getHangerList(): Observable<Hanger[]> {
    return this.http.get<Hanger[]>(this.baseUrl);
  }
  updateHanger(hanger: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}` + `/update`, hanger);
  }
  
  setHangerStatus(statusMessage:string,aeroplaneId:number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/update/status/${statusMessage}/${aeroplaneId}`);
  }
  getHangerList9(): Observable<Hanger[]> {
    return this.http.get<Hanger[]>(`${this.baseUrl}/hangers`);
  }
}
