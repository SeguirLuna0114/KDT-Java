package p2023_07_14;

import java.util.Scanner;

// If 문(조건문)
//	if (조건식) {
//		조건식이 참인경우 실행될 문장;
//	} else {
//		조건식이 거짓인경우 실행될 문장;
//	}
public class If03_IfElse_MaxMin {

	// 키보드로 정수 2개를 입력받았을 때, 최대값과 최소값을 구하는 문제
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 변수선언
		int n1, n2, min, max;
		
		System.out.println("정수 2개를 입력해주세요?");
		Scanner sc = new Scanner(System.in);
		
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		
		if (n1 > n2) {
			max = n1;
			min = n2;
		} else {
			max = n2;
			min = n1;
		}
		System.out.println("max= " + max);
		System.out.println("min= " + min);
		
	}

}
