package p2023_08_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;

/* 
 * 사용자가 키보드로 입력한 연도가 윤년인지 평년인지 판별하는 프로그램
 */
public class test1 {
	
	// 방법1) GregorianCalendar클래스를 이용해서 윤년인지 평년인지 확인
	static void checkLeapYear(int year) {
		GregorianCalendar cal = new GregorianCalendar();
		
		// boolean isLeapYear(int year) 메소드 사용
		if (cal.isLeapYear(year)) {
			System.out.println(year+"년은 윤년");
		} else {
			System.out.println(year+"년은 평년");
		}
	}
	
	// 방법2. if문으로 판별
	static void checkLeapIf(int year) {
		// 4의 배수이며 400의 배수일 경우 "윤년"
		// 단, 4의 배수이며 100의 배수일 경우 "평년"
		if((year%4==0 && year%100!=0) || year%400==0){
			System.out.println(year+"년도는 윤년");
		}else{
			System.out.println(year+"년도는 평년");
		}
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("연도를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int year = Integer.parseInt(br.readLine());
		
		// 방법1) GregorianCalendar클래스를 이용해서 윤년인지 평년인지 확인
		checkLeapYear(year);
		
		// 방법2. if문으로 판별
		checkLeapIf(year);
	}
}
