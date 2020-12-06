import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';

@Component({
  selector: 'app-query11',
  templateUrl: './query11.component.html',
  styleUrls: ['./query11.component.css']
})
export class Query11Component implements OnInit {

  constructor(private queryService: QueryService) { }

  ngOnInit(): void {
  }

}
