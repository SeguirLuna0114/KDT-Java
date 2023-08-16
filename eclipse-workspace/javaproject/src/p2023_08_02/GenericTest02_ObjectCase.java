package p2023_08_02;

// Object 데이터 타입 - 모든 데이터 타입을 다룰 수 있음 
// - Object클래스는 모든 클래스의 최상위 클래스이기에, 모든 자식 클래스의 객체 저장 가능
class TestClass02 {
	
	// 필드 - 변수이기에, 값을 저장하는 역할 수행
	// private 접근 제어자는 외부 클래스의 접근을 허용하지 않기에,
	// private로 선언된 member필드로 직접 접근 불가
	private Object member;

	// set메소드 - 필드값 설정(매개변수로 받은 값을 member필드에 저장)
	// Object형으로 매개변수를 받을 경우, 모든 데이터타입을 매개변수로 받을 수 있음
	public void setValue(Object value) {
		member = value;
	}

	// get메소드 - set메소드로 변경한 값을 반환
	// -private필드에 직접 접근 불가하기에, get메소드 사용
	public Object getValue() {
		// Object타입으로 값을 반환 => 이후, 필요한 형태로 캐스팅 해야 함
		return member;
	}
}

class GenericTest02_ObjectCase {
	
	public static void main(String[] args) {
		
		// Object value = new Integer(3);	// 박싱 + 업캐스팅
		// Object value = 3;				// 자동박싱 + 업캐스팅
		
		// TestClass2 클래스의 객체(obj01)생성
		TestClass02 obj01 = new TestClass02();
		
		// int -> Object형으로 업캐스팅
		obj01.setValue(3);
		System.out.println("되돌리는 값은->" + obj01.getValue());

		// double -> Object형으로 업캐스팅
		obj01.setValue(3.4);
		System.out.println("되돌리는 값은->" + obj01.getValue());

		// String -> Object형으로 업캐스팅
		obj01.setValue("이해할 수 있다.");
		System.out.println("되돌리는 값은->" + obj01.getValue());

	}
}
