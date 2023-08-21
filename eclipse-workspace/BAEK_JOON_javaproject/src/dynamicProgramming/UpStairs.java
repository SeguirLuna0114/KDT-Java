package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 각 계단에 쓰여 있는 점수가 주어질 때 
 * 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램
 * 
 * 계단 오르는 데는 다음과 같은 규칙이 있다.
 * 1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 
 * 	(즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.)
 * 2. 연속된 세 개의 계단을 모두 밟아서는 안 된다.
 *  (단, 시작점은 계단에 포함되지 않는다.)
 * 3. 마지막 도착 계단은 반드시 밟아야 한다.
 * 
 * 단, 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수
 */
public class UpStairs {

	/** 계단 오르기 조건
	 * 1. 계단을 오를 때 한 계단, 또는 두 계단을 오를 수 있다.
	 * 2. 연속된 3개의 계단을 밟으면 안된다. 
	 * (즉, 한 계단씩 올라갈 때 최대 연속으로 2번만 한계단씩 오를 수 있다는 의미다.)
	 * 3. 마지막 계단은 '반드시' 밟아야 한다. => 마지막 계단에 대한 경우의 수들의 누적합 중 최댓값 구함
	 */
	static int[] stair;
	
	/** TOP-DOWN 방식 : 큰 문제부터 작은 문제로 들어가는 방식
	 * 	- 재귀호출을 통해 작은문제로 쪼개어 들어가는 방식
	 ** BOTTOM-UP 방식: 작은 문제부터 풀어가며 전체를 풀어가는 방식
	 *	- 반복문을 통해 구현
	 * 
	 ** 메모이제이션을 통해 계산한 값을 dp배열에 저장할것
	 *	- 단, "연속으로 3계단을 밟을 수 없음"
	 */
	static Integer[] dp;		// 초기값 NULL로 설정됨
	// 방법1) TOP-DOWN 방식 - 재귀를 활용하여 문제풀이
	static int UPStair_recur(int N) {
		
		/** 재귀호출을 할 때 N-2 와 N-3 은 재귀호출을 하지만 
		 * 	N-1 은 재귀호출을 하지 않음
		 * - 연속 된 블럭의 경우의 수는 재귀호출이 아니라 이미 입력받은 배열의 값을 더해주어야함
		 * - 연속된 3개의 계단을 밟으면 안된다 & 마지막 계단은 '반드시' 밟아야 한다
		 * 	 => 두 계단 전의 경우와(N-2) 와 직전 계단을 밟고(N-1) 
		 *   	그 이전에는 두 계단 이전의 경우(N-3)에서 연속되지 않는 위치인 N-2와 N-3에 대해서만 재귀호출을 해주어야 한다. 
		 */
		// 재귀 dp는 int[] 배열이 아닌 Integer[] 객체배열을 사용하면
		// 디폴트값이 null이므로 0으로 초기화 해주어야한다
		dp[0] = stair[0];
		dp[1] = stair[1];
		
		// N 이 1이 입력될 수도 있기 때문에 예외처리를 해줄 필요가 있다.
		if (N >= 2) {
			dp[2] = stair[1] + stair[2];
		}
		
		if(dp[N] == null) {
			dp[N] = Math.max(UPStair_recur(N-2), UPStair_recur(N-3) + stair[N-1]) + stair[N];
		}
		
		return dp[N];
	}
	
	
	// 방법2) BOTTOM-UP 방식 - 반복문을 사용하여 문제풀이
	/** 계단 1층부터 하나씩 값을 더해가면서 채워나가 마지막 계단에서 누적 된 합을 구하기
	 * - 현재 인덱스 i 에 대해 두 칸 전(i - 2)의 '메모이제이션 값'과 
	 * 	 첫 칸 전(i - 1)의 값 + 셋 째칸 전(i - 3)의 '메모이제이션 값' 중 큰 값을 
	 *   현재 i 계단의 값과 합하여 DP배열에 저장(Memoization)
	 */
	static int[] DP;
	static void UPStairFor(int N) {
		/*
		반복문 DP배열은 int[] 배열로 쓸 것이기 때문에
		index 0은 초기화해줄 필요 없다.
		*/
		// index = 0 은 시작점이므로 0이다.
		DP[1] = stair[1];
		
		// N 이 1이 입력될 수도 있기 때문에 예외처리를 해줄 필요가 있다.
		if (N >= 2) {
			DP[2] = stair[1] + stair[2];
		} 
		
		for (int i=3; i <= N; i++) {
			DP[i] = Math.max(DP[i-2], DP[i-3] + stair[i-1]) + stair[i];
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 계단의 개수를 입력하고, \n"
				+ "둘째줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수를 입력하세요."
				+ "\n(계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		stair = new int[N+1];
		dp = new Integer[N+1];
		
		// 입력받은 계단에 쓰여 있는 점수로 계단배열 초기화 
		for (int i=1; i<=N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		// 방법1) TOP-DOWN 방식 - 재귀를 활용하여 문제풀이
		System.out.println(UPStair_recur(N));
		
		// 방법2) BOTTOM-UP 방식 - 반복문을 사용하여 문제풀이
		DP = new int[N+1];
		UPStairFor(N);
		System.out.println(DP[N]);
	}

}
