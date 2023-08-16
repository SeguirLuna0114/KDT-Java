package Input_Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//별 찍기
// 첫째 줄에는 별 1개, 둘째 줄에는 별 2개...N번째 줄에는 별 N개를 
// 오른쪽 기준으로 출력하는 프로그램
class MakeStar {

	// 알고리즘 - 오른쪽 기준으로 출력
	// 1번째: (n-1)개의 공백 출력 + 1개의 별 출력
	// 2번째: (n-2)개의 공백 출력 + 2개의 별 출력
	// n번째: (N-n)개의 공백 출력 + n개의 별 출력
	// N번째: 0개의 공백 출력 + N개의 별 출력
	static void PrintStarRight(int N) {

		for (int i = 1; i <= N; i++) {
			// j만큼 공백 출력
			for (int j = 0; j <= N - i; j++) {
				System.out.print(" ");
			}
			// k만큼 별 출력
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// 알고리즘 - 중앙에서 가운데 기준으로 별 출력
	// 1번째 : (N-1)/2개의 공백 + 1개의 별 + (N-1)/2개의 공백
	// 2번째 : (N-1)/2개의 공백 + 1개의 별 + (N-1)/2개의 공백
	// 3번째 : (N-3)/2개의 공백 + 3개의 별 + (N-3)/2개의 공백
	static void PrintStarMid(int N) {
		// 홀수일 경우에만 중앙에서 출력 
		// 입력값이 짝수인 경우 => N을 홀수로 변경
		if (N%2==0) {
			N++;	// 원래값보다 1 큰 홀수로 변경(N= N+1)
		}		
		// for반복문
		for (int i = 1; i <= N; i+=2) {
			// 왼쪽 공백 출력
			for (int left = 0; left <= ((N - i) / 2); left++) {
				System.out.print(" ");
			}
			// 가운데 별 출력
			for (int mid = 1; mid <= i; mid++) {
				System.out.print("*");
			}
			// 오른쪽 공백 출력
			for (int right = 0; right <= ((N - i) / 2); right++) {
				System.out.print(" ");
			}
			System.out.println();

		}
	}
	
	// 알고리즘 - 입력받은 정수 N줄의 가운데정렬 * 출력
	static void PrintNLineStar(int N) {
		// 입력받은 정수 N줄의 * 출력
		N = (2 * N) - 1;	// 실제 출력해야 하는 라인수
		
		// for반복문
		for (int i = 1; i <= N; i+=2) {
			System.out.print((i+1)/2+"번\t");
			// 왼쪽 공백 출력
			for (int left = 0; left <= ((N - i) / 2); left++) {
				System.out.print(" ");
			}
			// 가운데 별 출력
			for (int mid = 1; mid <= i; mid++) {
				System.out.print("*");
			}
			// 오른쪽 공백 출력
			for (int right = 0; right <= ((N - i) / 2); right++) {
				System.out.print(" ");
			}
			System.out.println();

		}
	}

}

public class MakeStar_right_mid {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("숫자를 입력해주세요.(단, 1<=N<=100");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 별을 오른쪽 기준으로 출력하는 메소드 호출
		MakeStar.PrintStarRight(N);

		System.out.println();

		// 별을 중앙에 출력하는 메소드 호출
		MakeStar.PrintStarMid(N);
		
		System.out.println();
		
		// 입력받은 숫자 만큼의 별 Line을 출력
		MakeStar.PrintNLineStar(N);
	}

}
