import java.sql.*;
import java.time.LocalDate;

public class WorkoutDAO {

    public void addWorkout(int userId, LocalDate date, int durationMins) throws SQLException {
        String sql = "INSERT INTO Workouts (user_id, date, duration_mins) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setDate(2, Date.valueOf(date));
            stmt.setInt(3, durationMins);
            stmt.executeUpdate();
        }
    }

    public void listWorkoutsByUser(int userId) throws SQLException {
        String sql = "SELECT workout_id, date, duration_mins FROM Workouts WHERE user_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.printf("Workout ID: %d | Date: %s | Duration: %d mins\n",
                            rs.getInt("workout_id"),
                            rs.getDate("date").toString(),
                            rs.getInt("duration_mins"));
                }
            }
        }
    }

    public void deleteWorkout(int workoutId) throws SQLException {
        String sql = "DELETE FROM Workouts WHERE workout_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, workoutId);
            stmt.executeUpdate();
        }
    }
}
