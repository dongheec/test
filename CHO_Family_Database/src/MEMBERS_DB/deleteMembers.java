package MEMBERS_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteMembers {
	public static void deletePerson(String firstName, String lastName) {
		String url = "jdbc:sqlite:C:/databases/cho_family.db";
		String sql = "DELETE FROM members WHERE first_name = ? AND last_name = ?";

		try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			int affectedRows = pstmt.executeUpdate();

			if (affectedRows > 0) {
				System.out.println(firstName + " " + lastName + " 데이터를 삭제했습니다.");
			} else {
				System.out.println("삭제할 데이터가 없습니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		deletePerson("Michael", "Johnson"); // "Michael Johnson" 삭제
	}
}