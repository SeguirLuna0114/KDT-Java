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
public class SquareArr_pow {
	
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
	
	// 방법1) 재귀 방식을 활용해 행렬 제곱 분할정복 메소드 구현
	static int[][] pow(int[][] A, long exp) {
		
		// 지수가 1일때는 A를 return
		if(exp == 1L) {
			return A;
		}
		
		// 지수를 절반으로 분할하여, 재귀호출(지수법칙 활용)
		int[][] result = pow(A, exp/2);
		
		// 하위 재귀에서 얻은 행렬을 제곱
		result = multiply(result, result);
		
		// 만일, 지수가 홀수라면 마지막에 A^1(origin)을 곱해줌
		if(exp % 2 == 1L) {
			result = multiply(result, origin);
		}
		
		return result;
	}
	
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
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				
				/* 맨 처음 입력 받을 때 미리 1000으로 나눈 나머지 값으로 초기화
				 * 
				 * B=1 일 때는 pow과정에서 바로 A가 반환 될 수 있다.
				 * 이 때의 경우 만약 원소가 1000이상일 경우 pow메소드에서 모듈러연산이
				 * 실행되지 않기 때문에 오답이 되어버린다.
				 * 
				 * 이를 방지하기 위해 초기 행렬에도 1000으로 나눈 나머지 값으로
				 * 초기화를 해준다.
				 */
				origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
			}
		}
		
		// pow()메소드 연산 실행
		int[][] result = pow(origin, B);
		
		
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
