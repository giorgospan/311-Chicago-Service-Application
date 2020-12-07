import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response3} from '../../../_responses/response3';
import {faCalendar} from '@fortawesome/free-solid-svg-icons';
import {DateService} from '../../../_services/date.service';


@Component({
  selector: 'app-query3',
  templateUrl: './query3.component.html',
  styleUrls: ['./query3.component.css']
})
export class Query3Component implements OnInit {

  faCalendar = faCalendar;
  results: Response3[];
  page = 1;
  pageSize = 10;
  pageSizeOptions = [10, 20, 30, 100];
  targetDate: Date;
  totalItems: number;

  constructor(private queryService: QueryService, private dateService: DateService) { }


  ngOnInit(): void {
    this.results = [];
  }

  fetchResults(): void{
    this.queryService.findQuery3({targetTm: this.dateService.parseDate(this.targetDate)})
      .subscribe(data => {this.results = data ; console.log(this.results); this.totalItems = this.results.length; } );
  }
  handlePageSizeChange(event): void {
    this.pageSize = event.target.value;
  }

}
