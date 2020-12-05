import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor, HttpErrorResponse
} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, retry} from 'rxjs/operators';

@Injectable()
export class HttpErrorInterceptor implements HttpInterceptor {

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return next.handle(request)

      .pipe(
        catchError((error: HttpErrorResponse) => {
          console.log('dsadsadasdas');
          let errorMessage = '';

          // client-side error
          if (error.error instanceof ErrorEvent) {
            errorMessage = `Error: ${error.error.message}`;
          }

          // server-side error
          if (error instanceof HttpErrorResponse) {
            errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
          }
          // window.alert(errorMessage);
          return throwError(errorMessage);

        })
      );
  }
}
