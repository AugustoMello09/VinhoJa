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
import { CardModule } from 'primeng/card';
import { MessagesModule } from 'primeng/messages';
import { InputTextModule } from 'primeng/inputtext';
import { InputMaskModule } from 'primeng/inputmask';

import { HeaderComponent } from './components/template/header/header.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { StepsComponent } from './components/template/steps/steps.component';
import { ProdutoComponent } from './components/produto/produto.component';
import { CartaoComponent } from './components/cartao/cartao.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    UsuarioComponent,
    StepsComponent,
    ProdutoComponent,
    CartaoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AccordionModule,
    ButtonModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    StepsModule,
    CardModule,
    MessagesModule,
    InputTextModule,
    InputMaskModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
