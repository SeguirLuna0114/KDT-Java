package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 포도주의 양이 주어졌을 때, 효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램
 * 
 * 포도주 시식 규칙
 * 1. 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 
 * 	  마신 후에는 원래 위치에 다시 놓아야 한다.
 * 2. 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
 * 
 * - UpStair(계단오르기 문제)와 비슷하나, 다른점 => "마지막 계단을 밟아야 함"이라는 조건X
 * 		"즉, 마지막 와인잔이 선택 될 때가 최대 누적합일수도, 또는 그 이전 와인잔까지 선택이 최대 누적합일 수도 있음"
 */

public class SelectRule_Wine {

	// 동적계획법을 사용하여 문제 풀이
	static Integer[] dp;	// 메모이제이션을 하는 배열이 dp
	static int[] wine;		// 입력받은 와인의 양
	
	/** 방법1) TOP-DOWN 방식 - 재귀를 활용하여 문제풀이
	 * - 2개의 연속된 값 =>  호출해 줄 때 비연속적인 값을 탐색해나가는 방법이 필요
	 * 		" N번째 값에 대하여 (N-2)번째 값과 (N-3)번째 값을 탐색해줄 필요 "
	 * - dp의 값이 항상 최댓값을 보장하는 것이 아니기에, N-1 을 넘긴 재귀호출의 값과도 비교
	 * 		=>  N-1 번째 누적합과 큰 것 중 하나를 선택하여 dp를 갱신
	 */
	static int recursionWine(int N) {
		
		if(dp[N] == null) {
			/* N-2를 재귀 호출 한 것과(비연속), 
			 * N-3을 재귀호출 한 값의 N-1번째의 와인잔을 합한 값 중 큰 것을 선택한 후,
			 * 현재 와인값의 값과 합해줌
			 * 
			 * & dp의 값이 항상 최댓값을 보장하는 것이 아니기에, N-1번째 누적합과 "비교" => 갱신
			 *   "각 노드는 이전의 최댓값과 비교하게 되며 조합 가능한 것 중 최댓값만을 저장"
			 */
			dp[N] = Math.max(Math.max(recursionWine(N-2), recursionWine(N-3)+wine[N-1]) + wine[N], recursionWine(N-1));
		}
		
		return dp[N];
	}
	
	
	
	/** 방법2) BOTTOM-UP 방식 - 반복문을 사용하여 문제풀이
	 * - 점화식 구조를 for반복문을 사용하여 문제 풀이
	 * - i가 3부터 시작 => dp[i - 3]에서 인덱스 참조가 벗어날 수 있기 때문
	 * 	" i = 3부터 N까지 순차적으로 쌓아가면서 풀어나가는 것"
	 */
	static int DP[];	// 메모이제이션을 하는 배열
	static void UsingFor(int N) {
		
		for(int i=3; i<=N; i++) {
			DP[i] = Math.max(DP[i-1], Math.max(DP[i-2]+wine[i], DP[i-3] + wine[i-1] + wine[i]));
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 포도주 잔의 개수 n(1 ≤ n ≤ 10,000)을 입력하고,\n"
				+ "둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양을 순서대로 입력하세요.(포도주의 양은 1,000 이하의 음이 아닌 정수)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 포도주 잔의 개수n
		int n = Integer.parseInt(br.readLine());
		
		dp = new Integer[n+1]; 	// => 초기화 null
		wine = new int[n+1];
		
		// 포도주 잔에 들어있는 포도주의 양을 배열에 입력
		for (int i=0; i<n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		// 방법1) TOP-DOWN 방식 - 재귀를 활용하여 문제풀이
		dp[0] = 0;
		dp[1] = wine[1];
		
		/* (N이 1로 주어질 수 있으므로 이럴 때를 위해 조건식을 달아둔다.
		 * 또한 dp[2]는 어떤 경우에도 첫 번째와 두 번째를 합한 것이 최댓값이다. 
		 */
		if (n > 1) {
			dp[2] = wine[1] + wine[2];
		}
		
		System.out.println(recursionWine(n));
		
		
		// 방법2) BOTTOM-UP 방식 - 반복문을 사용하여 문제풀이
		DP = new int[n+1];		// => 초기화 0
		
		DP[1] = 1;
		if(n>1) {
			DP[2] = wine[1] + wine[2];
		}
		
		// i=3 ~ i=n 최대값 구하는 메소드 실행
		UsingFor(n);
		
		// n번째 잔 선택시, 최대값
		System.out.println(DP[n]);
	}
}
