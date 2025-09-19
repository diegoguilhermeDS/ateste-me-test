import { Component, OnInit } from '@angular/core';
import { Profile } from '../../components/profile/profile';
import { DynamicButton } from "../../components/dynamic-button/dynamic-button";
import { UserService } from '../../services/User.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [Profile, DynamicButton],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit {
  name: string = '';

  constructor(private readonly userService: UserService, private readonly cookieService: CookieService, private readonly router: Router) {}

  ngOnInit(): void {
    const token = this.cookieService.get('auth_token');

    if (!token) {
      this.router.navigate(['/login']);
    } else {
      this.loadUser();
    }
  }

  private loadUser(): void {
    this.userService.getMe().subscribe({
      next: (user) => {
        this.name = user?.name || '';
      },
      error: (err) => {
        console.error('Erro ao carregar usuário:', err);
        alert('Erro ao carregar usuário. Por favor, faça login novamente.');
        window.location.href = '/login';
      }
    });
  }

  onLogout() {
    this.cookieService.delete('auth_token', '/');
    
     setTimeout(() => {
      this.router.navigate(['/login']);
    }, 500); 
  }
}
