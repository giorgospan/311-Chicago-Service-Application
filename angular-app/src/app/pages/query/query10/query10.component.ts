import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response10} from '../../../_responses/response10';

@Component({
  selector: 'app-query10',
  templateUrl: './query10.component.html',
  styleUrls: ['./query10.component.css']
})
export class Query10Component implements OnInit {

  results: Response10[];
  numOfPremises: number;
  page = 1;
  pageSize = 10;
  pageSizeOptions = [10, 20, 30, 100];
  totalItems: number;
  constructor(private queryService: QueryService) { }


  ngOnInit(): void {
    this.results = [];
  }

  fetchResults(): void{
    this.queryService.findQuery10({targetNum: this.numOfPremises})
      .subscribe(data => {this.results = data ; console.log(this.results); } );
  }
  handlePageSizeChange(event): void {
    this.pageSize = event.target.value;
  }


}
