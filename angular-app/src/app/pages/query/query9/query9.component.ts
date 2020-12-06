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
  page = 1;
  pageSize = 15;
  totalItems: number;
  constructor(private queryService: QueryService) { }


  ngOnInit(): void {
  }

  fetchResults(): void{
    this.queryService.findQuery9({targetNum: this.numOfPremises})
      .subscribe(data => {this.results = data ; console.log(this.results); } );
  }


}
