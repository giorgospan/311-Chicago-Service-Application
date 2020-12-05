import { Component, OnInit } from '@angular/core';
import {User} from '../../_models/user';
import {NgbDatepicker} from '@ng-bootstrap/ng-bootstrap';
import {NgbDatepickerDayView} from '@ng-bootstrap/ng-bootstrap/datepicker/datepicker-day-view';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: User;
  model: NgbDatepicker;

  constructor() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }
  ngOnInit(): void {
  }

}
