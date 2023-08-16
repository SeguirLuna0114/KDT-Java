package p2023_07_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 키보드로 연도를 입력받고, 이때 입력받은 연도가 윤년인지 평년인지를 판별하는 프로그램
// 윤년의 정의를 이용하여 작성
// 평년(2월달 28일까지), 윤년(2월 29일까지)
// 1. 해당 연도를 4로 나누어 떨어지면 윤년
// 1-1. 그 중에서 100으로 나누어 떨어지면 윤년X
// 1-2. 그 중에서 400으로 나누어 떨어지면 윤년O
class LeapYear {
	
	static void CalcLeapYear(int year) {
		// 4의 배수일 경우
		if (year % 4 == 0) {
			// 4의 배수이며 400의 배수일 경우
			if (year % 400 == 0) {
				System.out.println(year+"은 윤년");
			} else if (year % 100 == 0) {
				// 4의 배수이며 100의 배수일 경우
				System.out.println(year+"은 평년");
			} else {
				System.out.println(year+"은 윤년");
			}
		} else {
			System.out.println(year+"은 평년");
		}
	}
	
	static void CalcLeapYear2(int year) {
		// 좀 더 간단하게 if문 작성
		// 해당 연도를 4로 나누고, 그중 100으로 나누어 떨어지면 윤년X
		// 해당 연도를 400으로 나누어 떨어지면 윤년
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			System.out.println(year +"은 윤년");
		} else {
			System.out.println(year +"은 평년");
		}
	}
}

public class Report_0728_LeapYear {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		System.out.println("연도를 입력해주세요?");
//		Scanner sc = new Scanner(System.in);
//		
//		// 입력받은 값을 연도로 사용
//		int year = sc.nextInt();
		
		//BufferedReader클래스 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		
		
		// CalcLeapYear()메소드 사용
		LeapYear.CalcLeapYear(year);
		
		// 좀더 간단하게 if문 작성한 CalcLeapYear2()메소드 사용
		LeapYear.CalcLeapYear2(year);
		
	}

}
