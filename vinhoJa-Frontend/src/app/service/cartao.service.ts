import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Cartao } from '../model/cartao.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartaoService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) { }

  public create(dados : Cartao):Observable<Cartao> {
    const url = `${this.baseUrl}/cards-service`
    return this.http.post<Cartao>(url, dados);
  }

  public findByNumeroCartao(numeroCartao: string): Observable<Cartao> {
    const url = `${this.baseUrl}/cards-service/search?numeroCartao=${numeroCartao}`
    return this.http.get<Cartao>(url);
  }
}
