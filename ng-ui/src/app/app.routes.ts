import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { NewEventComponent } from './components/new-event/new-event.component';


export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'Events',
  },
  {
    path: 'create',
    component: NewEventComponent,
    title: 'Create Event',
  },
];
