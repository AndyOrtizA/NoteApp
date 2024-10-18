# Notes App

This is a simple Notes Application where users can create notes, delete a specific note, or delete all notes at once.

## Features
- **Create Notes**: Users can add new notes by providing a title and content.
- **Delete Notes**: You can remove individual notes or clear all notes with one click.
- **Display Notes**: The notes are displayed in a table, showing the note ID, title, content, and a delete option for each note.

## Technologies Used

### Frontend:
- **HTML**: For structuring the application and creating the form for adding notes.
- **JavaScript**: 
  - Manages the app's logic and interactivity, such as creating and deleting notes.
  - Connects the frontend to the backend API using `fetch()` to handle HTTP requests.
- **Bootstrap**: For styling the application, making it visually appealing and responsive with pre-built CSS classes.

### Backend:
- **Java**: The core programming language for building the backend.
- **Spring Boot**: A Java-based framework used to create the backend RESTful API, handling HTTP requests and responses.
- **SQL**: Used as the database system to store and retrieve the notes.

## Backend Architecture

The backend is organized into several layers following a **layered architecture** pattern, which separates concerns and improves maintainability:

1. **Controller Layer**: 
   - This layer handles the HTTP requests (such as `GET`, `POST`, `DELETE`) and sends responses to the client (frontend).
   - It maps requests to specific endpoints like `/api/notes/` for fetching, creating, and deleting notes.

2. **Service Layer**: 
   - Contains the core business logic of the application. It processes the requests sent by the controller, interacts with the repository, and returns the necessary data or success/failure responses.
   - Decouples the business logic from the controller for better code organization.

3. **Repository Layer**: 
   - Manages the database interactions. The repository layer is responsible for executing SQL queries and performing CRUD (Create, Read, Update, Delete) operations on the database.

4. **Model Layer**:
   - Represents the structure of the data in the application. In this case, it includes a `Note` class, which defines the fields for each note (such as `id`, `title`, and `content`).
   - Maps to the database tables and is used by the repository layer to persist and retrieve data.

## How to Run the App

### Prerequisites
- **Java **: Ensure that Java is installed to run the backend application.
- **MySQL** or another relational database for storing notes. (You can modify the DB configuration in the `application.properties` file if needed.)

### Steps to Run:

#### Backend:
1. Open the project in Eclipse or any preferred IDE.
2. Run the Spring Boot application by executing the main class `NotesApplication.java`.
3. Make sure the application starts on [http://localhost:8088/](http://localhost:8088/).

#### Frontend:
1. Open a browser and go to [http://localhost:8088/](http://localhost:8088/) to access the app.
2. In this page, you can create notes by entering a title and content, then clicking "Save." You can also delete individual notes by clicking the red "Delete" button next to each note, or delete all notes by clicking the "Delete All" button.

### Database Configuration
By default, the app is configured to use MySQL. You can configure your database in the `application.properties` file in the backend project: