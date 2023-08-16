package p2023_07_27;

//상속 - 클래스 3개 필요(부모/자식/메인)
//- 부모클래스의 "메소드"는 자식 클래스에게 상속됨

// - 부모클래스가 자식클래스에게 상속해주는것만 가능
//  (부모클래스가 자식클래스 내의 필드나 메소드에 접근X)
//   => 메인메소드에서 부모클래스의 객체 생성하는 것은 의미X
//   따라서, 자식클래스의 객체를 생성해야 함

// 1. 부모클래스
class Parent {
	
	// parentPrn()메소드
	public void parentPrn() {
		
		System.out.println("슈퍼 클래스 메서드는 상속된다.");
	}
	
}

// 2. 자식클래스
//Parent를 슈퍼 클래스로 하는 서브 클래스 Child 정의 
class Child extends Parent {
	// 자식클래스(Child클래스)는 부모클래스(Parent클래스)를 상속받음
	// => Parent클래스의 모든 멤버(메소드, 필드)를 상속받음
	
	// childPrn()메소드
	public void childPrn() {
		
		System.out.println("서브 클래스 메서드는 슈퍼가 사용 못한다.");
	}
	
}

// 3. 메인클래스
class SuperSub01_Inheritance_SubclassObject {
	
	// 상속에서는, 메인메소드에서 자식클래스의 객체를 생성 => 부모클래스의 필드, 메소드에 접근
	public static void main(String[] args) {
		
		// 자식클래스로 객체 생성시, 부모클래스로부터 상속받은 멤버(메소드, 필드)도 사용 가능
		// 자식클래스의 멤버(메소드, 필드)도 모두 사용 가능
		Child c = new Child(); 	// 서브 클래스로 객체를 생성
		
		c.parentPrn(); 			// 슈퍼 클래스에서 상속 받은 메서드 호출
		c.childPrn(); 			// 서브 클래스 자기 자신의 메서드 호출
		
		System.out.println("-------------------------------------->> ");
		
		// 부모클래스로 객체 생성시, 부모클래스의 멤버(필드, 메소드)만 사용 가능
		// 자식클래스의 멤버(필드, 메소드)는 사용X
		Parent p = new Parent(); 	// 슈퍼 클래스로 객체 생성
		
		p.parentPrn(); 				// 슈퍼 클래스 자기 자신의 메서드 호출
//		p.childPrn( ); 			//서브 클래스 메서드는 가져다 사용 못함
	
	}
}