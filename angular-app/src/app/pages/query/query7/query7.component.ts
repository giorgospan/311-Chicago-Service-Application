import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';

@Component({
  selector: 'app-query7',
  templateUrl: './query7.component.html',
  styleUrls: ['./query7.component.css']
})
export class Query7Component implements OnInit {

  constructor(private queryService: QueryService) { }


  ngOnInit(): void {
  }

}
