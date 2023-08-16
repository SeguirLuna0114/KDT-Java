package p2023_07_17;

//do~while문
//- 일단, 코드블록을 실행한 후에, 조건을 검사하여 반복을 "계속할지 결정"
//- 반복을 "적어도 1번"은 실행해야 하는 경우 사용
//do{
//  반복 실행할 문장;	// 먼저 코드블록 실행
//}while(조건식);		// 이후, 조건식 검사->참인경우 코드블록 다시 실행
public class DoWhile02_sumEvenOdd {

	// do-while문으로 1~100까지 홀수, 짝수의 합을 구하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 변수선언 및 초기화(초기값 설정)
		int count=1, odd=0, even=0;
		
		do {
		
			if (count%2==0) {	// 짝수
				even += count;
			} else {			// 홀수
				odd += count;
			}
			count++;			// 증감식
				
		} while (count <=100);	// 조건식
		
		System.out.println("1~100까지 홀수의 합: " + odd);
		System.out.println("1~100까지 짝수의 합: " + even);
	}

}