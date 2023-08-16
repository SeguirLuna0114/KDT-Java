package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 자연수 N과 정수 K가 주어졌을 때 
 * 이항 계수 N_C_K를 10,007로 나눈 나머지를 구하는 프로그램
 */
/** 12팩토리얼과 20팩토리얼은 각각 int와 long형이 넘어간다
 * 12! = 479,001,600 로 int형의 최댓값(2,147,483,647)을 넘어가고
 * c같이 unsigned int 최댓값(4,294,967,295)도 넘어간다.
 * 
 * 20! = 51,090,942,171,709,440,000 으로, 
 * long 9,223,372,036,854,775,807 이 넘어간다
 */
/** 모듈러 증명
 * 1. (a+b)%m = ((a%m)+(b%m))%m
 * 2. (a*b)%m = ((a%m) * (b%m))%m
 * 
 ** 페르마의 소정리
 * a는 정수, p는 소수이며 a는 p와 배수관계가 아닐때
 * a^p = a(mod p) -> a^p mod p = a mod p
 * 즉, a^(p-1) = 1(mod p) -> a * a^(p-2) = 1 (mod p)
 * 				"a^(p-2)rk a의 역원"
 * 
 * => 우리가 구하고자 하는 역원은 ( r!(n-r)! )에 대한 역원
 * 		a = (K!(N-K)!), p(나누는 수)= 10007
 * 		(K!(N-K)!)^-1 = (K!(N_K)!)^10007-2
 *
 * (N! / (k!(N-k)!))mod p = (N! * (k!(N-k)!)^-1)mod p
 * 						  = ((N! mod p) * (k!(N-k)!)^-1 mod p )mod p
 * 						  = ((N! mod p) * (k!(N-k)!)^(10007-2) mod p )mod p
 */
public class Bionomical_Coefficient2 {
	
	// 나누고자 하는 수 div
	static final int div = 10007;

	/** 알고리즘 1) 모듈러 역원을 적용하여 구하는 방법
	 *  n! / ((n-k)! * k!)   ->   n! * ((n-k)! * k!)^(-1) 으로 변환
	 *  ((n-k)! * k!)^(-1) == ((n-k)! * k!)^(p-2) 동치
	 *   p(=div)가 소수여서 가능함)
	 */
	static int factorial(int N) {
		// factorial(0) == 1 이다.
		if(N<= 1) {
			return 1;
		}
		return (N * factorial(N-1)) % div;
	}
	
	// 역원 구하기 (= 제곱승 구하기)
	static int mod_inverse(int a, int p) {
		int ret = 1;
		while (p > 0) {
			if (p % 2 == 1) {
				ret *= a;
				p--;
				ret %= div;
			}
			a *= a;
			a %= div;
			p >>>= 1;	// p = p/2 랑 동치( p /= 2)
		}
		return ret;
	}
	
	/** 알고리즘 2) 이항 계수의 성질을 이용한 풀이에 더해 동적계획법을 추가한 방법
	 * 입력값 최대가 1000이기에, 동적계획법을 사용해야 함!
	 */
	static int BionomicCoeffi(int N, int r) {
		// 결과값을 저장할 배열
		int[][] dp = new int[N+1][r+1];
		
		// 이미 풀었던 sub문제일 경우 값을 재활용
		if(dp[N][r] > 0) {
			return dp[N][r];
		}
	 
		if(N == r || r == 0) {
			return dp[N][r] = 1;
		}
	 
		return dp[N][r] = (BionomicCoeffi(N - 1, r - 1) + BionomicCoeffi(N - 1, r)) % 10007;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("N과 K를 입력하세요.(1 ≤ N ≤ 1,000, 0 ≤ K ≤ N)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 알고리즘 1) 모듈러 역원을 적용하여 구하는 방법
		// ((n-k)! * k!)^(-1) == ((n-k)! * k!)^(p-2) 동치 
		System.out.println((factorial(N)*mod_inverse((factorial(N-K) * factorial(K)) % div, div-2)) % div);
		
		System.out.println();
		
		// 알고리즘 2) 이항 계수의 성질을 이용한 풀이에 더해 동적계획법을 추가한 방법
		System.out.println(BionomicCoeffi(N, K));
	}
}
