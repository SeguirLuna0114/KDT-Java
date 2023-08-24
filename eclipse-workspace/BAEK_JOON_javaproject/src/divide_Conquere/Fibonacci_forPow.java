package divide_Conquere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램
 * 단, 첫째 줄에 n번째 피보나치 수를 1,000,000,007으로 나눈 나머지를 출력
 * (n은 1,000,000,000,000,000,000보다 작거나 같은 자연수)
 * 
 * 피보나치 수 Fn = Fn-1 + Fn-2 (n ≥ 2)
 * - 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1
 * - 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합
 */
public class Fibonacci_forPow {
	
	/** 피보나치 수를 "행렬
	 * - 입력이 1,000,000,000,000,000,000보다 작거나 같은 자연수 이기에, 
	 * 	 동적계획법으로 풀이하더라도 dp[]배열로 메모이제이션 하여 n에 대해 탐색했는지 확인X
	 * 	 (대신, HashMap같은 자료구조를 활용하여 n은 key값, 그리고 n에대한 피보나치 수를 value로 저장하는 방식으로 활용 가능)
	 * 
	 * - 선형방정식을 행렬 꼴(matrix form)로 변환
	 * 	 : Fn = Fn-1 + Fn-2 을 Ax = b 형태의 행렬로 만드는 것
	 * 		[Fn+2] = [1 1] [Fn+1 Fn]T  (T는 행렬의 전치)
	 *     => [Fn+1 Fn]T  = [1 1]^n [1
	 *     					[1 0]	 0]
	 *     => n제곱 할 행렬 A
	 *     	(A12 혹은 A21 과 A22 원소를 더하면 A11 원소를 얻을 수 있다)
	 *     		A^n = [Fn+1		Fn]
	 *     			  [Fn		Fn-1]
	 * - n번째 피보나치 수를 1,000,000,007으로 나눈 나머지를 출력
	 * 	 모듈러 연산을 해주어야 하니 
	 *   행렬끼리 곱할 때 각 원소에 1000000007 을 나눈 나머지 값을 저장				
	 */
	static final long MOD = 1000000007;
	
	// 방법2) 반복문을 사용해 재귀를 구현하는 행렬 제곱 분할정복 메소드
	// o1[][]과 o2[][] 행렬을 곱해주는 메소드
	static long[][] multiply(long[][] o1, long[][] o2) {
		
		long[][] ret = new long[2][2];
		
		ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
		ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
		ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
		ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;
		
		/* 반복문으로 작성해주어도 무방함
			for (int k = 0; k < 2; k++) {
				for (int i = 0; i < 2; i++) {							
					for (int j = 0; j < 2; j++) {
						ret[i][j] += o1[i][k] * o2[k][j];
						ret[i][j] %= MOD;
					}
				}
			}
		*/
		
		return ret;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째줄에 n을 입력하세요.(n은 1,000,000,000,000,000,000보다 작거나 같은 자연수)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());

		// N이 1이거나 0이라면 N을 출력하고 종료
		if(N == 1 || N == 0) {
			System.out.println(N);
			return;		// 종료
		}
		
		/*
		 *                n
		 *       | 1   1 |    | F(n+1)  F(n)  |
		 * A^n = |       |  = |               |
		 *       | 1   0 |    |  F(n)  F(n-1) |
		 */
		
		// A^(n-1)의 [0][0] 원소를 구하면 되므로 1을 빼준다. 
		N--;
		
		long[][] origin = {{1, 1}, {1, 0}};
		long[][] A = {{1, 0}, {0, 1}};	// 초기 값은 단위행렬(I)로 초기화해준다.
		
		// 방법1) 재귀 방식을 활용해 행렬 제곱 분할정복 메소드
		/*
		 * origin 행렬은 이전 loop에서 제곱값을 갖고있는 행렬이고,
		 * A는 지수가 홀 수 일 때, 이전 loop에서 얻은 제곱 행렬인 origin과
		 * 현재 A 행렬을 곱해주는 방식으로 간다.
		 * 
		 * 즉, 재귀 과정을 역순으로 거치면 된다.
		 * 
		 * ex)
		 * A^11 과정일 떄,
		 * 
		 * N = 11 (N % 2 == 1) -> I * A^1 = A^1 (result)
		 *                     -> A^1 * A^1 = A^2 (origin)
		 *                     
		 * N = 5  (N % 2 == 1) -> A^1 * A^2 = A^3 (result)
		 *                     -> A^2 * A^2 = A^4 (origin)
		 *                     
		 * N = 2  (N % 2 == 0) -> A^4 * A^4 = A^8 (origin)
		 *
		 * N = 1  (N % 2 == 1) -> A^3 * A^8 = A^11 (result)
		 *                     -> A^8 * A^8 = A^16 (origin)  
		 */
		while(N > 0) {
			
			// 지수가 홀수라면 origin 배열을 한번 더 곱해줌
			if(N % 2 == 1) {	// b % 2 == 1 을 (b & 1L) != 0L 으로도 수정할 수 있다.
				A = multiply(A, origin);
			}
			
			origin = multiply(origin, origin);
			
			N /= 2;
		}
		
		// Fn을 구하기 위해 A행렬을 n-1제곱한 뒤 반환된 행렬 A11원소를 출력
		System.out.println(A[0][0]);
	}
}
