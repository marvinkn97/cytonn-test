# Ticket Booking System

+  Challenge:
   + Develop a ticket booking system application.

+  Requirements:
   + The administrator should be able to add/ edit or remove events.
   + For each event, the admin should be able to specify the ticket price specifying ticket type (VIP and regular).
   + Admin should also be able to specify the maximum number of attendees. 
   + Users should be able to view events details and reserve tickets (VIP or regular) NB: One user can reserve up to 5 tickets.
   + The user should then be able to get an email notification for the successful reservation.

+  System Design: 
   +   User Interface: The system can have a web-based user interface where users can browse events, select tickets, and make bookings.
   +   API Layer: The Spring Boot API will handle requests from the user interface and interact with the database to perform CRUD operations.
   +   Business Logic: The API layer will implement business rules, such as ticket availability, payment processing, and generating tickets. 
   +   Data Access Layer: The data access layer will interact with the database to perform CRUD operations.
   +   Database: The database will store information about events, tickets, users, bookings, and any other necessary entities.
   
   +   Event table:
       +  event_id (Primary Key)
       +  event_name
       +  event_date
       +  location 
       +  image
       +  description
       +  capacity - track maximum number of attendees
       +  created_date
       +  updated_date

   +   Ticket table:
       +  ticket_id (Primary Key)
       +  event_id (Foreign Key referencing Event table)
       +  ticket_type
       +  price
       +  quantity_available - track the number of tickets remaining for a particular ticket type.
       
   +   User table
       +  user_id (Primary Key)
       +  username
       +  password
       +  email
       +  full_name
       +  phone_number
       +  address
       +  role (e.g., admin, user)
       +  created_date
       +  updated_date
       
   +   Booking table
       +  booking_id (Primary Key)
       +  user_id (Foreign Key referencing User table)
       +  event_id (Foreign Key referencing Event table)
       +  ticket_id (Foreign Key referencing Ticket table)
       +  booking_date
       
       +  optional:
          +  payment_status
          +  payment_amount
          +  payment_date
   

