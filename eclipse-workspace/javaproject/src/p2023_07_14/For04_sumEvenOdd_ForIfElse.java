package p2023_07_14;

public class For04_sumEvenOdd_ForIfElse {

	// 1~100까지 홀수, 짝수의 합을 구하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// for문 1개 & if-else문 활용하여 간단히 작성
		
		// 변수 선언 및 초기화
		int odd=0, even=0;
		
		// i++ = i+=1
		for (int i=1; i<=100; i++) {
			if (i%2==0) {	// 짝수
				even += i;
			} else {
				odd += i;	// 홀수
			}
		}
		System.out.println("1~100까지 홀수의 합: " + odd);
		System.out.println("1~100까지 짝수의 합: " + even);
		
	}

}
