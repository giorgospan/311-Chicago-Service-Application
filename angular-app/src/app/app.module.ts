import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {AlertModule} from 'ngx-bootstrap/alert';
import {HomeComponent} from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { SelectionComponent} from './pages/selection/selection.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { ProfileComponent } from './pages/profile/profile.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpErrorInterceptor} from './_interceptors/http-error.interceptor';
import {JwtInterceptor} from './_interceptors/jwt.interceptor';
import {FontAwesomeModule} from '@devoto13/angular-fontawesome';
import { InsertComponent } from './pages/insert/insert.component';
import { Query1Component } from './pages/query/query1/query1.component';
import { Query2Component } from './pages/query/query2/query2.component';
import { Query3Component } from './pages/query/query3/query3.component';
import { Query4Component } from './pages/query/query4/query4.component';
import { Query5Component } from './pages/query/query5/query5.component';
import { Query6Component } from './pages/query/query6/query6.component';
import { Query7Component } from './pages/query/query7/query7.component';
import { Query8Component } from './pages/query/query8/query8.component';
import { Query9Component } from './pages/query/query9/query9.component';
import { Query10Component } from './pages/query/query10/query10.component';
import { Query11Component } from './pages/query/query11/query11.component';
import { Query12Component } from './pages/query/query12/query12.component';
import { SearchComponent } from './pages/search/search.component';
import {NgxPaginationModule} from 'ngx-pagination';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    SelectionComponent,
    HeaderComponent,
    FooterComponent,
    ProfileComponent,
    InsertComponent,
    Query1Component,
    Query2Component,
    Query3Component,
    Query4Component,
    Query5Component,
    Query6Component,
    Query7Component,
    Query8Component,
    Query9Component,
    Query10Component,
    Query11Component,
    Query12Component,
    SearchComponent,
  ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        AlertModule,
        RouterModule,
        AppRoutingModule,
        FormsModule,
        FontAwesomeModule,
        HttpClientModule,
        NgbModule,
        NgxPaginationModule,
    ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: HttpErrorInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
