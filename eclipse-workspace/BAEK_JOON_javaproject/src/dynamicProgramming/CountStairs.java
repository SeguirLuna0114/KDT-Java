package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램
 * 첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력
 * => 자릿수가 100, 즉 100째자리 수까지 주어지니 기본 형식은 long타입으로 해준다고 가정
 * 
 * * 계단수: "인접한 모든 자리의 차이가 1"인 수(ex. 45656)
 */
public class CountStairs {
	
	// 정답을 1,000,000,000으로 나눈 나머지를 출력
	static long MOD = 1000000000;
	
	/** 계단수
	 * 1) N번째 자릿수의 자릿값이 0인 경우 : 다음 자릿수의 자릿값은 1밖에 올 수 없음
	 * 2) N번째 자릿수의 자릿값이 9인 경우 : 다음 자릿수의 자릿값은 8밖에 올 수 없음
	 * => ex) 10 다음에 붙을 수 있는 수는 1밖에 없으므로 101 이 되는 것
	 * 		  19가 온다면 8밖에 올 수 없으므로 198 이 되는 것
	 * 			" 그 외의 값(2~8)은 각 값보다 -1 또는 +1 인 값을 가질 수 있음 "
	 * 			=>  자릿값은 0~9를 가질 수 있고, N개의 자릿값을 표현해야하므로 2차원 배열이 필요
	 */
		
	/** 방법1) Top-Down 방식으로 재귀로 풀어내는 방법
	 * - Top-Down방식의 장점: 점화식을 그대로 적용할 수 있다는 점
	 * -  재귀를 쓰기 위한 두 가지 변수: 자릿값을 표현 할 변수인 digit, 자릿값을 표현 할 변수인 val
	 * 
	 * 자릿값에 따라 자릿값이 0이라면 다음에 올 자릿값은 1로, 9라면 8로 호출해주고,
	 * 그 외의 경우는 val-1, val+1 둘 다 가능하니 둘 다 호출하여 경우의 수를 합하는 방법 사용
	 * 첫째 자리수는 각 val이 끝이기 때문에 경우의 수는 1밖에 없다
	 * => 즉, dp[1]의 각 자릿값은 1로 초기화 되어있어야한다.
	 */
	// 자릿수와 자릿값을 index로 쓸 2차원 배열
	static Long[][] dp;
	// 해당 자리수의 경우의수를 생성하는 메소드
	static long recursion(int digit, int val) {
		
		// 첫째 자리수에 도착한다면, 더이상 탐색할 필요 X
		// (각 val이 끝이기 때문에 경우의 수는 1)
		if (digit == 1) {
			return dp[digit][val];
		}
		
		// 해당 자리수의 val값에 대해 탐색하지 않았을 경우
		// N 번째 자릿수의 자릿값이 없으면 N-1번째 자릿수를 탐색하고, 
		// N-1 도 없으면 N-1의 -1 번째 자릿수를 탐색하여 값이 있을 때 까지 찾아나가는 방식
		if(dp[digit][val] == null) {
			
			// val이 0일 경우 "이전 자리"는 1밖에 못옴
			// N번째 자릿수의 자릿값이 0인 경우 : +-1 자릿수의 자릿값은 1밖에 올 수 없음
			if(val == 0) {
				dp[digit][val] = recursion(digit-1, 1);
			}
			
			// val이 9인 경우 이전 자리는 8밖에 못옴
			else if(val == 9) {
				dp[digit][val] = recursion(digit-1, 8);
			}
			
			// 그 외의 경우는 val-1과 val+1값의 경우의수를 합한 경우의수가 됨
			else {
				dp[digit][val] = recursion(digit-1, val-1) + recursion(digit-1,  val+1);
			}
		}
		// long 범위에서 벗어나지 않도록 각 return마다 나머지값을 return시켜주어야 한다
		return dp[digit][val] % MOD;
	}
	
	
	
	/** 방법2) Bottom-Up 방식으로 반복문으로 풀어내는 방법
	 * - 사실 엄연히 하면 자릿수가 거꾸로 되어있는데, 어차피 경우의 수를 구하는 것이기 때문에 크게 문제되진 않음
	 */
	// DP[자릿값][0~9자리수]
	static long[][] DP;
	
	static void UsingFor(int N) {
		
		// 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개밖에 없음
		
		// => 두 번째 자릿수부터 N까지 탐색
		for(int i=2; i<=N; i++) {
			
			// i번W째 자리수의 자릿값들을 탐색(0~9)
			for (int j=0; j<10; j++) {
				
				// j=0이라면(자릿값=0), 이전 자릿수의 첫번째 자릿수만 가능
				if(j==0) {
					DP[i][0] = DP[i-1][1] % MOD;
				}
				
				// j=9라면(자릿값=9), 이전 자릿수는 8만 가능
				else if(j==9) {
					DP[i][9] = DP[i-1][8] % MOD;
				}
				
				// 그외의 경우, 이전 자리수의 자리값+1, -1의 합이 됨
				else {
					DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1]) % MOD;
				}
			}
		}
	}
	


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("N을 입력하세요.(단, N은 1보다 크거나 같고, 100보다 작거나 같은 자연수)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// N개의 자릿값을 표현하기 위한 2차원배열 생성(N개의 자릿수에 0~9 자릿값 표시)
		dp = new Long[N+1][10];
		
		// 각 val이 끝이기 때문에 경우의 수는 1=> dp[1]의 각 자릿값은 1로 초기화
		// dp[1][0], dp[1][1], ⋯ ,dp[1][9] 는 1로 초기화 되어있어야 한다
		for(int i=0; i<10; i++) {
			dp[1][i] = 1L;
		}
		
		// 해당 자리수의 경우의수를 생성하는 메소드 활용 => 마지막 자릿수인 1~9까지의 경우의 수를 모두 더해준다.
		// 방법1) Top-Down 방식으로 재귀로 풀어내는 방법
		// 정답을 1,000,000,000으로 나눈 나머지를 출력
		long result = 0;
		for(int i=1; i<=9; i++) {
			result += recursion(N, i);
		}
		System.out.println(result % MOD);
		
		
		// 방법2) Bottom-Up 방식으로 반복문으로 풀어내는 방법
		DP = new long[N+1][10];
		
		// 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개밖에 없음
		for(int i=1; i<10; i++) {
			DP[1][i] = 1;
		}
		
		// 반복문을 사용해서 경우의 수 구함
		UsingFor(N);
		
		// 정답을 1,000,000,000으로 나눈 나머지 출력
		long result2 = 0;
		for (int i=0; i<10; i++) {
			result2 += DP[N][i];
		}
		System.out.println(result2 % MOD);
	}
}
