package p2023_07_14;

import java.util.Scanner;

// 지역변수(Local variable) : 스택 영역에 저장
// 1.메소드 안에서 정의 되는 변수	
// 2.매개 변수(parameter) : 메소드 괄호안에서 사용되는 변수
// 3.블럭문(조건문,반복문) 안에서 사용되는 변수
// -지역변수는 자동으로 초기화X
public class For02_sum_Accum {

	// 1~10까지의 합을 구하는 프로그램을 작성하세요
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 합계 초기화
		int sum = 0;		// main메소드 내 지역변수(local variable)
		
		// 1~10까지의 합
		for (int i=1; i<=10; i++) {		// i는 for문 내 지역변수
			sum += i;	// sum = sum + i
//			 				1  =  0  + 1
//			 				3  =  1  + 2
//			 				6  =  3  + 3
//			 				10 =  6  + 4
			System.out.println("1~"+i+"="+sum);	//누적합 출력
		}
//		System.out.println(i);	// 오류발생: i변수가 for구문 내 지역변수
		System.out.println("sum= "+sum);
		System.out.println();
		
		//숫자를 입력받아서 합계 출력
		int sum_input = 0;
		System.out.println("숫자를 입력하세요");
		Scanner sc = new Scanner(System.in);
		int inputNum = sc.nextInt();
		
		for (int i=0; i<=inputNum; i++) {
			sum_input += i;
		}
		System.out.println("1~"+inputNum+"="+sum_input);
		
		
	}

}
