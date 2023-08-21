package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 
 * 가장 긴 바이토닉 수열의 길이를 구하는 프로그램
 * 
 * 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면,
 * 그 수열을 바이토닉 수열
 * 
 * 바이토닉(Bitonic):  특정 값을 기준으로 왼쪽 부분은 오름차순(LIS), 
 * 					오른쪽 부분은 내림차순(LDS)인 수열 또는 그러한 부분 순환이동을 의미
 * 1. 오름차순 부분수열(즉 왼쪽에서 오른쪽으로 진행하는 오름차순)을 구함
 * 2. 내림차순 부분수열( = 오른쪽에서 왼쪽으로 진행하는 오름차순 부분수열)을 구함
 * 3. 오름차순과 내림차순이 합쳐진 가장 긴 부분수열 => 오름차순 수열 및 내림차순 수열을 합하는 방법
 * 		즉, 각각의 수열을 합침으로인해 오름차순과 내림차순이 합쳐진 수열이 완성됨
 * 		단, result 배열은 단순히 합친 것이므로 원소 1개씩 중복되어 있음=> 진짜 최종 결과는 -1씩 해줌
 */
public class Bitonic_LIS_LDS {
	
	/** 바이토닉(Bitonic):  특정 값을 기준으로 왼쪽 부분은 오름차순(LIS), 
	 * 					오른쪽 부분은 내림차순(LDS)인 수열 또는 그러한 부분 순환이동을 의미
	 * 1. 오름차순 부분수열(즉 왼쪽에서 오른쪽으로 진행하는 오름차순)을 구함
	 * 2. 내림차순 부분수열( = 오른쪽에서 왼쪽으로 진행하는 오름차순 부분수열)을 구함
	 * 3. 오름차순과 내림차순이 합쳐진 가장 긴 부분수열 => 오름차순 수열 및 내림차순 수열을 합하는 방법
	 * 		즉, 각각의 수열을 합침으로인해 오름차순과 내림차순이 합쳐진 수열이 완성됨
	 * 		단, result 배열은 단순히 합친 것이므로 원소 1개씩 중복되어 있음=> 진짜 최종 결과는 -1씩 해줌
	 */
	// 주어진 입력 수열을 저장
	static int[] seq;
	// 메모이제이션 배열로, 각 인덱스에 해당하는 위치에서의 LIS 길이를 저장
	static Integer[] dp_LIS;
	static Integer[] dp_LDS;
	
	/** 방식1) Top-Down방식
	 * - 탐색하려는 인덱스(위치)에 대해서 이전 위치들을 찾아나가면서 
	 * 	 해당 값보다 작을 경우 재귀호출을 통해 탐색
	 */
	// 순방향(LIS) 오름차순 부분수열을 구하고, 
	// 주어진 수열에서 N번째 위치의 원소를 포함하는 LIS의 최대 길이를 반환하는 메소드
	static int LIS(int N) {
		
		// 만약 탐색하지 않았던 위치인 경우
		if(dp_LIS[N] == null) {
			// 입력받는 수열의 최소길이이 1로 초기화
			// => N번째 위치의 원소 자체가 하나의 부분 수열을 이룬다는 것을 의미
			dp_LIS[N] = 1;
			
			// N에 대하여 N 이전의 노드들을 탐색
			for(int i=N-1; i >=0; i--) {
				// 이전 노드 중 seq[N]의 값보다 작은 수를 발견한 경우
				if(seq[i] < seq[N]) {
					// 그 중 N의 노드 값보다 작은 값들에 대해 재귀호출 => 이전 노드에서의 LIS 길이 가져옴
					dp_LIS[N] = Math.max(dp_LIS[N], LIS(i)+1);
				}
			}
		}
		
		//  이미 해당 위치를 탐색한 경우에는 저장된 값을 반환하여 중복 계산을 피함
		return dp_LIS[N];
	}
	
	
	// 역방향(LDS) 오름차순 부분수열을 구하고, 수열의 길이를 구하는 메소드
	// N이후의 노드들을 탐색하면서 이후 노드들이 N의 노드값보다 작으면 됨
	static int LDS(int N) {
		
		// 만약 탐색하지 않았던 위치인 경우
		if(dp_LDS[N] == null) {
			// 1로 초기화(모든 부분수열의 길이는 '최소한 1 이상'이기 때문)
			dp_LDS[N] = 1;
			
			// N에 대하여 "이후의" 노드들을 탐색
			for(int i=N+1; i < dp_LDS.length; i++) {
				
				// 이후 노드 중, seq[N]의 값보다 작은 걸 발견한 경우
				if(seq[i] < seq[N]) {
					// 그 중 N의 노드 값보다 작은 값들에 대해 재귀호출 => 이후 노드에서의 LDS길이 가져옴
					dp_LDS[N] = Math.max(dp_LDS[N], LDS(i) + 1);
				}
			}
		}
		
		//  이미 해당 위치를 탐색한 경우에는 저장된 값을 반환하여 중복 계산을 피함
		return dp_LDS[N];
	}
	
	
	/** 방법2) Bottom-Up(반복문) 방식
	 * - 이중반복문으로 0 ~ N-1 까지 각 원소보다 큰 값들을 카운팅해주는 것
	 * - 작은 문제들을 풀어 결합해나가는 방식
	 */
	static int[] DP_LIS;
	static int[] DP_LDS;
	
	static void LIS_LDS_DblFor(int N) {
		
		// LIS 알고리즘 - 앞에서부터 오름차순으로 구함
		for(int i=0; i<N; i++) {
			
			// 1로 초기화(모든 부분수열의 길이는 '최소한 1 이상'이기 때문)
			DP_LIS[i] = 1;
			
			// 0~i 이전 원소들을 탐색
			for(int j=0; j< i; j++) {
				
				// j번째 원소가 i번째 원소보다 작으면서, i번째 DP가 j번째 DP+1보다 작은 경우
				if(seq[j] < seq[i] &&  DP_LIS[i] < DP_LIS[j]+1 ) {
					// j번째 원소의 +1값이 i번째 DP가 됨
					DP_LIS[i] = DP_LIS[j] + 1; 
				}
			}
		}
		
		// LDS 알고리즘 - 뒤에서부터 오름차순으로 구함
		for (int i=N-1; i >= 0; i--) {
			// 1로 초기화(모든 부분수열의 길이는 '최소한 1 이상'이기 때문)
			DP_LDS[i] = 1;
			
			// 맨 뒤에서 i 이전 원소들을 탐색
			for(int j=N-1; j>i; j--) {
				
				// j번째 원소가 i번째 원소보다 작으면서, i번째 DP_LDS가 j번째 DP_LDS+1보다 작은 경우
				if(seq[j] < seq[i] &&  DP_LDS[i] < DP_LDS[j]+1 ) {
					// j번째 원소의 +1값이 i번째 DP_LDS가 됨
					DP_LDS[i] = DP_LDS[j] + 1; 
				}
			}
		}
	}

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 수열 A의 크기 N을, 둘째 줄에는 수열 A를 이루고 있는 Ai를 입력하세요.\n"
				+ "(1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수열 A의 크기 N
		int N = Integer.parseInt(br.readLine());
		
		// 둘째줄에 입력받은 수열
		seq = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		// 방법1) Top-Down(재귀)방식을 통해 Bitonic배열 최대길이 구하는 방법
		// 메모이제이션 수행 배열
		dp_LIS = new Integer[N];
		dp_LDS = new Integer[N];
		
		// 0~N-1까지 모든 부분수열 탐색 =>  각각의 원소에 대한 부분 증가 수열을 모두 구함
		for (int i=0; i<N; i++) {
			LIS(i);
			LDS(i);
		}
		
		// 최댓값 찾기
		int max = -1;
		for (int i=0; i < N; i++) {
			max = Math.max(dp_LIS[i] + dp_LDS[i], max);
		}
		
		System.out.println(max -1);
		
		
		// 방법2) Bottom-Up방식을 통해 Bitonic배열 최대길이 구하는 방법
		// 메모이제이션 수행 배열
		DP_LIS = new int[N];
		DP_LDS = new int[N];
		
		// 이중 반복문을 통해 0~N-1까지 모든 부분수열 탐색 =>  각각의 원소에 대한 부분 증가 수열을 모두 구함
		LIS_LDS_DblFor(N);
		
		// 최댓값 찾기
		/** 다른 방식으로구현
		 * 	int max = 0;
		 * 	for(int i = 0; i < N; i++) {
		 * 		if(max < r_dp[i] + l_dp[i]) {
		 * 			max = r_dp[i] + l_dp[i];
		 * 		}
		 * 	}
		 */
		int maxVal = -1;
		for (int i=0; i<N; i++) {
			maxVal = Math.max(DP_LIS[i] + DP_LDS[i], maxVal);
		}
		System.out.println(maxVal -1);
	}
}
