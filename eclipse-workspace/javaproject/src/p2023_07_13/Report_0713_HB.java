package p2023_07_13;

import java.util.Scanner;

public class Report_0713_HB {

	// 키보드로 3개의 정수를 입력 받았을 때 최대값과 최소값
	// 조건 연산자를 활용하여 작성
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n1, n2, n3, max, min;
		
		System.out.println("정수 3개를 입력 하세요!");
		
		Scanner sc = new Scanner(System.in);
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		n3 = sc.nextInt();

		max = (n1 > n2 && n1 > n3) ? n1 : (n2 > n3 ? n2 : n3);	// 최대값
		min = (n1 < n2 && n1 < n3) ? n1 : (n2 < n3 ? n2 : n3);	// 최소값
		
		System.out.println("max: " + max);
		System.out.println("min: " + min);
		
	}

}
