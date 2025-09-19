import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Background } from '../../components/background/background';
import { ContainerForm } from '../../components/container-form/container-form';
import { Infor } from '../../components/infor/infor';
import { DynamicButton } from '../../components/dynamic-button/dynamic-button';
import { FormInput } from '../../components/form-input/form-input';
import { matchValidator } from '../../validators/match.validator';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BoxInputs } from '../../components/box-inputs/box-inputs';
import { RegisterData, UserService } from '../../services/User.service';

@Component({
  selector: 'app-register',
  imports: [
    ReactiveFormsModule,
    RouterLink,
    Background,
    ContainerForm,
    Infor,
    DynamicButton,
    FormInput,
    HttpClientModule,
    BoxInputs,
  ],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class Register {
  registerForm: FormGroup;

  constructor(
    private readonly http: HttpClient,
    private readonly fb: FormBuilder,
    private readonly router: Router,
    private readonly userService: UserService
  ) {
    this.registerForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      password: [
        '',
        [
          Validators.required,
          Validators.minLength(8),
          Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$/),
        ],
      ],
      confirmPassword: ['', [Validators.required, matchValidator('password')]],
      cep: [''],
      logradouro: [''],
      numero: [''],
      bairro: [''],
      cidade: [''],
      estado: [''],
    });

    this.registerForm.get('logradouro')?.disable();
    this.registerForm.get('bairro')?.disable();
    this.registerForm.get('cidade')?.disable();
    this.registerForm.get('estado')?.disable();
  }

  onRegister() {
    if (this.registerForm.valid) {
      const data: RegisterData = {
        name: this.registerForm.value.name,
        password: this.registerForm.value.password,
        email: this.registerForm.value.email,
        cep: this.registerForm.value.cep,
      };

      this.userService.register(data).subscribe({
        next: (response) => {
          this.registerForm.reset();
          alert('SUCESSO! VOCÊ ESTÁ CADASTRADO');
          setTimeout(() => {
            this.router.navigate(['/login']);
          }, 500); 
        },
        error: (err) => {
          alert('Ocorreu um erro ao realizar o cadastro.');
        },
      });
      
    } else {
      this.registerForm.markAllAsTouched();
    }
  }

  onCepBlur() {
    const cep = this.registerForm.get('cep')?.value;
    if (cep && cep.length === 8) {
      this.http.get(`https://viacep.com.br/ws/${cep}/json/`).subscribe(
        (dados: any) => {
          if (!dados.erro) {
            this.registerForm.patchValue({
              logradouro: dados.logradouro,
              bairro: dados.bairro,
              cidade: dados.localidade,
              estado: dados.uf,
            });
          } else {
            alert('CEP não encontrado');
          }
        },
        (error) => {
          console.error('Erro ao buscar CEP', error);
        }
      );
    }
  }
}
