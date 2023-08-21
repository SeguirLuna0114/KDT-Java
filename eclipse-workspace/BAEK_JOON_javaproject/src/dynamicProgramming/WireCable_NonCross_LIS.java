package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때,
 * 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 
 * 전깃줄의 최소 개수를 구하는 프로그램
 * 
 * 
 * 두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생
 * 합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다
 * 
 * 전깃줄의 개수는 100 이하의 자연수
 * 위치의 번호는 500 이하의 자연수
 * 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없음
 */
public class WireCable_NonCross_LIS {
	
	/** 서로 교차되지 않도록 하기 위해 철거되어야 할 전선의 최소 개수
	 * 
	 * - 철거되어야 할 전선의 최소 개수는...
	 * 		(전체 전선 개수 - 설치 가능 개수) = 철거 개수
	 * 		=> "설치 가능한 개수를 구하고, 전체 전선개수에서 빼면 됨"
	 * 
	 * - A전봇대 기준으로 i번째에 연결된 전깃줄을 잇고
	 *   이후 전선들을 탐색하면서 i번째가 연결된 B의 값보다 큰 경우들을 모두 탐색
	 *   => 정렬된 A를 기준으로 B에 연결된 값들에서 LIS
	 */
	/** 방법1) Top-Down 방식(재귀) 사용
	 * - A전봇대와 B전봇대를 의미하는 2차원 배열 wire[][]
	 * 		- A전봇대 => wire[N][0]
	 * 		- B전봇대 => wire[N][1]
	 * - 메모이제이션을 시행할 배열 dp[]
	 * 
	 * - A전봇대의 탐색 기준값을 중심으로 B에 연결할 때 이전에 B에 연결된 전봇대 값보다 커야함
	 * 	=> 그래야 겹치지 않음
	 * 	: N+1부터 마지막 까지 A전봇대를 기준으로 탐색하면서 B전봇대에 연결 가능 한지 여부를 확인
	 * 	  연결 가능하다면 그 다음에 연결할 전선을 탐색하기 위해 재귀
	 */
	static int[][] wire;
	static Integer[] dp;
	
	// 이후의 전봇대들의 연결 가능한 개수의 경우의 수 중 최댓값을 dp에 메모이제이션
	static int LIS(int N) {
		
		// 탐색하지 않았다면
		if(dp[N] == null) {
			
			// 해당 위치에서의 최소 개수는 1이기에, 1로 초기화
			dp[N] = 1;
			
			// A의 N번째의 이후의 전봇대들 비교(겹치지 않게)
			// N+1부터 마지막 까지 A전봇대를 기준으로 탐색하면서 B전봇대에 연결 가능 한지
			for(int i=N+1; i<dp.length; i++) {
				/**
				 *  A전봇대의 N번째 전선이 연결되어있는 B전봇대보다 
				 *  A의 i번째 전봇대의 전선이 이어진 B전봇대가 뒤에 있을 경우 
				 *  전선을 설치할 수 있음 
				 */
				if(wire[N][1] < wire[i][1]) {
					// 연결 가능한 전선의 경우의 수 중, 큰 값을 dp에 저장
					dp[N] = Math.max(dp[N],LIS(i) + 1);
				}
			}
		}
		
		// 탐색한 경우에는 해당 N return
		return dp[N];
	}
	
	
	/** 방법2) Bottom-Up 방식 사용
	 * -  for문은 반대로 A전봇대를 기준으로 이전의 A전봇대들을 살펴보면서 메모이제이션
	 */
	static int[] DP;
	static void UsingFor(int N) {
		
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에는 두 전봇대 사이의 전깃줄의 개수(100 이하의 자연수)를,"
				+ "\n둘째 줄부터 한 줄에 하나씩 전깃줄이 A전봇대와 연결되는 위치의 번호와 B전봇대와 연결되는 위치의 번호를 입력하세요.\n"
				+ "(단, 위치의 번호는 500 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없음)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// 메모이제이션을 시행할 배열 dp[]
		dp = new Integer[N];
		
		// A전봇대와 B전봇대를 의미하는 2차원 배열 wire[][]
		wire = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// wire배열을 A전봇대 기준으로 정렬 
		/** Arrays.sort() 메소드 자체에는 
		 * 2차원 배열을 정렬해주는 것이 없으므로 
		 * comparator를 이용하여 다음과 같이 정렬
		 */
		Arrays.sort(wire, Comparator<int[]>() {
			
			@Override
			public int compare(int[] wire1, int[] wire2) {
				return wire1[0] - wire2[0];
			}
		});
		
		
	}

}
