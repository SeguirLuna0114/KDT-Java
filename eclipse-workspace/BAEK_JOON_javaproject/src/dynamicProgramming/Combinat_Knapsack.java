package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 배낭에 넣을 수 있는 최댓값이 정해지고
 * 해당 한도 물건을 넣어 가치의 합이 최대가 되도록 고르는 방법을 찾는 프로그램
 * (한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력)
 * "조합 최적화 문제"
 * 
 * - 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다
 */
public class Combinat_Knapsack {
	
	/** 배낭문제(냅색 알고리즘)
	 * 1. 짐을 쪼갤 수 있는 경우(Fraction Knapsack Problem)
	 * 		- 탐욕 알고리즘(Greedy)를 사용
	 * 
	 * 2. 짐을 쪼갤 수 없는 경우(0/1 Knapsack Problem)
	 * 		- DP(Dynamic Programming)법 사용
	 */
	static int N;
	static int K;
	
	// 각 물건의 무게W와 해당 물건의 가치 V에 대한 배열
	static int[] W;
	static int[] V;
	
	
	/** 방법1) 짐을 쪼갤 수 없는 경우(0/1 Knapsack Problem)
	 * 		- DP(Dynamic Programming)법 사용
	 *  무게 W[] 배열과 가치 V[] 배열 생성
	 * 	- dp(수용가능한 무게)배열
	 * 	- 당연히 dp[0] 은 수용가능한 무게가 0이므로 모두 0일 것
	 *  - 탐색하기 전에 해당 값에 대하여 이전 i값에 대한 dp에 메모이제이션 되어있는 값을 갖고와야함
	 *  -  i 탐색 전에 먼저 이전 i에 대한 값을 갖고와야하는데, i = 0인 경우는 주어지지 않음 => 0으로 채워짐
	 *  - i = 0 일 때는 주어진 배열 범위 밖이기 때문에 0이 됨 => 따라서 i=1일때 부터 탐색
	 *  
	 *  함수 f,  dp는 k, W는 입력으로 주어지는 무게, V는 입력으로 주어지는 가치
	 *  f(i, k) = 0  			if(i=0, k=0)
	 *  f(i, k) = f(i-1, k)		if Wi > k
	 *  Max(f(i-1, k-Wi) +Vi, f(i-1, k))	if(0<i and Wi <= K)
	 */
	
	// 방법1) Top-Down(재귀) 방식을 사용하여 
	// 수용가능한 무게를 메모이제이션할 배열 생성
	static Integer[][] dp;
	static int knapsack(int i, int k) {
		
		// 인덱스 i가 범위 밖인 경우(i가 0미만)
		// W와 V 배열은 N길이로 인덱스가 0 부터 시작하기 때문에 위의 i=0일 때를 약간 수정하여 i < 0으로 고쳐준다
		if(i<0) {
			return 0;
		}
		
		// 탐색하지 않은 위치인 경우
		if(dp[i][k] == null) {
			
			// 현재 물건(i)를 추가로 못담는 경우(이전 i값 탐색)
			if(W[i] > k) {
				dp[i][k] = knapsack(i-1, k);
			}
			
			// 현재 물건을 담을 수 있는 경우
			else if(W[i] <= k) {			// else { 로 구현 가능
				// 이전 i값과 이전 i값에 대한 k-W[i]의 값 + 현재 가치(V[i])중 큰 값을 저장
				dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k - W[i])+V[i]);
			}
		}
		
		return dp[i][k];
	}
	
	
	/** 방법2) Bottom-UP 방식으로 구현 - DP[][] 2차원 배열
	 * 	 하위 인덱스부터 시작하기 때문에 i-1 에 대하여
	 *   자칫 인덱스 범위 밖을 참조하게 될 수 있다. 
	 *   그렇기 때문에 W, N 은 각각 [N+1] 사이즈로 선언해줘야 함
	 */
	static int[][] DP;
	static void UsingFor(int N, int K) {
		
		for (int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				
				// i번째 무게를 더 담을 수 없는 경우
				if(W[i-1] > j) {
					DP[i][j] = DP[i-1][j];
				}
				
				// i번째 무게를 더 담을 수 있는 경우
				else {
					DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-W[i-1]] + V[i-1]);
				}
			}
		}
		
		System.out.println(DP[N][K]);
	}
	
	
	/** 방법3) Bottom-UP 방식으로 구현 - DP[]
	 * " 무게를 더 담을 수 있는지 여부를 조건삼아 반복문으로 구현하기 때문에 
	 *   dp[] 배열을 1차원으로 쓸 수 있고 불필요한 탐색을 하지 않기 때문에 성능 개선"
	 * 
	 * - 작은 것부터 맞춰나가기 때문에 dp배열을 2차원이 아니라 
	 *   "1차원으로 생성"하고 중복탐색을 피해가는 방식으로 바꿀 수 있다.
	 * - 각 탐색의 경우 i번째 물건에 대하여 W[i]의 합이 K를 넘겨서는 안된다
	 * 	 => K(최대무게) - 누적된 W값이 0보다 커야한다는 의미
	 * 
	 * 따라서, 불필요하게 1부터 K까지 탐색하는 것이 아니라 K-W[i] 에 대하여 
	 * 0보다 크거나 같을 때 까지만 탐색함으로 불필요한 탐색을 줄일 수 있고, 
	 * 중복 카운트 또한 피할 수 있다
	 */
	static int[] DP2;
	// 반복문 조건식 자체를 j-W[i] >= 0 으로 선언해주면서 
	// i번째 물건에 대해 넣을 수 있는 경우에 한정하여 탐색
	static void UsingFor2(int N, int K) {
		
		for (int i=1; i<=N; i++) {
			
			// K부터 탐색하여 담을 수 있는 무게 한계치가 넘지 않을 때까지 반복
			for (int j=K; j-W[i-1] >= 0; j--) {
				DP2[j] = Math.max(DP2[j], DP2[j-W[i-1]] + V[i-1]);
			}
		}
		System.out.println(DP2[K]);
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)를 입력하세요.\n"
				+ "두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 물품의 수 N(1 ≤ N ≤ 100)
		N = Integer.parseInt(st.nextToken());
		// 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)
		K = Integer.parseInt(st.nextToken());
		
		// 각 무게와 가치에 대해 수용가능한 무게를 계산하는 메소드 실행
		// 방법1) Top-Down(재귀) 방식을 사용
		// 각 물건의 무게W와 해당 물건의 가치 V에 대한 배열 생성
		W = new int[N];
		V = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			W[i] = Integer.parseInt(st2.nextToken());
			V[i] = Integer.parseInt(st2.nextToken());
		}
		
		dp = new Integer[N][K+1];
		
		// 인덱스의 끝 값은 N-1이기에 매개변수를 N-1부터 시작하여 Top-Down방식 실행
		System.out.println(knapsack(N-1, K));
		
		
		// 방법2) Bottom-UP 방식으로 구현 - DP[][] 2차원 배열
		/**
		 * 	 하위 인덱스부터 시작하기 때문에 i-1 에 대하여
		 *   자칫 인덱스 범위 밖을 참조하게 될 수 있다. 
		 *   그렇기 때문에 W, N 은 각각 [N+1] 사이즈로 선언해줘야 함
		 */
		DP = new int[N+1][K+1];
		
		/** 각 물건의 무게W와 해당 물건의 가치 V에 대한 배열을 공집합 경우도 고려하여 N+1크기로 생성
		 * int[] W = new int[N + 1]; // 무게
		 * int[] V = new int[N + 1]; // 가치
		 * 
		 * for (int i = 1; i <= N; i++) {
		  		st = new StringTokenizer(br.readLine(), " ");
				W[i] = Integer.parseInt(st.nextToken());
				V[i] = Integer.parseInt(st.nextToken());
			}	
		 */
		
		// 2차원 배열DP[][]를 이용하여 Bottom-up방식으로 수용가능 최대무게 계산
		UsingFor(N-1, K);
		
		
		// 방법3) Bottom-UP 방식으로 구현 - DP[]
		DP2 = new int[K+1];
		
		/** 각 물건의 무게W와 해당 물건의 가치 V에 대한 배열을 공집합 경우도 고려하여 N+1크기로 생성
		 * int[] W = new int[N + 1]; // 무게
		 * int[] V = new int[N + 1]; // 가치
		 * 
		 * for (int i = 1; i <= N; i++) {
		  		st = new StringTokenizer(br.readLine(), " ");
				W[i] = Integer.parseInt(st.nextToken());
				V[i] = Integer.parseInt(st.nextToken());
			}	
		 */
		
		// 무게를 더 담을 수 있는지 여부를 조건삼아 반복문을 구현했기에, DP2[] 1차원배열으로 작성 가능
		UsingFor2(N-1, K);
	}
}
