import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response12} from '../../../_responses/response12';
import {faCalendar} from '@fortawesome/free-solid-svg-icons';
import {DateService} from '../../../_services/date.service';


@Component({
  selector: 'app-query12',
  templateUrl: './query12.component.html',
  styleUrls: ['./query12.component.css']
})
export class Query12Component implements OnInit {

  faCalendar = faCalendar;
  results: Response12[];
  page = 1;
  pageSize = 10;
  pageSizeOptions = [10, 20, 30, 100];
  totalItems: number;
  targetDate: Date;

  constructor(private queryService: QueryService, private dateService: DateService) { }

  ngOnInit(): void {
    this.results = [];
  }

  fetchResults(): void{
    this.queryService.findQuery12({targetDt: this.dateService.parseDate(this.targetDate)})
      .subscribe(data => {this.results = data ; console.log(this.results); } );
  }
  handlePageSizeChange(event): void {
    this.pageSize = event.target.value;
  }

}
