package p2023_07_26;

class TestClass {
	
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

class GenericTest01_int_args {
	
	public static void main(String[] args) {
		
		// TestClass 클래스의 객체(obj01)생성
		TestClass obj01 = new TestClass();

		// private 접근 제어자는 외부 클래스의 접근을 허용하지 않기에,
		// private로 선언된 member필드로 직접 접근 불가
//		obj01.member = 30;		// 오류 발생
		
		// 따라서, set메소드를 활용하여 우회적으로 private 필드에 접근O
		// setValue(int value)메소드 - 매개변수로 int값을 받음
		obj01.setValue(3);
		System.out.println("되돌리는 값은->" + obj01.getValue());
		// 되돌리는 값은->3
		
		// setValue()메소드 중, 매개변수로 double형을 받는 메소드X => 오류
		obj01.setValue(3.4);	// setValue메소드는 정수를 받도록 정의됨
		System.out.println("되돌리는 값은->" + obj01.getValue());
		
		// setValue()메소드 중, 매개변수로 String형을 받는 메소드X => 오류
		obj01.setValue("이해할 수 있다.");	// setValue메소드는 정수를 받도록 정의됨
		System.out.println("되돌리는 값은->" + obj01.getValue());
		
	}
}
