# Fitness Tracker App – JDBC Java Project

## Overview

This is a simple Fitness Tracker application implemented in Java using JDBC to connect to a MySQL database.  
The project manages users, exercises, workouts, workout exercises, and fitness progress entries with full CRUD functionality through a command-line interface.

---

## Features

- User registration, update, listing, and deletion  
- Manage exercises: add, list, delete  
- Track workouts for users (date, duration)  
- Link exercises to workouts with details (sets, reps, distance, duration)  
- Log fitness progress entries (weight measurements over time)  
- Interactive CLI menu for manual testing and usage  

---

## Project Structure


Here is a well-structured README file tailored for your Fitness Tracker JDBC Java project, emphasizing setup, usage, and best practices, including notes about handling database credentials securely:

# Fitness Tracker App – JDBC Java Project

## Overview

This is a simple Fitness Tracker application implemented in Java using JDBC to connect to a MySQL database.  
The project manages users, exercises, workouts, workout exercises, and fitness progress entries with full CRUD functionality through a command-line interface.

---

## Features

- User registration, update, listing, and deletion  
- Manage exercises: add, list, delete  
- Track workouts for users (date, duration)  
- Link exercises to workouts with details (sets, reps, distance, duration)  
- Log fitness progress entries (weight measurements over time)  
- Interactive CLI menu for manual testing and usage  

---

## Project Structure

fitness-tracker/
├── src/ # Java source files (DAO classes, main, utils)
│ ├── DatabaseUtil.java
│ ├── UserDAO.java
│ ├── ExerciseDAO.java
│ ├── WorkoutDAO.java
│ ├── WorkoutsExercisesDAO.java
│ ├── FitnessProgressDAO.java
│ └── Main.java
├── lib/ # External libraries (MySQL Connector/J)
│ └── mysql-connector-j-9.4.0.jar
├── schema.sql # SQL script to create database schema
├── README.md # This file
└── .gitignore # Recommended to ignore class files and credentials

---

## Setup Instructions

### 1. Prerequisites

- Java JDK 8 or above installed  
- MySQL Server installed and running  
- VS Code (or any Java IDE/text editor)  
- MySQL Connector/J driver (downloaded and placed in `lib/` folder)  

### 2. Database Setup

- Create the database schema in MySQL:

  1. Open MySQL shell or MySQL Workbench
  2. Create a new database named `fitness_tracker` (if not already created):

     ```
     CREATE DATABASE fitness_tracker;
     USE fitness_tracker;
     ```

  3. Import the `schema.sql` file to create tables and constraints:

     ```
     SOURCE /path/to/your/schema.sql;
     ```

### 3. Configure Database Credentials

- Open `src/DatabaseUtil.java`
- Update the following constants with your MySQL credentials (avoid hard-coding real passwords in public repos):

private static final String URL = "jdbc:mysql://localhost:3306/fitness_tracker";
private static final String USER = "root";
private static final String PASSWORD = "your_password";


- **Security Tip:** For production or shared repos, read credentials via a config file or environment variables rather than hard-coding.

### 4. Compile and Run the Project

Use VS Code integrated terminal or any command prompt in your project root:

- Compile:

javac -cp "lib/mysql-connector-j-9.4.0.jar" src/*.java


- Run:

- On **Windows**:

  ```
  java -cp "src;lib/mysql-connector-j-9.4.0.jar" Main
  ```

- On **Linux/macOS**:

  ```
  java -cp "src:lib/mysql-connector-j-9.4.0.jar" Main
  ```

### 5. Using the Application

- The application runs a simple CLI menu to:

- Add and list users
- Add and list exercises
- Add workouts and link exercises
- Maintain fitness progress logs

- Follow on-screen prompts to interact with the app.

---

## Optional: Git Configuration

- It is highly recommended to add a `.gitignore` file with the following content to avoid uploading sensitive files or compiled classes:

lib/mysql-connector-j-9.4.0.jar
*.class
config.properties
.env


---

## Future Improvements

- Implement password hashing and secure authentication workflow  
- Add unit tests for DAO classes  
- Build a GUI or Web front-end  
- Refine data validation and error handling  
- Externalize DB credentials (environment variables or config files)

---

## Contact

For issues or questions, please raise them in the project GitHub repository Issues section or contact me.

---

Thank you for checking out the Fitness Tracker project!
