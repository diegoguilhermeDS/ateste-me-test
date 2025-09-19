import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-dynamic-button',
  imports: [CommonModule],
  templateUrl: './dynamic-button.html',
  styleUrl: './dynamic-button.css'
})
export class DynamicButton {
  @Input() type: 'submit' | 'logout' | 'default' = 'default';

  @Input() label: string = 'Button';

  @Input() extraClass: string = '';

  @Input() disabled: boolean = false;

  onClick() {
    if (this.type === 'logout') {
      this.onLogout();
    } 
  }

  onLogout() {
    window.location.href = '/login';
  }
}
