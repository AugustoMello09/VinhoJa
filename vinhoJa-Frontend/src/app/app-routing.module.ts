import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UsuarioComponent } from './components/usuario/usuario.component';
import { CartaoComponent } from './components/cartao/cartao.component';
import { ConfirmacaoComponent } from './components/confirmacao/confirmacao.component';
import { FimComponent } from './components/fim/fim.component';

const routes: Routes = [
  { path: '', component: UsuarioComponent },
  { path: 'cartao', component: CartaoComponent },
  { path: 'confirmar', component: ConfirmacaoComponent },
  { path: 'fim', component: FimComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
