# somos-homework

## Project Overview

This project is a modern microservices-based application built using Java 17 and Spring Boot 3.3.5 for the backend. The frontend is developed with React.js, using Node.js v22.11.0 to manage the development environment and dependencies. This architecture ensures a clean separation of concerns, enabling scalability, maintainability, and flexibility for future enhancements. The project is designed to provide a seamless user experience while maintaining high performance and reliability through its microservices design.

## How to Build the Application

To build this application, ensure you have ** Java 17 and Node.js v22.11.0 **. Start by cloning the repository and navigating to the projects and clean and build manually or using cmd:- * mvn clean i *. For the frontend, navigate to the react-for-frontend directory, run * npm install * to install dependencies, and use * npm run build * to generate the production-ready frontend assets. 

## Project Focus Areas

This project is primarily designed to address four key functionalities: 
1. managing the number of seats available in real time to ensure accurate capacity tracking.
2. providing the ability to find and hold seats.
3. enabling users to reserve held seats.  and
4. directly allowing users to reserve seats if they are not already on hold. These core features aim to deliver an efficient and user-friendly system for managing seat availability and reservations.

## Pre-requisite API Call

Before accessing the key functionalities, you must invoke the initialization API using tools like Postman or similar. This API sets up the necessary configurations and ensures the application is ready to manage seat availability and reservations effectively.

### Customer Signup

To access the key functionalities, customers must first sign up. This can be done by calling the API using a ** POST ** method at http://localhost:8090/person-service/api/person/service , there is no request body for this time.

After signing up, verify if the process was successful by calling the API using a ** GET ** method at http://localhost:8090/person-service/api/person/service/test@email.com. 
Note: For testing purposes, the signup functionality is configured to work only with the email ID test@email.com.

### Add Airplane to Database

add an airplane to the database. This can be done by calling the API using a ** POST ** method at http://localhost:8090/airplane-service/api/airbus/service with the following request body: { "planName": "airbus_123" }

To confirm that the airplane has been successfully added to the database, call the API using a ** GET ** method at http://localhost:8090/airplane-service/api/airbus/service/ABCD. Replace ** ABCD ** with the appropriate ** planName ** used during the addition.

### Create and Set Seats

To create seats and assign them to the airplane, call the API using a ** POST ** method at http://localhost:8090/seat-service/api/seat/service/ABCD. Replace ** ABCD ** with the appropriate ** planName **. The seat levels is configured based on the requirements.

## Accessing Key Functionalities

After completing all the steps above, you can access the key functionalities of the application. Please note that all API requests must be made using port 8090, as the API gateway is configured to run on this port for all operations.

## Database Configuration

This project uses MySQL as the database for all microservices. You can either use a single database schema shared across all microservices or separate schemas for each microservice, depending on your architectural needs. Both approaches are supported, allowing flexibility in how data is organized and managed across the services. The choice of schema setup should align with your scalability, security, and data isolation requirements.

## How to Run the Application on a Developer's Local System

1. Clone the Repository:
   - git clone https://github.com/tesabel85/somos-homework.git

2. Configure MySQL:
   - Set up a MySQL database and configure the connection details in the application.properties files for each microservice.

3. Install Dependencies:
   - For backend (Spring Boot), navigate to each microservice folder and run:-   mvn clean install or clean and build manually.
   - For frontend (React), navigate to the frontend directory and run:- npm install

4. Run the Application:
   - For backend services, run each Spring Boot microservice manually or :- mvn spring-boot:run
   - For the frontend, run:-  npm start

5. ready to test.

