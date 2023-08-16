package p2023_07_31;

//* 다운 캐스팅(강제 형변환)
//: 기본 클래스의 객체를 파생 클래스 타입으로 형변환하는 것
//	"부모 클래스의 참조변수를 자식 클래스 타입으로 형변환하는 것"
//
// 1. 슈퍼클래스에서 서브클래스로 형변환 하는것
// 2. 참조 가능한 영역이 확대가 된다.
// 3. 컴파일러에 의해서 암시적 형변환(자동 형변환)이 되지 않기    
//    때문에 자료형을 생략할 수 없다.(강제 형변환)

// 부모클래스
class Parent02 {
	
	public void parentPrn() {
		System.out.println("슈퍼 클래스 : ParentPrn 메서드");
	}
}

// 상속받는 자식클래스(두 클래스 사이 상속관계 형성됨)
class Child02 extends Parent02 {
	
	public void childPrn() {
		System.out.println("서브 클래스 : ChildPrn 메서드");
	}
}

class RefTest02_DownCast_Error {
	
	public static void main(String[] args) {
		
		// 다운캐스팅을 하기 위해선, 자식클래스의 객체 생성 -> 상위 클래스로 업 캐스팅 한 후
		// 다시 다운캐스팅을 해야 함
		
		// 부모클래스 -> 자식클래스 (다운캐스팅)
		Parent02 p = new Parent02();	// 부모객체 p
		
		// 자식클래스의 객체를 가리킬 참조변수를 선언했지만, 아직 객체를 생성하지 않았기에
		// 주소값은 할당되지X => null로 초기화 됨
		Child02 c;						// 주소값을 가지지 못한 상태
		
		// 서브 클래스형 레퍼런스 변수에 슈퍼 클래스의 레퍼런스 값을 대입하면
		// 부모 객체 p를 자식 객체c에 전달하여 다운캐스팅 시도
		// But, 컴파일 에러가 발생(다운캐스팅 불가능)
		// 		=> 다운캐스팅은 실제로 부모 객체가 자식 객체로 할당된 경우에만 가능
		//			이 경우, p는 Parent02클래스의 객체를 참조하고, 실제 child02클래스 객체가 아님
		c = (Child02) p; // 이를 DownCasting 이라하는데 컴파일러 에러가 발생한다.
		
		
		c.parentPrn(); // 2개의 메소드 모두 호출 안됨.
		c.childPrn();
	}
}