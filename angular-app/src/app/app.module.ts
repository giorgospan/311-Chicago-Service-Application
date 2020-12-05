import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {AlertModule} from 'ngx-bootstrap/alert';
import {HomeComponent} from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { QueryComponent } from './pages/query/query.component';
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
import { ResultsComponent } from './pages/results/results.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    QueryComponent,
    SelectionComponent,
    HeaderComponent,
    FooterComponent,
    ProfileComponent,
    ResultsComponent,
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
    NgbModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: HttpErrorInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
