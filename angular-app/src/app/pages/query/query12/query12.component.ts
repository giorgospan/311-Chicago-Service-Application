import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response12} from '../../../_responses/response12';
import {faCalendar} from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-query12',
  templateUrl: './query12.component.html',
  styleUrls: ['./query12.component.css']
})
export class Query12Component implements OnInit {

  faCalendar = faCalendar;
  results: Response12[];
  page = 1;
  pageSize = 15;
  totalItems: number;
  targetDate: Date;

  constructor(private queryService: QueryService) { }

  ngOnInit(): void {
  }

  fetchResults(): void{
    this.queryService.findQuery12({targetDt: null})
      .subscribe(data => {this.results = data ; console.log(this.results); } );
  }
}
