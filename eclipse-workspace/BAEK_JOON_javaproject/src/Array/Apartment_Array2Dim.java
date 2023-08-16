package Array;

import java.util.Scanner;

// a층 b호에 살려면, 자신의 아래(a-1)층의 1호~b호까지 사람들 수의 합만큼
// 살 사람들을 데려와 살아야 함
// 이때, 주어지는 양의 정수k와 n에 대해 k층 n호에는 몇명이 사는가?
// 단, 아파트는 0층부터 존재 => 2차원 배열 활용
public class Apartment_Array2Dim {

	// (1<=k<=14, 1<=n<=14)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("아파트 층수를 입력하세요");
		
		Scanner sc = new Scanner(System.in);
		
		// 아파트 배열 생성
		// (1<=k<=14, 1<=n<=14)
		int[][] APT = new int[15][15];	// 2차원 배열 선언
		
		// 단, 아파트는 0층(k)부터 존재, 호수는 1호(n)부터 존재
		for (int i=0; i<15; i++) {
			APT[i][1] = 1; // 아파트의 i층 1호는 1로 초기화
			APT[0][i] = i; // 아파트의 0층 i호는 i로 초기화
		}
		
		// 남은 1층의 2호 ~ 14층의 14호까지 반복
		// k층 n호 = (k-1)층 1호 + (k-1)층 2호 + ... + (k-1)층 n호
		// 		  =	k층 (n-1)호 + (k-1)층 n호
		for (int i=1; i<15; i++) {	// 1층 ~ 14층
			for (int j=2; j<15; j++) {	// 2호 ~ 14호
				APT[i][j] = APT[i-1][j] + APT[i][j-1];
			}
		}

		// 첫번째 줄에는 Test case의 수 T가 주어짐
		int TestCase = sc.nextInt();	// 입력받은 정수 input에 저장
		
		// 입력받은 정수에 대해서 해당 집에 거주민 수를 출력
		// 입력받은 첫번째 정수 = k, 두번째 정수=n으로 할당
		for (int i=0; i<TestCase; i++) {	// 입력받은 Test Case동안
			int k = sc.nextInt();
			int n = sc.nextInt();
			// k와 n을 입력받을 때마다 APT배열의 원소 APT[k][n] 출력
			System.out.println(APT[k][n]);
		}
		
	}

}
