package p2023_07_18;

import java.util.Scanner;

//배열(Array) - 참조형
//동일한 (한가지) 자료형의 데이터를 저장하기 위한 "정적인" 자료구조
//- 인덱스를 사용하여 개별 요소에 접근 가능

//형식1) 배열에 저장될 값이 정해져있지 않은 경우 주로 사용
public class ArrayEx03_Score_SumAvg_input {

	// 키보드로 5과목의 점수를 입력받아서,
	// 총점과 평균을 구하는 프로그램을 작성
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1차원 배열 선언
		// (값이 정해지지X => 형식1 사용)
		int[] s = new int[5];	// 5과목의 점수로 이루어진 배열
		
		System.out.println("5과목의 점수를 입력 하세요?");
		Scanner sc = new Scanner(System.in);
		
		int sum=0;	// 총점 변수 초기화
		// 입력받은 값들을 for문으로 입력
		for (int idx=0; idx<s.length; idx++) {
			s[idx] = sc.nextInt();
			sum += s[idx];
		}	// 배열 사용 => 변수를 여러개 작성하는 것을 대신함
		System.out.println("총점: "+sum);
		
		// 확장 for문 사용X
		// -확장 for문은 배열 또는 컬렉션과 같은 반복 가능 객체를 순회하는데 사용되지만,
		//  사용자의 입력을 받아 배열에 저장하는 경우에는 일반적인 for문을 사용해야 함
//		System.out.println("확장 for문 사용");
//		int sum2=0;
//		for (int idx=0; idx<s.length; idx++) {
//			s[idx] = sc.nextInt();
//		}
//		for (int score : s) {
//			sum2 += score;
//		}
//		System.out.println("총점: "+sum2);
		
		// 평균값
		double avg = (double)sum / s.length;
//		double avg = sum / 5.0;
		// int형 sum과 double형 5.0의 산술연산 결과는 double형
		System.out.println("평균: "+avg);
		System.out.printf("평균: %.3f",avg);
		
	}

}
