Fitness Tracker App – Your Personal Progress Companion 🚀
Overview
Welcome to the Fitness Tracker App! This is a robust, command-line interface (CLI) application built with Java and JDBC, designed to help you manage your fitness journey. It connects seamlessly to a MySQL database to store all your essential fitness data.

From user management to detailed workout logging and progress tracking, this app provides full CRUD (Create, Read, Update, Delete) functionality, making it easy to keep an eye on your fitness goals.

✨ Features You'll Love
👥 User Management: Easily register, update, list, and delete users.

🏋️ Exercise Catalog: Add, list, and remove your favorite exercises.

🗓️ Workout Tracking: Log workouts with details like date and duration.

🔗 Detailed Workout Exercises: Link specific exercises to your workouts, capturing sets, reps, distance, and duration.

📈 Fitness Progress Logs: Keep a chronological record of your weight measurements to visualize your journey.

🎮 Interactive CLI: A user-friendly command-line menu for easy navigation and interaction.

📂 Project Structure
fitness-tracker/
├── src/                      # Your Java source files (DAO classes, main app, utilities)
│   ├── DatabaseUtil.java     # Handles database connection
│   ├── UserDAO.java          # Manages user data operations
│   ├── ExerciseDAO.java      # Manages exercise data operations
│   ├── WorkoutDAO.java       # Manages workout data operations
│   ├── WorkoutsExercisesDAO.java # Manages linking exercises to workouts
│   ├── FitnessProgressDAO.java # Manages fitness progress entries
│   └── Main.java             # The main application entry point
├── lib/                      # External libraries go here
│   └── mysql-connector-j-9.4.0.jar # MySQL JDBC driver
├── schema.sql                # SQL script to set up your database tables
├── README.md                 # You're reading it!
└── .gitignore                # Essential for keeping your repo clean and secure
🛠️ Setup Instructions – Let's Get You Started!
1. Prerequisites
Before you dive in, make sure you have these installed:

Java JDK 8 or above: Download here

MySQL Server: [suspicious link removed] (Ensure it's up and running!)

VS Code (or your preferred Java IDE/text editor): Download VS Code

MySQL Connector/J driver:

Download the mysql-connector-j-9.4.0.jar file from the MySQL Connector/J download page.

Place this .jar file directly into the lib/ folder of your project.

2. Database Setup
Let's get your database ready to store all that awesome fitness data!

Open MySQL: Use your preferred tool (MySQL Shell, MySQL Workbench, or phpMyAdmin).

Create the Database:

SQL

CREATE DATABASE fitness_tracker;
Select the Database:

SQL

USE fitness_tracker;
Import Schema: Run the schema.sql file to create all the necessary tables.

SQL

SOURCE /path/to/your/schema.sql; -- Replace with the actual path to your schema.sql file
3. Configure Database Credentials (Important!)
This step is crucial for connecting your Java app to your MySQL database.

Open src/DatabaseUtil.java.

Locate these lines and update them with your MySQL username and password:

Java

private static final String URL = "jdbc:mysql://localhost:3306/fitness_tracker";
private static final String USER = "root"; // Your MySQL username
private static final String PASSWORD = "your_password"; // Your MySQL password
🔒 Security Tip: For any production environment or if you're sharing your code, never hard-code sensitive credentials! Consider using environment variables or a separate configuration file (e.g., config.properties) that is excluded from version control. See "Future Improvements" for more on this.

4. Compile and Run the Project
You're almost there! Let's get the application running.

Open your VS Code integrated terminal (or any command prompt) in the fitness-tracker/ project root directory.

Compile:
Bash

javac -cp "lib/mysql-connector-j-9.4.0.jar" src/*.java
Run:
Windows:

Bash

java -cp "src;lib/mysql-connector-j-9.4.0.jar" Main
Linux/macOS:

Bash

java -cp "src:lib/mysql-connector-j-9.4.0.jar" Main
🏃 Using the Application
Once the application runs, you'll be greeted by an interactive command-line menu. Simply follow the on-screen prompts to:

Add and list users.

Add and list exercises.

Create new workouts and link exercises to them.

Log your fitness progress over time.

Experiment with the options to get a feel for the application's capabilities!

💡 Optional: Git Configuration
To keep your repository clean and prevent sensitive files from being accidentally uploaded, it's highly recommended to add a .gitignore file. Create a file named .gitignore in your project's root directory with the following content:

# Compiled class files
*.class

# MySQL Connector JAR (if you prefer to not commit it)
lib/mysql-connector-j-9.4.0.jar

# Configuration files (for future credential handling)
config.properties
.env
🚀 Future Improvements – What's Next?
This project provides a solid foundation, but there's always room to grow! Here are some ideas for enhancement:

Security First: Implement password hashing and a more secure authentication workflow.

Robustness: Add unit tests for DAO classes to ensure data integrity.

User Interface: Develop a graphical user interface (GUI) or a web front-end for a richer user experience.

Error Handling: Refine data validation and error handling for a more bulletproof application.

Externalize DB Credentials: Transition from hard-coded credentials to environment variables or dedicated configuration files for better security and flexibility.

✉️ Contact
Got questions, found a bug, or just want to chat about fitness tracking? Feel free to:

Raise an issue on the project's GitHub repository.

Contact me directly (if you plan to share your contact info).

Thank you for exploring the Fitness Tracker project! We hope it helps you on your fitness journey! 💪
