package recursionFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 하노이 탑
 * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다.
 * 각 원판은 반경이 큰 순서대로 쌓여있다. 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
	1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
	2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
	이 작업을 수행하는데 필요한 최소 이동 순서를 출력하는 프로그램
	
	- 가장 큰 원판을 C 로 옮기기 위해서는 n-1 개의 원판이 A 에서 B 로 가야함
		->  A 에 있는 가장 큰 원판이 C 로 이동 ->  B 에 있는 (n-1)개의 원판을 C 로 이동
	=> 𝑛개의 원판을 이동시키기 위한 이동 횟수를 𝑎𝑛 이라고 할 때, 
		 𝑎𝑛 = 𝑎𝑛-1 + 1 + 𝑎𝑛-1 
		 𝑛-1 개의 원판이 A 에서 B 로 이동하는 경우는 𝑎𝑛-1
		 𝑛 번째 원판을 A 에서 C 로 옮기는 경우는 1 
		 B에 있는 n-1개의 원판이 C로 옮기는 경우는 𝑎𝑛-1 
 */
public class HanoiTower_recursion {
	
	static StringBuilder sb = new StringBuilder();
	/**
	 * @param 	원판의 개수 N
	 * 		  	출발지 start
	 * 			옮기기 위해 이동해야 하는 장소 mid
	 * 			목적지 to
	 */
	static void HanoiTower(int N, int start, int mid, int to) {
		
		// 이동할 원반의 개수가 1
		if (N==1) {
			sb.append(start).append(' ').append(to).append('\n');
			return;
		}
		
		// A -> C로 옮긴다고 가정할 떄,
		// STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
		HanoiTower(N - 1, start, to, mid);
	    
		// STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
		sb.append(start).append(' ').append(to).append('\n');
	    
		// STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
		HanoiTower(N - 1, mid, start, to);
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		sb.append((int)(Math.pow(2, N)-1)).append('\n');
		
		// 재귀 방법 사용
		HanoiTower(N, 1, 2, 3);
		System.out.println(sb);
	}

}
