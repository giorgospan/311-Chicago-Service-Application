import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Response1} from '../_responses/response1';
import {environment} from '../../environments/environment';
import {map} from 'rxjs/operators';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class QueryService {

  constructor(private http: HttpClient) { }

  findQuery1(from: Date, to: Date): Observable<Response1[]>{

    const params = new HttpParams();

    return this.http.get<Response1[]>(environment.serverUrl + environment.query1, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery2(type: string, from: Date, to: Date): Observable<Response1[]>{

    const params = new HttpParams();

    return this.http.get<Response1[]>(environment.serverUrl + environment.query1, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery3(targetTm: Date): Observable<Response1[]>{

    const params = new HttpParams();

    return this.http.get<Response1[]>(environment.serverUrl + environment.query1, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery4(from: Date, to: Date): Observable<Response1[]>{

    const params = new HttpParams();

    return this.http.get<Response1[]>(environment.serverUrl + environment.query1, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery5(xMin: number, yMin: number , xMax: number, yMax: number, targetDt: Date): Observable<Response1[]>{

    const params = new HttpParams();

    return this.http.get<Response1[]>(environment.serverUrl + environment.query1, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery6(from: Date, to: Date): Observable<Response1[]>{

    const params = new HttpParams();

    return this.http.get<Response1[]>(environment.serverUrl + environment.query1, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery7(): Observable<Response1[]>{

    const params = new HttpParams();

    return this.http.get<Response1[]>(environment.serverUrl + environment.query1, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery8(): Observable<Response1[]>{

    const params = new HttpParams();

    return this.http.get<Response1[]>(environment.serverUrl + environment.query1, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery9(targetNum: number): Observable<Response1[]>{

    const params = new HttpParams();

    return this.http.get<Response1[]>(environment.serverUrl + environment.query1, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery10(targetNum: number): Observable<Response1[]>{

    const params = new HttpParams();

    return this.http.get<Response1[]>(environment.serverUrl + environment.query1, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery11(targetNum: number): Observable<Response1[]>{

    const params = new HttpParams();

    return this.http.get<Response1[]>(environment.serverUrl + environment.query1, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery12(targetDt: Date): Observable<Response1[]>{

    const params = new HttpParams();

    return this.http.get<Response1[]>(environment.serverUrl + environment.query1, {params})
      .pipe(map(values => {
        return values;
      }));
  }
}
