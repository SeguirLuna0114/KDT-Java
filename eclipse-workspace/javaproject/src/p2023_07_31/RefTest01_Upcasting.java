package p2023_07_31;

// 레퍼런스 형변환(Reference Type Casting)
// -두 클래스 사이에 상속관계가 있어야 함
// # 업캐스팅(Upcasting)(자동 형변환)
// 1. 서브클래스에서 슈퍼클래스로 형변환 하는것
// 2. 참조 가능한 영역이 축소가 된다.(업 캐스팅 후에는 부모로부터 상속받은 메서드만 호출할 수 있음)
// 3. 컴파일러에 의해서 암시적 형변환(자동 형변환) 된다.
// " 자식클래스의 객체를 부모클래스의 참조 변수에 할당하는 것"

// 부모 클래스
class Parent {
	public void parentPrn() {
		System.out.println("슈퍼 클래스 : ParentPrn 메서드");
	}
}

// 자식클래스 (두 클래스 사이에 상속관계가 형성됨)
class Child extends Parent {

	public void childPrn() {
		System.out.println("서브 클래스 : ChildPrn 메서드");
	}
}

class RefTest01_Upcasting {
	
	public static void main(String[] args) {
		
		// 일반적인 객체 생성과 참조변수 할당
		// 자식클래스의 객체를 생성하여 Child클래스 타입의 참조변수 c에 객체를 할당
		Child c = new Child();

		// 자식클래스에서 부모클래스의 메소드를 상속받아 사용
		c.parentPrn();
		// 자식클래스(본인클래스)에서 정의한 메소드 사용
		c.childPrn();
		
		// 업캐스팅 방법
		// 1. 부모 클래스의 객체 선언 -> 자식클래스의 객체를 부모클래스의 객체에 할당
		// 부모 클래스의 객체를 선언
		Parent p;
		// 자식클래스의 객체 c를 부모클래스의 객체 p에 할당(업캐스팅)
		p = (Parent) c; // 암시적으로 업 캐스팅이 일어남
		p = c; // 컴파일러가 자동으로 형변환 해주기에, (Parent)자료형 생략 가능
		
		// 2. 자식클래스의 객체의 주소를 바로 부모클래스의 참조변수에 할당
		Parent p1 = new Child();
		
		// 업 캐스팅 후에는 부모로부터 상속받은 메서드만 호출할 수 있음
		// 참조 가능한 영역이 축소되었기 때문
		p.parentPrn(); 
//		p.childPrn(); //컴파일 에러가 발생하게 된다. 
	
	}
}