import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive],
  template: `
    <nav class="navbar navbar-expand-lg bg-body-tertiary p-3">
      <div class="container-fluid">
        <a [routerLink]="''" class="navbar-brand" href="#">ASPIL</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNavDropdown"
          aria-controls="navbarNavDropdown"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a [routerLink]="''" class="nav-link" href="#">Events</a>
            </li>
            <li class="nav-item">
              <a [routerLink]="'create'" class="nav-link" href="#"
                >Add New Event</a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Register</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  `,
  styles: [],
})
export class NavComponent {}
