import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';

@Component({
  selector: 'app-query10',
  templateUrl: './query10.component.html',
  styleUrls: ['./query10.component.css']
})
export class Query10Component implements OnInit {

  constructor(private queryService: QueryService) { }


  ngOnInit(): void {
  }

}
