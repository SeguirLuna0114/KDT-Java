package p2023_07_28;

//두 인터페이스로부터 상속을 받는 클래스 설계
//인터페이스의 다중상속 - 인터페이스는 다중상속을 허용
//1. 자바에서 인터페이스의 다중 상속을 허용
//2. 인터페이스 2개를 상속 받을 때, 상속받는 순서는 바뀌어도 상관없다.
//		(단, 추상클래스는 먼저 상속받고, 인터페이스는 그 다음으로 상속받아야 함)

// 인터페이스
interface IHello05 {
		
	// 추상 메소드
	public abstract void sayHello(String name);
}

// 인터페이스
interface IGoodBye05 {
	// 추상 메소드
	public abstract void sayGoodBye(String name);
}

//두 인터페이스로부터 상속을 받는 클래스 설계
class SubClass05 implements IHello05, IGoodBye05 {
	// 메소드 오버라이딩
	public void sayHello(String name) {
		
		System.out.println(name + "씨 안녕하세요!");
	}
	// 메소드 오버라이딩
	public void sayGoodBye(String name) {
		System.out.println(name + "씨 안녕히 가세요!");
	}
}

class AbstractTest05_MultiInherit_Interface {
	
	public static void main(String[] args) {
		
		SubClass05 test = new SubClass05();
		// 메소드 오버라이딩 된 메소드가 호출됨
		test.sayHello("홍길동");
		test.sayGoodBye("이순신");
	}
}