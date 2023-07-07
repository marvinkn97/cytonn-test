import { Component, inject } from '@angular/core';
import { EventService } from 'src/app/event.service';
import { EventComponent } from '../event/event.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [EventComponent],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  events !: Event[];
  eventService = inject(EventService);

  constructor() {
    this.eventService.getAllEvents().then((response: Event[]) => {
      this.events = response;
    });
  }

  filterResults(name: string) {
    throw new Error('Method not implemented.');
  }
}
