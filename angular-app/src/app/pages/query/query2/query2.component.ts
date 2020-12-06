import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response9} from '../../../_responses/response9';
import {faCalendar} from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-query2',
  templateUrl: './query2.component.html',
  styleUrls: ['./query2.component.css']
})
export class Query2Component implements OnInit {

  faCalendar = faCalendar;
  results: Response9[];
  page = 1;
  pageSize = 15;
  totalItems;
  fromDate;
  toDate;
  requestType;

  options = [
    'Abandoned Vehicle Complaint',
    'Alley Light Out',
    'Garbage Cart Black Maintenance/Replacement',
    'Graffiti Removal',
    'Pothole in Street',
    'Rodent Baiting/Rat Complaint',
    'Sanitation Code Violation',
    'Street Light - 1/Out',
    'Street Lights - All/Out',
    'Tree Debris',
    'Tree Trim'
  ];
  constructor(private queryService: QueryService) { }


  ngOnInit(): void {
  }
  fetchResults(): void{
    // this.queryService.findQuery1({from: this.fromDate.toISOString(), to: this.toDate.toISOString().slice(0, 10)})
    //   .subscribe(data => {this.results = data ; console.log(this.results); } );
    this.queryService.findQuery9({targetNum: 50})
      .subscribe(data => {this.results = data ; console.log(this.results); this.totalItems = this.results.length; } );
  }
}
