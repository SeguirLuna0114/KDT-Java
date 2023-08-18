package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 
 * 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램
 * 			7
 * 		  3	  8
 * 		8	1	0
 *    2	  7	  4	  4
 * 4	5	2	6	5
 * 
 * - 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 
 * 	 또는 대각선 오른쪽에 있는 것 중에서만 선택
 * - 삼각형의 크기는 1 이상 500 이하
 * - 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하
 * 
 * 첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어짐
 * 이때, 첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력
 */
public class IntTriangle {
	
	/** 메모이제이션 방법을 사용하여 "DP를 위에서부터 탐색"
	 * - 가끔 위에서 아래로 내려오면서 최댓값 경로만 찾아서 하는 경우가 있는데 그렇게 하면 100% 오답
	 * - DP에 한 번 탐색한 값을 재활용(Memoization)하지 않고 불필요하게 재귀호출을 다 해주면 시간초과
	 * 
	 * 1. 삼각형을 입력받을 2차원 배열 생성
	 * 2. 경로 합을 누적할 DP배열 생성
	 * 	  - 이때, 삼각형의 밑변(마지막 값)은 DP배열 초기값으로 설정
	 */
	static int N;
	
	static Integer[][] dp;
	static int[][] arr;
	
	/** 각 밑의 값 중 최댓값과 현 위치의 값을 더해나가면서 가는 방식
	 * @param depth : 깊이(행), idx : 인덱스(열)
	 * - DP[0][0]에 최종적으로 쌓인 누적 합이 최댓값이 됨
	 */
	static int findMemo(int depth, int idx) {
		
		// 만약 맨 밑(깊이)의 행에 도달하면 해당 인덱스를 반환한다.
		if(depth == N-1) {
			return dp[depth][idx];
		}
		
		// 만약 아직 탐색하지 않은 위치라면 다음 행의 양쪽 열 중 최댓값을 구함
		if(dp[depth][idx] == null) {
			/*
			 바로 다음행의 인덱스와 그 오른쪽의 인덱스 중 
			 큰 값 찾아 dp에 현재 인덱스의 값과 더하여 저장
			*/
			dp[depth][idx] = Math.max(findMemo(depth+1, idx), findMemo(depth+1, idx+1)) 
							+ arr[depth][idx]; 
		}
		return dp[depth][idx];
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)을 \n"
				+ "둘째 줄부터 n+1번째 줄까지 정수 삼각형을 입력하세요.");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// 입력받은 정수 삼각형 형태 배열
		arr = new int[N][N];
		
		// 연산결과를 저장할 배열
		dp = new Integer[N][N];		// 초기화되지 않는 값은 NULL로 조회하기 위함
		
		
		// 입력받은 정수 삼각형 배열 초기화
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j=0; j<i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 가장 마지막 행의 값들을 DP의 마지막 행에도 똑같이 복사
		for(int i=0; i<N; i++) {
			dp[N-1][i] = arr[N-1][i];
		}
		
		// 각 밑의 값 중 최댓값과 현 위치의 값을 더해나가면서 가는 방식
		System.out.println(findMemo(0, 0));
	}
}
