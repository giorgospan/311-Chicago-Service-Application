import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response6} from '../../../_responses/response6';
import {faCalendar} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-query6',
  templateUrl: './query6.component.html',
  styleUrls: ['./query6.component.css']
})
export class Query6Component implements OnInit {

  faCalendar = faCalendar;
  results: Response6[];
  page = 1;
  pageSize = 15;
  fromDate: Date;
  toDate: Date;
  totalItems: number;

  constructor(private queryService: QueryService) { }

  ngOnInit(): void {
  }

  fetchResults(): void{
    // this.queryService.findQuery6({from: this.fromDate.toISOString(), to: this.toDate.toISOString().slice(0, 10)})
    //   .subscribe(data => {this.results = data ; console.log(this.results); } );
  }

}
