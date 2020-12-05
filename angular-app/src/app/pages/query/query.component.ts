import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {switchMap} from 'rxjs/operators';
@Component({
  selector: 'app-query',
  templateUrl: './query.component.html',
  styleUrls: ['./query.component.css']
})
export class QueryComponent implements OnInit {

  type: string;
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.type = this.route.snapshot.paramMap.get('type');
  }

}
