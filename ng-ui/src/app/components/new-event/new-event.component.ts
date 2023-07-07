import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { EventService } from 'src/app/event.service';

@Component({
  selector: 'app-new-event',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './new-event.component.html',
  styleUrls: ['./new-event.component.css'],
})
export class NewEventComponent {
  eventService = inject(EventService);

  createEvent = new FormGroup({
    name: new FormControl(''),
    startDate: new FormControl(new Date('')),
    endDate: new FormControl(new Date('')),
    location: new FormControl(''),
    capacity: new FormControl(0),
    image: new FormControl(''),
    host: new FormControl(''),
    description: new FormControl(''),
  });

  eventRegistration() {
    this.eventService.eventRegistration(
      this.createEvent.value.name ?? '',
      this.createEvent.value.startDate ?? new Date(''),
      this.createEvent.value.endDate ?? new Date(''),
      this.createEvent.value.location ?? '',
      this.createEvent.value.capacity ?? 0,
      this.createEvent.value.image ?? '',
      this.createEvent.value.host ?? '',
      this.createEvent.value.description ?? ''
    );
  }
}
