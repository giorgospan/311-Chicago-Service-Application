import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {faCalendar} from '@fortawesome/free-solid-svg-icons';
import {Response2} from '../../../_responses/response2';
import {DateService} from '../../../_services/date.service';


@Component({
  selector: 'app-query2',
  templateUrl: './query2.component.html',
  styleUrls: ['./query2.component.css']
})
export class Query2Component implements OnInit {

  faCalendar = faCalendar;
  results: Response2[];
  page = 1;
  pageSize = 10;
  pageSizeOptions = [10, 20, 30, 100];
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
  constructor(private queryService: QueryService, private dateService: DateService) { }


  ngOnInit(): void {
    this.results = [];
  }
  fetchResults(): void{

    const params  = {from: this.dateService.parseDate(this.fromDate),
      to: this.dateService.parseDate(this.toDate),
      type: this.requestType
    };
    this.queryService.findQuery2(params)
      .subscribe(data => {this.results = data ; console.log(this.results); this.totalItems = this.results.length; } );
  }
  handlePageSizeChange(event): void {
    this.pageSize = event.target.value;
  }

}
