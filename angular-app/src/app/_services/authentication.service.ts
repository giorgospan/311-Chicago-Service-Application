import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {HttpClient} from '@angular/common/http';
import {LoginRequest} from '../_requests/authentication/login-request';
import {environment} from '../../environments/environment';
import {Router} from '@angular/router';
import {RegistrationRequest} from '../_requests/authentication/registration-request';
import {User} from '../_models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient, private  router: Router) {
    if (localStorage.getItem('currentUser') != null)
    {this.loggedIn.next(true);}
  }

  login(body: LoginRequest): Observable<User> {
    return this.http.post<User>( environment.serverUrl + environment.login , body)
      .pipe(map(user => {
        // store user details and jwt token in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUser', JSON.stringify(user));
        this.loggedIn.next(true);
        return user;
      }));
  }

  register(body: RegistrationRequest): Observable<User> {
    return this.http.post<User>(environment.serverUrl + environment.register , body)
      .pipe(map(user => {
        // store user details and jwt token in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUser', JSON.stringify(user));
        this.loggedIn.next(true);
        return user;
      }));
  }
  // tslint:disable-next-line:typedef
  isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  logout(): void {
    localStorage.removeItem('currentUser');
    localStorage.clear();
    this.loggedIn.next(false);
    this.router.navigate(['/']);
  }


}
