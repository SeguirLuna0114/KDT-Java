package Array;

// 크기가 N*N인 배열 A에 들어있는 수를 일차원 배열B에 넣고 오름차순 정렬시
// B[k]를 구하는 프로그램
import java.util.Scanner;

// *알고리즘
// B[11]=8: B행렬의 11번째 값은 9 ==> 8이라는 값보다 작거나 같은 원소의 개수 최소 11개
// 모든 구간에 대해 B[i] <= B[i+a]라는 의미를 가짐
// 	따라서, B[k]=x의 x값을 조정하며 "x보다 작거나 같은 원소의 개수"가 k값과 일치하는 경우를 생각
// 2차원 행렬(A[i][j] = i*j를 만족한다고 정의되었기에, 각 행 혹은 열은 일종의 구구단이 됨
// ex) 3보다 작은 원소의 개수 ==> x(3)을 각 단(i)으로 나눠버리면 개수가 됨


// 이분 탐색
// B[k] = x에 대해, x는 left <= x < right안의 수


// 첫째줄에 배열의 크기 N(<=10^5 자연수)이 주어지고, 
// 둘째 줄에 자연수k(<= min(10^9, N&2))가 주어질때
// B[k]를 구하는 프로그램
public class Trans_2dimArr_1Dim {

	// N=3, k=7일경우, B[7]=6
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("배열의 크기N을 입력하세요");
		System.out.println("자연수k를 입력하세요.(B[k])");
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		// B[k]=x에 대해, x의 범위: low <= x < high
		long low = 1;
		long high = k;
		
		// lower-bound
		while (low < high) {	// low값이 high보다 작은동안 동작
			
			// 임의의 x를 중간값(mid)으로 잡음
			long mid = (low + high) / 2;
			
			// mid값보다 작거나 같은 원소의 개수 누적
			long count=0;	
			// 임의의 x에 대해 i번째 행을 나눔으로써 x보다 작거나 같은 원소의 개수 누적합을 구함
			for (int i=1; i<=N; i++) {
				// 이때 각 행의 원소의 개수가 N(열 개수)를 초과하지 않는 선에서 합해줌
				count += Math.min(mid/i, N);	// mid를 i로 나눈 결과와 N중에서 작은값을 누적
				// mid를 i로 나눈 결과는 i번째 행에서 mid보다 작거나 같은 원소의 개수
				// 각 행의 원소개수가 N을 초과할 수 있으므로, 세어진 개수와 N중 작은값을 누적함
			}
			
			// count가 많다 = 임의의 x(현재 설정한 mid)보다 작은 수가 B[k]보다 많다
			if (k <= count) {
				// high를 mid(현재 설정한 임의의 x)로 업데이트
				high = mid;
			} else {
				// count가 적다 = 임의의 x(현재 설정한 mid)보다 작은 수가 B[k]보다 부족
				// 따라서, low를 mid+1로 업데이트
				low = mid+1;
			}
			
		}	// 이진탐색을 반복 => 최종적으로 찾고자 하는 B[k]값을 나타냄
		// low는 최종적으로 찾고자하는 B[k]이기에, 이를 출력
		System.out.println(low);
	}
}
