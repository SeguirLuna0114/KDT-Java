package p2023_07_14;

import java.util.Scanner;

// If문(조건문)
//	if(조건식1){
//		조건식1이 참인경우 실행될 문장;
//	}else if(조건식2){
//		조건식2가 참인경우 실행될 문장;
//	}else{
//		위의 조건식을 만족하지 않을때 실행될 문장;
//	}
public class If04_IfElseifElse_Score {

	// 키보드로 입력한 점수가 어느 학점에 해당되는지 판별하는 프로그램
	// 90점 이상 - A학점
	// 80점 이상 - B학점
	// 70점 이상 - C학점
	// 60점 이상 - D학점
	// 60점 미만 - F학점
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int s;
		System.out.println("점수를 입력해주세요?");
		
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		
		// if문 활용
		// if else-if문은 여러개의 조건식을 모두 만족하더라도,
		// 가장 먼저 만족하는 조건절 아래쪽의 문장만 실행됨
		if (s >= 90) {
			System.out.println("A학점");
		} else if (s >= 80) {
			System.out.println("B학점");
		} else if (s >= 70) {
			System.out.println("C학점");
		} else if (s >= 60) {
			System.out.println("D학점");
		} else {
			System.out.println("F학점");
		}
		System.out.println();
		
		// switch문 활용
		switch (s / 10) {
			case 10:
			case 9:
				System.out.println(s+"점, A학점");
				break;
			case 8:
				System.out.println(s+"점, B학점");
				break;
			case 7:
				System.out.println(s+"점, C학점");
				break;
			case 6:
				System.out.println(s+"점, D학점");
				break;
			default:
				System.out.println(s+"점, F학점");
		}
		
	}

}
