CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    name VARCHAR(100),
    age INT
);

CREATE TABLE Exercises (
    exercise_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(50)
);

CREATE TABLE Workouts (
    workout_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    date DATE,
    duration_mins INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Workouts_Exercises (
    workout_id INT,
    exercise_id INT,
    sets INT,
    reps INT,
    distance_kms FLOAT,
    duration_mins INT,
    PRIMARY KEY (workout_id, exercise_id),
    FOREIGN KEY (workout_id) REFERENCES Workouts(workout_id),
    FOREIGN KEY (exercise_id) REFERENCES Exercises(exercise_id)
);

CREATE TABLE Fitness_Progress (
    entry_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    entry_date DATE,
    weight_kg FLOAT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);
