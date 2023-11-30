import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Valor } from '../model/valor.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) { }

  create(payment: Valor, idCartao : any, idUsuario : any): Observable<Valor> {
    const url = `${this.baseUrl}/payment-service/${idCartao}/${idUsuario}`;
    return this.http.post<Valor>(url, payment);
  }
}
