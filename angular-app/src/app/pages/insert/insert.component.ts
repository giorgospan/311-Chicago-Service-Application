import { Component, OnInit } from '@angular/core';
import {QueryService} from '../../_services/query.service';
import {DateService} from '../../_services/date.service';
import {IncidentRequest} from '../../_requests/incident-request';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-insert',
  templateUrl: './insert.component.html',
  styleUrls: ['./insert.component.css']
})
export class InsertComponent implements OnInit {

  showErrorMessage = false;
  showSuccessMessage = false;
  submitted = false;
  incidentForm: IncidentRequest;
  options = [
    'Abandoned Vehicle Complaint',
    'Alley Light Out',
    'Garbage Cart Black Maintenance/Replacement',
    'Graffiti Removal',
    'Pothole in Street',
    'Rodent Baiting/Rat Complaint',
    'Sanitation Code Violation',
    'Street Light - 1/Out',
    'Street Lights - All/Out',
    'Tree Debris',
    'Tree Trim'
  ];
  constructor(private queryService: QueryService, private  dateService: DateService) { }

  ngOnInit(): void {
    this.incidentForm = new IncidentRequest();
  }

  insert(): void {

      const loginObserver = {
        next: response => {
          this.submitted = true;
          this.showSuccessMessage = true;
        },
        error: err => {
          console.log('>>>Error: ' + err);
          this.showErrorMessage = true;
        }
      };
      this.queryService.insert(this.incidentForm.requestType, this.incidentForm)
        .pipe(first())
        .subscribe(loginObserver);
  }
}
