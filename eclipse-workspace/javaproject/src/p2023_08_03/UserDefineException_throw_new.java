package p2023_08_03;

/*
 * 예외 처리와 사용자 정의 예외 처리 클래스를 함께 사용하는 예제

	사용자가 직접 정의한 예외처리 클래스
	- 모든 예외처리 클래스의 상위 클래스인 Exception클래스를 상속하여, 
  	  예외처리를 구현하기 위해 기본적으로 제공되는 클래스 계층구조 활용
  		(일반적으로 사용자정의 예외클래스 생성시 Exception클래스를 상속받음)
	- 프로그래머가 특정 상황에 발생시키고자 하는 예외를 표현하는데 사용
		ex) 프로그램에서 특정 조건이 충족되지 않거나, 오류 상황 감지시
			사용자 정의 예외를 발생시키고, 호출자에서 이를 처리하도록 함
	- 이렇게 정의된 예외도 try~catch문으로 처리 가능
*/
public class UserDefineException_throw_new {

	// UserDefineException_super 클래스: 사용자가 직접 정의한 예외 처리 클래스
	// 예외를 발생시키는 메소드(printNumber)에서 이 예외를 던지도록 선언
	public void printNumber() throws UserDefineException_super {
		
		for (int i = 0; i < 10; i++) {
			// 프로그래머가 강제로 Excpetion을 발생시킴
			if (i == 5)
				throw new UserDefineException_super("사용자가 정의한 Exception입니다");
			
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		
		// UserDefineException_throw_new 객체를 생성
		UserDefineException_throw_new uet = new UserDefineException_throw_new();

		try {
			// printNumber 메소드를 호출
			// - throws UserDefineException_super로 선언되어 있으므로, 
			// 	  호출하는 쪽에서 예외 처리를 해야함 => try~catch 블록 사용하여 예외처리
			uet.printNumber();
			
		} catch (UserDefineException_super ue) {
			// UserDefineException_super 예외를 처리
			System.out.println(ue.toString());
		}
	}
}
