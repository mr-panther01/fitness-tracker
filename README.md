# 🏋️‍♂️ Fitness Tracker App – JDBC Java Project

## 💡 Overview

This is a simple Fitness Tracker application built in **Java** with JDBC, connecting to a **MySQL** database.  
It allows you to manage users, exercises, workouts, and fitness progress — all via a straightforward command-line menu! 🚀

---

## ✨ Features

- 👤 **User management:** Registration, update, listing, and deletion  
- 🏃 **Exercise Management:** Add, list, and delete exercises  
- 📝 **Workouts:** Track workouts for users (date, duration)  
- 🏆 **Workout Details:** Link exercises to workouts (sets, reps, distance, etc.)  
- 📈 **Progress Logs:** Record weight and fitness progress over time  
- 💻 **Easy to Use:** Interactive CLI menu

---

## 🗂️ Project Structure

fitness-tracker/

├── src/  
│ ├── DatabaseUtil.java  
│ ├── UserDAO.java  
│ ├── ExerciseDAO.java  
│ ├── WorkoutDAO.java  
│ ├── WorkoutsExercisesDAO.java  
│ ├── FitnessProgressDAO.java  
│ └── Main.java  
├── lib/  
│ └── mysql-connector-j-9.4.0.jar  
├── schema.sql  
├── README.md  
└── .gitignore  


---

## ⚙️ Setup Instructions

### 1. Prerequisites

- ☕ Java JDK 8 or higher  
- 🐬 MySQL Server (running)  
- 🖥️ VS Code (or any Java editor)  
- 📦 MySQL Connector/J driver (place in `lib/`)

### 2. Database Setup

- Start MySQL and create your database:

      CREATE DATABASE fitness_tracker;
  
      USE fitness_tracker;


- Import schema (replace with your path):

      SOURCE /path/to/your/schema.sql;


### 3. Configure Database Credentials

- Edit `src/DatabaseUtil.java`:

    private static final String URL = "jdbc:mysql://localhost:3306/fitness_tracker";
  
    private static final String USER = "root";
  
    private static final String PASSWORD = "your_password"; // 🔒 Don’t push real passwords!


> 💡 **Tip:** For real projects, read credentials from a secure config file or environment variable.

### 4. Compile & Run

Use the VS Code terminal from project root:

- **Compile:**  

      javac -cp "lib/mysql-connector-j-9.4.0.jar" src/*.java

- **Run:**  
  _(Windows)_

      java -cp "src;lib/mysql-connector-j-9.4.0.jar" Main

  _(Linux/macOS)_
  
      java -cp "src:lib/mysql-connector-j-9.4.0.jar" Main


---

## 🕹️ How to Use

Use the on-screen CLI menu to:

- ➕ Add/List users
- 💪 Add/List exercises
- 🗓️ Log workouts and add exercises
- 📊 Track weight/progress

Just follow the menu prompts!

---

## 🚫 Recommended: .gitignore

Prevent committing large jars or secrets by adding:

    lib/mysql-connector-j-9.4.0.jar

    *.class

    config.properties

    .env


---

## 🚀 Future Ideas

- 🔐 Password hashing and secure login
- 🧪 Unit tests
- 🖼️ GUI/Webapp interface
- 🛡️ Improved validation
- 🌱 Config via environment variables

---

## 🙋‍♂️ Contact & Help

For help, open an issue in the repo or contact the maintainer!  
Happy coding! 🎉

---

_Thanks for checking out the Fitness Tracker project!_ 💙
