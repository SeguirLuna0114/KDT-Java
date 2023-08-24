package divide_Conquere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* N*M크기의 행렬 A와 M*K크기의 행렬 B가 주어졌을 때, 두 행렬을 곱하는 프로그램
 * 첫째 줄부터 N개의 줄에 행렬 A와 B를 곱한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분
 */
public class MultipleArr {
	
	static int[][] A;
	static int[][] B;
	
	/** 방법1) 기본적인 행렬 곱셈 알고리즘 이용
	 * 	- A의 행과 B의 열을 순서대로 반복하면서 곱셈
	 * 	- n×m 크기의 A행렬과 m×k 크기의 B행렬의 곱은 n×k 크기의 행렬로 반환됨
	 */ 
	// 방법1) 기본적인 행렬 곱셈 알고리즘 이용
	static void MultiArr() {
		
		// 연산 결과 출력 클래스
		StringBuilder sb = new StringBuilder();
		
		// i = A행렬의 i번째 row
		// A행렬의 row는 N까지 존재 => A.length = N(행의 개수)
//		for(int i=0; i<N; i++) {
		for(int i=0; i<A.length; i++) {
			
			// j = B행렬의 j번째 col
			// B행렬의 column은 K까지 존재 => B[0].length = K(열의 개수)
//			for(int j=0; j<K; j++) {
			for(int j=0; j<B[0].length; j++) {
				
				/*
				 * A의 row(i)와 B의 col(j)의 각 원소들을 곱한 뒤 더하는 과정
				 * ex) A(row1) = [a b c],  B(col1) = [g h i]
				 *     --> = (ab + bh + ci)
				 */
				// 계산 결과 반환 변수 설정
				int sum = 0;
				// 더해주는 원소의 개수는 총 M개
//				for(int k=0; k<M; k++) {
				for(int k=0; k<B.length; k++) {
					// A의 i번째 row의 k번째 열 원소와, B의 j번째 col의 k번째 행 원소를 곱한 뒤 누적합
					sum += A[i][k] * B[k][j];
				}
				// A의 i행의 j열 연산이 끝나면 바로 출력문으로 보내준다. 
				sb.append(sum).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
		/** 좀 더 캐시 친화적인 코드로 작성
		 * 
		 * for (int k = 0; k < M; k++) {
		 * 	for (int i = 0; i < N; i++) { 
		 * 		// A(ik) 원소를 고정시켜두고, 그에 대한 B의 k열을 고정시켜 j행을 움직이면서 연산한다.
		 * 		r = A[i][k];	
		 * 		for (int j = 0; j < K; j++) {
		 * 			res[i][j] += r * B[k][j];
		 * 		}
		 * 	}
		 * }
		 */
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 행렬 A의 크기 N 과 M을,\n"
				+ "둘째 줄부터 N개의 줄에 행렬 A의 원소 M개를 입력하고,\n"
				+ "그 다음 줄에는 행렬 B의 크기 M과 K를, \n"
				+ "이어서 M개의 줄에 행렬 B의 원소 K개를 차례대로 입력하세요.\n"
				+ "(N과 M, 그리고 K는 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// N*M크기의 행렬 A의 원소를 저장
		A = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		// 어차피 M값으로 같은 수이기 때문에 버려도 상관 없다.
		st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		
		// M*K크기의 행렬 B의 원소를 저장
		B = new int[M][K];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<K; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 방법1) 기본적인 행렬 곱셈 알고리즘 이용
		MultiArr();
	}
}