import { NgModule } from '@angular/core';
import {HomeComponent} from './pages/home/home.component';
import {RouterModule, Routes} from '@angular/router';
import {RegistrationComponent} from './pages/registration/registration.component';
import {QueryComponent} from './pages/query/query.component';
import {ErrorComponent} from './pages/error/error.component';
import {LoginComponent} from './pages/login/login.component';
import {SelectionComponent} from './pages/selection/selection.component';
import {ProfileComponent} from './pages/profile/profile.component';
import {AuthGuard} from './_guards/auth.guard';
import {ResultsComponent} from './pages/results/results.component';


const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent  },
  { path: 'registration', component: RegistrationComponent },
  { path: 'profile', component: ProfileComponent, canActivate: [AuthGuard]  },
  { path: 'selection', component: SelectionComponent, canActivate: [AuthGuard] },
  { path: 'query/:type', component: QueryComponent,
    canActivate: [AuthGuard],
    children: [
      {path: 'results', component: ResultsComponent}
    ]
  },
  { path: '**', component: ErrorComponent  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
