package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* n개의 정수로 이루어진 임의의 수열이 주어질 때,
 * 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하는 프로그램
 * 
 * ex) 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어지면,
 * 		정답은 12+21인 33
 */
public class ConsecutiveNum_Sum {
	
	/** 방법1) Top-Down(재귀) 방식의 메모이제이션을 활용한 방법
	 * 1. 입력받은 수열을 배열로 표현
	 * 2. 배열에서 연속된 수를 뽑아내어 "연속적으로 선택한 수의 합이 최대가 되는 수"
	 * 3. 메모이제이션 배열에 이전까지 탐색했던 값과 현재 위치의 값을 비교하며 큰 값을 저장
	 * 4. 탐색 과정에서 아예 max변수를 두고 해당 index n의 위치에 저장 될 최댓값과 현재 max값을 비교하면서 최댓값을 갱신
	 */
	static Integer[] dp;
	static int[] seq;
	// 합의 최대값
	static int max;
	
	static int recursion(int N) {
		
		// 만일 탐색하지 않았던 인덱스인경우
		if(dp[N] == null) {
			
			// '이전 배열의 누적합 + 현재값' 과 '현재 값'을 비교하여 최댓값을 N위치에 저장
			// - 음수일 경우도 있기에 max로 비교 필요
			dp[N] = Math.max(recursion(N-1) + seq[N], seq[N]);

			// 해당 dp[N]과 max 중 큰 값으로 max갱신
			max = Math.max(dp[N], max);
		}
		
		return dp[N];
	}
	
	
	/** 방법2) Bottom-Up방식의 반복문으로 구현
	 * - 그 결과, 메모이제이션이 된 dp배열에는 각 인덱스까지의 최댓값이 저장됨
	 * - 따라서, dp배열의 원소들 중 가장 큰 값을 찾아서 출력
	 * 	=> dp배열의 최댓값을 1) 정렬한 후, 하나하나 탐색하는 방법
	 * 	   				 2) 처음부터 아예 재귀 또는 반복문안에 max변수를 하나 두어 최댓값을 갱신하는 방법
	 */
	static int[] DP;
	static int maxVal;
	static void UsingFor(int N) {
		
		for(int i=1; i<N; i++) {
			// (이전 dp + 현재 arr값) 과 현재 arr값 중 큰 것을 dp에 저장 
			DP[i] = Math.max(DP[i-1] + seq[i], seq[i]); 
			
			// 최대값 갱신
			maxVal = Math.max(maxVal, dp[i]);
		}
		
		System.out.println(maxVal);
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 정수 n(1 ≤ n ≤ 100,000)을\n"
				+ "둘째 줄에는 n개의 정수로 이루어진 수열을 입력하세요.(이때, 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 입력받은 수열을 저장할 배열
		seq = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		// 방법1) Top-Down(재귀) 방식의 메모이제이션을 활용한 방법
		// 배열 생성
		dp = new Integer[N];
		
		/*
		 * dp[0]은 첫 원소이기에, 이전에 탐색할 것이 없음
		 * seq[0]은 자체 값이 되기에, seq[0]으로 초기화 해줌
		 * max 또한 첫번째 원소로 초기화
		 */
		dp[0] = seq[0];
		max = seq[0];
		
		// dp의 마지막 인덱스는 N-1이기에, N-1부터 Top-Down 탐색
		recursion(N-1);
		
		// 최대값을 출력
		System.out.println(max);
		
		
		// 방법2) Bottom-Up방식의 반복문으로 구현
		// 메모이제이션 배열 생성
		DP = new int[N];
		
		/*
		 * dp[0]은 첫 원소이기에, 이전에 탐색할 것이 없음
		 * seq[0]은 자체 값이 되기에, seq[0]으로 초기화 해줌
		 * max 또한 첫번째 원소로 초기화
		 */
		DP[0] = seq[0];
		maxVal = seq[0];
				
		UsingFor(N);
	}
}
