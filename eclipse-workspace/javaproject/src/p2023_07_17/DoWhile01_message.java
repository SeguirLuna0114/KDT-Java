package p2023_07_17;

// do~while문
// - 일단, 코드블록을 실행한 후에, 조건을 검사하여 반복을 "계속할지 결정"
// - 반복을 "적어도 1번"은 실행해야 하는 경우 사용
// do{
//     반복 실행할 문장;	// 먼저 코드블록 실행
// }while(조건식);		// 이후, 조건식 검사->참인경우 코드블록 다시 실행
public class DoWhile01_message {
	
	// do~while문으로 '사랑해요'메세지를 10번 출력하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// do-while문은 조건식이 거짓일 경우에도 최소 1번은 반복문이 실행됨
		int i=1;
		do {
			System.out.println(i+". 사랑해요~!!");
			i++; 			// 증감식: i값 1 증가(증감식을 추가해야 유의미)
		} while (i<=10);	// 조건식
		
	}	// end main

}	// end class
