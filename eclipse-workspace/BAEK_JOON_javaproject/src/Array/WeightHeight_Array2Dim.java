package Array;

import java.util.Scanner;

// 사람의 덩치를 키와 몸무게만으로 평가
// 덩치 등수는 자신보다 더 큰 덩치의 사람의 수로 평가됨
// (자신보다 덩치가 큰 사람이 k명이라면, 덩치등수는 k+1)
// 같은 덩치 = 같은 (높은)등수로 처리
public class WeightHeight_Array2Dim {

	// 첫 줄에는 전체 사람의 수N이 주어짐
	// 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 정수
	// (2 <= N <= 50, 10 <=x,y <=200)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("전체사람의 수와 각 사람의 몸무게, 키를 입력해주세요");
		// 첫줄에는 전체 사람의 수 N이 주어짐
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 전체 사람의 수
		
		// 각 사람의 키와 몸무게를 저장할 2차원 배열 형성
		// N행 2열 (N명의 키, 몸무게 저장할것)
		int[][] Array = new int[N][3];
		
		// 각 사람들의 키, 몸무게 입력
		for (int i=0; i<N; i++) {
			// Array배열의 1번째 열에는 몸무게 저장
			Array[i][0] = sc.nextInt();
			// Array배열의 2번째 열에는 키 저장
			Array[i][1] = sc.nextInt();
		}

		// 순위를 계산하고 출력
		for (int i=0; i<N; i++) {	// 0~N-1행까지 반복
			int rank = 1;	// 현재 행(사람)의 순위 변수를 1로 초기화
			for (int j=0; j<N; j++) {
				// 자기 자신과의 비교는 피함
				if (i==j) {
					continue;	// 다음 반복으로 넘어감
				}
				// 키와 몸무게가 작으면 순위+1
				if (Array[i][0] < Array[j][0] &&
					Array[i][1] < Array[j][1]) {
					rank++;
				}
			}
			System.out.print("사람"+(i+1)+": "+rank+"위 ");
			Array[i][2] = rank;
		}
		System.out.println();
		
		// 확장 for문 활용 - 입력된 2차원 배열 출력
		int rowIdx=1;
		System.out.println("\t몸무게\t키\t순위");
		for (int[] row : Array) {
			System.out.print("사람"+rowIdx);
			for (int element : row) {
				System.out.print("\t"+element);
			}
			System.out.println(); // 줄바꿈
			rowIdx++;
		}
		
	}

}
