import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Message } from 'primeng/api';
import { Usuario } from 'src/app/model/usuario.model';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  
  message1: Message[] = [];

  usuario: Usuario = {
    nome: '',
    email: ''
  }
  
  constructor(private router: Router, private userService: UsuarioService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.userService.create(this.usuario).subscribe(
      (result: any) => {
        this.usuario = result;
        const usuarioJSON = JSON.stringify(this.usuario);
        localStorage.setItem('usuario', usuarioJSON);
        this.router.navigate(['/cartao']);
      },
      (err: any) => {
        if (err.error.error === 'Email já existe') {
          this.userService.findByEmail(this.usuario.email).subscribe(user => {
            const usuarioJSON = JSON.stringify(user);
            localStorage.setItem('usuario', usuarioJSON);
            this.router.navigate(['/cartao']);
          })
        } else {
          for (const error of err.error.errors) {
            this.addMessage(error.fieldName, error.message);
          }
        }
      }
    );
  }

  addMessage(fieldName: string, errorMessage: string): void {
    this.message1 = [{ severity: 'error', summary: 'Erro', detail: `${fieldName}: ${errorMessage}` }];
  }

}
