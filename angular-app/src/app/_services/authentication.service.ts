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

  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;

  constructor(private http: HttpClient, private router: Router) {
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }

  login(body: LoginRequest): Observable<User> {
    return this.http.post<User>( environment.serverUrl + environment.login , body)
      .pipe(map(user => {
        // store user details and jwt token in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUser', JSON.stringify(user));
        this.currentUserSubject.next(user);
        console.log(user.jwt);
        return user;
      }));
  }

  register(body: RegistrationRequest): Observable<any> {
    delete body.confirmPassword;
    const s = JSON.stringify(body);
    return this.http.post<any>(environment.serverUrl + environment.register , body);
  }

  logout(): void {
    localStorage.removeItem('currentUser');
    localStorage.clear();
    this.currentUserSubject.next(null);
    this.router.navigate(['/login']);
  }


}
