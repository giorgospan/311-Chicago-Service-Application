import { Component, OnInit } from '@angular/core';
import {User} from '../../_models/user';
import {NgbDatepicker} from '@ng-bootstrap/ng-bootstrap';
import {NgbDatepickerDayView} from '@ng-bootstrap/ng-bootstrap/datepicker/datepicker-day-view';
import {UserService} from '../../_services/user.service';
import {Observable} from 'rxjs';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  model: NgbDatepicker;

  constructor(private userService: UserService) {
    // this.user = JSON.parse(localStorage.getItem('currentUser'));
  }
  ngOnInit(): void {
    console.log('ProfileComponent');

    const stuffObserver = {
      next: user => {
        console.log(JSON.stringify(user));
      },
      error: err => {
        console.log('>>>Error: ' + err);
      }
    };
    this.userService.getStuff('32')
      .pipe(first())
      .subscribe(stuffObserver);
  }

}
