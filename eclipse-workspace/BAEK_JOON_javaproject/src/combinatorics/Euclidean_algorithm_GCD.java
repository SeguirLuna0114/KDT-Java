package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램
 */
public class Euclidean_algorithm_GCD {
	
	/** 유클리드 호제법(Euclidean algorithm)
	 *	"GCD(a, b) = GCD(b, r)"
	 *	두 수 a, b ∈ ℤ 이고, r = a mod b 이라고 한다. (r 은 a에 b를 나눈 나머지를 의미)
	 * 	이 때 r은 (0 ≤ r < b) 이고, a ≥ b 이다.
	 * 	이 때 a 와 b의 최대공약수를 (a, b)라고 할 때 
	 * 	(a, b)의 최대공약수는 (b, r)의 최대공약수와 같다.
	 * 
	 ** 최대공약수(GCD: Greatest Common Divisor)
	 * 	1) d는 B와 r의 공약수
	 * 		B = bd 와 r = (a - bq)d 로 B 와 r 은 d 를 공통된 약수로 갖는다
	 * 	2) b 와 (a - bq) 가 서로소
	 * 		b = mp, (a - bq) = np
	 * 		(mq + n)p = a
	 * 		a와 b는 p를 공약수로 갖는다 => 모순 => b와 (a - bq)도 서로소, d도 최대공약수
	 * 
	 ** 최소공배수(LCM:Least Common Multiple)
	 *	"유클리드 호제법으로 최대공약수를 구해, 입력받은 두 수의 곱에서 최대공약수를 나눠줌"
	 *	유클리드 호제법에 의해, A=ad, B= bd 에서 a 와 b 는 서로소이고, d 는 최대공약수인 경우
	 *	d는 최대공약수, a×b×d는 최소공배수
	 *	(즉,  A = ad, B= bd이었으므로 A × B ÷ d는 최소공배수)
	 */
	
	// 방법1. 반복문을 사용해서 최대공약수 및 최소공배수 찾기
	static int GCDEuclidian_While(int a, int b) {
		
		// 최대공약수
		while(b != 0) {
			// 나머지를 구해줌
			int r = a % b;	// (단, a >= b)
			
			// GCD(a,b) = GCD(b,r)이기에 변환
			a = b;
			b = r;
		}
		
		return a;
	}
	
	// 최소공배수
	static int LCMEuclidian_While(int a, int b) {
		// 두 수의 곱을 최대공약수로 나눈다.
		return a * b / GCDEuclidian_While(a,b);
	}
	
	
	// 방법2. 재귀함수를 사용하여 최대공약수 및 최소공배수 찾기
	static int GCDEuclidian_recursion(int a, int b) {
		// 최대공약수
		if (b == 0) {
			return a;
		}
		
		// GCD(a, b) = GCD(b, r)이므로 (r = a % b)
		return GCDEuclidian_recursion(b, a % b);
	}
	
	// 최소공배수
	static int LCMEuclidian_recursion(int a, int b) {
		// 두 수의 곱을 최대공약수로 나눈다.
		return a * b / GCDEuclidian_recursion(a,b);
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("두 개의 자연수를 공백 구분으로 입력하세요. (10,000이하의 자연수)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// String[] split(String regex)메소드 사용 => 문자열 파싱
		String[] inputN = br.readLine().split(" ");
		int n1 = Integer.parseInt(inputN[0]);
		int n2 = Integer.parseInt(inputN[1]);
		
		// 방법1. 반복문을 사용해서 최대공약수 및 최소공배수 찾기
		int GCD1 = GCDEuclidian_While(n1, n2);
		int LCM1 = LCMEuclidian_While(n1, n2);
		System.out.println(GCD1+"\n"+LCM1);
		
		// 방법2. 재귀함수를 사용하여 최대공약수 및 최소공배수 찾기
		int GCD2 = GCDEuclidian_recursion(n1, n2);
		int LCM2 = LCMEuclidian_recursion(n1, n2);
		System.out.println(GCD2+"\n"+LCM2);
	}
}
