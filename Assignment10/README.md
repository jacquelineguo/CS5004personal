CS 5004, Spring 2021\
Xuan Guo\
Assignment 10

This assignment is to design a ReservationSystem for Movie thickets reserve.

I designed 7 classes and separate them into three folders with the requirement of MV* architecture.

Controller contains:
1. DisplayTheater class: help display theater seats.
2. Interaction class: helps handle the interaction between customer and reservation system.
3. ReservationsService class: helps make the reservation.

Model contains:
1. Theater class: represents as a theater which contains fields of theater name, list of rows, and wheelchair rows.
2. Row class: represents the rows in the theater, which contains fields of row number, is wheelchair row, and seats number in each row.
3. Seat class: represents a seat in a row, which contains seat name as letters, and customer name if it's occupied, if no one occupied, then the customer name should be null.

View contains:\
ReservationSystem class: which is the Main class, in the main class we generated the theater and start the reservation.

I have used Singleton patterns in Theater class, since we can only have one theater in each reservation.