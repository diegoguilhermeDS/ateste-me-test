import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-container-form',
  imports: [CommonModule],
  templateUrl: './container-form.html',
  styleUrl: './container-form.css'
})
export class ContainerForm {
  @Input() reverse: boolean = false;
}
