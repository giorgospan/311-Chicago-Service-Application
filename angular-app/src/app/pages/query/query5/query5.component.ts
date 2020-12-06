import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';

@Component({
  selector: 'app-query5',
  templateUrl: './query5.component.html',
  styleUrls: ['./query5.component.css']
})
export class Query5Component implements OnInit {

  constructor(private queryService: QueryService) { }


  ngOnInit(): void {
  }

}
