import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Usuario } from '../model/usuario.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) { }

  public create(usuario : Usuario):Observable<Usuario> {
    const url = `${this.baseUrl}/users-service`
    return this.http.post<Usuario>(url, usuario);
  }

  public findByEmail(email: string): Observable<Usuario> {
    const url = `${this.baseUrl}/users-service/search?email=${email}`
    return this.http.get<Usuario>(url);
  }
}
