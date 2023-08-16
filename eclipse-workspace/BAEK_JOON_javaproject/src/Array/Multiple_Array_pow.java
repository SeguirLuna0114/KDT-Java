package Array;

import java.util.Scanner;

// 크기가 N*N으로 주어진 행렬A의 B제곱을 구하는 프로그램
// 2 <= N <= 5, 1 <= B <= 100,000,000,000)

// 곱셈문제 풀이와 같게 행렬의 지수를 절반으로 잘라가며 분할정복
// M^8 = M^4 * M^4 = (M^2*M^2)*(M^2*M^2) = ((M^1 * M^1)*(M^1 * M^1)) * ((M^1 * M^1)*(M^1 * M^1)) 

class Multiple_2 {

	// 필드
	private static int N;
	// A^1일 때의 배열(초기 배열)
	private static int[][] init_array;
	static int MOD = 1000;

	// 메소드
	// pow()메소드 - 행렬 제곱 분할정복 메소드
	static int[][] pow(int[][] Array, long exp) {
		// 지수가 1일 땐 A를 return
		if (exp == 1L) {
			return Array;
		}

		// 지수를 절반으로 분할하여 재귀호출
		int[][] result = pow(Array, exp / 2);

		// 하위 재귀에서 얻은 행렬을 제곱
		result = multiplyArr(result, result);

		// 만약 지수가 홀수라면 마지막에 Array^1 (init_array)을 곱해줌
		if (exp % 2 == 1L) {
			result = multiplyArr(result, init_array);
		}
		return result;
	}

	// multiplyArr()메소드
	static int[][] multiplyArr(int[][] arr1, int[][] arr2) {

		int[][] result = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					result[i][j] += arr1[i][k] * arr2[k][j];
					// 행렬 원소 연산이 끝나면 MOD로 나머지 연산
					result[i][j] %= MOD;
				}
			}
		}
		return result;
	}
}

public class Multiple_Array_pow {

	// 메인
	public static void main(String[] args) {

		// 배열의 크기 N을 입력
		System.out.println("설정할 배열의 크기N을 입력해주세요");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long B = sc.nextInt();

		int[][] init_array = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				init_array[i][j] = sc.nextInt() % Multiple_2.MOD;
			}
		}

		// pow()메소드를 사용하여 제곱 구하기
		int[][] result_array = Multiple_2.pow(init_array, B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result_array[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
