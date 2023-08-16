package p2023_07_17;

import java.util.Scanner;

// 키보드를 이용하여 입력한 정수의 팩토리얼을 구하는 프로그램

public class Report_0717_Factorial {

	static int factorial(int n) {
		if (n<=1) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("정수를 입력해주세요?");
		Scanner sc = new Scanner(System.in);
		int inputN = sc.nextInt();	// 입력받은 정수
		
		int[] Arrayfact = new int[inputN];	// 배열 형성
		// 배열 요소에 접근할 index=i
		int i;

		System.out.print(inputN+"! = ");
		for (i=0; i<inputN-1; i++) {
			Arrayfact[i] = inputN-i;
			System.out.print(Arrayfact[i]+" * ");
		}
		System.out.print("1");
		System.out.println();

		// factorial메소드 출력
		System.out.println("use factorial method");
		System.out.println(inputN+"!= "+factorial(inputN));
		
		
	}

}
