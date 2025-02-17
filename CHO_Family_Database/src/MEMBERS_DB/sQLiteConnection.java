package MEMBERS_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sQLiteConnection {
	public static Connection connect() {
		String url = "jdbc:sqlite:C:/databases/cho_family.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("SQLite 연결 성공!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void main(String[] args) {
		connect();
	}
}
