import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {AuthenticationService} from '../../_services/authentication.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isLoggedIn: Observable<boolean>;
  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.authenticationService.isLoggedIn();

  }

}
