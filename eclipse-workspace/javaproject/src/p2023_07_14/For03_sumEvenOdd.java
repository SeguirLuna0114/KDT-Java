package p2023_07_14;

public class For03_sumEvenOdd {

	// 1~100까지 홀수, 짝수의 합을 구하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 변수 선언 및 초기화
		int odd = 0, even = 0;
		
		// 홀수 합(i+=2: i=i+2)
		for (int i=1; i<=100; i+=2) {
			odd += i;
		}
		// 짝수 합
		for (int i=0; i<=100; i+=2) {
			even += i;
		}
		System.out.println("1~100 홀수의 합: " + odd);		// 1~100 홀수의 합: 2500
		System.out.println("1~100 짝수의 합: " + even);	// 1~100 짝수의 합: 2550
		System.out.println();
		
		// 간단하게 한번에 작성
		int odd2=0, even2=0;
		for (int i=1; i<=100; i+=1) {
			if (i%2==0) {
				even2 += i;
			} else {
				odd2 += i;
			}
		}
		System.out.println("홀수의 합: " + odd2);
		System.out.println("짝수의 합: " + even2);
		
	}

}
