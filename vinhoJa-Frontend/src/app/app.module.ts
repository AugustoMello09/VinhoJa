import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AccordionModule } from 'primeng/accordion';     //accordion and accordion tab
import { ButtonModule } from 'primeng/button';
import { StepsModule } from 'primeng/steps';

import { HeaderComponent } from './components/template/header/header.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { StepsComponent } from './components/template/steps/steps.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    UsuarioComponent,
    StepsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AccordionModule,
    ButtonModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    StepsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
