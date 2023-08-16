package p2023_07_28;

// 추상 클래스 : 인스턴스(객체)를 직접 생성할 수 없는 클래스
// 1. 자체적으로 객체를 생성할수 없는 클래스를 말한다.
// 2. 추상클래스를 상속받은 자식 클래스는 추상 클래스 안에 있는 추상메소드를
//	  반드시 메소드 오버라이딩 해야 함

// 자동적으로 메소드 오버라이딩하는 방법
// 추상클래스를 상속받는 자식클래스의 왼쪽[x]클릭 -> [Add Unimplemented methods]

//부모 클래스(추상클래스)
abstract class AbstractClass {		
	
	int a = 10;
	
	// 추상 메소드 : 이름만 있고, 내용이 없는 메소드
	abstract void Method01();		

	// 일반 메소드
	void Method02() {
		System.out.println("Method02:  추상클래스에서 구현");
	}
}

// 추상클래스를 상속받는(extends) 자식클래스
class SubClass extends AbstractClass {

	// 자동적으로 메소드 오버라이딩하는 방법
	// 추상클래스를 상속받는 자식클래스의 왼쪽[x]클릭 -> [Add Unimplemented methods]
	// 추상클래스의 추상 메소드를 오버라이딩한 메소드(생략시 오류가 발생)
	@Override
	void Method01() {				// 메소드 오버라이딩
		// TODO Auto-generated method stub
		System.out.println("Method01: 서브클래스에서 구현된 추상메소드");	
	}
}

class AbstractTest01_AbstMethod_Overriding {
	
	public static void main(String args[]) {
		
		// 추상클래스는 '자체적으로' 객체 생성이 불가능
//		AbstractClass abs = new AbstractClass();
		
		// 추상클래스를 상속받는 하위클래스를 이용해 객체 생성 가능
		SubClass obj = new SubClass();
		
		// 하위클래스에서 메소드 오버라이딩된 메소드가 호출됨
		obj.Method01();
		
		// Method02는 부모클래스의 일반 메소드로서,
		// 하위클래스가 부모클래스로부터 상속받은 Method02메소드가 호출됨
		obj.Method02();
	}
}
