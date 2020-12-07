import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DateService {

  constructor() { }

  parseDate(date): string {
    return new Date(date.year, date.month - 1, date.day).toISOString().split('T')[0];
  }
}
