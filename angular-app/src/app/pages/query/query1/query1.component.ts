import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {faCalendar} from '@fortawesome/free-solid-svg-icons';
import {Response1} from '../../../_responses/response1';

@Component({
  selector: 'app-query1',
  templateUrl: './query1.component.html',
  styleUrls: ['./query1.component.css']
})
export class Query1Component implements OnInit {

  faCalendar = faCalendar;
  results: Response1[];
  fromDate: Date;
  toDate: Date;
  page = 1;
  pageSize = 15;
  totalItems: number;

  constructor(private queryService: QueryService) { }

  ngOnInit(): void {
  }

  fetchResults(): void{
    this.queryService.findQuery1({from: this.fromDate.toISOString(), to: this.toDate.toISOString().slice(0, 10)})
      .subscribe(data => {this.results = data ; console.log(this.results); } );
  }

}
