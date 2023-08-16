package p2023_07_17;

import java.util.Scanner;

//do~while문
//- 일단, 코드블록을 실행한 후에, 조건을 검사하여 반복을 "계속할지 결정"
//- 반복을 "적어도 1번"은 실행해야 하는 경우 사용
//do{
//반복 실행할 문장;	// 먼저 코드블록 실행
//}while(조건식);		// 이후, 조건식 검사->참인경우 코드블록 다시 실행
public class DoWhile03_q_Quit {

	// 사용자가 q를 입력하면 do-while문을 빠져나오게 됨
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("메세지를 입력하세요?");
		System.out.println("프로그램을 종료하려면 q를 입력하세요?");
		
		Scanner sc = new Scanner(System.in);
		String input;
		
		do {
			System.out.println(">");
			// Scanner클래스에서 문자열 입력 메서드:next(), nextLine()
			// next() 메서드: 공백을 기준으로 문자열 구분. 첫번째 공백 이전의 부분만 반환
			// nextLine() 메서드: Enter를 기준으로 문자열 구분. 입력된 "전체 문자열" 반환
			//	(공백을 포함한 여러단어를 한줄에 입력&출력 가능)
			input = sc.nextLine(); 		// 문자로 입력받음
			System.out.println("입력문자: "+input);
				// equals메서드: 두개의 객체(문자열 비롯 모든) 비교 메서드
				// equalsIgnoreCase()메서드: 문자열 비교시 대소문자구분X
		} while (!input.equals("q"));	// 정확히 Q와 동일
//		while(!"oracle".equals("q"));	// loop문이 계속 싫행됨
//		while(!"q".equals("q"));		// loop문을 빠져나옴
		
		
		System.out.println("프로그램 종료");
		sc.close();	// Scanner객체 사용 후, 리소스를 해제/정리/닫는 역할
		// (단, Scanner가 표준입력(System.in)을 읽는 경우에는 close메소드 생략 가능)
		// (표준입력(System.in)을 읽는 경우에는 프로그램 종료시 자동으로 닫히기 때문)
		
	}

}
