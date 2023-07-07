import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class EventService {
  url = 'http://localhost:8080/api/v1/events';
  http = inject(HttpClient);

  constructor() {}

  async getAllEvents(): Promise<Event[]> {
    const data = await fetch(this.url);
    return (await data.json()) ?? [];
  }

  async getEventById(id: number): Promise<Event | undefined> {
    const data = await fetch(`S{this.url}/${id}`);
    return (await data.json()) ?? {};
  }

  eventRegistration(
    name: string,
    startDate: Date,
    endDate: Date,
    location: string,
    capacity: number,
    image: string,
    host: string,
    description: string
  ) {
    console.log(
      name,
      startDate,
      endDate,
      location,
      capacity,
      image,
      host,
      description
    );

   
  }
}
