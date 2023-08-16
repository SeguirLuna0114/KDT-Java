package p2023_07_28;

// 인터페이스의 다중상속 - 인터페이스는 다중상속을 허용
// 1. 자바에서 인터페이스의 다중 상속을 허용
// 2. 인터페이스 2개를 상속 받을 때, 상속받는 순서는 바뀌어도 상관없다.
//		(단, 추상클래스는 먼저 상속받고, 인터페이스는 그 다음으로 상속받아야 함)

//인터페이스 - default접근제어자로 선언됨
interface IHello02 {
	// 추상메소드
	public abstract void sayHello(String name);
}

//인터페이스 - default접근제어자로 선언됨
interface IGoodBye02 {
	
	// 추상메소드
	public abstract void sayGoodBye(String name);
}

//두 인터페이스로부터 상속을 받는 클래스 설계(순서 바뀌어도 상관X)
class SubClass02 implements IHello02, IGoodBye02 {
	
	// 메소드 오버라이딩
	public void sayHello(String name) {
		System.out.println(name + "씨 안녕하세요!");
	}

	// 메소드 오버라이딩
	public void sayGoodBye(String name) {
		System.out.println(name + "씨 안녕히 가세요!");
	}
}

class InterfaceTest02_MultiInherit {
	
	public static void main(String[] args) {
		// 
		SubClass02 test = new SubClass02();
		
		// 메소드 오버라이딩 된 메소드가 호출됨
		test.sayHello("홍길동");
		// 홍길동씨 안녕하세요!
		test.sayGoodBye("이순신");
		// 이순신씨 안녕히 가세요!
	}
}