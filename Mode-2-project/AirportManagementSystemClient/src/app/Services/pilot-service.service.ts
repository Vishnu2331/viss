import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pilot } from '../ModelClasses/Pilot';

@Injectable({
  providedIn: 'root'
})
export class PilotServiceService {
  private baseUrl = 'http://localhost:8080/airport/pilot';
  constructor(private http:HttpClient) { }
  createPilot(pilot:any):Observable<any>{
    return this.http.post(this.baseUrl, pilot);
  }
  getPilotList(): Observable<Pilot[]> {
    return this.http.get<Pilot[]>(this.baseUrl);
  }
  upadatePilot(aeroplaneId:number,pilotId:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/aeroplane/${aeroplaneId}/${pilotId}`);
  }

  setPilotStatus(statusMessage:string,aeroplaneId:number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/update/status/${statusMessage}/${aeroplaneId}`);
  }
  getPilotList9(): Observable<Pilot[]> {
    return this.http.get<Pilot[]>(`${this.baseUrl}/pilots`);
  }
} 
