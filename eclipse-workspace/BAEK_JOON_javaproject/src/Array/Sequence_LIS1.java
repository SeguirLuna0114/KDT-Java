package Array;

import java.util.Scanner;

//가장 긴 증가하는 부분수열을 구하는 프로그램
//LIS(Longest Increasing Sub-sequence)

//-직전 숫자 대비 차이가 작은 값 위주로 비교
//가장 긴 증가하는 수열 = 중점이 '증가'한다는 것과 '가장 길다'는 것
//=> 증가한다 = 선행 원소 < 후행 원소 => 길다는 것은 제한된 수의 범위 내에서 "상호 원소값의 차이가 적어야 함"

// Top-Down방식 => 재귀호출 방식 사용
class LIS_TopDown {
	
	// int배열 선언
	static int[] SeqArray;	// 입력한 배열
	static Integer[] dp;	// // dp[]배열에 메모이제이션 시행 => dp[]의 길이는 부분수열을 의미
	
	// LIS메소드 - 각 원소에 대한 부분 증가수열 구하는 메소드
	static int LIS(int N) {
		// 만약 탐색하지 않던 위치의 경우
		if (dp[N] == null) {
			dp[N] = 1;	// 1로 초기화
			
			// Top-Down방식
			// N-1부터 0까지 중 N보다 작은 값들을 찾으면서 재귀호출
			for (int i=N-1; i>=0; i--) {
				if (SeqArray[i] < SeqArray[N]) {
					dp[N] = Math.max(dp[N], LIS(i)+1);
				}
			}
		}
		return dp[N];
	}
}

// Bottom-up방식 => 반복문으로 풀이
class LIS_BottomUp {
	
	// int배열 선언
	static int[] SeqArray;	// 입력한 배열
	static Integer[] dp;	// // dp[]배열에 메모이제이션 시행 => dp[]의 길이는 부분수열을 의미
	
	static int LIS(int N) {
		
		Integer[] dp = new Integer[N];
		
		for (int i=0; i<N; i++) {
			dp[i] = 1;
			
			// 0~(i-1)원소들 탐색
			for (int j=0; j<i; j++) {
				// j번째 원소가 i번째 원소보다 작으면서
				// i번째 dp가 j번째 dp+1 값보다 작은경우
				if (SeqArray[j] < SeqArray[i] && dp[i] < dp[j]+1) {
					// j번째 원소의 +1 값이 i번째 dp가 됨
					dp[i] = dp[j]+1; 
				}
			}
		}
		// 최대값(최대길이) 탐색
		int max = -1;
		for (int i=0; i<N; i++) {
			// 삼항 연산자 사용
			max = (dp[i] > max) ? dp[i] : max;
		}
		return max;
	}
}


// 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하라
// ex) 수열A = {10, 20, 10, 30, 20, 50} => A'={10, 20, 30, 50}
public class Sequence_LIS1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("가장 긴 증가하는 부분수열 구하기(LIS)");
		System.out.println("수열 A를 입력하세요");
		
		Scanner sc = new Scanner(System.in);
		// 수열의 크기 N
		int N = sc.nextInt();
		
//		1) LIS_TopDown클래스 사용
		// int 배열 선언
		// SeqArray배열 초기화
		LIS_TopDown.SeqArray = new int[N];	// 입력한 배열
		
		// 입력받은 수열을 SeqArray에 입력
		for (int i=0; i<N; i++) {
			LIS_TopDown.SeqArray[i] = sc.nextInt();
		}
		
		// dp배열 초기화
		LIS_TopDown.dp = new Integer[N];
		
		// LIS메소드를 사용 => 0~N-1까지 모든 부분수열 검색
		for (int i=0; i<N; i++) {
			LIS_TopDown.LIS(i);
		}
		
		// 최대값 찾기
		int max = LIS_TopDown.dp[0];	// 초기값 설정
		for (int i=1; i<N; i++) {
			// 기존에 설정한 max와 dp[i]중에 최대값을 max에 할당
			max = Math.max(max, LIS_TopDown.dp[i]);
		}
		System.out.println(max);
		
		
//		2)LIS_BottomUp 클래스 활용
//		// SeqArray배열 초기화
//		LIS_BottomUp.SeqArray = new int[N];	// 입력한 배열
//		
//		// 입력받은 수열을 SeqArray에 입력
//		for (int i=0; i<N; i++) {
//			LIS_BottomUp.SeqArray[i] = sc.nextInt();
//		}
//		
//		// dp배열 초기화
//		LIS_BottomUp.dp = new Integer[N];
//		
//		// LIS메소드 사용 => 0~N-1까지 모든 부분수열 검색
//		int max = LIS_BottomUp.LIS(N);
//		System.out.println(max);
		
		
	}
}
