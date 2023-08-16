package p2023_08_02;

// * 제네릭(Generic): 자료구조에 한가지 자료형의 데이터만 저장 하도록 해주는 역할
// 제네릭을 사용하지 않았을 경우
//- 여러 자료형의 데이터를 저장할 수 있음
//- 모든 데이터가 Object로 업캐스팅 되기 때문에, 컴파일러가 데이터타입을 확인X
//- 데이터를 꺼낼 때마다, 데이터 타입에 맞게 다운캐스팅을 수행해야 함

// 제네릭을 사용하면 이러한 제한을 없앨 수 있으며, 
// 여러 종류의 데이터 타입을 지원하는 범용적인 클래스로 확장 가능
class TestClass01 {
	
	// 필드 - 변수이기에, 값을 저장하는 역할 수행
	// private 접근 제어자는 외부 클래스의 접근을 허용하지 않기에,
	// private로 선언된 member필드로 직접 접근 불가
	private int member;

	// set메소드 - 필드값 설정
	public void setValue(int value) {
		// 매개변수로 받은 값을 member필드에 저장 => 필드값 설정
		member = value;
	}

	// get메소드 - set메소드로 변경한 값을 반환
	public int getValue() {
		// member필드에 저장된 값 반환
		// -private필드에 직접 접근 불가하기에, get메소드 사용
		return member;
	}
}

class GenericTest01_intCase {
	
	public static void main(String[] args) {
		
		// TestClass01 클래스의 객체(obj01)생성
		TestClass01 obj01 = new TestClass01();
		// 제네릭을 사용하지않았기에, TestClass01은 오직 int타입만 저장&반환 가능
		// => 정수 데이터에만 제한적으로 사용됨
		// 제네릭을 사용하면 이러한 제한을 없앨 수 있으며, 여러 종류의 데이터타입을 지원 가능
		
		// private 접근 제어자는 외부 클래스의 접근을 허용하지 않기에,
		// private로 선언된 member필드로 직접 접근 불가
//		obj01.member = 30;		// 오류 발생
		
		// obj01의 member 변수에 정수 값인 3을 설정
		obj01.setValue(3);
		System.out.println("되돌리는 값은->" + obj01.getValue());
		
		// TestClass01 클래스는 int 타입만을 지원하므로 컴파일 에러가 발생
		obj01.setValue(3.4);
		System.out.println("되돌리는 값은->" + obj01.getValue());
		
		// TestClass01 클래스는 int 타입만을 지원하므로 컴파일 에러가 발생
		obj01.setValue("이해할 수 있다.");
		System.out.println("되돌리는 값은->" + obj01.getValue());
	}
}
