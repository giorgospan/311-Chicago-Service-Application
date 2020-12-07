import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response4} from '../../../_responses/response4';
import {faCalendar} from '@fortawesome/free-solid-svg-icons';
import {DateService} from '../../../_services/date.service';

@Component({
  selector: 'app-query4',
  templateUrl: './query4.component.html',
  styleUrls: ['./query4.component.css']
})
export class Query4Component implements OnInit {

  faCalendar = faCalendar;
  results: Response4[];
  page = 1;
  pageSize = 10;
  pageSizeOptions = [10, 20, 30, 100];
  fromDate: Date;
  toDate: Date;
  totalItems: number;

  constructor(private queryService: QueryService, private dateService: DateService) { }

  ngOnInit(): void {
    this.results = [];
  }

  fetchResults(): void{

    this.queryService.findQuery4({from: this.dateService.parseDate(this.fromDate), to: this.dateService.parseDate(this.toDate)})
      .subscribe(data => {this.results = data ; console.log(this.results); } );
  }
  handlePageSizeChange(event): void {
    this.pageSize = event.target.value;
  }

}
