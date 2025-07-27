import java.sql.*;
import java.time.LocalDate;

public class FitnessProgressDAO {

    public void addProgressEntry(int userId, LocalDate entryDate, float weightKg) throws SQLException {
        String sql = "INSERT INTO Fitness_Progress (user_id, entry_date, weight_kg) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setDate(2, Date.valueOf(entryDate));
            stmt.setFloat(3, weightKg);
            stmt.executeUpdate();
        }
    }

    public void listProgressForUser(int userId) throws SQLException {
        String sql = "SELECT entry_date, weight_kg FROM Fitness_Progress WHERE user_id = ? ORDER BY entry_date";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.printf("Date: %s | Weight (kg): %.2f\n",
                            rs.getDate("entry_date").toString(),
                            rs.getFloat("weight_kg"));
                }
            }
        }
    }
}
