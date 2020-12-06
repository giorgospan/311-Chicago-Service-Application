import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response4} from '../../../_responses/response4';
import {faCalendar} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-query4',
  templateUrl: './query4.component.html',
  styleUrls: ['./query4.component.css']
})
export class Query4Component implements OnInit {

  faCalendar = faCalendar;
  results: Response4[];
  page = 1;
  pageSize = 15;
  fromDate: Date;
  toDate: Date;
  totalItems: number;

  constructor(private queryService: QueryService) { }

  ngOnInit(): void {
  }

  fetchResults(): void{
    this.queryService.findQuery4({from: this.fromDate.toISOString(), to: this.toDate.toISOString().slice(0, 10)})
      .subscribe(data => {this.results = data ; console.log(this.results); } );
  }

}
