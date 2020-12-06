import { NgModule } from '@angular/core';
import {HomeComponent} from './pages/home/home.component';
import {RouterModule, Routes} from '@angular/router';
import {RegistrationComponent} from './pages/registration/registration.component';
import {ErrorComponent} from './pages/error/error.component';
import {LoginComponent} from './pages/login/login.component';
import {SelectionComponent} from './pages/selection/selection.component';
import {ProfileComponent} from './pages/profile/profile.component';
import {AuthGuard} from './_guards/auth.guard';
import {InsertComponent} from './pages/insert/insert.component';
import {Query1Component} from './pages/query/query1/query1.component';
import {Query2Component} from './pages/query/query2/query2.component';
import {Query3Component} from './pages/query/query3/query3.component';
import {Query4Component} from './pages/query/query4/query4.component';
import {Query5Component} from './pages/query/query5/query5.component';
import {Query6Component} from './pages/query/query6/query6.component';
import {Query7Component} from './pages/query/query7/query7.component';
import {Query8Component} from './pages/query/query8/query8.component';
import {Query9Component} from './pages/query/query9/query9.component';
import {Query10Component} from './pages/query/query10/query10.component';
import {Query11Component} from './pages/query/query11/query11.component';
import {Query12Component} from './pages/query/query12/query12.component';
import {SearchComponent} from './pages/search/search.component';


const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent  },
  { path: 'registration', component: RegistrationComponent },
  { path: 'profile', component: ProfileComponent, canActivate: [AuthGuard]  },
  { path: 'insert', component: InsertComponent, canActivate: [AuthGuard] },
  { path: 'search', component: SearchComponent, canActivate: [AuthGuard] },
  { path: 'selection', component: SelectionComponent, canActivate: [AuthGuard] },
  { path: 'query1', component: Query1Component, canActivate: [AuthGuard] },
  { path: 'query2', component: Query2Component, canActivate: [AuthGuard] },
  { path: 'query3', component: Query3Component, canActivate: [AuthGuard] },
  { path: 'query4', component: Query4Component, canActivate: [AuthGuard] },
  { path: 'query5', component: Query5Component, canActivate: [AuthGuard] },
  { path: 'query6', component: Query6Component, canActivate: [AuthGuard] },
  { path: 'query7', component: Query7Component, canActivate: [AuthGuard] },
  { path: 'query8', component: Query8Component, canActivate: [AuthGuard] },
  { path: 'query9', component: Query9Component, canActivate: [AuthGuard] },
  { path: 'query10', component: Query10Component, canActivate: [AuthGuard] },
  { path: 'query11', component: Query11Component, canActivate: [AuthGuard] },
  { path: 'query12', component: Query12Component, canActivate: [AuthGuard] },
  { path: '**', component: ErrorComponent  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
