import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response7} from '../../../_responses/response7';


@Component({
  selector: 'app-query7',
  templateUrl: './query7.component.html',
  styleUrls: ['./query7.component.css']
})
export class Query7Component implements OnInit {

  results: Response7[];
  page = 1;
  pageSize = 10;
  pageSizeOptions = [10, 20, 30, 100];
  totalItems: number;

  constructor(private queryService: QueryService) { }


  ngOnInit(): void {
    this.fetchResults();
    this.results = [];
  }

  fetchResults(): void{
    this.queryService.findQuery7()
      .subscribe(data => {this.results = data ; console.log(this.results); this.totalItems = this.results.length; } );
  }
  handlePageSizeChange(event): void {
    this.pageSize = event.target.value;
  }


}
