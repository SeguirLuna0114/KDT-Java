package p2023_07_14;

import java.util.Scanner;

// switch ~ case문
//	switch (표현식) {	// 표현식은 조건을 평가하는데 사용됨
//		// 표현식의 모든 값은 case의 값과 비교됨
//		case 값1:
//    		// 코드 블록1
//    		break;	// switch-case문을 빠져나갈 수 있게 해줌
//					// 없을 경우, 아래 case구문이 실행됨
//		default:	// 표현식의 값과 일치하는 case가 없을때 실행됨
//    		// 기본 코드 블록
//	}

public class Switch01_Score {
	
	// 키보드로 입력한 점수가 어느 학점에 해당되는지 판별하는 프로그램
	// 90점 이상 - A학점
	// 80점 이상 - B학점
	// 70점 이상 - C학점
	// 60점 이상 - D학점
	// 60점 미만 - F학점
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int s;
		System.out.println("0~100점 사이의 점수를 입력해주세요?");
		
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		
		switch (s/10) {	//s는 int이고, 10또한 int이기에, 계산을 하면 int형값이 출력(소수점X)
			case 10:
			case 9:
				System.out.println("A학점");
				break;	// switch~case문을 빠져나가도록 해줌
			case 8:
				System.out.println("B학점");
				break;
			case 7:
				System.out.println("C학점");
				break;
			case 6:
				System.out.println("D학점");
				break;
			default:
				if (s>100 || s<0) {
					System.out.println("0~100점 사이의 점수를 입력 해주세요!");
				} else {
					System.out.println("F학점");
				}
		}
		
	}

}
