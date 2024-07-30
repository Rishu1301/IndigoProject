# IndigoProject
This is the project for selection of Indigo.
# Flight Status Update System

## Project Overview

This project provides a system to display real-time flight status updates and send notifications to passengers. The system is built using a combination of frontend and backend technologies to ensure efficient and real-time updates.

## Features

- **Real-time Updates**: Display current flight status including delays, cancellations, and gate changes.
- **Push Notifications**: Send notifications for flight status changes via SMS, email, or app notifications using Kafka for real-time messaging.
- **Integration with Airport Systems**: Pull data from airport databases for accurate information (mock data provided for development).

## Tech Stack

### Frontend

- **HTML**: Structure of the web pages.
- **CSS**: Styling of the web pages.
- **React.js**: Building the interactive user interface.

### Backend

- **Java**: Main programming language for backend logic.
- **Spring Boot**: Framework for building the RESTful API and WebSocket server.
- **Kafka**: Messaging system to handle real-time notifications.

### Database

- **PostgreSQL**: Relational database for storing flight and user data.

### Additional Tools and Libraries

- **axios**: Promise-based HTTP client for the browser and Node.js, used to make HTTP requests from React.
- **kafka-clients**: Kafka client library for Java to produce and consume messages.
- **WebSocket**: Protocol for real-time communication between the frontend and backend.
- **Spring WebSocket**: Spring module for handling WebSocket connections in Java.

