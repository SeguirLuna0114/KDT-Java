package p2023_07_28;

// 추상 클래스 : 인스턴스(객체)를 직접 생성할 수 없는 클래스
// 추상클래스끼리 상속받는 경우, 자식클래스를 일반 구현 클래스에 상속해 줘야 함


// 추상 클래스
abstract class AbstractClass_B {
	
	// 추상 메소드
	abstract void Method01();

	// 일반 메소드
	void Method02() {
		System.out.println("Method02:  추상클래스에서 구현");
	}
}

// 자식 클래스(추상 클래스)
abstract class MiddleClass extends AbstractClass_B {
	
	// 메소드 오버라이딩: 부모클래스 내의 형식과 이름을 그대로 따르면서, 내용을 달리함
	// 자식 추상클래스에서 메소드 오버라이딩해도 되고,
	// 자식 추상클래스를 상속받는 일반구현 자식 클래스에서 메소드 오버라이딩 해도 됨
	void Method01() {
		System.out.println("Method01: 서브클래스에서 구현된 추상메소드");
	}

	public void Method03() {
		System.out.println("Method03: 추상클래스에서 구현");
	}
}

// 자식클래스(일반 구현 클래스)
// 추상클래스끼리 상속받는 경우, 자식클래스를 일반 구현 클래스에 상속해 줘야 함
class SubClass_B extends MiddleClass {
	
	// 자식 추상클래스에서 메소드 오버라이딩해도 되고,
	// 자식 추상클래스를 상속받는 일반구현 자식 클래스에서 메소드 오버라이딩 해도 됨
	void Method01(){	
		// 부모 추상클래스의 추상 메소드 Method01을 두곳중에서 한곳에서만 메소드 오버라이딩 하면 됨
	  	System.out.println("Method01: 서브클래스에서 구현된 추상메소드");
	}
}

// 메인 클래스
class AbstractTestB_Inherit_FromAbstract {
	
	public static void main(String args[]) {
		
		SubClass_B obj = new SubClass_B();
		
		obj.Method01();		// 메소드 오버라이딩 된 메소드가 호출됨
		obj.Method02();		// 조상 클래스로부터 상속받은 메소드를 호출
		obj.Method03();		// 조상 클래스로부터 상속받은 메소드를 호출
	}
}
