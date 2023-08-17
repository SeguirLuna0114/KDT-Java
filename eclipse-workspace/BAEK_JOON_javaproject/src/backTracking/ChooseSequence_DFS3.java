package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램
 * - 1부터 N까지 자연수 중에서 M개를 고른 수열
 * - 같은 수를 여러 번 골라도 된다.
 * 
 * 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력
 * 수열은 사전 순으로 증가하는 순서로 출력
 */
public class ChooseSequence_DFS3 {
	
	static int N;
	static int M;
	
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	/** 백트래킹 문제의 경우, 
	 * 1. 가장먼저 "문제의 조건"을 확인해야 함
	 * 		1) 1~N까지의 수를 조합
	 * 		2) M개를 선택하여 조합 => 깊이가 M
	 * 		3) 중복해서 조합 가능
	 * 2. 그 다음, 재귀함수를 만들어야 함
	 * 	- 백트래킹의 경우 대표적으로 DFS(깊이우선탐색)으로 구현 가능
	 * 	ex) DFS의 경우 깊이 우선 탐색 => 1부터 중복가능한 조합으로 4개 뽑는경우 1 1 1 1 -> 1 1 1 2
	 *  - 가장 마지막(깊은) 노드까지 들어가 가장 깊은 노드부터 탐색한 후,
	 *    더이상 탐색할 자식노드가 없다면 부모노드로 돌아가(백트래킹) 다음 자식노드를 탐색
	 */
	// 백트래킹과 깊이 우선 탐색(DFS)을 사용하여 조합을 생성하는 함수
	static void DFS(int depth) {
		/**
		 * depth와 M(출력해야 하는 수열의 수)가 같아지면(깊이가 최대 깊이)
		 * 더이상 탐색할 자식노드는 없으므로
		 * 재귀호출X. 탐색중이던 값(value)를 담은 배열을 출력후 return
		*/
		if(depth == M) {
			for (int val : arr) {				// for(int i=0; i<M; i++) {
				sb.append(val).append(' ');		// 		sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		// 1부터 N까지의 숫자 중에서 M개를 선택하여 만들 수 있는 모든 조합을 생성
		for (int i=1; i<=N; i++) {
			// 해당 depth(깊이)를 index로 하여 i값을 저장(이때, 1부터 시작하기에 +1해줄 필요X)
			arr[depth] = i;		// 1~N중 하나를 depth인덱스에 저장
			
			// 다음 자식노드 방문을 위해 depth+1로 재귀호출
			DFS(depth+1);
		}
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("자연수 N과 M(1 ≤ M ≤ N ≤ 7)을 입력하세요.");

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
		DFS(0);
		// 마지막에 한번에 결과 출력
		System.out.println(sb);
	}
}
