package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 프로그램
 * 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력
 * 
 * 예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다. 
 * (01, 10은 만들 수 없게 되었다.) 
 * 또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.
 */
public class BinarySequence {
	
	/** 개수가 피보나치 수의 수열처럼 증가
	 * - N=1 부터 경우의수 나열해보면 다음과 같음
	 * 	N=1		 1
	 * 	N=2 	11			00
	 *  N=3		111			100			001
	 *  N=4	   1111		   1100		   1001		 0011		0000
	 *  N=5	   11111	   11100	   11001    10011		00111		10000		00100		00001
	 *  개수가 1 -> 2 -> 3 -> 5 -> 8 .... 피보나치수의 수열처럼 증가
	 */
	/** 동적계획법으로 풀이
	 * (물론, 동적계획법 말고, 반복문을 통해 풀어낼 수 있음)
	 * 동적계획법: 이미 연산했던 결과가 있으면, 해당 값을 이용하여 중복되는 연산을 줄이고, 
	 * 			성능을 개선하는 방법(메모이제이션을 활용하는 방법)
	 * 
	 * - 경우의수를 15746으로 나눈 값(즉, dp[N] % 15746)을 출력해야 함
	 * - 이때, 모듈러의 연산법칙((A+B)%C = (A%C + B%C)%C)이 성립하기 때문에,
	 * 	 각 배열에 나머지값을 저장하고, 다른 재귀에서 해당 값을 사용해도 상관X
	 */
	// 입력받는 자연수의 범위가 1~1000000이기에, 배열의 크기는 1000000+1로 설정
	static int[] dp = new int[1000001];
	
	
	/** 방법1) 동적계획법 중 메모이제이션을 활용하여 문제풀이한 방법*/
	static int MemoizationTile(int N) {
		
		// 배열에 값이 없는 경우, 재귀호출 => 피보나치수열 계산
		if(dp[N] == -1) {
			dp[N] = (MemoizationTile(N-1) + MemoizationTile(N-2)) % 15746;
		}
		return dp[N];
	}
	
	
	/** 방법2. 동적계획법을 변형하여, 단순 반복문으로 풀이
	 * 먼저 N=1 일 때와 N=2 일 때의 초기 값을 변수로 두고, 
	 * N 이 2보다 큰 값일 경우 반복문을 통해 두 변수를 합해주는 방식 사용
	 */
	static int ForTile(int N) {
		
		if (N == 1) {
			return 1;
		}
		if (N == 2) {
			return 2;
		}
		
		// 초기값 설정
		int val1 = 1;
		int val2 = 2;
		int sum = 0;
		
		for (int i=2; i<N; i++) {
			// 이전 값과 이전의 이전 값의 합
			sum = (val2 + val1) % 15746;
			// 이전의 이전 값은 이전값으로 변경
			val1 = val2;
			// 이전값은 현재의 합 값으로 변경
			val2 = sum;
		}
		return sum;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("자연수 N(1 ≤ N ≤ 1,000,000)을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		/** 비어있는 배열을 -1로 초기화
		 * => 입력받은 배열dp를 4번째(3번째 인덱스)부터 -1로 초기화
		 * 	  N=1일때 1, N=2일때 2이기에, N=3일때부터 피보나치 수열 계산하기 위함
		 */
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i <dp.length; i++) {
			dp[i] = -1;
		}
		
		// 방법1) 메모이제이션 방법을 활용하여 피보나치수열 계산한 방법
		System.out.println(MemoizationTile(N));
		
		// 방법2. 동적계획법을 변형하여, 단순 반복문으로 풀이
		System.out.println(ForTile(N));
	}

}
