package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* a, b, c가 주어졌을 때, w(a, b, c)를 출력하는 프로그램을 작성
 * 
 * 다음과 같은 재귀함수 w(a, b, c)가 있다.
 * if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
 *     1
 * 
 * if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
 *     w(20, 20, 20)
 *     
 * if a < b and b < c, then w(a, b, c) returns:
 *     w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
 * 
 * otherwise it returns:
 *     w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
 *  
 * 위의 함수를 구현하는 것은 매우 쉽다. 
 * 하지만, 그대로 구현하면 값을 구하는데 매우 오랜 시간이 걸린다. 
 * (예를 들면, a=15, b=15, c=15)
 * (-50 ≤ a, b, c ≤ 50)
 */
public class W_RecursionFuncion {
	
	
	/** 동적계획법 사용: 재귀 + Memoization(메모이제이션)
	 * - 메모이제이션: 처음 방문하는 재귀라면 계산을 통해 얻은 값을 메모리에 저장(기록)하고, 
	 * 				이 후 재방문을 할 경우 다시 계산하는 것이 아닌 저장 된 값을 사용
	 * 
	 * -  a, b, c 라는 변수가 작용하는만큼 3차원 배열을 이용하여 풀이
	 */
	/*
	 * 함수 w에서 a, b, c 중 20이 넘어가게 되면 w(20, 20, 20)을 호출하고,
	 * 0 이하일 경우는 1을 반환하기 때문에
	 * 각 배열의 크기가 21 (0~20)을 넘기지 않는다.
	 */
	static int[][][] dp = new int[21][21][21];

	static int w(int a, int b, int c) {
		
		// a, b, c가 범위를 벗어나지 않으면서 메모이제이션이 되어있는 경우
		if(inRange(a, b, c) && dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
				
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		/*
		 * a, b, c중 하나라도 20이 넘어가면 w(20, 20, 20)을 호출하기 때문에
		 * dp[20][20][20] 에 저장하고 반환하면 된다.
		 */
		if(a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}
		
		if(a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}
	
	/**
	 *  배열을 참조하려 할 때 a, b, c 중 하나라도 범위 밖의 수가
	 *  나올 수 있기 때문에 이를 체크를 해주기 위한 함수
	 */
	static boolean inRange(int a, int b, int c) {
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20; 
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("한 줄에 하나씩 세 정수 a, b, c를 입력하세요."
				+ "\n단, 입력의 마지막은 -1 -1 -1로 나타내며, 세 정수가 모두 -1인 경우는 입력의 마지막을 제외하면 없다"
				+ "\n(-50 ≤ a, b, c ≤ 50)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 입력의 마지막은 -1 -1 -1 => 종료
			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			
			// 메모이제이션 및 재귀 방식을 사용해 효율적으로 w메소드 실행
			/** printf()를 이용하는 방법도 존재하지만,
			 * System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
			 * 
			 * 효율적인 실행을 위해 StringBuilder클래스 활용
			 */
//			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
			
			sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a ,b ,c)).append('\n');
		}
		
		// 한번에 결과 출력
		System.out.println(sb);
	}
}
