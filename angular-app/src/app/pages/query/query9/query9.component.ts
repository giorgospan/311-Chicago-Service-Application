import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response9} from '../../../_responses/response9';

@Component({
  selector: 'app-query9',
  templateUrl: './query9.component.html',
  styleUrls: ['./query9.component.css']
})
export class Query9Component implements OnInit {

  results: Response9[];
  numOfPremises: number;
  totalItems: number;
  page = 1;
  pageSize = 10;
  pageSizeOptions = [10, 20, 30, 100];
  constructor(private queryService: QueryService) { }


  ngOnInit(): void {
    this.results = [];
  }

  fetchResults(): void{
    this.queryService.findQuery9({targetNum: this.numOfPremises})
      .subscribe(data => {this.results = data ; console.log(this.results); this.totalItems = this.results.length; } );
  }

  handlePageSizeChange(event): void {
    this.pageSize = event.target.value;
  }

}
