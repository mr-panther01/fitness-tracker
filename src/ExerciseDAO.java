import java.sql.*;

public class ExerciseDAO {

    public void addExercise(String name, String type) throws SQLException {
        String sql = "INSERT INTO Exercises (name, type) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, type);
            stmt.executeUpdate();
        }
    }

    public void listExercises() throws SQLException {
        String sql = "SELECT exercise_id, name, type FROM Exercises";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Type: %s\n",
                        rs.getInt("exercise_id"),
                        rs.getString("name"),
                        rs.getString("type"));
            }
        }
    }

    public void deleteExercise(int exerciseId) throws SQLException {
        String sql = "DELETE FROM Exercises WHERE exercise_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, exerciseId);
            stmt.executeUpdate();
        }
    }
}
