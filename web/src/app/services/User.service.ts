// auth.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface RegisterData {
  name: string;
  password: string;
  email?: string;
  cep?: string;
}

function getCookie(name: string): string | null {
  const match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
  return match ? match[2] : null;
}

@Injectable({ providedIn: 'root' })
export class UserService {
  private readonly apiUrl = 'http://localhost:8080/';

  constructor(private readonly http: HttpClient) {}

  getMe(): Observable<any> {
    const token = getCookie('auth_token');
    console.log('Token retrieved from cookies:', token);
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });

    return this.http.get(`${this.apiUrl}user/me`, { headers });
  }

  register(data: RegisterData): Observable<any> {
    return this.http.post(`${this.apiUrl}user`, data);
  }
}
