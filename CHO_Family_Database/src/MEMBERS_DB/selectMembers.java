package MEMBERS_DB;

import java.sql.*;

public class selectMembers {
    public static void main(String[] args) {
		String url = "jdbc:sqlite:C:/databases/cho_family.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM members")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String gender = rs.getString("gender");
                String birthDate = rs.getString("birth_date");
                int age = rs.getInt("age");

                System.out.println("ID: " + id);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Gender: " + gender);
                System.out.println("Birth Date: " + birthDate);
                System.out.println("Age: " + age);
                System.out.println("-------------------");
            }

        } catch (SQLException e) {
            System.out.println("데이터 조회 오류: " + e.getMessage());
        }
    }
}
