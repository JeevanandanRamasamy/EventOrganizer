# EventOrganizer

**EventOrganizer** is a Java-based calendar application designed to help users manage and schedule events without conflicts. The program ensures that no two events overlap by checking for availability and managing event details, such as date, time, location, and department. It provides a back-end solution to store and organize events, making it ideal for scheduling in organizations or departments.

---

## Features

- **Conflict-Free Scheduling**:  
  Automatically checks and ensures that no two events overlap in time and location.  

- **Event Management**:  
  Allows users to create, update, and delete events with attributes like date, time, location, and associated department.  

- **Custom Time Slots**:  
  Defines available time slots to help organize events effectively and avoid conflicts.  

- **Comprehensive Data Models**:  
  The application is structured using several Java classes for clear separation of concerns:
  - `Event`: Represents event details such as title, date, time, and participants.  
  - `EventCalendar`: A calendar object that manages and schedules events.  
  - `Timeslot`: Defines available times for scheduling events.  
  - `Location`: Manages the locations where events can take place.  
  - `Department`: Associates events with specific departments for organizational management.  
  - `Contact`: Handles information about contacts that are associated with events.  

---

## How to Run

1. **Clone the Repository**:  
   Clone the repository to your local machine using Git:  
   ```bash
   git clone https://github.com/your-username/EventOrganizer.git
      ```
   
2. **Compile the Code**:  
   Navigate to the project directory and compile the code using a Java compiler:
   ```bash
   javac *.java
   ```

3. **Run the Application**:  
   Launch the program using the following command:
   ```bash
   java RunProject1
   ```
   This will execute the EventOrganizer application and allow you to start scheduling events.

---

## Technologies Used

- **Java**: Core programming language used for backend functionality and data management.  
- **Object-Oriented Programming (OOP)**: Structured using classes for clear data separation and modularity.
- **Java Collections**: Utilized for managing and storing events, timeslots, locations, and departments.  
