package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 
 * 수열은 사전 순으로 증가하는 순서로 출력
 * N과 M을 입력받으면 "1부터 N까지의 수 중 오름차순이면서 M의 길이까지 나열 가능한 수열이어야 함
 */
public class ChooseSequence_DFS2_at {
	
	/** 재귀를 통해 문제해결
	 * - 중복되는 수를 제외한 모든 경우의 수를 탐색
	 * 
	 ** 백트래킹
	 * - 이미 방문한 노드(값)이라면, 다음 (유망한) 노드를 탐색하도록 하기 위해
	 * 	 N크기의 boolean 배열을 생성해서 possibility 확인
	 * - 값(value)를 담을 배열 생성
	 * 
	 ** 백트래킹 - DFS 함수
	 *	- N과 M을 변수로 받고, depth변수(재귀함수를 호출한 빈도수)를 추가
	 *	- depth를 통해 재귀가 깊어질 때마다(재귀를 반복할 때 마다) depth를 ++
	 *	- depth와 M(출력해야 하는 수열의 수, limit)과 같아지면 더이상 재귀를 호출X
	 *	  탐색 중 값(value)를 담은 배열을 return(출력)해줌
	 *
	 *  - at변수: 현재 위치, 즉 어디서부터 시작하는지를 의미하는 변수
	 *  	반복문에서 재귀를 해 줄 때, at = 1 부터 시작하면 다음 재귀는 오름차순으로 탐색하기 위해 
	 *  	at 을 1 증가시킨 2를 인자로 넘겨주면서
	 *  	다음 재귀의 반복문이 2부터 시작하도록 하는 변수
	 *  	" i는 at부터 탐색하도록 함 " => 반복문에서 결과적으로 이전 값보다 큰 수부터 탐색
	 *  - 중복방문인지 고려할 필요 X => boolean배열로 중복여부 체크할 필요X
	 */
	
	static int N;
	static int M;
	
	static int[] arr; 
	static StringBuilder sb = new StringBuilder();

	// 백트래킹과 깊이 우선 탐색(DFS)을 사용하여 조합을 생성하는 함수 - at 변수 사용
	// 재귀적으로 모든 경우의 수를 탐색하면서 조합을 생성하고 출력
	static void DFS_AT(int at, int depth) {
		
		// depth와 M(출력해야 하는 수열의 수)가 같아지면 더이상 재귀 호출X
		// 탐색중이던 값(value)를 담은 배열을 return(출력)
		if(depth == M) {
			for (int value : arr) {
				sb.append(value).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		// 1부터 N까지의 숫자 중에서 M개를 선택하여 만들 수 있는 모든 조합을 출력
		// i는 at부터 탐색 => 반복문에서 결과적으로 이전 값보다 큰 수부터 탐색
		for (int i=at; i<=N; i++) {		// 1~N까지 탐색
			
			// 해당 depth(깊이)를 index로 하여 i값을 저장(이때, 1부터 시작하기에 +1해줄 필요X)
			arr[depth] = i;		// 1~N중 하나를 depth인덱스에 저장
			
			// 다음 자식노드 방문을 위해 at+1로 오름차순으로 탐색, depth+1로 재귀호출
			DFS_AT(i+1, depth+1);
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
		DFS_AT(1, 0);
		System.out.println(sb);		// 마지막에 한번에 출력
	}
}
