import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-steps',
  templateUrl: './steps.component.html',
  styleUrls: ['./steps.component.css']
})
export class StepsComponent implements OnInit {

  items: MenuItem[] = [];

  constructor() { }

  ngOnInit(): void {
    this.items = [
      {
          label: 'Dados Pessoais',
          routerLink: ''
      },
      {
        label: 'Dados Financeiro',
        routerLink: '/cartao'
      },
      { 
        label: 'Confirmação',
        routerLink: '/confirmar'
      },
      {
        label: 'Fim',
        routerLink: '/fim'
      },];
  }

}
