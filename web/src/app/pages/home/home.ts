import { Component } from '@angular/core';
import { Profile } from '../../components/profile/profile';
import { DynamicButton } from "../../components/dynamic-button/dynamic-button";

@Component({
  selector: 'app-home',
  imports: [Profile, DynamicButton],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
  onLogout() {
    window.location.href = '/login';
  }
}
