import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [ReactiveFormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register {
  registerForm: FormGroup;

  constructor(private readonly fb: FormBuilder, private readonly router: Router) {
    this.registerForm = this.fb.group({
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

  onRegister() {
    if (this.registerForm.valid) {
      console.log('Dados válidos', this.registerForm.value);
      alert('SUCESSO! VOCÊ ESTÁ CADASTRADO');
      this.router.navigate(['/login']);
      // aqui você faria a chamada ao back-end (Quarkus) para autenticação
    } else {
      this.registerForm.markAllAsTouched(); // força exibir erros
    }
  }
}
