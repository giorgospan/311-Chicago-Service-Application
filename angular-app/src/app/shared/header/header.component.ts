import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../../_services/authentication.service';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLoggedIn: Observable<boolean>;

  constructor(private authenticationService: AuthenticationService,
              private router: Router) {}

  ngOnInit(): void {
    this.isLoggedIn = this.authenticationService.isLoggedIn();
    // this.isLoggedIn = localStorage.getItem('currentUser') !== null;
  }

  logout(): void {
    this.authenticationService.logout();
  }


}
