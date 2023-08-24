package divide_Conquere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* N*M크기의 행렬 A와 M*K크기의 행렬 B가 주어졌을 때, 두 행렬을 곱하는 프로그램
 * 첫째 줄부터 N개의 줄에 행렬 A와 B를 곱한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분
 */
public class MultipleArr_StrassenAlgorithm_enhanced {

	static int[][] A;
	static int[][] B;

	/**
	 * 방법3) 개선된 스트라센 알고리즘 (Strassen Alogrithm)
	 * - 임계값(threshold)을 정해서 일정 크기 이하가 되면 반복문으로 행렬 곱을 하도록 처리하는 것
	 * 	 => 대략 70 언저리쯤으로 잡는 것 추천(이번에는 16정도로 잡을 것)
	 */
	// 임계값
	static final int threshold = 16;
	
	// 추가 된 행렬 loop 곱 메소드(3중 for 루프를 사용하여 행렬 A와 B의 곱을 직접 계산)
	static int[][] loopMultiply(int[][] A, int[][] B, int size) {
	 
		int res[][] = new int[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					res[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return res;
	}
	
	
	// 정사각행렬로 padding 되기 때문에 행과 열이 같은 2^n의 size를 갖는다.
	static int[][] multiply(int[][] A, int[][] B, int size) {
		 /** 작은 크기의 행렬에 대해서는 일반적인 행렬 곱셈이 더 효율적
		  * 따라서 임계값을 설정하여 Strassen 알고리즘을 작은 행렬에 적용하지 않고,
		  * 루프 기반의 행렬 곱셈을 사용
		  */
		 
		int[][] C = new int[size][size];	// 완성시킬 C 배열
	    
		// 임계값 이하가 되면 loop로 곱셈을 하여 반환한다.
		if (size <= threshold) {	
			return C = loopMultiply(A, B, size);
		}
 
		int newSize = size / 2;	// 부분행렬에 대한 사이즈
 
		// A의 부분행렬
		int[][] a11 = subArray(A, 0, 0, newSize);
		int[][] a12 = subArray(A, 0, newSize, newSize);
		int[][] a21 = subArray(A, newSize, 0, newSize);
		int[][] a22 = subArray(A,newSize, newSize, newSize);
 
		// A의 부분행렬
		int[][] b11 = subArray(B, 0, 0, newSize);
		int[][] b12 = subArray(B, 0, newSize, newSize);
		int[][] b21 = subArray(B, newSize, 0, newSize);
		int[][] b22 = subArray(B, newSize, newSize, newSize);
 
 
	
		// M1 := (A11 + A22) * (B11 + B22)
		int[][] M1 = multiply(add(a11, a22, newSize), add(b11, b22, newSize), newSize);
 
		// M2 := (A21 + A22) * B11
		int[][] M2 = multiply(add(a21, a22, newSize), b11, newSize);
 
		// M3 := A11 * (B12 - B22)
		int[][] M3 = multiply(a11, sub(b12, b22, newSize), newSize);
 
		// M4 := A22  * (B21 − B11)
		int[][] M4 = multiply(a22, sub(b21, b11, newSize), newSize);
 
		// M5 := (A11 + A12) * B22
		int[][] M5 = multiply(add(a11, a12, newSize), b22, newSize);
 
		// M6 := (A21 - A11) * (B11 + B12)
		int[][] M6 = multiply(sub(a21, a11, newSize), add(b11, b12, newSize), newSize);
 
		// M7 := (A12 - A22) * (B21−B22)
		int[][] M7 = multiply(sub(a12, a22, newSize), add(b21, b22, newSize), newSize);
 
		
		
		// C11 := M1 + M4 − M5 + M7
		int[][] c11 = add(sub(add(M1, M4, newSize), M5, newSize), M7, newSize);
 
		// C12 := M3 + M5
		int[][] c12 = add(M3, M5, newSize);
 
		// C21 := M2 + M4
		int[][] c21 = add(M2, M4, newSize);
 
		// C22 := M1 − M2 + M3 + M6
		int[][] c22 = add(add(sub(M1, M2, newSize), M3, newSize), M6, newSize);
 
 
		// 구해진 C의 부분행렬들 합치기
		merge(c11, C, 0, 0, newSize);
		merge(c12, C, 0, newSize, newSize);
		merge(c21, C, newSize, 0, newSize);
		merge(c22, C, newSize, newSize, newSize);
 
 
		return C;
	}

	// 행렬 뺄셈 - 행렬 A와 B를 빼는 연산을 수행
	static int[][] sub(int[][] A, int[][] B, int size) {
 
		// 행렬 뺄셈 결과를 반환할 배열
		int[][] C = new int[size][size];
 
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				C[i][j] = A[i][j] - B[i][j];
			}
		}
		return C;
	}
 
	// 행렬 덧셈 - 두 개의 행렬 A와 B를 더하는 연산을 수행
	static int[][] add(int[][] A, int[][] B, int size) {
 
		// size 변수는 두 행렬의 크기
		int n = size;
 
		// 행렬 덧셈 결과를 반환할 배열
		int[][] C = new int[n][n];
 
		for (int i = 0; i < n; i++) {
 
			for (int j = 0; j < n; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;
	}
	
 
	// 부분행렬을 반환하는 메소드 - 특정위치에서 시작해 size*size크기의 부분행렬 추출
	/* src로부터 지정된 위치 (row, col)에서부터 
	 * 크기 size x size의 부분 행렬을 추출하여 
	 * 새로운 행렬 dest에 저장
	 */
	static int[][] subArray(int[][] src, int row, int col, int size) {
 
		int[][] dest = new int[size][size];
		
		// dset_i와 dset_j는 새로운 부분 행렬 dest의 행과 열
		// src_i와 src_j는 원래 행렬 src에서 추출할 부분 행렬의 시작 위치
		for (int dest_i = 0, src_i = row; dest_i < size; dest_i++, src_i++) {
			for (int dest_j = 0, src_j = col; dest_j < size; dest_j++, src_j++) {
				dest[dest_i][dest_j] = src[src_i][src_j];
			}
		}
		
		return dest;
	}
 
	
	// 부분행렬을 병합하는 메소드 - src는 복사할 배열(=부분배열), dest는 합쳐질 배열(= 배열 C)
	/* src로부터 지정된 위치 (row, col)에서부터 
	 * 크기 size x size의 부분 행렬을 추출하여 
	 * 새로운 행렬 dest에 병합하는 함수
	 */
	static void merge(int[][] src, int[][] dest, int row, int col, int size) {
 
		// src_i와 src_j는 원래 행렬 src에서 추출할 부분 행렬의 시작 위치
		// dest_i와 dest_j는 새로운 행렬 dest에서 병합할 위치
		for (int src_i = 0, dest_i = row; src_i < size; src_i++, dest_i++) {
			for (int src_j = 0, dest_j = col; src_j < size; src_j++, dest_j++) {
				// 주어진 크기의 부분 행렬을 src로부터 추출하여 dest에 병합
				dest[dest_i][dest_j] = src[src_i][src_j];
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫째 줄에 행렬 A의 크기 N 과 M을,\n" + "둘째 줄부터 N개의 줄에 행렬 A의 원소 M개를 입력하고,\n"
				+ "그 다음 줄에는 행렬 B의 크기 M과 K를, \n" + "이어서 M개의 줄에 행렬 B의 원소 K개를 차례대로 입력하세요.\n"
				+ "(N과 M, 그리고 K는 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 방법3) 개선된 스트라센 알고리즘을 이용한 행렬 곱셈 알고리즘 풀이 방법
		/*
		 * 행렬의 크기가 주어진 뒤, 바로 행렬의 값이 주어지기 때문에 패딩 과정을 따로 거치기 보다는 행렬의 크기 최댓값이 100이므로 2n과 가장
		 * 가까운 128로 미리 선언해주고 채워주도록 한다.
		 */

		// N*M크기의 행렬 A의 원소를 저장
		A = new int[128][128];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		// 어차피 M값으로 같은 수이기 때문에 버려도 상관 없다.
		st.nextToken();
		int K = Integer.parseInt(st.nextToken());

		// M*K크기의 행렬 B의 원소를 저장
		B = new int[128][128];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		/*
		 * 2^n꼴의 정사각 행렬로 패딩해야 하기 때문에 패딩 된 사이즈를 구해야한다.
		 * 즉, N과 K, M중 가장 큰 값을 기준으로 해당 값보다
		 * 크면서 2^n에 가장 가까운 값을 얻어야 한다.
		 */
		int big = Math.max(Math.max(N, K), M);

		int size = 1;
		while (true) {
			if (size >= big) {
				break;
			}
			size *= 2;
		}

		// 분할정복 메소드 호출
		int[][] C = multiply(A, B, size);

		// 계산된 배열C 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				sb.append(C[i][j] + " ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}
}
