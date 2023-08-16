package p2023_07_28;

// 인터페이스
// 1. 모든 메서드는 암묵적으로 public이며 abstract임 (public abstract 생략 가능)
// 2. 부모 인터페이스에서 상속을 받으면, 부모 인터페이스 안에 있는 추상 메소드를 
//	  자식 구현 클래스에서 반드시 메소드 오버라이딩 해야 한다.

// 인터페이스 - default접근제어자로 선언됨
interface IHello01 {
	
	// 추상 메소드(public abstract 생략 가능)
	void sayHello(String name);
}

class Hello01 implements IHello01 {

	// 메소드 오버라이딩
	// public을 붙여서 메소드 오버라이딩 해야함
	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + "씨 안녕하세요!");
	}
	
}

class InterfaceTest01_SubMethodOverriding {
	
	public static void main(String[] args) {
		// 인터페이스는 자체적으로 객체 생성을 할 수 없다.
//		IHello01 obj = new IHello01();	// 오류 발생
		
		Hello01 obj = new Hello01();
		obj.sayHello("홍길동");
		obj.sayHello("이순신");
		
		// 오류 발생
//		obj.sayHello(args[0]);
//		obj.sayHello(args[1]);
	}
}
