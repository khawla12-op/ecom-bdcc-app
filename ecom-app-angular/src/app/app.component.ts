import {Component, OnInit} from '@angular/core';
import {KeycloakService} from 'keycloak-angular';
import {KeycloakProfile} from 'keycloak-js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'ecom-app-angular';
  public profile!: KeycloakProfile;
  constructor(public keycloakService: KeycloakService) {
  }
  ngOnInit() {
    if(this.keycloakService.isLoggedIn()){
      this.keycloakService.loadUserProfile().then(profile=>{
        this.profile=profile;
      });
    }
  }


  async handleLogin() {
    try {
      await this.keycloakService.login({
        redirectUri: window.location.origin // Redirect back to current page after login
      });
    } catch (error) {
      console.error('Login error', error);
    }
  }

  async handlelogout() {
    try {
      await this.keycloakService.logout(window.location.origin);
    } catch (error) {
      console.error('Logout error', error);
    }
  }
}
