package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N장의 카드에 써져 있는 숫자가 주어졌을 때, 
 * M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하는 프로그램
 * 
 * 블랙잭: 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임
 * - N장의 카드 중에서 3장의 카드를 골라야 함
 * - 단, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 함
 */
public class BlackJack {
	
	static StringBuilder sb;
	
	/* 방법1. 세 카드의 합이 M이랑 같기 전까진 모든 경우의 수를 탐색
	 * i, j, k 번째 카드의 합을 구한다.
	 * - 만약 세 카드의 합이 M 이랑 같으면, 더이상 탐색을 할 필요가 없기 때문에
	 * 	 바로 세 카드의 합을 리턴
	 * - 만일 세 카드의 합이 M 보다 작으면서, 이전에 저장했던 세 카드의 합보다 크면
	 * 	 result 를 새로 갱신
	 */
	static void searchBlackJack(int N, int M, int[] arr) {
		sb = new StringBuilder();
		int result =0;
		
		// 3장의 카드를 고르기 때문에, 첫번째 카드는 1번째 ~ N-2번째까지만 순회
		for (int i=0; i<N-2; i++) {
			
			// 2번째 카드는 i+1번째 ~ N-1번째까지만 순회
			for (int j=i+1; j<N-1; j++) {
				
				// 3번째 카드는 j+1번째~ N번째 까지 순회
				for(int k=j+1; k<N; k++) {
					
					// 3개 카드의 합 변수 temp
					int temp = arr[i] + arr[j] + arr[k];
					
					// M과 세 카드의 합이 같다면 temp return 및 종료 
					if (M == temp) {	
						sb.append(temp).append('\n');
						System.out.println(sb);
						return;
					}
					
					// 세 카드의 합이 이전 합보다 크면서 M 보다 작을 경우 result 갱신 
					if(result < temp && temp < M) {
						result = temp;
					}
				}
			}
		}
		// 모든 순회를 마치면 result 출력
		sb.append(result).append('\n');
		System.out.println(sb);
	}
	
	
	/* 방법2. 세 카드의 합이 M 을 넘으면 안된다는 조건 =>  카드 한 장이 이미 M 보다 크면 탐색할 필요X
	 * - 만약 첫 번째 카드가 M 보다 작거나 같은 경우라도,
	 *   두 번째 카드를 선택 했을 때 두 카드의 합이 M 보다 커도 이미 탐색할 가치는 없음
	 *   (카드는 양의정수)
	 */
	static void searchBlackJack_Enhanced(int N, int M, int[] arr) {
		sb = new StringBuilder();
		int result =0;
		// 3장의 카드를 고르기 때문에, 첫번째 카드는 1번째 ~ N-2번째까지만 순회
		for (int i=0; i<N-2; i++) {
			
			// 만일, 1번째 카드가 M보다 크면 skip
			if(arr[i] > M) {
				continue;		// continue문으로 해당 i는 건너뛰고 다음 i로 실행
			}
			
			// 2번째 카드는 i+1번째 ~ N-1번째까지만 순회
			for (int j=i+1; j<N-1; j++) {
				
				// 만일, 2번째 카드와 1번째 카드의 합이 M보다 크면 skip
				if(arr[i] + arr[j] > M) {
					continue;	// continue문으로 해당 j는 건너뛰고 다음 j로 실행
				}
				
				// 3번째 카드는 j+1번째~ N번째 까지 순회
				for(int k=j+1; k<N; k++) {
					
					// 3개 카드의 합 변수 temp
					int temp = arr[i] + arr[j] + arr[k];
					
					// M과 세 카드의 합이 같다면 temp출력 및 종료 
					if (M == temp) {	
						sb.append(temp).append('\n');
						System.out.println(sb);
						return;
					}
					
					// 세 카드의 합이 이전 합보다 크면서 M 보다 작을 경우 result 갱신 
					if(result < temp && temp < M) {
						result = temp;
					}
				}
			}
		}
		// 모든 순회를 마치면 result 출력
		sb.append(result).append('\n');
		System.out.println(sb);
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)를 입력하고\n"
				+ "둘째 줄에는 카드에 쓰여 있는 수(100,000을 넘지 않는 양의 정수)를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 둘째줄에 입력받은 카드에 적힌 수를 할당할 배열
		int[] NumArr = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			NumArr[i] = Integer.parseInt(st2.nextToken());
		}
		
		// 방법1. M을 넘지 않으면서 M에 최대한 가까운 3장의 카드 합을 구해 출력하는 메소드 실행
		searchBlackJack(N, M, NumArr);
		
		
		// 방법2. 세 카드의 합이 M 을 넘으면 안된다는 조건 =>  카드 한 장이 이미 M 보다 크면 탐색할 필요X
		searchBlackJack_Enhanced(N, M, NumArr);
	}
}
