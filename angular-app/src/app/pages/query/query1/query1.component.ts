import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {faCalendar} from '@fortawesome/free-solid-svg-icons';
import {Response1} from '../../../_responses/response1';
import {DateService} from '../../../_services/date.service';

@Component({
  selector: 'app-query1',
  templateUrl: './query1.component.html',
  styleUrls: ['./query1.component.css']
})
export class Query1Component implements OnInit {

  faCalendar = faCalendar;
  results: Response1[];
  totalItems: number;
  fromDate;
  toDate;
  page = 1;
  pageSize = 10;
  pageSizeOptions = [10, 20, 30, 100];

  constructor(private queryService: QueryService, private dateService: DateService) { }

  ngOnInit(): void {
    this.results = [];
  }

  fetchResults(): void{

    this.queryService.findQuery1({from: this.dateService.parseDate(this.fromDate), to: this.dateService.parseDate(this.toDate)})
      .subscribe(data => {this.results = data ; console.log(this.results); } );
  }

  handlePageSizeChange(event): void {
    this.pageSize = event.target.value;
  }
}
