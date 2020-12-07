import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response6} from '../../../_responses/response6';
import {faCalendar} from '@fortawesome/free-solid-svg-icons';
import {DateService} from '../../../_services/date.service';

@Component({
  selector: 'app-query6',
  templateUrl: './query6.component.html',
  styleUrls: ['./query6.component.css']
})
export class Query6Component implements OnInit {

  faCalendar = faCalendar;
  results: Response6[];
  page = 1;
  pageSize = 10;
  pageSizeOptions = [10, 20, 30, 100];
  fromDate: Date;
  toDate: Date;
  totalItems: number;

  constructor(private queryService: QueryService,private dateService: DateService) { }

  ngOnInit(): void {
    this.results = [];
  }

  fetchResults(): void{
    this.queryService.findQuery6({from: this.dateService.parseDate(this.fromDate), to: this.dateService.parseDate(this.toDate)})
      .subscribe(data => {this.results = data ; console.log(this.results); } );
  }
  handlePageSizeChange(event): void {
    this.pageSize = event.target.value;
  }


}
