import { Component, EventEmitter, Input, Output } from '@angular/core';
import { AbstractControl, FormControl, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-input',
  imports: [ReactiveFormsModule],
  templateUrl: './form-input.html',
  styleUrl: './form-input.css',
})
export class FormInput {
  @Input() label!: string;
  @Input() type: string = 'text';
  @Input() control!: AbstractControl<any, any>;
  @Input() placeholder: string = '';
  @Input() name!: string;
  @Input() errorMessages: { [key: string]: string } = {};

  get formControl(): FormControl {
    return this.control as FormControl;
  }

  getErrorKeys(): string[] {
    return this.control.errors ? Object.keys(this.control.errors) : [];
  }

  @Output() blurEvent = new EventEmitter<void>();

  onBlur() {
    this.blurEvent.emit();
  }
}
