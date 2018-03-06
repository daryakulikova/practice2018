import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts';

import {Routes, RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import {CalcComponent} from './calc.component';
import {IntegrComponent} from './integr.component';
import {SlauComponent} from './slau.component';
import { FormsModule } from '@angular/forms';
import {InterpolComponent} from "./interpol.component";

const appRoutes: Routes =[
  { path: '', component: CalcComponent},
  { path: 'integr', component: IntegrComponent},
  { path: 'slau', component: SlauComponent},
  { path: 'interpol', component: InterpolComponent}
];


@NgModule({
  declarations: [
    AppComponent, CalcComponent, IntegrComponent, SlauComponent, InterpolComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, RouterModule.forRoot(appRoutes),
    FormsModule, ChartsModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
