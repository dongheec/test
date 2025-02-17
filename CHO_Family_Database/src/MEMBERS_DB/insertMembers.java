package MEMBERS_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class insertMembers {
	public static void insert(String firstName, String lastName, String gender, String birthDate, int age) {
		String url = "jdbc:sqlite:C:/databases/cho_family.db";
		String sql = "INSERT INTO members (first_name, last_name, gender, birth_date, age) " + "VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, gender);
			pstmt.setString(4, birthDate);
			pstmt.setInt(5, age);
			pstmt.executeUpdate();
			System.out.println(firstName + " " + lastName + " 데이터 추가 완료!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int calculateAge(String birthDate) {
//		String birthDate = "19891203"; // 생년월일 (yyyyMMdd)

		// 현재 연도 및 오늘 날짜 가져오기
		int currentYear = LocalDate.now().getYear();
		LocalDate today = LocalDate.now();

		// birthDate에서 연도 및 월/일 추출
		int birthYear = Integer.parseInt(birthDate.substring(0, 4));
		String birthMonthDay = birthDate.substring(4, 8); // MMdd

		// birthDay를 LocalDate 형태로 변환
		LocalDate birthDay = LocalDate.parse(currentYear + birthMonthDay, DateTimeFormatter.ofPattern("yyyyMMdd"));

		// 나이 계산(unused)
		int koreanAge = currentYear - birthYear + 1; // 한국 나이
		int age = currentYear - birthYear; // 기본 나이

		// 만 나이 계산 (생일이 지났는지 확인)
		if(today.isBefore(birthDay))
		{ // 생일이 아직 안 지났다면
			age--; // 한 살 빼기
		}
		
		return age;
	}

	public static void main(String[] args) {
		
		
		insert("Dong Hee", "Cho", "Male", "19891203", calculateAge("19891203")); // 똥킹
		insert("Eun Ho", "Cho", "Male", "20220614", calculateAge("20220614"));	// 으노
		insert("Ji Su", "Yang", "Female", "19911022", calculateAge("19911022"));	//띠뚜
		insert("Gil Dong", "Hong", "Male", "19000101", calculateAge("19000101"));	//샘플 홍길동
	}
}
