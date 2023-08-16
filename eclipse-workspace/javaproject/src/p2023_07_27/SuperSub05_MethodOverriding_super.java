package p2023_07_27;

// #메소드 재정의(Method Overriding)
//	: 부모 클래스로부터 상속받은 메소드를 자식 클래스에서 재정의하며 사용하는 것
// 1. 자식 클래스로 객체 생성한 후, 메소드를 호출하면 메소드 오버라이딩 된 자식메소드만 호출됨
// 2. 부모클래스의 상속해주는 메소드는 더 이상 사용할 수 없는 은닉 메소드가 됨
// 3. 부모 클래스의 은닉된 메소드를 사용하기 위해서는 
//	  자식클래스의 메소드 내에서 "super.은닉메소드명" 형식을 통해 호출해서 사용가능

// 1. 부모클래스
class Parent_05 {
	
	// 자식메소드에서 메소드재정의 했기에, 은닉메소드가 됨
	public void parentPrn() {
		System.out.println("슈퍼 클래스 : ParentPrn 메서드");
	}
}

// 2. 자식클래스
//Parent를 슈퍼 클래스로 하는 서브 클래스 Child 정의 
class Child_05 extends Parent_05 {
	// 슈퍼 클래스에 있는 ParentPrn 메서드를 오버라이딩하면
	// Child로 선언된 객체는 슈퍼 클래스의 메서드가 은닉되어 상속 받지 못하게 된다.
	
	// 메소드 오버라이딩(메소드 재정의)
	// 부모클래스 내의 "메소드 이름"과 "형식"이 같은 경우
	public void parentPrn() {
		// 메소드 내용은 달라야 함(재정의 된 것)
		// super키워드를 통해 은닉된 부모메소드 호출 가능
		super.parentPrn();
		System.out.println("서브 클래스 : ParentPrn 메서드");
	}

	public void childPrn() {
		System.out.println("서브 클래스 : ChildPrn 메서드");
	}
}

// 3. 메인 클래스
class SuperSub05_MethodOverriding_super {
	
	public static void main(String[] args) {
		
		// 자식클래스로 객체 생성
		Child_05 c = new Child_05(); // 서브 클래스로 객체를 생성
		
		// 자식클래스에서 메소드 오버라이딩 되었기에, 자식클래스에서 재정의된 메소드 호출
		c.parentPrn(); // 오버라이딩된 서브 클래스의 메서드 호출
		c.childPrn(); // 서브 클래스 자기 자신의 메서드 호출
		
		System.out.println("-------------------------------------------->> ");
		
		// 부모클래스로 객체 생성
		Parent_05 p = new Parent_05(); // 슈퍼 클래스로 객체를 생성
		// 부모클래스의 메소드 호출
		p.parentPrn(); // 슈퍼 클래스(자기 자신)의 메서드 호출
	}
}
