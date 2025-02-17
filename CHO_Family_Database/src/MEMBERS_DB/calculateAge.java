package MEMBERS_DB;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class calculateAge {

    public static void main(String[] args) {
        String birthDate = "19891203"; // 생년월일 (yyyyMMdd)

        // 현재 연도 및 오늘 날짜 가져오기
        int currentYear = LocalDate.now().getYear();
        LocalDate today = LocalDate.now();

        // birthDate에서 연도 및 월/일 추출
        int birthYear = Integer.parseInt(birthDate.substring(0, 4));
        String birthMonthDay = birthDate.substring(4, 8); // MMdd

        // birthDay를 LocalDate 형태로 변환
        LocalDate birthDay = LocalDate.parse(currentYear + birthMonthDay, DateTimeFormatter.ofPattern("yyyyMMdd"));

        // 나이 계산
        int koreanAge = currentYear - birthYear + 1; // 한국 나이
        int age = currentYear - birthYear; // 기본 나이

        // 출력
        System.out.println("birthDate: " + birthDate);
        System.out.println("currentYear: " + currentYear);
        System.out.println("birthYear: " + birthYear);
        System.out.println("birthDay (This year): " + birthDay);
        System.out.println("koreanAge: " + koreanAge);
        System.out.println("age (before check): " + age);

        // 만 나이 계산 (생일이 지났는지 확인)
        if (today.isBefore(birthDay)) { // 생일이 아직 안 지났다면
            age--; // 한 살 빼기
        }

        // 결과 출력
        System.out.println("Final age (International Age): " + age);
    }
}
