package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램
 * - 1부터 N까지 자연수 중에서 M개를 고른 수열
 * - 같은 수를 여러 번 골라도 됨
 * - 고른 수열은 비내림차순이어야 한다. (길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순)
 * 
 * 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력
 * 수열은 사전 순으로 증가하는 순서로 출력
 */
public class ChooseSequence_DFS4_NonDESC {
	
	static int N;
	static int M;
	
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	/** 비내림차순으로 중복이 허용되는 경우
	 * - 반복문 내에서 i값을 1 더하여 재귀호출하는게 아니라,
	 * 	 그냥 i값을 인자로 넘겨 재귀호출
	 * 	 => DFS 재귀호출 시, i값을 인자로 바로 넘김
	 * 		for (int i=at, i<=N; i++) {
	 * 			arr[depth] = i;
	 * 			DFS(i, depth+1);
	 * 		}
	 */
	static void DFS_at(int at, int depth) {
		/**
		 * depth와 M(출력해야 하는 수열의 수)가 같아지면(깊이가 최대 깊이)
		 * 더이상 탐색할 자식노드는 없으므로
		 * 재귀호출X. 탐색중이던 값(value)를 담은 배열을 출력후 return
		*/
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		// 1부터 N까지의 숫자 중에서 M개를 선택하여 만들 수 있는 모든 조합을 생성
		for(int i=at; i<=N; i++) {
			
			// 해당 depth(깊이)를 index로 하여 i값을 저장(이때, 1부터 시작하기에 +1해줄 필요X)
			arr[depth] = i;
			
			// 다음 자식노드 방문을 위해 at으로 비내림차순 탐색, depth+1로 재귀호출
			DFS_at(i, depth+1);
		}
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("자연수 N과 M(1 ≤ M ≤ N ≤ 8)을 입력하세요.");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		/** N과 M은 자체 값이 변경되거나 할 일이 없기 때문에 전역변수로 바꾸어도 무방 */
		// 1~N까지의 자연수
		N = Integer.parseInt(input[0]);
		// M개의 수열 출력
		M = Integer.parseInt(input[1]);
		
		// 탐색한 값을 담아두기 위한 배열 arr 생성
		arr = new int[M];
		
		// 백트래킹 - DFS로 중복되지 않는 수열을 생성 및 출력
		DFS_at(1, 0);
		// 결과값을 한번에 출력
		System.out.println(sb);
		
	}

}
