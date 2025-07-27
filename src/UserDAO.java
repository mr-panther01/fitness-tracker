import java.sql.*;

public class UserDAO {

    public void addUser(String email, String pwdHash, String name, int age) throws SQLException {
        String sql = "INSERT INTO Users (email, password_hash, name, age) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, pwdHash);
            stmt.setString(3, name);
            stmt.setInt(4, age);
            stmt.executeUpdate();
        }
    }

    public void updateUserName(int userId, String newName) throws SQLException {
        String sql = "UPDATE Users SET name = ? WHERE user_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setInt(2, userId);
            stmt.executeUpdate();
        }
    }

    public void deleteUser(int userId) throws SQLException {
        String sql = "DELETE FROM Users WHERE user_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        }
    }

    public void listUsers() throws SQLException {
        String sql = "SELECT user_id, email, name, age FROM Users";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | Email: %s | Name: %s | Age: %d\n",
                        rs.getInt("user_id"), rs.getString("email"),
                        rs.getString("name"), rs.getInt("age"));
            }
        }
    }
}
