import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Background } from '../../components/background/background';
import { ContainerForm } from '../../components/container-form/container-form';
import { Infor } from '../../components/infor/infor';
import { DynamicButton } from '../../components/dynamic-button/dynamic-button';
import { FormInput } from '../../components/form-input/form-input';
import { AuthService } from '../../services/auth.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-login',
  imports: [
    ReactiveFormsModule,
    RouterLink,
    Background,
    ContainerForm,
    Infor,
    DynamicButton,
    FormInput,
  ],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  loginForm: FormGroup;

  constructor(
    private readonly fb: FormBuilder,
    private readonly router: Router,
    private readonly authService: AuthService,
    private readonly cookieService: CookieService
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: [
        '',
        [
          Validators.required,
          // Validators.minLength(8),
          // Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$/),
        ],
      ],
    });
  }

  onLogin() {
    if (this.loginForm.valid) {
      this.authService.login(this.loginForm.value.email, this.loginForm.value.password).subscribe({
        next: (res) => {
          const token = res?.token;
          if (token) {
            this.cookieService.set('auth_token', token, { expires: 1, path: '/' });
            alert('SUCESSO! VOCÊ ESTÁ LOGADO');
            this.router.navigate(['/home']);
          } else {
            alert('Falha no login');
          }
        },
        error: (err) => {
          if (err.status === 401) {
            alert('Usuário ou senha inválidos');
          } else {
            alert('Erro ao conectar com o servidor');
          }
        },
      });

    } else {
      this.loginForm.markAllAsTouched();
    }
  }
}
