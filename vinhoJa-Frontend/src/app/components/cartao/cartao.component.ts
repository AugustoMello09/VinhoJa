import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cartao } from 'src/app/model/cartao.model';

@Component({
  selector: 'app-cartao',
  templateUrl: './cartao.component.html',
  styleUrls: ['./cartao.component.css']
})
export class CartaoComponent implements OnInit {

  cartao : Cartao = {
    nomeCartao: '',
    numeroCartao: '',
    cod: '',
    dataExp: ''
  }
  
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    const cartaoJSON = JSON.stringify(this.cartao);
    localStorage.setItem('dados', cartaoJSON);
    this.router.navigate(['/confirmar']);
  }

}
