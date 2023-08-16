package Array;

import java.util.Scanner;

public class Compare_Array {

	// 정수N개로 이루어진 수열A와 정수X
	// 이때, A에서 X보다 작은 수를 모두 출력
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("1<=N, X<=10,000");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		
		// 배열을 이용하는 방법
		int[] array = new int[N];

		// 입력받은 배열 요소 입력
		for (int idx=0; idx<N; idx++) {
			array[idx] = sc.nextInt();
		}
		
		System.out.println("A에서 X보다 작은수");
		for (int idx=0; idx<N; idx++) {
			if (array[idx] < X) {
				System.out.print(array[idx]+"\t");
			}
		}
		System.out.println();
		
	}

}
