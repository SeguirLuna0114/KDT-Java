package p2023_07_14;

import java.util.Scanner;

// If 문(조건문)
//	if (조건식) {
//  	  조건식이 참인경우 실행될 문장;
//	} else {
//  	  조건식이 거짓인경우 실행될 문장;
//	}
public class If02_IfElse_EvenOdd {

	// 키보드로 입력한 정수가 짝수, 홀수인지 판별
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("정수를 입력하세요?");
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// n=입력받은 정수
		
		// if문을 사용
		if (n % 2 == 0) {	// 짝수
			System.out.println(n+"은(는) 짝수");
		} else {			// 홀수
			System.out.println(n+"은(는) 홀수");
		}
		System.out.println();
		
		// switch-case문을 사용
		switch (n % 2) {
			case 1:
				System.out.println(n+"은(는) 홀수");
				break;
			case 0:
				System.out.println(n+"은(는) 짝수");
				break;
		}
		
		
	}

}
