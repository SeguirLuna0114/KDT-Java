package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 
 * 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구하는 프로그램
 * 
 * RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 
 * 1번 집부터 N번 집이 순서대로 있다.
 * 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 
 * 다음의 규칙에 의해 집을 칠한다.
 * 1. 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
 * 2. N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
 * 3. i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 */
public class RGBstreet_cost {
	
	/** 각각의 집을 색칠해야하고, 색의 종류는 3가지. 비용이 주어짐
	 * - "인접한 집끼리는 색이 겹치면 안됨"
	 * - 비용을 구할 경우, 최솟값만을 찾아서 구하면 안됨
	 *   => 각 집의 최솟값을 찾아 누적합을 구하는게 아니라,
	 *   	모든 경로의 경우의 수를 찾아서 최종적으로 작은 누적합을 찾아야 함
	 *   
	 * - N개의 케이스에 대해
	 * R: Cost[N][0] = min(Cost[N-1][1], Cost[N-1][2]) + Cost[N][0]
	 * G: Cost[N][1] = min(Cost[N-1][0], Cost[N-1][2]) + Cost[N][1]
	 * B: Cost[N][2] = min(Cost[N-1][0], Cost[N-1][1]) + Cost[N][2]
	 */
	// 빨강, 초록, 파랑으로 칠하는 비용
	static int[][] Cost;
	// 누적합을 저장할 DP배열
	static int[][] DP;
	
	// 각 색상에 대해 인덱스 설정
	static final int R = 0;
	static final int G = 1;
	static final int B = 2;
	
	/** 방법1. 동적 계획법으로 문제 풀이
	 * - 3가지 케이스를 사용(집, 색의 종류, 비용) 
	 * 	 => Cost[][]배열, 누적합을 저장할 DP[][]배열
	 * - 재귀함수로 구성
	 * 	 => 해당 배열을 탐색하지 않았다면 재귀 실행, 그 외의 경우는 DP배열 반환(출력)
	 * - 각 비용은 자연수로 입력됨 => DP배열을 -1로 초기화할 필요 없이, 탐색하지 않은 경우를 초기값(0)으로 사용
	 * 
	 * * 하나의 함수를 만들고 각 색상에 대해 함수를 호출하여 해당 반환 값 중 최솟값을 출력
	 */
	static int MemoizationPaint(int N, int color) {
		
		// 만일 탐색하지 않은 배열인 경우
		if(DP[N][color] == 0) {
			
			/* color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 
			 * 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
			 */
			// color = red(0)
			if(color == R) {
				DP[N][R] = Math.min(MemoizationPaint(N-1, G), MemoizationPaint(N-1, B)) + Cost[N][R];
			}
			// color = green(1)
			else if(color == G) {
				DP[N][G] = Math.min(MemoizationPaint(N-1, R), MemoizationPaint(N-1, B)) + Cost[N][G];
			}
			// color = blue(2)
			else if(color == B) {
				DP[N][B] = Math.min(MemoizationPaint(N-1, R), MemoizationPaint(N-1, G)) + Cost[N][B];
			}
		}
		// 탐색이 끝난 배열인 경우
		return DP[N][color];
	}
	
	
	/** 방법2. 동적계획법 대신 반복문으로 문제 풀이
	 * - 좀 더 직관적임 
	 * - 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다.
	 * - Cost[][]배열만을 사용: Cost[][] 배열 호출하면서 이전에 풀었던 문제의 값을 그대로 갖고와 활용
	 */
	static void ForPaint(int N) {
		
		// 입력받은 값으로 idx=0일때는 값이 초기화 된 상태 => idx=1일때부터 반복문을 사용해서 최솟값 누적
		// 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더함
		for (int i=1; i<N; i++) {
			Cost[i][R] += Math.min(Cost[i-1][G], Cost[i-1][B]);
			Cost[i][G] += Math.min(Cost[i-1][R], Cost[i-1][B]);
			Cost[i][B] += Math.min(Cost[i-1][R], Cost[i-1][G]);
		}
		
		// R, G, B에 대해 값이 최소인 경우의 비용을 출력
		// N번째에 대해 인덱스 값은 N-1이기에 N-1을 매개변수로 전달
		System.out.println(Math.min(Math.min(Cost[N-1][R], Cost[N-1][G]), Cost[N-1][B]));
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)를 \n"
				+ "둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용을 한 줄에 하나씩 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 입력받은 값으로 비용배열 초기화
		Cost = new int[N][3];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Cost[i][R] = Integer.parseInt(st.nextToken());
			Cost[i][G] = Integer.parseInt(st.nextToken());
			Cost[i][B] = Integer.parseInt(st.nextToken());
		}
		
		// 누적합을 저장할 DP배열 생성
		DP = new int[N][3];
		
		// DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
		DP[0][R] = Cost[0][R];
		DP[0][G] = Cost[0][G];
		DP[0][B] = Cost[0][B];
		
		// 방법1. 동적 계획법으로 모든 집을 칠하는 비용의 최솟값을 구하는 방법
		// 각 색상에 대해 함수를 호출하여 해당 반환 값 중 최솟값을 출력
		System.out.println(Math.min(MemoizationPaint(N-1, R), Math.min(MemoizationPaint(N-1, G), MemoizationPaint(N-1, B))));
		// N번째에 대해 인덱스 값은 N-1이기에 N-1을 매개변수로 전달
		
		
		// 방법2. 동적계획법 대신 반복문으로 문제 풀이
		ForPaint(N);
	}
}
