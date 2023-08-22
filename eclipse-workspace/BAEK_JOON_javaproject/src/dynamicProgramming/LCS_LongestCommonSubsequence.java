package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력하는 프로그램
 * 
 * LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 
 * 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제
 * 
 * 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어짐
 * 
 * "맨 앞 문자부터 차례대로 비교하여 부분수열의 길이를 누적"
 * ex) str1 = ACAYKP, str2 = CAPCAK
 * 		str1의 첫번째 문자인 A를 기준으로 str2의 문자들을 비교
 * 	=>  [A, A] 의 경우 {C, A} 와 {A}의 LCS 길이를 의미
 * 			즉 두 번째 A가 오더라도 +1 더하는 것이 아니라 {C, A, P, C, A} 와 {A}의 최장 부분수열은 {A} 하나 뿐이므로 1
 * 		{C} 와 {A, C}의 부분수열은 {C} 이고, 두 번째 C에서는 {C, A, P ,C} 와 {A, C}의 부분 수열은 {A, C}로 +1이 증가
 * 		=> 각 열을 채울 때 같은 원소가 있다면 이전 열 또는 행에 +1 한 값이 LCS 길이가 된다는 것
 * 			"x번째 원소와 y번째 원소가 같다면 (x-1, y-1) 의 LCS길이의 +1"
 * 			"만약 같지 않다면? 이전 행의 원소 또는 열 원소 중 '큰 것'을 기준으로 채우면 됨"
 * 			LCS(Xi, Yj) : LCS(Xi-1, Yj-1) + 1                                  if (Xi == Yj)   
 * 			LCS(Xi, Yj) : max( LCS(Xi-1, Yj), LCS(Xi, Yj-1) )           if (Xi != Yj)    
 * 
 */
public class LCS_LongestCommonSubsequence {

	
	/** LCS : Longest Common SubSequance 
	 *  (가장 긴(longest) 공통된(Common) 부분수열(subsequance))
	 *  - 임의의 두 수열에서 각각의 부분 수열들 중, 서로 같은 부분 수열 중에서 가장 긴 부분 수열을 의미
	 *  
	 *  -  부분수열에서 '순서'가 지켜지기 때문에 각 문자열들의 문자들을 서로 비교하면서 
	 *     서로 같으면 값을 1씩 증가시키면서 누적합을 구하는 것
	 * 
	 * => 메모이제이션을 사용하여 Top-Down방식으로 탐색하거나 Bottom-Up방식을 사용하여 문제 풀이
	 */
	
	/** 알고리즘
	 * "맨 앞 문자부터 차례대로 비교하여 부분수열의 길이를 누적"
	 * ex) str1 = ACAYKP, str2 = CAPCAK
	 * 		str1의 첫번째 문자인 A를 기준으로 str2의 문자들을 비교
	 * 	=>  [A, A] 의 경우 {C, A} 와 {A}의 LCS 길이를 의미
	 * 			즉 두 번째 A가 오더라도 +1 더하는 것이 아니라 {C, A, P, C, A} 와 {A}의 최장 부분수열은 {A} 하나 뿐이므로 1
	 * 		{C} 와 {A, C}의 부분수열은 {C} 이고, 두 번째 C에서는 {C, A, P ,C} 와 {A, C}의 부분 수열은 {A, C}로 +1이 증가
	 * 		=> 각 열을 채울 때 같은 원소가 있다면 이전 열 또는 행에 +1 한 값이 LCS 길이가 된다는 것
	 * 			"x번째 원소와 y번째 원소가 같다면 (x-1, y-1) 의 LCS길이의 +1"
	 * 			"만약 같지 않다면? 이전 행의 원소 또는 열 원소 중 '큰 것'을 기준으로 채우면 됨"
	 * 			LCS(Xi, Yj) : LCS(Xi-1, Yj-1) + 1                                  if (Xi == Yj)   
	 * 			LCS(Xi, Yj) : max( LCS(Xi-1, Yj), LCS(Xi, Yj-1) )
	 * 
	 * 1) 메모이제이션을 위한 dp[][] 2차원 배열을 두고
	 * 2)  Top-Down의 경우 점화식(함수)만 발견하면 쉽게 구현 가능
	 * 3) 인덱스 밖(-1)을 참조할 수 없으므로 이 조건까지 추가
	 */
	static Integer[][] dp;
	static char[] str1;
	static char[] str2;
	
	// 방법1) 메모이제이션을 사용하여 Top-Down방식으로 탐색
	static int LSC(int x, int y) {
		
		// 인덱스 밖(공집합)일 경우 0을 반환
		if(x == -1 || y == -1) {
			return 0;
		}
		
		// 만약 탐색하지 않았던 인덱스라면
		if(dp[x][y] == null) {
			
			// LCS의 최소 길이는 0이기에, 0으로 초기화
			dp[x][y] = 0;
			
			//str1의 x번째 문자와 str2의 y번째 문자가 같은지 검사
			if(str1[x] == str2[y]) {
				dp[x][y] = LSC(x-1, y-1)+1;
			}
			
			// 같지 않다면, LCS(dp)[x-1][y]와 LCS(dp)[x][y-1] 중 큰 값으로 초기화
			else {
				dp[x][y] = Math.max(LSC(x-1, y),LSC(x, y-1));			}
		}
		
		return dp[x][y];
	}
	
	
	/** 방법2) 메모이제이션을 사용한 Bottom-Up방식으로 문제 풀이
	 * 	- for문(반복문)으로 공집합(인덱스 참조값이 -1 이 되면 0을 반환)을 구현 하려면 오버헤드 비용이 너무 많이 소모됨
	 *  - DP배열을 한 줄씩 늘려 0번째 행과 0번째 열은 위 그림처럼 공집합을 의미하는 행과 열로 나타내주는 것이 가장 현명
	 *  	"서로 문자가 같을경우 (i-1, j-1)을 참조해야하는데 
	 *  	 index가 0부터 시작한다면 -1을 참조해버리기 때문에 위와 같이 1부터 시작"
	 */
	// 공집합 표현을 위해 인덱스가 한 줄씩 추가 됨
	static int[][] DP;
	static void LCS_For() {
		
		// 1부터 시작(index 0은 0으로 초기화 되어있고, 인덱스 참조값이 -1이 되는것 방지하기 위함)
		for(int i=1; i<= str1.length; i++) {
			for (int j=1; j<= str2.length; j++) {
				
				// (i-1)과 (j-1)번째 문자가 서로 같다면(0,0 부터 문자열 탐색하기 위함)
				if(str1[i-1] == str2[j-1]) {
					// 대각선 위(i-1, j-1)의 DP에 +1(길이 추가)한 값으로 갱신
					DP[i][j] = DP[i-1][j-1] + 1;
				}
				
				// 같지 않다면, 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신
				else {
					DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄과 둘째 줄에 두 문자열을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// String.toCharArray() 메소드: 문지열을 char[]배열로 반환해주는 메소드 사용
		// 각 문자를 하나씩 참조하며 사용해야 하기 때문
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		
		// 방법1) 메모이제이션을 사용하여 Top-Down방식으로 탐색
		// 메모이제이션 배열 생성
		dp = new Integer[str1.length][str2.length];
		
		System.out.println(LSC(str1.length-1, str2.length-1));

		// 방법2) 메모이제이션을 사용한 Bottom-Up방식으로 문제 풀이
		// 메모이제이션 배열 생성
		// - 공집합 표현을 위해 인덱스가 한 줄씩 추가 됨(0~len)
		DP = new int[str1.length + 1][str2.length + 1];
		
		// 1부터 시작 (index 0 은 공집합이므로 0의 값을 갖고있음)
		LCS_For();
		
		// Top-Down 때와는 다르게 dp 인덱스가 한 줄씩 추가되었으므로 -1을 하지 않음
		System.out.println(DP[str1.length][str2.length]);
	}
}
