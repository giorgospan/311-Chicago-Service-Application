import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpParams} from '@angular/common/http';
import {User} from '../_models/user';
import {environment} from '../../environments/environment';
import {catchError, first, map, retry, tap} from 'rxjs/operators';
import {Observable, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  // tslint:disable-next-line:typedef
  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // Return an observable with a user-facing error message.
    return throwError(
      'Something bad happened; please try again later.');
  }


  getStuff(id: string): Observable<User> {

    const params = new HttpParams()
      .set('id', id);

    // Just make a GET request for testing
    return this.http.get<User>(environment.serverUrl + environment.stuff, {params})
      .pipe(map(user => {
        return user;
      }));
  }
}
