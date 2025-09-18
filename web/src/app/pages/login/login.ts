import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  loginForm: FormGroup;

  constructor(private readonly fb: FormBuilder, private readonly router: Router) {
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
      console.log('Dados válidos', this.loginForm.value);
      alert('SUCESSO! VOCÊ ESTÁ LOGADO');
      this.router.navigate(['/home']);
      // aqui você faria a chamada ao back-end (Quarkus) para autenticação
    } else {
      this.loginForm.markAllAsTouched(); // força exibir erros
    }
  }
}
