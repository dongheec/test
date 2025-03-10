package MEMBERS_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dropTable {
    public static void createNewTable() {
        String url = "jdbc:sqlite:C:/databases/cho_family.db";

        String sql = "DROP TABLE members;";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("members 테이블이 성공적으로 제거되었습니다.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewTable();
    }
}