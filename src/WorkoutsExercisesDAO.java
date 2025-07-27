import java.sql.*;

public class WorkoutsExercisesDAO {

    public void addExerciseToWorkout(int workoutId, int exerciseId, int sets, int reps, float distanceKms, int durationMins) throws SQLException {
        String sql = "INSERT INTO Workouts_Exercises (workout_id, exercise_id, sets, reps, distance_kms, duration_mins) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, workoutId);
            stmt.setInt(2, exerciseId);
            stmt.setInt(3, sets);
            stmt.setInt(4, reps);
            stmt.setFloat(5, distanceKms);
            stmt.setInt(6, durationMins);
            stmt.executeUpdate();
        }
    }

    public void listExercisesForWorkout(int workoutId) throws SQLException {
        String sql = "SELECT exercise_id, sets, reps, distance_kms, duration_mins FROM Workouts_Exercises WHERE workout_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, workoutId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.printf("Exercise ID: %d | Sets: %d | Reps: %d | Distance (km): %.2f | Duration (mins): %d\n",
                            rs.getInt("exercise_id"),
                            rs.getInt("sets"),
                            rs.getInt("reps"),
                            rs.getFloat("distance_kms"),
                            rs.getInt("duration_mins"));
                }
            }
        }
    }

    public void removeExerciseFromWorkout(int workoutId, int exerciseId) throws SQLException {
        String sql = "DELETE FROM Workouts_Exercises WHERE workout_id = ? AND exercise_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, workoutId);
            stmt.setInt(2, exerciseId);
            stmt.executeUpdate();
        }
    }
}
