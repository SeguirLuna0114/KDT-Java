package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 이항계수(Binomial coefficient)를 구하는 프로그램
 * 
 * 조합 공식 nCr = (n!) / r!(n-r)!
 */
public class Bionomical_Coefficient {
	
	/** 조합 성질
	 * 1. n_C_r = n-1_C_r-1 + n-1_C_r
	 *  	- 파스칼의 법칙을 활용
	 * 2. nC0 = nCn = 1
	 * 		- n과 r이 같거나, r=0이면 1
	 */
	// 방법1. 조합공식 nCr = (n!) / r!(n-r)!을 사용하는 방법
	static int factorial(int N) {
		
		// factorial(0) == 1
		if(N <= 1) {
			return 1;
		}
		
		return N * factorial(N-1);
	}
	
	
	// 방법2. 조합 성질을 활용하여 이항계수 구하는 방법
	static int BionomicCoeff(int n, int r) {
		
		// 2번 성질
		if(n==r || r ==0) {
			return 1;
		}
		
		// 1번 성질
		return BionomicCoeff(n-1, r-1) + BionomicCoeff(n-1, r);
	}
	
	/** 메모이제이션(Memoization)
	 * : 함수의 결과를 한 번 계산한 후 그 값을 저장하여
	 *  같은 인자로 다시 호출될 때 계산을 다시 수행하지 않고 저장된 값을 반환하는 것
	 *  - 중복된 계산을 피하고 실행 속도를 향상
	 * 
	 * 방법2 코드에 메모이제이션을 할 배열을 초기에 선언하고, 
	 * 재귀로 하위 문제로 접근하고, 문제가 풀리면 메모이제이션을 할 배열에 저장하면서 나오는 것
	 */
	// 방법3. 동적 계획법 사용
	static int MemoizationBionomicCoefficient(int n, int r) {
		
		// 메모이제이션을 할 배열을 초기에 선언
		int[][] dp = new int[n+1][r+1];
		
		// 이미 풀었던 sub문제일 경우 값을 재활용
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		
		// 2번 성질: nC0 = nCn = 1
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
	    // 1번 성질: n_C_r = n-1_C_r-1 + n-1_C_r
		return dp[n][r] = MemoizationBionomicCoefficient(n - 1, r - 1) 
				+ MemoizationBionomicCoefficient(n - 1, r);
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("N과 K를 입력하세요.(단, 1<=N<=10, 0<=K<=N)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		StringBuilder sb = new StringBuilder();
		// 방법1. 조합공식 nCr = (n!) / r!(n-r)!을 사용하는 방법
		sb.append(factorial(N) / (factorial(K) * factorial(N-K))).append('\n');
		System.out.println(sb);
		
		// 방법2. 조합 성질을 활용하여 이항계수 구하는 방법
		System.out.println(BionomicCoeff(N, K));

		System.out.println();
		
		// 방법3. 동적계획법 사용
		System.out.println(MemoizationBionomicCoefficient(N, K));
	}

}
