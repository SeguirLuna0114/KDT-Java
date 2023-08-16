package p2023_07_28;

//추상클래스와 인터페이스를 동시에 상속받는 경우,
//추상클래스를 먼저 상속받고, 인터페이스를 그 다음으로 상속받아야 함
//(상속받는 순서가 바뀌면 오류가 발생)

// 부모 인터페이스
interface IHello04 {
	// 추상 메소드(public abstract 생략 가능)
	public abstract void sayHello(String name);
}

// 추상 클래스
abstract class GoodBye04 {
	// 추상 메소드
	// - 추상 클래스 내의 메소드는 'abstract'를 생략해도 추상 메소드로 취급됨
	public abstract void sayGoodBye(String name);
}

// 추상클래스와 인터페이스를 동시에 상속받는 경우,
// 추상클래스를 먼저 상속받고, 인터페이스를 그 다음으로 상속받아야 함
// (상속받는 순서가 바뀌면 오류가 발생)
class SubClass04 extends GoodBye04 implements IHello04 {
	
	// 인터페이스의 추상메소드 오버라이딩
	public void sayHello(String name) {
		System.out.println(name + "씨 안녕하세요!");
	}

	// 추상클래스의 추상메소드 오버라이딩
	public void sayGoodBye(String name) {
		System.out.println(name + "씨 안녕히 가세요!");
	}
}

class AbstractTest04_inherit_AbstrClass_Interface {
	
	public static void main(String[] args) {
		// 하위 클래스의 객체를 선언 => 인터페이스와 추상클래스에 접근
		SubClass04 test = new SubClass04();
		
		// 메소드 오버라이딩 된 메소드가 호출됨
		test.sayHello("홍길동");
		test.sayGoodBye("이순신");
	}
}