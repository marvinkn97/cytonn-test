# Ticket Booking System

+  Challenge:
   + Develop a ticket booking system application.


+  Requirements:
   + The administrator should be able to add/ edit or remove events. ✔️
   + For each event, the admin should be able to specify the ticket price specifying ticket type (VIP and regular).✔️
   + Admin should also be able to specify the maximum number of attendees. ✔️
   + Users should be able to view events details and reserve tickets (VIP or regular) NB: One appUser can reserve up to 5 tickets.
   + The appUser should then be able to get an email notification for the successful reservation.


+  System Design: 
   +   User Interface: The system can have a web-based appUser interface where users can browse events, select tickets, and make bookings.
   +   API Layer: The Spring Boot API will handle requests from the UI and interact with the database to perform CRUD operations.
   +   Business Logic: The API layer will implement business rules, such as ticket availability, payment processing, and generating tickets. 
   +   Data Access Layer: The data access layer will interact with the database to perform CRUD operations.
   +   Database: The database will store information about events, tickets, users, bookings, and any other necessary entities.
 
   
+  Application Layer:
   +  User Management: Handles user registration, authentication, and authorization.
   +  Event Management: Manages the creation, retrieval, and modification of events.
   +  Ticket Management: Handles the availability, reservation, and purchase of tickets.
   +  Booking Management: Manages the creation, retrieval, and cancellation of bookings.


+  Database Layer:   
   +  User: Represents users of the system. Contains fields such as user ID, username, password, email, etc.
   +  Event: Represents individual events. Contains fields like event ID, title, description, date, time, venue, etc.
   +  Ticket: Represents a ticket for a specific event. Contains fields like ticket ID, event ID (foreign key), price, availability, etc.
   +  Booking: Represents a booking made by a user for a particular event. Contains fields like booking ID, user ID (foreign key), ticket ID (foreign key), date of booking, status, etc.


+  Process Flow:
   +  User Registration and Authentication:
      +  Users register and create an account in the system.
      +  User authentication mechanisms are implemented to secure user access to the system.

   +  Event Discovery and Selection:
      +  Users browse and search for available events.
      +  The system displays event listings with relevant information such as title, date, location, and available tickets.
      
   +  Ticket Selection and Reservation:
      +  Users select the desired event and specify the number of tickets they want to reserve.
      +  The system validates ticket availability and user-specific constraints (e.g., maximum number of tickets per user).
      +  Upon successful validation, the system reserves the requested tickets and associates them with the user.
   
   +  Ticket Payment:
      +  Users proceed to the payment step, where they provide payment details.
      +  The system securely processes the payment using a payment gateway or third-party payment provider.
      +  Payment confirmation or a transaction ID is obtained upon successful payment.
   
   +  Ticket Confirmation:
      +  The system generates a booking confirmation or ticket(s) with a unique identifier.
      +  The confirmation includes relevant details such as event title, date, venue.
  
   +  Ticket Delivery:
      +  Users receive the ticket confirmation via email, SMS, or within their user account in the system.
      +  Users can manage their booked tickets, including viewing their ticket details, modifying or canceling bookings.


