package MEMBERS_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateMembers {
    public static void updateAge(String firstName, String lastName, int newAge) {
        String url = "jdbc:sqlite:C:/databases/cho_family.db";
        String sql = "UPDATE members SET age = ? WHERE first_name = ? AND last_name = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newAge);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println(firstName + " " + lastName + "의 나이를 " + newAge + "로 변경했습니다.");
            } else {
                System.out.println("업데이트할 데이터가 없습니다.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        updateAge("John", "Doe", 35);  // "John Doe"의 나이를 35로 변경
    }
}
