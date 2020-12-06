import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../../_services/query.service';

@Component({
  selector: 'app-query8',
  templateUrl: './query8.component.html',
  styleUrls: ['./query8.component.css']
})
export class Query8Component implements OnInit {

  constructor(private queryService: QueryService) { }


  ngOnInit(): void {
  }

}
