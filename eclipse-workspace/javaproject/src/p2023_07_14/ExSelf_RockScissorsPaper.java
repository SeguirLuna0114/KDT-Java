package p2023_07_14;

import java.util.Random;
import java.util.Scanner;

// Rock-Scissors-Paper Game
public class ExSelf_RockScissorsPaper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("가위 바위 보 게임을 시작합니다. \n가위, 바위, 보 중 하나를 입력하세요!");
		
		Scanner sc = new Scanner(System.in);
		String userIn = sc.next();
		
		// computerIn변수에 가위,바위,보 중 하나 입력
		Random random = new Random();	// Random클래스를 사용해 난수 생성할 random객체 생성
		int computerN = random.nextInt(3);	//nextInt(3)메서드: 0~2범위의 난수 생성(0,1,2중 하나)
		// int computerN = (int)(Math.random() *3) +1;
		String[] choices = {"가위", "바위", "보"};	// 문자열 배열 choices를 선언
		String computerIn = choices[computerN];
		
//		switch (userIn) {
//			case "가위":
//			case "바위":
//			case "보":
//				System.out.println("사용자: "+userIn);
//				break;
//			default:
//				System.out.println("잘못 입력하셨습니다.");
//		}
		
//		if (userIn !="가위" && userIn !="바위" && userIn !="보") {
		// 문자열 비교할 경우에는, equals()메서드 사용!!!!

		if (!userIn.equals("가위") && !userIn.equals("바위") && !userIn.equals("보")) {
			System.out.println("잘못 입력하셨습니다.");
			return;	// 메소드 실행이 중지됨(다음의 코드가 실행되지X)
		}
		
		System.out.println("사용자: "+userIn);
		System.out.println("컴퓨터: "+computerIn);
		if (userIn.equals(computerIn)) {
			System.out.println("무승부");
		} else if ((userIn.equals("가위")&&computerIn.equals("보")) 
				|| (userIn.equals("바위")&&computerIn.equals("가위")) 
				|| (userIn.equals("보")&&computerIn.equals("바위"))) {
					System.out.println("사용자 승리");
		} else {
			System.out.println("컴퓨터 승리");
		}
		
		// 가위바위보를 숫자로 인식해서 계산하는 코드
		
		
	}

}
