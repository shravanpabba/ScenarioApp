import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DetailListComponent } from './detail-list/detail-list.component';

const routes: Routes = [
 // { path: '', redirectTo: 'view-detail', pathMatch: 'full' },
  { path: 'view-detail', component: DetailListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
