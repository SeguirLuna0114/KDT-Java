package Array;

import java.util.Scanner;

// 크기가 N*N으로 주어진 행렬A의 B제곱을 구하는 프로그램
// 2 <= N <= 5, 1 <= B <= 100,000,000,000)

// 곱셈문제 풀이와 같게 행렬의 지수를 절반으로 잘라가며 분할정복
// M^8 = M^4 * M^4 = (M^2*M^2)*(M^2*M^2) = ((M^1 * M^1)*(M^1 * M^1)) * ((M^1 * M^1)*(M^1 * M^1)) 

class Multiple {

	// 필드
	static int MOD = 1000;

	// 메소드
	// pow()메소드 - 분할 정복을 이용하여 행렬을 제곱하는 역할 수행
	static int[][] pow(int[][] Array, long exp, int N) {
		// 지수가 1일 땐 A를 return
		if (exp == 1L) {
			return Array;
		}

		// 지수를 절반으로 분할하여 재귀호출
		int[][] result = pow(Array, exp / 2, N);

		// 하위 재귀에서 얻은 행렬을 제곱
		result = multiplyArr(result, result, N);

		// 만약 지수가 홀수라면 마지막에 Array^1 (init_array)을 곱해줌
		if (exp % 2 == 1L) {
			result = multiplyArr(result, Array, N);
		}
		return result;
	}

	// multiplyArr()메소드
	static int[][] multiplyArr(int[][] arr1, int[][] arr2, int N) {

		// 받은 행렬의 크기N을 인자로, result의 크기가 N*N이 되게 함
		int[][] result = new int[N][N];

		// arr1의 i번째 행과 arr2의 j번째 열을 내적하여 계산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					result[i][j] += arr1[i][k] * arr2[k][j];
					// 행렬 원소 연산이 끝나면 MOD로 나머지 연산 => 결과값이 너무 커지는 것 방지
					result[i][j] %= MOD;
				}
			}
		}
		return result; // result배열은 두 행렬의 곱인 결과행렬
	}
}

public class Multiple_Array2Dim {

	// 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 배열의 크기 N을 입력
		System.out.println("설정할 행렬의 크기N과 B를 입력해주세요");
		Scanner sc = new Scanner(System.in);

		// 행렬의 크기N, 행렬을 B번 제곱할 것을 의미
		int N = sc.nextInt();
		long B = sc.nextInt();

		// N크기의 행렬을 선언
		int[][] init_array = new int[N][N];

		// 입력받은 init_array의 모든 원소를 1000으로 나눈 나머지 값으로 초기화
		// B=1일 경우 pow메소드에서 바로 A가 반환될 경우를 대비
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				init_array[i][j] = sc.nextInt() % Multiple.MOD;
			}
		}

		// pow()메소드를 사용하여 제곱 구하기
		int[][] result_array = Multiple.pow(init_array, B, N);

		// result_array 행렬을 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result_array[i][j] + "\t");
			}
			System.out.println();
		}
	}
}