package p2023_08_03;

/*
	사용자가 직접 정의한 예외처리 클래스
	- 모든 예외처리 클래스의 상위 클래스인 Exception클래스를 상속하여, 
	  예외처리를 구현하기 위해 기본적으로 제공되는 클래스 계층구조 활용
	  (일반적으로 사용자정의 예외클래스 생성시 Exception클래스를 상속받음)
	- 프로그래머가 특정 상황에 발생시키고자 하는 예외를 표현하는데 사용
	ex) 프로그램에서 특정 조건이 충족되지 않거나, 오류 상황 감지시
		사용자 정의 예외를 발생시키고, 호출자에서 이를 처리하도록 함
	- 이렇게 정의된 예외도 try~catch문으로 처리 가능
 */
public class UserDefineException_super extends Exception {
//			 사용자 정의 예외처리 클래스

	// 기본 생성자 - 사용자가 직접 호출하는 경우에 사용(주로 예외 객체를 생성할 때 사용)
	public UserDefineException_super() {
	}

	// 인수를 하나 받아들이는 생성자
	public UserDefineException_super(String information) {
		// Exception 클래스의 생성자 호출하여, 예외객체 생성
		super(information);
		// super키워드로 상위클래스의 생성자를 호출 -> 전달받은 문자열을 예외객체에 저장
	}
}
