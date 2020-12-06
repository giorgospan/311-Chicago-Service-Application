import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response11} from '../../../_responses/response11';

@Component({
  selector: 'app-query11',
  templateUrl: './query11.component.html',
  styleUrls: ['./query11.component.css']
})
export class Query11Component implements OnInit {

  results: Response11[];
  numOfPremises: number;
  page = 1;
  pageSize = 15;
  totalItems: number;
  constructor(private queryService: QueryService) { }


  ngOnInit(): void {
  }

  fetchResults(): void{
    this.queryService.findQuery11({targetNum: this.numOfPremises})
      .subscribe(data => {this.results = data ; console.log(this.results); } );
  }

}
