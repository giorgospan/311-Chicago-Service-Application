import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {faArrowCircleRight} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-selection',
  templateUrl: './selection.component.html',
  styleUrls: ['./selection.component.css']
})
export class SelectionComponent implements OnInit {
  faArrowCircleRight = faArrowCircleRight;
  constructor() { }

  ngOnInit(): void {
  }

}
