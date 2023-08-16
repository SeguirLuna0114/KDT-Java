package p2023_07_18;

import java.util.Scanner;

public class ExSelf_Fibonacci {
	
	// 재귀함수 Fibonacci
	static int Fibonacci(int n) {
		if (n==0) {
			return 0;
		} else if (n==1) {
			return 1;
		} else {
			return Fibonacci(n-1)+Fibonacci(n-2);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 피보나치 수열
		// f(x) = f(x-1)+f(x-2)
		// 0, 1, 1, 2, 3, 5, 8,...
		System.out.println("피보나치 수열 연산할 숫자 입력");
		Scanner sc = new Scanner(System.in);
		int inputN = sc.nextInt();
	
		// fibonacci = cur + prev
		int fibonacci=0;
		if (inputN == 0) {	// 입력된 숫자가 0인경우 예외
			fibonacci = 0;
		} else if (inputN == 1) {	// 입력된 숫자가 1인경우 예외
			fibonacci = 1;
		} else {	// 그 외의 경우 반복문을 통해 피보나치수 계산
			int prev = 0;	// 이전 항의 값
			int cur = 1;	// 현재 항의 값
			
			for (int i=2; i<=inputN; i++) {
				fibonacci = cur + prev;		// fibonacci = 현재 + 이전
				prev = cur;					// 현재값 -> 이전 항 (업데이트)
				cur =  fibonacci;			// fibonacci값 -> 현재 항	(업데이트)
			}
		}
		// inputN과 fibonacci값 출력
		System.out.println(inputN+"의 피보나치 수는 "+fibonacci);
		System.out.println();
		
		// Fibonacci()메소드 호출
		int Fibo = Fibonacci(inputN);
		System.out.println(inputN+"의 피보나치 수는 "+Fibo);
		System.out.println();
		
		// 배열을 이용하는 방법
		int[] ArrayFibo = new int[inputN+1]; // f(0)부터 시작하기에, N+1크기 생성
		
		for (int idx=0; idx<ArrayFibo.length; idx++) {
			// f(0)과 f(1)은 각각 0과 1로 예외처리
			if (idx==0) {
				ArrayFibo[0]=0;
			} else if (idx==1) {
				ArrayFibo[1]=1;
			} else {
				ArrayFibo[idx] = ArrayFibo[idx-1]+ArrayFibo[idx-2];
			}
			System.out.print(ArrayFibo[idx]+"\t");
		}
//		System.out.print("="+ArrayFibo[inputN]);
		System.out.println();
		System.out.println(inputN+"의 피보나치 수는 "+ArrayFibo[inputN]);
		
		
	}

}
