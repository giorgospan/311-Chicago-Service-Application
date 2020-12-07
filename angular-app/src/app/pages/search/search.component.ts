import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../_services/query.service';
import {SearchResponse} from '../../_responses/search-response';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  mode;
  searchValue;
  results: SearchResponse[];
  page = 1;
  pageSize = 10;
  pageSizeOptions = [10, 20, 30, 100];
  constructor(private queryService: QueryService) { }

  ngOnInit(): void {
    this.results = [];
  }

  search(): void {
    this.queryService.search(this.mode, this.searchValue)
      .subscribe(data => {this.results = data ; console.log(this.results); } );
  }
  handlePageSizeChange(event): void {
    this.pageSize = event.target.value;
  }
}
