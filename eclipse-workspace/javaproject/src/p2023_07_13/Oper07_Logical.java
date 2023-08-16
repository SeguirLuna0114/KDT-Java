package p2023_07_13;

import java.util.Scanner;

// 논리 연산자: ||(or 연산자), &&(and 연산자), !(not 연산자)

public class Oper07_Logical {

	// 5과목의 점수를 키보드로 입력받았을때,
	// 입력 점수로 합격/불합격을 판별하는 프로그램
	// 과목당 과락 40점이고, 평균 60점 이상 받아야 합격
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 변수 선언
		int n1, n2, n3, n4, n5, total;
		double avg; // 평균값을 double형으로 선언
		
		System.out.println("5과목의 점수를 입력 해주세요?");
		
		Scanner sc = new Scanner(System.in);
		
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		n3 = sc.nextInt();
		n4 = sc.nextInt();
		n5 = sc.nextInt();
		
		total = n1 + n2 + n3 + n4 + n5;		// 총점
		
		// 1. int형과 int형을 산술연산을 수행하면 결과는 int형으로 처리됨
		// 2. int형과 double형을 산술연산 수행하면 큰 자료형인 double형으로 처리됨
		avg = (double)total / (double)5;	// 만일, 5로 나눈다면 int형으로 처리되어 소수점 아래값이 손실됨
		System.out.println("평균값(avg): " + avg);
		
		// 조건식 작성
		if (n1 >= 40 && n2 >= 40 && n3 >= 40 && n4 >= 40 && n5 >= 40) {
			if (avg > 60) {
				System.out.println("합격");				
			} else {
				System.out.println("불합격\n사유: 평균 60점 이하");
			}
		} else {
			System.out.println("불합격\n사유: 과락");
		}
		
		// 삼향연산자 이용
		String result = (n1 >= 40 && n2 >= 40 && n3 >= 40 && n4 >= 40 && n5 >= 40) ? (avg > 60 ? "합격" : "불합격\n사유: 평균 60점 이하") : "불합격\n사유: 과락";
		System.out.println("\n"+result);
		
		
	}

}
