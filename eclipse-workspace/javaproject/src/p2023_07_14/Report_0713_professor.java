package p2023_07_14;

import java.util.Scanner;

// 키보드로 3개의 정수를 입력받았을 때, 최대 최소
public class Report_0713_professor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("3개의 정수를 입력 하세요?");
		// 변수 선언
		int n1, n2, n3, max, min;

		// java에서 쉽게 입력받을 수 있는 클래스
		Scanner sc = new Scanner(System.in);	// new연산자를 사용해 scanner객체 생성
		n1 = sc.nextInt(); // n1=20;
		n2 = sc.nextInt(); // n2=10;
		n3 = sc.nextInt();
		
		// 배열을 이용하는 방법
//		int[] numbers = new int[3];	// int n1, n2, n3;
//		Scanner sc = new Scanner(System.in);	// new연산자를 사용해 scanner객체 생성
//		
//		int max = Integer.MIN_VALUE;	// int max = numbers[0];
//		int min = Integer.MAX_VALUE;
//		
//		for (int i = 0; i < numbers.length; i++) {
//			numbers[i] = sc.nextInt();
//			System.out.println("n"+(i+1)+"= "+numbers[i]);
//		}	// n1 = sc.nextInt(); n2 = sc.nextInt(); n3 = sc.nextInt();

//		for (int i = 0; i < numbers.length; i++) {
//			if (numbers[i] > max) {
//			max = numbers[i];
//			}
//			if (numbers[i] < min) {
//				min = numbers[i];
//			}
//		}
//		System.out.println("max=" + max);
//		System.out.println("min=" + min);
		
			
		// 최대값 with 삼항 조건 연산자
		// (조건) ? (참일 때의 값 또는 식) : (거짓일 때의 값 또는 식)
		max = (n1 > n2) ? n1 : n2;		// n1과 n2를 비교하여 큰 값을 max
		max = (max > n3) ? max : n3;	// 위에서 할당된 큰값(max)와 n3를 비교하여 더 큰값을 max에 다시 할당
//		max = (n1>n2 && n1>n3) ? n1 : (n2>n3) ? n2: n3;
		
		
		
		
		// 최소값		
		min = (n1 < n2) ? n1 : n2;
		min = (min < n3) ? min : n3;		
//		min = (n1<n2 && n1<n3) ? n1 : (n2<n3) ? n2: n3;
		
		System.out.println("max=" + max);
		System.out.println("min=" + min);		
		
	}

}
