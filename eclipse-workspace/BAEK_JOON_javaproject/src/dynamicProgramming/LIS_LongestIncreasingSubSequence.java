package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 가장 긴 증가하는 부분수열을 구하는 프로그램
 * ex) 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에
 *     가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4
 * 
 * - SelectionRule_Wine(포도주 시식)문제와 UpStairs(계단오르기) 문제와 비슷한 계열
 */
public class LIS_LongestIncreasingSubSequence {
	
	/** 방법1) Top-Down(재귀)방식
	 * - 탐색하려는 인덱스(위치)에 대해서 이전 위치들을 찾아나가면서 
	 * 	 해당 값보다 작을 경우 재귀호출을 통해 탐색
	 * 
	 * ex) N=4 을 탐색 -> 해당 노드의 값이 N번째 값보다 작은 경우를 찾기
	 * 		i=2 에서 현재 탐색하고자 하는 값 dp[4]와 recur(2) + 1 재귀호출 한 값 중 큰 값을 dp[4]에 갱신
	 * 		recur(2) 재귀호출을 하면 dp[2] 은 아직 탐색하지 않았을 경우 dp[2] = 1 로 초기화가 되고, 또한 0~1까지 중 작은 값들을 찾
	 */
	static int[] LIS;
	static Integer[] dp;
	
	// 입력받은 N의 부분수열 탐색
	static int recursion(int N) {
		
		// 만약 탐색하지 않았던 위치의 경우
		if(dp[N] == null) {
			// 1로 초기화(모든 부분수열의 길이는 '최소한 1 이상'이기 때문)
			// => 이후, 입력받은 값 중, 큰 값으로 갱신 
			dp[N] = 1;
			
			// N 이전의 노드를 탐색(N-1 부터 0까지 N보다 작은 노드들을 탐색)
			// "해당 노드의 값이 N번째 값보다 작은 경우를 찾기"
			for (int i=N-1; i>= 0; i--) {
				
				// 이전의 노드 중, LIS[N]의 값보다 작은 값을 발견한 경우, dp배열에 추가
				if(LIS[i] < LIS[N]) {
					// +1을 하는 이유: dp[N]이 이전 부분수열에 N번째 원소가 추가되었다는 의미
					dp[N] = Math.max(dp[N], recursion(i) + 1);
				}
			}
		}
		
		return dp[N];
	} 
	
	
	/** 방법2) Bottom-Up(반복문) 방식
	 * - 이중반복문으로 0 ~ N-1 까지 각 원소보다 큰 값들을 카운팅해주는 것
	 * - 작은 문제들을 풀어 결합해나가는 방식
	 */
	static int[] DP;
	
	static void UsingDoubleFor(int N) {
		
		for (int i=0; i < N; i++) {
			// 1로 초기화(모든 부분수열의 길이는 '최소한 1 이상'이기 때문)
			DP[i] = 1;
			
			// 0~i이전 원소를 탐색
			for (int j=0; j<i; j++) {
				
				// j번째 원소가 i번째 원소보다 작으면서, i번째 DP가 j번째 DP+1보다 작은경우
				if(LIS[j] < LIS[i] && DP[i] < DP[j]+1) {
					// j번째 원소의 +1 값이 i번째 DP가 된다.
					DP[i] = DP[j] + 1;
				}
			}
		}
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("수열 A의 크기 N (1 ≤ N ≤ 1,000)을 입력하고, \n"
				+ "둘째 줄에는 수열 A를 이루고 있는 Ai(1 ≤ Ai ≤ 1,000)를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수열 A의 크기 N
		int N = Integer.parseInt(br.readLine());
		
		// 메모이제이션 배열 생성
		dp = new Integer[N];		// 방법1에서 사용
		DP = new int[N];			// 방법2에서 사용
		
		// 수열 A를 이루고 있는 Ai를 입력
		LIS = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			LIS[i] = Integer.parseInt(st.nextToken());
		}
		
		// 방법1) Top-Down(재귀)방식을 통해 LIS배열 최대길이 구하는 방법
		// 0~N-1까지 모든 부분수열 탐색 =>  각각의 원소에 대한 부분 증가 수열을 모두 구함
		for(int i=0; i<N; i++) {
			recursion(i);
		}
		
		// 최댓값 찾기
		int max = dp[0];
		for(int i=1; i<N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
		
		// 방법2) Bottom-Up(반복문) 방식을 통해, 0 ~ N-1 까지 각 원소보다 큰 값들을 카운팅
		// 이중 반복문을 통해 0~N-1까지 모든 부분수열 탐색 =>  각각의 원소에 대한 부분 증가 수열을 모두 구함
		UsingDoubleFor(N);
		
		// 최대값(최대길이) 탐색
		int maxVal = -1;	// 초기 최대값 설정(int[] 초기값은 0이기에)
		for (int i=0; i<N; i++) {
			maxVal = (DP[i] > maxVal) ? DP[i] : maxVal;
		}
		
		System.out.println(maxVal);
	}
}
