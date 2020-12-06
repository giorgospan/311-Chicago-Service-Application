import { Component, OnInit } from '@angular/core';
import {first} from 'rxjs/operators';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {LoginRequest} from '../../_requests/authentication/login-request';
import {RegistrationRequest} from '../../_requests/authentication/registration-request';
import {User} from '../../_models/user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  registrationForm: RegistrationRequest;
  showErrorMessage = false;

  constructor(private router: Router,
              private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
    this.registrationForm = new RegistrationRequest();
  }

  public register(): void {

    const registerObserver = {
      error: err => {
        console.log('>>>Error: ' + err);
        this.showErrorMessage = true;
      }
    };

    this.authenticationService.register(this.registrationForm)
      .pipe(first())
      .subscribe(registerObserver);
    this.router.navigate(['/login']);
  }

}
