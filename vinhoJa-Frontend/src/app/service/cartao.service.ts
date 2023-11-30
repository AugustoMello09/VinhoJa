import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CartaoService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) { }
}
