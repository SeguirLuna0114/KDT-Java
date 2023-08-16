package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 프로그램
 * 
 * 서쪽에는 N개의 사이트가 있고 동쪽에는 M개의 사이트가 있다(N ≤ M)
 * 서쪽의 사이트와 동쪽의 사이트를 다리로 연결
 *  (이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.)
 * 다리를 최대한 많이 지으려고 하기 때문에 서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 한다.
 * 
 */
public class CombinationCase_Bridge {

	/**
	 * 순서를 고려하지 않고, M개 중 N개를 선택... 중복X "조합공식"
	 * 
	 * 한 사이트에서는 한개의 다리만 놓일 수 있음 서로 다른 다리가 겹치면 안됨 => N ≤ M 에서 최대한 많은 다리를 놓기 위해서는 N개의
	 * 다리가 필요하고, M개에서 다리를 놓을 포인트를 정해야함
	 */
	// 사이트의 개수 정수 N, M (0 < N ≤ M < 30) => 최대 입력가능 정수 30
	static int[][] site = new int[30][30];
	static StringBuilder sb = new StringBuilder();

	/** 재귀함수 사용
	 */
	// M개 중 N개를 선택 => mCn
	static int CombinationBridge(int n, int r) {

		// 이미 탐색했던 경우 바로 반환
		if (site[n][r] > 0) {
			return site[n][r];
		}

		// 2번 성질(nC0 = nCn = 1)
		if (n == r || r == 0) {
			return site[n][r] = 1;
		}
		
		// 1번 성질(n+1_C_r+1 = n_C_r + n_C_r+1)
		return site[n][r] = CombinationBridge(n - 1, r - 1) + CombinationBridge(n - 1, r);
	}
	
	
	/** 반복문(bottom - up방식 풀이)
	 */
	static int CombinationFor(int M, int N) {
		
		// 2번 성질(nC0 = nCn = 1)
		for (int i=0; i<30; i++) {
			site[i][i] = 1;
			site[i][0] = 1;
		}
		
		// 1번 성질(n+1_C_r+1 = n_C_r + n_C_r+1)
		for(int i=2; i<30; i++) {
			for (int j=1; j<30; j++) {
				
				site[i][j] = site[i-1][j-1] + site[i-1][j];
			}
		}
		return site[M][N];
	}

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("입력의 첫 줄에는 테스트 케이스의 개수 T를 입력하고, \n"
				+ "그 다음 줄부터 각각의 테스트케이스에 대해 강의 서쪽과 동쪽에 있는 사이트의 개수 정수 N, M (0 < N ≤ M < 30)를 입력하세요.");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String[] testcase = br.readLine().split(" ");

			int N = Integer.parseInt(testcase[0]);
			int M = Integer.parseInt(testcase[1]);

			// 방법1. 재귀함수 사용
			sb.append(CombinationBridge(M, N)).append('\n');
			
			// 방법2. 반복문(bottom - up방식 풀이)
			System.out.println(CombinationFor(M, N));
		}
		System.out.println();
		System.out.println(sb);
	}
}
