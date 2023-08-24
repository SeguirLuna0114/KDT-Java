package divide_Conquere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 자연수 N과 정수 K가 주어졌을 때 이항 계수(binom{N}{K})를
 * 1,000,000,007로 나눈 나머지를 구하는 프로그램
 */
public class BionomicalCoefficient_long {

	/** 입력 범위 1 ≤ N ≤ 4,000,000,0
	 * - 입력값이 최대 4,000,000 으로, 
	 *   단순하게 분자의 N! (4,000,000!) 만 구하더라도 long범위를 아득하게 넘는다
	 * 
	 ** 12팩토리얼과 20팩토리얼은 각각 int와 long형이 넘어간다
	 * 12! = 479,001,600 로 int형의 최댓값(2,147,483,647)을 넘어가고
	 * 20! = 51,090,942,171,709,440,000 으로, long 9,223,372,036,854,775,807 이 넘어간다
	 * 
	 **  1,000,000,007 로 나눈 나머지 값을 출력해야 함
	 *	=> 모듈러 연산 활용
	 ** 이항계수를 구할 때, N!*(K!(N-K)!)^-1이기에, 
	 *	(K!(N-K)!)의 역원인 (K!(N-K)!)^-1을 구하기 위해 '페르마 소정리' 활용
	 *
	 *  "역원을 구하는, 사실상 (N-K)를 p-2 승만큼 제곱하는 알고리즘에서 분할정복"
	 */
	/** 모듈러 연산
	 * 1. (a + b) mod m = ((a mod m) + (b mod m)) mod m
	 * 		=> (a+b) % m = (( a % m) + (b % m)) % m
	 * 2. (a * b) mod m = ((a mod m) * (b mod m)) mod m
	 * 		=> (a*b) % m = (( a % m) * (b % m)) % m
	 * (단, 모듈러 연산에서 나눗셈 연산은 없음 => 역원을 통해 분수를 정수 곱셈으로 변경하여 문제 풀이)
	 * 
	 ** 페르마 소정리
	 *  a는 정수, p는 소수이며 a와 p는 배수관계X
	 *  a^p = a(mod p) => a^p mod p = a mod p
	 *  a^(p-1) = 1(mod p) => a * a^(p-2) = 1(mod p) => a^(p-2) = a^-1(mod p)
	 *  "따라서, a^(p-2)(mod p)가 a의 역원"
	 *  
	 *  이항계수 N_C_K (binom{N}{K}) = N! X (K! (N-K)!)^-1
	 *  따라서, 이항계수 (binom{N}{K})(mod P) = (N! X (K! (N-K)!)^-1)(mod P)
	 *  								  = ((N! mod P) X ((K!(N-K)!)^-1 mod P)) mod P
	 *  								  = ((N! mod P) X ((K!(N-K)!)^(P-2) mod P)) mod P
	 */
	static final long div = 1000000007;
	
	// 방법1. 지수 법칙을 재귀로 거듭제곱을 분할정복 방식으로 수행
	// A^exponent: A = 밑, exponent = 지수
	// A^B 지수법칙을 이용해, 지수를 반으로 나누어서 계산
	static long pow(long A, long exponent) {

		// 지수가 1일 경우, A^1=A이기에, A 리턴
		if(exponent == 1) {
			return A % div;
		}
		
		// 지수법칙 적용 => 지수의 절반에 해당하는 A^(exponent/2)을 구함
		long temp = pow(A, exponent / 2);
		
		/* 현재 지수가 홀수 였다면
		 * A^(exponent / 2) * A^(exponent / 2) * A 이므로
		 * A를 한 번 더 곱해주어야 한다.
		 * 
		 * ex) A^9 = A^4 * A^4 * A
		 */
		if(exponent % 2 == 1) {
			return ((temp * temp % div) * A) % div;
		}
		
		// 현재 지수가 짝수인 경우에는 지수의 절반값을 한번 더 곱해서 반환
		return temp * temp % div;
	}
	
	// 반복문을 활용한 팩토리얼 함수
	static long factorial(long N) {
		// 팩토리얼 값 초기화
		long facto = 1L;
		
		// 반복문을 통해 팩토리얼 값 구하기
		while(N > 1) {
			facto = (facto * N) % div;
			N--;
		}
		
		return facto;
	}
	
	
	// 방법2) 반복문 방식을 통해 제곱 방식 수행
	// A^exponent: A = 밑, exponent = 지수
	static long BinomCoeff(long A, long exponent) {
		
		// 반환할 결과값 변수
		long result = 1;
		
		// 지수만큼 반복문 실행
		while(exponent > 0) {
			
			// 지수가 홀 수면 반환하고자 하는 result에 곱해주도록 한다.
			// A^(2n+1) = A^n * A^n * A
			if(exponent % 2 == 1) {
				result *= A;
				result %= div;
			}
			
			// 지수가 모두 짝수라면 expo가 1이 될 떄까지 base의 값이 제곱되다가 최종적으로 result에 담긴다.
			A = (A * A) % div;
			
			// 지수를 절반으로 나눔
			exponent /= 2;			// exponent >>>= 1;과 동치
		}
		
		return result;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 N과 K를 입력하세요.(단, 1 ≤ N ≤ 4,000,000,0 ≤ K ≤ N)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		/** 이항계수 N_C_K = (N!) * ((N-K)!*(K!))^-1
		* => N_C_K(mod p) = ((N!) * ((N-K)!*(K!))^-1)(mod p)
		* 				  = ((N! mod p) X ((K!(N-K)!)^(P-2) mod p)) mod p
		*/
		
		// 분자 (N! mod p)
		long number = factorial(N) % div;
		
		// 분모 ((N-K)!*(K!))^-1(mod P)
		// (K! * (N-K)!) mod p -> 이후 pow메소드 사용하여 역원의 거듭제곱 구하기
		long denom = (factorial(N-K) * factorial(K)) % div;
		
		// N! * 분모의 역원((K! * (N-K)!)
		// 방법1. 지수 법칙을 재귀로 거듭제곱을 분할정복 방식 수행
		System.out.println((number * pow(denom, div - 2)) % div);
		
		
		// 방법2) 반복문 방식을 통해 제곱 방식 수행
		System.out.println((number * BinomCoeff(denom, div - 2)) % div);
	}
}
