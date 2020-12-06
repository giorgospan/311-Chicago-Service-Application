import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';

@Component({
  selector: 'app-query12',
  templateUrl: './query12.component.html',
  styleUrls: ['./query12.component.css']
})
export class Query12Component implements OnInit {

  constructor(private queryService: QueryService) { }


  ngOnInit(): void {
  }

}
