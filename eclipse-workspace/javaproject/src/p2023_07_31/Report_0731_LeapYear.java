package p2023_07_31;

import java.util.GregorianCalendar;
import java.util.Scanner;

// 키보드를 통해서 연도를 입력받음
// 이때, 입력받은 연도가 윤년인지 평년인지 판별하는 프로그램을 작성
// 단, GregorianCalendar클래스를 이용해서 처리
class LeapYear {
	
	static void checkLeapYear(int year) {
		// GregorianCalendar클래스를 활용하여 객체 생성
		GregorianCalendar cal = new GregorianCalendar();
		
		// boolean isLeapYear(int year) 메소드 활용
		if(cal.isLeapYear(year)){
			System.out.println(year+"은 윤년");
		}else{
			System.out.println(year+"은 평년");
		}
		
	}
}

public class Report_0731_LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("연도를 입력해주세요(ex. 2023)");
		
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		
		// checkLeapYear()메소드 사용하여 윤년인지 확인
		LeapYear.checkLeapYear(year);

	}

}
