package greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 
 * 이때 필요한 동전 개수의 최솟값을 구하는 프로그램(K원을 만드는데 필요한 동전 개수의 최솟값)
 * 
 * 둘째줄부터 입력되는 동전의 가치 Ai에 대해
 * (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 */
public class Coin_mincount {
	
	/** 동전 0 문제 알고리즘
	 * - 각 동전들은 '서로 배수 관계에 있다'
	 * 		=> 배수관계에 놓여있을 경우 풀리는 대표적인 문제가 바로 거스름돈 문제와 동전문제(이번 문제)
	 * - 배수관계에 놓여있을 경우 풀리는 대표적인 문제가 바로 거스름돈 문제와
	 * 		=> 가장 큰 가치를 지닌 동전부터 선택하는 것이 당연할 것
	 * 			"N개의 동전 중 가장 큰 가치를 지닌 동전부터 탐색하여
	 * 			 동전의 가치가 K보다 클 경우는 넘어가고, 
	 * 			 아닐경우는 최대 구성 가능한 개수를 더해줌"
	 */
	static int[] Coin;
	
	// 가치가 큰 동전부터 탐색하며, 동전의 가치가 K보다 작은 경우에 최대개수를 더하는 메소드
	static void GreedyCoin(int N, int K) {
		
		// 필요한 동전 개수 변수
		int count = 0;
		
		/* N개의 동전 중 가장 큰 가치를 지닌 동전부터 탐색하여
		 * 동전의 가치가 K보다 클 경우는 넘어가고,
		 * 아닐경우는 최대 구성 가능한 개수를 더해줌
		 */
		for(int i=N-1; i>=0; i--) {
			
			// 현재 동전의 가치가 K보다 작거나 같아야 구성가능
			if(Coin[i] <= K) {
				
				// 현재 가치의 동전으로 구성할 수 있는 개수를 더해줌
				count += (K / Coin[i]);
				
				// K원을 만들기 위해 남은 금액의 수로 K값을 갱신
				K = K % Coin[i];
			}
		}
		
		System.out.println(count);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 N과 K(1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)\n"
				+ "둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 입력하시오.\n"
				+ "(1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 첫째 줄에 N과 K(1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 둘째 줄부터 입력되는 동전의 가치(오름차순으로 입력됨)
		Coin = new int[N];
		for(int i=0; i<N; i++) {
			Coin[i] = Integer.parseInt(br.readLine());
		}
		
		// 가치가 큰 동전부터 탐색하며, 동전의 가치가 K보다 작은 경우에 최대개수를 더하는 메소드 실행
		GreedyCoin(N, K);
	}
}
