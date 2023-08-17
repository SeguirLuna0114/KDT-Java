package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 
 * 수열은 사전 순으로 증가하는 순서로 출력
 */
public class ChooseSequence_DFS1_visit {
	
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
	 */
	static int N;
	static int M;
	
	static boolean[] visit;
	static int[] arr;
	
	// 백트래킹과 깊이 우선 탐색(DFS)을 사용하여 조합을 생성하는 함수 - visit 배열 사용
	// 순서는 고려하지 않고 중복 없이 M 개의 숫자를 선택하여 조합 생성
	static void DFS_check(int depth) {
		
		// depth와 M(출력해야 하는 수열의 수, limit)과 같아지면 더이상 재귀를 호출X
		// 탐색 중 값(value)를 담은 배열을 return(출력)해줌
		StringBuilder sb = new StringBuilder();
		if(depth == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			// 마지막에 한번에 출력
			System.out.print(sb);
			return;
		}
		
		// 해당 index가 방문하지 않는 노드(값)일 때만 재귀호출
		for (int i=0; i<N; i++) {
			// 해당 노드(값)을 방문하지 않았었다면,
			if(!visit[i]) {
				
				// 해당 노드를 방문한 상태로 변경
				visit[i] = true;
				
				// 해당 depth(깊이)를 index로 하여 i+1한 값을 저장
				arr[depth] = i+1;
				
				// 다음 자식 노드 방문을 위해 depth+1로 재귀호출
				DFS_check(depth+1);
				/** depth + 1 과 depth++ 은 똑같이 1은 증가시켜주지만 작동원리는 다름
				 * depth++ 은 depth 변수의 값 자체가 1 증가하기 때문에 재귀에서 빠져나와도 증가된 값은 그대로 유지
				 * depth + 1 은 자바 내부에서 임시로 depth + 1 값을 복사하여 해당 값을 사용
				 */
				
				
				// 재귀호출이 끝나면, 자식노드 방문이 끝나고 돌아왔다는 뜻이기에, 
				// 해당 노드를 방문하지 않았던 상태로 변경
				visit[i] = false;
			}
		}
		
		return;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("자연수 N과 M(1 ≤ M ≤ N ≤ 8)을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		/** N과 M은 자체 값이 변경되거나 할 일이 없기 때문에 전역변수로 바꾸어도 무방*/
		// 1~N까지의 자연수
		N = Integer.parseInt(input[0]);
		// M개의 수열 출력
		M = Integer.parseInt(input[1]);
		
		// 방문했던 노드인지 아닌지 확인하기 위해 visit배열 생성
		visit = new boolean[N];
		// 탐색한 값을 담아두기 위한 배열 arr 생성
		arr = new int[M];
		
		// 백트래킹 - DFS
		DFS_check(0);
	}
}
