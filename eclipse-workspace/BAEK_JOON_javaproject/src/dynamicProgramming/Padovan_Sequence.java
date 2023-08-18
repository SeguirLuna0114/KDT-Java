package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 파도반 수열에서 N이 주어졌을 때, P(N)을 구하는 프로그램을 작성
 * 
 * 파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다.
 * P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
 * 
 * 파도반 수열의 경우, 피보나치와는 달리 두 인접 값의 합이 다음 인덱스가 아닌, 다다음 인덱스에 위치
 * Func(N) = Func(N-2) + Func(N-3)
 * 
 * 또한 1~100까지 N의 파도반 수열의 경우, 
 * 9000억 가까이 되기에 int형 범위를 넘어감 => long타입으로 해결
 */
public class Padovan_Sequence {

	static Long[] seq = new Long[101];		// N의 범위(1~100)
	
	/** 방법1) 여러개의 테이스케이스마다 동적계획법 사용
	 * Func(N) = Func(N-2) + Func(N-3)
	 */
	static long PadovanMemo(int N) {
		
		// 만일 해당 배열에 값이 존재하지 않는 경우, 재귀호출
		if(seq[N] == null) {
			seq[N] = PadovanMemo(N-2) + PadovanMemo(N-3);
		}
		
		return seq[N];
	}
	
	
	/** 방법2) 메모이제이션을 배열 및 반복문을 이용해 풀이
	 * - seq[]배열이 메모이제이션을 해주고, 반복문(Bottom-up) 방식으로 문제 해결
	 */
	static void PadovanFor() {
		
		long[] seq2 = new long[101];
		
		seq2[0] = 0;
		seq2[1] = 1;
		seq2[2] = 1;
		seq2[3] = 1;
		
		for (int i=4; i<101; i++) {
			seq[i] = seq[i-2] + seq[i-3];
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 테스트 케이스의 개수 T를 입력하고,\n"
				+ "각 테스트 케이스에 N(1 ≤ N ≤ 100)을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		/** 비어있는 배열 체크하는 방법
		 ** 방법1) 비어있는 배열을 -1로 초기화
		 * => 입력받은 배열seq를 4번째 인덱스부터 -1로 초기화
		 * 	  N=1일때 1, N=2일때 1, N=3일때 1, 이후부터 파도반 수열 계산하기 위함
		 * 		
		 * 		long[] seq = new long[101];
		 * 		seq[0] = 0;
		 * 		seq[1] = 1;
		 * 		seq[2] = 1;
		 * 		seq[3] = 1;
		 * 
		 * 		for(int i=4; i<N; i++) {
		 * 				seq[i] = -1;
		 * 		}
		 * 
		 ** 방법2) 1로 초기화 해주는 대신 Long 타입 Wrapper Class 로 하여 null 체크
		 *
		 *		Long[] seq = new Long[101];
		 *		seq[0] = 0L;
		 *		seq[1] = 1L;
		 *		seq[2] = 1L;
		 *		seq[3] = 1L;
		 *
		 *		=> 비어있는 배열은 자동으로 null로 초기화 됨
		 */
		// seq배열의 초기값을 설정
		seq[0] = 0L;
		seq[1] = 1L;
		seq[2] = 1L;
		seq[3] = 1L;
		
		// 4번부터 1번+2번의 계산이 수행됨
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while (T-- >0) {
			
			int N = Integer.parseInt(br.readLine());
			
			// 방법1) 여러 케이스마다 동적계획법을 사용하는 방법
			sb.append(PadovanMemo(N)).append('\n');
			
			// 방법2) 메모이제이션을 배열 및 반복문을 이용해 풀이
			PadovanFor();		// 입력받을 수 있는 N의 범위 1~100까지의 수에 대해 파도반 배열을 구함
			sb2.append(seq[N]).append('\n');
		}
		System.out.println(sb);
		System.out.println(sb2);
	}
}
