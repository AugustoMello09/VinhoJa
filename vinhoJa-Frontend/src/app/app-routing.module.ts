import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UsuarioComponent } from './components/usuario/usuario.component';
import { CartaoComponent } from './components/cartao/cartao.component';

const routes: Routes = [
  { path: '', component: UsuarioComponent },
  {path: 'cartao', component: CartaoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
