import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';
import {Response5} from '../../../_responses/response5';
import {faCalendar} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-query5',
  templateUrl: './query5.component.html',
  styleUrls: ['./query5.component.css']
})
export class Query5Component implements OnInit {

  faCalendar = faCalendar;
  targetDate: Date;
  results: Response5[];
  xMin; yMin; xMax; yMax;
  constructor(private queryService: QueryService) { }


  ngOnInit(): void {
    this.targetDate = new Date();
  }

  fetchResults(): void{
    const params  = {targetDt: this.targetDate.toISOString().slice(0, 10),
      xMin: this.xMin,
      xMax: this.xMax,
      yMin: this.yMin,
      yMax: this.yMax
    };
    // this.queryService.findQuery5(params)
    //   .subscribe(data => {this.results = data ; console.log(this.results); } );
  }
}
