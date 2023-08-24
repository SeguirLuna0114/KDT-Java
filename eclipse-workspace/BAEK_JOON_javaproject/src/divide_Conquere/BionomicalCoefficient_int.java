package divide_Conquere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 자연수 N과 정수 K가 주어졌을 때 이항 계수(binom{N}{K})를
 * 10,007로 나눈 나머지를 구하는 프로그램
 */
public class BionomicalCoefficient_int {

	/** 입력 범위 1 ≤ N ≤ 1000
	 * - 입력값이 최대 1000이기에, 동적계획법을 사용하지 않으면 시간초과됨!
	 * 
	 ** 12팩토리얼과 20팩토리얼은 각각 int와 long형이 넘어간다
	 * 12! = 479,001,600 로 int형의 최댓값(2,147,483,647)을 넘어가고
	 * 20! = 51,090,942,171,709,440,000 으로, long 9,223,372,036,854,775,807 이 넘어간다
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
	static final int div = 10007;
	
	// 방법1. 모듈러 연산을 활용하여 이항계수 값 계산
	// 팩토리얼 값을 구해주는 재귀메소드
	static int factorial(int N) {
		
		// factorial(0) == 1 
		if(N == 0) {
			return 1;
		}
		
		return (N * factorial(N-1)) % div;
	}
	
	// 모듈러 역원을 이용해 제곱승을 구하는 메소드(이항계수의 역원을 구하는 메소드)
	static int mod_inverse(int a, int p) {
		// 반환할 값 초기화
		int ret = 1;
		
		// 지수의 계수만큼 반복
		while (p > 0) {
			// 지수 p가 홀수인 경우, 밑a를 곱함
			if(p % 2 == 1) {
				ret *= a;
				p--;
				ret %= div;
			}
			
			// 지수 p가 짝수인 경우
			a *= a;
			a %= div;
			
			// 지수p를 2로 나눠줌(지수 공식 활용a^(n+n) = a^n + a^n)
			p /= 2;			// p >>>= 1;과 동치
		}
		
		return ret;
	}
	
	
	
	// 방법2) 동적계획법을 활용하여 이항계수를 계산하는 메소드
	static int[][] dp;
	static int BinomCoeff(int N, int K) {
		
		// 이미 풀었던 문제일 경우 값을 리턴
		if(dp[N][K] > 0) {
			return dp[N][K];
		}
		
		// nCn = nC0 = 1
		if(N == K || K == 0) {
			return dp[N][K] = 1;
		}
		
		return dp[N][K] = (BinomCoeff(N-1, K-1) + BinomCoeff(N-1, K)) % div;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 N과 K를 입력하세요.(단, 1 ≤ N ≤ 1,000, 0 ≤ K ≤ N)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 방법1) 모듈러 역원을 이용하여 이항계수 계산
		/*   n! / ((n-k)! * k!)   ->   n! * ((n-k)! * k!)^(-1) 으로 변환
		 *   ((n-k)! * k!)^(-1) == ((n-k)! * k!)^(p-2) 동치  
		 *   p(=div)가 소수여서 가능함)
		 */
		System.out.println((factorial(N) * mod_inverse((factorial(N-K) * factorial(K)) % div, div -2)) % div);
		
		
		// 방법2) 동적계획법을 활용하여 이항계수를 계산
		// 메모이제이션 할 배열 생성
		dp = new int[N+1][K+1];
		
		// 이항계수를 계산하는 메소드 실행
		System.out.println(BinomCoeff(N, K));
	}
}
