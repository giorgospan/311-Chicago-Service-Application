import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Response1} from '../_responses/response1';
import {environment} from '../../environments/environment';
import {map} from 'rxjs/operators';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Response11} from '../_responses/response11';
import {Response12} from '../_responses/response12';
import {Response9} from '../_responses/response9';
import {Response10} from '../_responses/response10';
import {Response8} from '../_responses/response8';
import {Response6} from '../_responses/response6';
import {Response7} from '../_responses/response7';
import {Response4} from '../_responses/response4';
import {Response5} from '../_responses/response5';
import {Response3} from '../_responses/response3';
import {Response2} from '../_responses/response2';

@Injectable({
  providedIn: 'root'
})
export class QueryService {

  constructor(private http: HttpClient) { }

  findQuery1(params): Observable<Response1[]>{

    console.log(params);
    return this.http.get<Response1[]>(environment.serverUrl + environment.query1, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery2(params): Observable<Response2[]>{

    return this.http.get<Response2[]>(environment.serverUrl + environment.query2, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery3(params): Observable<Response3[]>{

    return this.http.get<Response3[]>(environment.serverUrl + environment.query3, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery4(params): Observable<Response4[]>{

    return this.http.get<Response4[]>(environment.serverUrl + environment.query4, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery5(params): Observable<Response5[]>{

    return this.http.get<Response5[]>(environment.serverUrl + environment.query5, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery6(params): Observable<Response6[]>{

    return this.http.get<Response6[]>(environment.serverUrl + environment.query6, {params})
      .pipe(map(values => {
        return values;
      }));
  }


  findQuery7(): Observable<Response7[]>{

    return this.http.get<Response7[]>(environment.serverUrl + environment.query7)
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery8(): Observable<Response8[]>{

    return this.http.get<Response8[]>(environment.serverUrl + environment.query8)
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery9(params): Observable<Response9[]>{

    return this.http.get<Response9[]>(environment.serverUrl + environment.query9, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery10(params): Observable<Response10[]>{

    return this.http.get<Response10[]>(environment.serverUrl + environment.query10, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery11(params): Observable<Response11[]>{

    return this.http.get<Response11[]>(environment.serverUrl + environment.query11, {params})
      .pipe(map(values => {
        return values;
      }));
  }

  findQuery12(params): Observable<Response12[]>{

    return this.http.get<Response12[]>(environment.serverUrl + environment.query12, {params})
      .pipe(map(values => {
        return values;
      }));
  }
}
