import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Aeroplane } from '../ModelClasses/Aeroplane';

@Injectable({
  providedIn: 'root'
})
export class AeroplaneServiceService {

  private baseUrl = 'http://localhost:8080/airport/aeroplane';
  constructor(private http:HttpClient) { }
  createAeroplane(aeroplane:any):Observable<any>{
    return this.http.post(this.baseUrl, aeroplane);
  }
  getAeroplaneList(): Observable<Aeroplane[]> {
    return this.http.get<Aeroplane[]>(`${this.baseUrl}/pilot`);
  }
  getAeroplaneList1(): Observable<Aeroplane[]> {
    return this.http.get<Aeroplane[]>(`${this.baseUrl}/hanger`);
  }
  upadateAeroplane(aeroplaneId:number,hangerId:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${aeroplaneId}/${hangerId}`);
  }
  upadateAeroplane1(aeroplaneId:number,pilotId:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/pilot/${aeroplaneId}/${pilotId}`);
  }
  getAeroplaneList2(): Observable<Aeroplane[]> {
    return this.http.get<Aeroplane[]>(`${this.baseUrl}/hanger/approval`);
  }

  getAeroplaneList3(): Observable<Aeroplane[]> {
    return this.http.get<Aeroplane[]>(`${this.baseUrl}/pilot/approval1`);
  }

  getAeroplaneList9(): Observable<Aeroplane[]> {
    return this.http.get<Aeroplane[]>(this.baseUrl);
  }
}
