import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cartao } from 'src/app/model/cartao.model';
import { idCartao } from 'src/app/model/idCartao.model';
import { idUsuario } from 'src/app/model/idUser.model';
import { Payment } from 'src/app/model/payment.model';
import { Valor } from 'src/app/model/valor.model';
import { CartaoService } from 'src/app/service/cartao.service';
import { PaymentService } from 'src/app/service/payment.service';

@Component({
  selector: 'app-confirmacao',
  templateUrl: './confirmacao.component.html',
  styleUrls: ['./confirmacao.component.css']
})
export class ConfirmacaoComponent implements OnInit {

  dados : Cartao = {
    nomeCartao: '',
    numeroCartao: '',
    cod: '',
    dataExp: ''
  }

  idCartao: idCartao = {
    id : ''
  }

  idUsuario: idUsuario = {
    id: ''
  }

  valor: Valor = {
    valor: 59.90,
  }

  payment: Payment = {
    id: '',
    data: '',
    valor: 0
  }


  mostrarLabel: boolean = false;

  pronto: boolean = false;
  
  constructor(private router: Router, private cartaoService: CartaoService,
    private paymentService: PaymentService) { }

  ngOnInit(): void {
    console.log(this.valor);
    const cartaoData = localStorage.getItem('dados');
    if (cartaoData) {
      this.dados = JSON.parse(cartaoData);
    }
  }

  returnPage() {
    localStorage.removeItem('dados');
    this.router.navigate(['/cartao']);
  }

  confirm() {
    this.cartaoService.create(this.dados).subscribe(res => {
      this.dados = res;
      console.log(this.dados);
      const dadosJSON = JSON.stringify(this.dados);
      localStorage.setItem('cartao', dadosJSON);
      this.mostrarLabel = true;
      localStorage.removeItem('dados');
      this.pronto = true;
    }, (err: any) => {
      if (err.error.error === 'Cartão já cadastrado.') {
        this.cartaoService.findByNumeroCartao(this.dados.numeroCartao).subscribe(data => {
          const dadosJSON = JSON.stringify(data);
          localStorage.setItem('cartao', dadosJSON);
          this.mostrarLabel = true;
          this.pronto = true;
          localStorage.removeItem('dados');
        })
      }
    })

  }

  finalizar() {
    this.atribuirIdCartao();
    this.atribuirIdUsuario();
    this.paymentService.create(this.valor, this.idCartao, this.idUsuario).subscribe(data => {
      this.valor = data;
      this.router.navigate(['/fim']);
    })
  }

  private atribuirIdCartao() {
    const idC = localStorage.getItem('cartao');
    if (idC) {
      const dadoCartao = JSON.parse(idC);
      this.idCartao = dadoCartao.id;
    }
  }

  private atribuirIdUsuario() {
    const idU = localStorage.getItem('usuario');
    if (idU) {
      const dadoUsuario = JSON.parse(idU);
      this.idUsuario = dadoUsuario.id;
    }
  }

}
