import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static UserDAO userDAO = new UserDAO();
    private static ExerciseDAO exerciseDAO = new ExerciseDAO();
    private static WorkoutDAO workoutDAO = new WorkoutDAO();
    private static WorkoutsExercisesDAO workoutsExercisesDAO = new WorkoutsExercisesDAO();
    private static FitnessProgressDAO fitnessProgressDAO = new FitnessProgressDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            System.out.print("Enter choice: ");
            String input = scanner.nextLine();

            try {
                switch (input) {
                    case "1":
                        addUser(scanner);
                        break;
                    case "2":
                        listUsers();
                        break;
                    case "3":
                        addExercise(scanner);
                        break;
                    case "4":
                        listExercises();
                        break;
                    case "5":
                        addWorkout(scanner);
                        break;
                    case "6":
                        listWorkouts(scanner);
                        break;
                    case "7":
                        addExerciseToWorkout(scanner);
                        break;
                    case "8":
                        listExercisesForWorkout(scanner);
                        break;
                    case "9":
                        addFitnessProgress(scanner);
                        break;
                    case "10":
                        listFitnessProgress(scanner);
                        break;
                    case "0":
                        exit = true;
                        System.out.println("Exiting application.");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=== Fitness Tracker Menu ===");
        System.out.println("1: Add User");
        System.out.println("2: List Users");
        System.out.println("3: Add Exercise");
        System.out.println("4: List Exercises");
        System.out.println("5: Add Workout");
        System.out.println("6: List Workouts for User");
        System.out.println("7: Add Exercise to Workout");
        System.out.println("8: List Exercises for Workout");
        System.out.println("9: Add Fitness Progress Entry");
        System.out.println("10: List Fitness Progress for User");
        System.out.println("0: Exit");
    }

    private static void addUser(Scanner scanner) throws SQLException {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password Hash (enter plain password - hash yourself in real project): ");
        String pwdHash = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        userDAO.addUser(email, pwdHash, name, age);
        System.out.println("User added successfully.");
    }

    private static void listUsers() throws SQLException {
        userDAO.listUsers();
    }

    private static void addExercise(Scanner scanner) throws SQLException {
        System.out.print("Exercise Name: ");
        String name = scanner.nextLine();

        System.out.print("Exercise Type: ");
        String type = scanner.nextLine();

        exerciseDAO.addExercise(name, type);
        System.out.println("Exercise added successfully.");
    }

    private static void listExercises() throws SQLException {
        exerciseDAO.listExercises();
    }

    private static void addWorkout(Scanner scanner) throws SQLException {
        System.out.print("User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());

        System.out.print("Workout Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Duration (minutes): ");
        int duration = Integer.parseInt(scanner.nextLine());

        workoutDAO.addWorkout(userId, date, duration);
        System.out.println("Workout added successfully.");
    }

    private static void listWorkouts(Scanner scanner) throws SQLException {
        System.out.print("User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());

        workoutDAO.listWorkoutsByUser(userId);
    }

    private static void addExerciseToWorkout(Scanner scanner) throws SQLException {
        System.out.print("Workout ID: ");
        int workoutId = Integer.parseInt(scanner.nextLine());

        System.out.print("Exercise ID: ");
        int exerciseId = Integer.parseInt(scanner.nextLine());

        System.out.print("Sets: ");
        int sets = Integer.parseInt(scanner.nextLine());

        System.out.print("Reps: ");
        int reps = Integer.parseInt(scanner.nextLine());

        System.out.print("Distance (km) [enter 0 if none]: ");
        float distance = Float.parseFloat(scanner.nextLine());

        System.out.print("Duration (minutes): ");
        int duration = Integer.parseInt(scanner.nextLine());

        workoutsExercisesDAO.addExerciseToWorkout(workoutId, exerciseId, sets, reps, distance, duration);
        System.out.println("Exercise added to workout successfully.");
    }

    private static void listExercisesForWorkout(Scanner scanner) throws SQLException {
        System.out.print("Workout ID: ");
        int workoutId = Integer.parseInt(scanner.nextLine());

        workoutsExercisesDAO.listExercisesForWorkout(workoutId);
    }

    private static void addFitnessProgress(Scanner scanner) throws SQLException {
        System.out.print("User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());

        System.out.print("Entry Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Weight (kg): ");
        float weight = Float.parseFloat(scanner.nextLine());

        fitnessProgressDAO.addProgressEntry(userId, date, weight);
        System.out.println("Fitness progress entry added.");
    }

    private static void listFitnessProgress(Scanner scanner) throws SQLException {
        System.out.print("User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());

        fitnessProgressDAO.listProgressForUser(userId);
    }
}
