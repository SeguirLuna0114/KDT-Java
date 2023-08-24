package divide_Conquere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 크기가 N*N인 행렬 A가 주어진다. 이때, A의 B제곱을 구하는 프로그램
 * 단, 수가 매우 커질 수 있으니, A^B의 각 원소를 1,000으로 나눈 나머지를 출력
 * 
 * 입력받는 행렬의 크기 N과 M :  (2 ≤ N ≤  5, 1 ≤ B ≤ 100,000,000,000)
 * - 입력범위가 int를 넘기에, long타입으로 받아서 계산
 * - 출력시 각 원소를 1000으로 나눈 나머지 출력
 */
public class SquareArr_for {
	
	/** 행렬 제곱
	 * "행렬의 지수(exponential)을 절반으로 잘라가며 분할정복"
	 * ex) M8 	= M4 * M4
	 * 			= (M2*M2) * (M2*M2)
	 * 			= ((M1*M1)*(M1*M1)) * ((M1*M1)*(M1*M1))
	 * 
	 * 단, 지수가 홀수인 경우 M(밑)을 한번 더 곱해줌
	 * ex) M11 	= M5 * M5 * M1
	 * 			= ((M2*M2)*M1) * ((M2*M2)*M1) * M1
	 * 			= (((M1*M1)*(M1*M1)) * M1) * (((M1*M1)*(M1*M1)) * M1) * M1
	 */
	static int N;
	static final int MOD = 1000;		// 결과값을 1000으로 나눠줘야 함
	// A^1일 때의 배열(초기 배열)
	static int[][] origin;
	// 연산 결과를 담을 배열
	static int[][] result;
	
	/** 방법2) 반복문으로 제곱해나가면서 풀이하는 방식을 활용해 행렬 제곱 분할정복 메소드 구현
	 * - 반복문은 B가 0보다 클 때 반복하면서 B를 매 회마다 2로 나누면서 진행
	 * - 그 안에서 origin 행렬(A)의 경우 매 회마다 origin의 '제곱 행렬'으로 갱신
	 * -  출력을 할 배열인 result는 B가 홀 수일 때만 origin의 배열과 자기 자신을 곱한 행렬로 갱신
	 */
	// 배열 o1과 배열 o2를 곱해주는 메소드
	static int[][] multiply(int[][] o1, int[][] o2) {
		
		// 반환할 결과 배열
		int[][] result = new int[N][N];
		
		for(int i=0; i< N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					
					result[i][j] += o1[i][k] * o2[k][j];
					// 행렬 원소 연산이 끝나면 MOD로 나눠 나머지 연산
					result[i][j] %= MOD;
				}
			}
		}
		
		// 연산 결과 반환
		return result;
	}
	
//	효율적인 캐싱을 위한 행렬 곱셈 방식
	static int[][] multiply_enhanced(int[][] o1, int[][] o2) {
		
		// 반환할 결과 배열
		int[][] result = new int[N][N];
		
		int r;
		for(int k = 0; k < N; k++) {
			for(int i=0; i< N; i++) {
				
				// o1(ik) 원소를 고정시켜두고, 그에 대한 o2의 k열을 고정시켜 j행을 움직이면서 연산한다.
				r = o1[i][k];
				for(int j = 0; j < N; j++) {
					result[i][j] += r * o2[k][j];
					// 행렬 원소 연산이 끝나면 MOD로 나눠 나머지 연산
					result[i][j] %= MOD;
				}
			}
		}
				
		// 연산 결과 반환
		return result;
	}
	
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 행렬의 크기 N과 B를 입력하고,\n(2 ≤ N ≤  5, 1 ≤ B ≤ 100,000,000,000)"
				+ "\n둘째 줄부터 N개의 줄에 행렬의 각 원소를 입력하세요.(단, 행렬의 각 원소는 1,000보다 작거나 같은 자연수 또는 0)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = (br.readLine()).split(" ");
		N = Integer.parseInt(input[0]);
		long B = Long.parseLong(input[1]);		// B의 입력범위를 보면 1 ≤ B ≤ 100,000,000,000 (천억)
		
		// 입력받은 행렬 배열
		origin = new int[N][N];
		// 결과를 출력할 배열
		result = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
			// 결과값을 담을 배열 1로 초기화(단위행렬I로 초기화)
			result[i][i] = 1;
		}
		
		/*
		 * origin 행렬은 이전 loop에서 제곱값을 갖고있는 행렬이고,
		 * result는 지수가 홀 수 일 때, 이전 loop에서 얻은 제곱 행렬인 origin과
		 * 현재 result 행렬을 곱해주는 방식으로 간다.
		 * => 즉, 재귀 과정을 역순으로 거치면 된다.
		 * 
		 * ex) A^11 과정일 떄,
		 * 
		 * B = 11 (B % 2 == 1) -> I * A^1 = A^1 (result)
		 *                     -> A^1 * A^1 = A^2 (origin)
		 *                     
		 * B = 5  (B % 2 == 1) -> A^1 * A^2 = A^3 (result)
		 *                     -> A^2 * A^2 = A^4 (origin)
		 *                     
		 * B = 2  (B % 2 == 0) -> A^4 * A^4 = A^8 (origin)
		 *
		 * B = 1  (B % 2 == 1) -> A^3 * A^8 = A^11 (result)
		 *                     -> A^8 * A^8 = A^16 (origin)  
		 */
		while(B > 0) {
			
			// 지수가 홀수라면 origin배열을 한번 더 곱해줌
			if(B % 2 == 1) {	// (b & 1L) != 0L과 동치(b의 가장 오른쪽 비트가 1인지 아닌지를 확인하는 조건)
				result = multiply(result, origin);
			}
			
			origin = multiply(origin, origin);
			
			// 지수 B를 2로 나눠줌
			B /= 2;
		}
		
		// 연산 결과 출력
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
