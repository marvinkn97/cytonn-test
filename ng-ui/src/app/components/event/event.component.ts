import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-event',
  standalone: true,
  imports: [],
  template: `
    <div class="card" style="width: 18rem">
      <img
        [src]=""
        class="card-img-top"
        style="height: 240px; width: 100%; object-fit: cover"
        alt=""
      />
      <div class="card-body">
        <h5 class="card-title"></h5>
        <p class="card-text">
          <i class="bi bi-geo-alt-fill"></i>
        </p>
        <a class="btn btn-sm btn-primary">
          Details <i class="bi bi-arrow-right"></i></a>
      </div>
    </div>
  `,
  styles: [],
})
export class EventComponent {
  @Input() event!: Event;
}
