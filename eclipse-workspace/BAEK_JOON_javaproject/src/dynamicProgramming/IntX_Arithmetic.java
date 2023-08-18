package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
 * 연산을 사용하는 횟수의 최솟값을 출력
 * 
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * 2. X가 2로 나누어 떨어지면, 2로 나눈다.
 * 3. 1을 뺀다.
 */
public class IntX_Arithmetic {
	
	/** 메모이제이션을 활용한 방법 중, TOP-DOWN방식(재귀) 이용
	 * 1. 3으로 나누는 경우
	 * 2. 2로 나누는 경우
	 * 3. 1을 빼는 경우
	 * => 여기서 1로 만들기 위한 최소 연산 횟수를 찾아내야 함
	 * 
	 * - 이때, 무조건 큰 수로 나눈다고 해결되지는 않음
	 * 	ex) 10 -> 5 -> 4 -> 2 -> 1 (4번)
	 * 		10 -> 9 -> 3 -> 1	(3번이 정답)
	 * - 2와 3의 배수인 6으로 나누어지는 경우도 고려 필요
	 */
	
	// 메모이제이션을 시행할 배열
	static Integer[] dp;	// 초기값 null이라 편함
	/** 방법1) 메모이제이션을 활용한 방법 중, TOP-DOWN방식(재귀) 이용
	 * - 재귀호출을 하면서 DP를 최솟값으로 갱신
	 * - 6으로 나눠지는 경우는 3으로 나누는 경우와 2로 나누는 경우, 1을 빼는 경우 
	 *   모두 재귀호출 하여 3가지 경우 중 최솟값으로 DP를 갱신
	 * - 각 부분에 이전 재귀호출 중 최솟값에 1을 더한 값이 현재 N에 대한 최소연산 횟수
	 *   (하위 문제에 대해, 1을 더해야 연산이 추가된것)
	 */
	static int IntX_recur(int N) {
		
		// 탐색하지 않았던 N인 경우
		if(dp[N] == null) {
			
			// 6으로 나눠질 경우
			// - 6으로 나눠지는 경우는 3으로 나누는 경우와 2로 나누는 경우, 1을 빼는 경우 
			//   모두 재귀호출 하여 3가지 경우 중 최솟값으로 DP를 갱신
			if(N % 6 == 0) {
				dp[N] = Math.min(IntX_recur(N-1),
						Math.min(IntX_recur(N/3), IntX_recur(N/2))) + 1;
			}
			
			// 3으로만 나눠지는 경우
			else if(N % 3 == 0) {
				// N-1부터 호출하게 되면 결국 어떤 경우건 0부터 N-1까지 모두 탐색되기에, 시간초과
				// N/3, N/2 같이 일정 부분만 먼저 탐색해서 메모이제이션을 하고, 그 뒤에 N-1 호출
				dp[N] = Math.min(IntX_recur(N/3), IntX_recur(N-1)) + 1;
			}
			
			// 2로만 나눠지는 경우
			else if(N % 2 == 0) {
				dp[N] = Math.min(IntX_recur(N/2), IntX_recur(N-1)) + 1;
			}
			
			// 2와 3으로 나눠지지 않는 경우
			else {
				dp[N] =IntX_recur(N-1) + 1;
			}
		}
		return dp[N];
	}
	
	
	/** 방법2) TOP-DOWN방식(재귀) 이용 - dp사용X
	 * - dp를 사용하지 않는 방법
	 * - 아예 재귀 호출 할 때 같이 연산 횟수를 같이 갱신시키는 것
	 * - 그렇게 해서 N=1 이 되기 전 까지 count를 누적했다가 
	 *   1이 되면 누적된 count를 반환하여 재귀를 탈출시키는 방법
	 */
	static int OnlyRecursion(int N, int count) {
		
		// N이 2 미만인 경우 누적된 count값을 반환
		if (N < 2) {
			return count;
		}
		
		/*
		 N으로 각각 2와 3으로 나누면 count는 +1에 각 연산의
		 나머지 값을 더해준 것이 된다.
		 나머지 값은 빼기 1했을 때의 count 값과 같기 때문
		 
		 ex) N=5: 5 -> 4 -> 2 -> 1 (3)
		 	 OnlyRecursion(N/2, count +1 +(N%2)에서
		 	 N=5, count=0
		 	 N=5/2=2, count=0+1+1=2
		 	 N=2/2=1, count=2+1+0=3
		 	 N=1이기에, return count해서 count값 3이 반환됨
		 	 
		 	 OnlyRecursion(N/3, count+1+(N%3))에서
		 	 N=5, count=0
		 	 N=5/3=1, count=0+1+2=3
		 	 N=1이기에, return count해서 count값 3이 반환됨
		*/
		return Math.min(OnlyRecursion(N/2, count +1 +(N%2)),
						OnlyRecursion(N/3, count+1+(N%3)));
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("1보다 크거나 같고, 10^6보다 작거나 같은 정수 N을 입력하세요."); 
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 계산한 값을 저장할 dp배열 생성
		dp = new Integer[N+1];
		
		// 초기화(값이 null로 초기화 되어있기에)
		dp[0] = dp[1] = 0;
		
		// 방법1) 메모이제이션을 활용한 방법 중, TOP-DOWN방식(재귀) 이용
		System.out.println(IntX_recur(N));

		// 방법2) TOP-DOWN방식(재귀) 이용 - dp사용X
		System.out.println(OnlyRecursion(N, 0));
	}

}
