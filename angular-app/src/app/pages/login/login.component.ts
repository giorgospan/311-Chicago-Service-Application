import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../../_services/authentication.service';
import {Router} from '@angular/router';
import {LoginRequest} from '../../_requests/authentication/login-request';
import {first} from 'rxjs/operators';
import {User} from '../../_models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: LoginRequest;
  showErrorMessage = false;
  submitted = false;


  constructor(private router: Router,
              private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
    this.loginForm = new LoginRequest();
  }

  public login(): void {

    this.submitted = true;
    const loginObserver = {
      next: user => {
        this.router.navigate(['']);
      },
      error: err => {
        console.log('>>>Error: ' + err);
        this.showErrorMessage = true;
      }
    };

    this.authenticationService.login(this.loginForm)
      .pipe(first())
      .subscribe(loginObserver);
  }
}
