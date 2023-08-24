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
public class Fibonacci_recurPow {
	
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
	static long[][] origin = {{1, 1} , {1, 0}};	// 초기값을 갖고있는 행렬
	
	// 방법1) 재귀 방식을 활용해 행렬 제곱 분할정복 메소드
	static long[][] pow(long[][] A, long exp) {
		
		// 지수가 1 또는 0일 경우 A를 return
		if(exp == 1 || exp == 0) {
			return A;
		}
		
		// 지수의 절반을 분할하여 재귀호출
		long[][] ret = pow(A, exp/2);
		
		// 하위 재귀에서 얻은 행렬을 제곱
		ret = multiply(ret, ret);
		
		// 만일 지수가 홀수라면 마지막에 A^1(origin)을 제곱
		if(exp % 2 == 1L) {
			ret = multiply(ret, origin);
		}
		
		return ret;
	}
	
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

		/*
		 *                n
		 *       | 1   1 |    | F(n+1)  F(n)  |
		 * A^n = |       |  = |               |
		 *       | 1   0 |    |  F(n)  F(n-1) |
		 */
		long[][] A = {{1, 1}, {1, 0}};
		
		// 방법1) 재귀 방식을 활용해 행렬 제곱 분할정복 메소드
		// Fn을 구하기 위해 A행렬을 n-1제곱한 뒤 반환된 행렬 A11원소를 출력
		System.out.println(pow(A, N-1)[0][0]);
		
	}

}
