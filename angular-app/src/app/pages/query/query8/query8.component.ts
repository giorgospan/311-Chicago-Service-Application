import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response8} from '../../../_responses/response8';

@Component({
  selector: 'app-query8',
  templateUrl: './query8.component.html',
  styleUrls: ['./query8.component.css']
})
export class Query8Component implements OnInit {

  results: Response8[];
  mostCommonColor;
  constructor(private queryService: QueryService) { }


  ngOnInit(): void {
    this.fetchResults();
    this.results = [];
  }

  fetchResults(): void{
    this.queryService.findQuery8()
      .subscribe(data => {this.mostCommonColor = data[0].color; } );
  }
}
