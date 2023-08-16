package p2023_08_02;

// Object 데이터 타입 - 모든 데이터 타입을 다룰 수 있음 

//자동박싱 & 업캐스팅
// -자동박싱 : 자동으로 기본 데이터타입값을 Wrapper클래스로 변환하여 Object클래스 타입 변수로 할당
// -업캐스팅 : Wrapper클래스 객체가 Object클래스 타입 변수로 할당됨. 
//			이때 Object클래스는 최상위 클래스로 모든 자식클래스 객체 저장 가능
class TestClass2 {
// default제어자로 선언된 class의 경우, 같은 패키지 내에서class명 중복 불가

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

class GenericTest02_Object_DataType {

	public static void main(String[] args) {

		// TestClass2 클래스의 객체(obj01)생성
		TestClass2 obj01 = new TestClass2();

		// 업캐스팅(자동 형변환): 자식객체를 만들어 부모에게 전달

		// new연산자를 사용해 박싱이 발생
		// + 업캐스팅(Integer 객체를 Object 클래스 타입으로 업캐스팅)
		// * Object클래스는 모든 클래스의 최상위 클래스이기에, 모든 자식 클래스의 객체 저장 가능
//		Object value = new Integer(3);
		// - new Integer(3): Integer클래스의 생성자호출 => 정수3을 갖게 초기화
		// - Object value = : 생성된 Integer객체를 Object클래스 타입의 변수 value에 할당

		// 자동박싱 & 업캐스팅
//		Object value = 3;		// Object value = Integer.valueOf(3);
		// int형(3)값을 Object형 변수(value)에 할당
		// -자동박싱 : 자동으로 기본 데이터타입(int)값을 (Integer)Wrapper클래스로 변환하여 Object클래스 타입 변수로 할당
		// -업캐스팅 : Integer객체가 Object클래스 타입 변수로 할당됨. 이때 Object클래스는 최상위 클래스로 모든 자식클래스 객체
		// 저장 가능
		

		// 자동박싱 + 업캐스팅
		// -자동박싱 : 자동으로 기본 데이터타입(int)값을 (Integer)Wrapper클래스로 변환하여 Object클래스 타입 변수로 할당
		// -업캐스팅 : Integer객체가 Object클래스 타입 변수로 할당됨.
		obj01.setValue(3);
		System.out.println("되돌리는 값은->" + obj01.getValue());

		// method앞의 자료형이 Object인 경우
		// 다운 캐스팅 + 언박싱
		// getValue()메소드로 반환된 Object 타입의 값을 int 데이터 타입으로 변환
		// -다운 캐스팅: ((Integer)(obj01.getValue()))
		// 반환되는 데이터 타입은 Object타입이지만, 실제 값은 Integer클래스 객체이기에,
		// 원래 자료형인 Integer로 다운 캐스팅 수행
		// -언박싱: .intValue()
		// Integer객체에서 intValue()메소드를 호출해 Integer객체가 감싸고 있는 int값으로 언박싱
		int n1 = ((Integer) (obj01.getValue())).intValue();

		// 다운 캐스팅 + 자동 언박싱
		// -자동 언박싱: Integer객체가 int타입의 변수에 할당되어 자동으로 Integer객체가 int값으로 언박싱됨
		int n2 = ((Integer) (obj01.getValue()));

		// 박싱(new연산자를 사용)
		// + 업캐스팅(Double 객체를 Object 클래스 타입으로 업캐스팅)
		// * Object클래스는 모든 클래스의 최상위 클래스이기에, 모든 자식 클래스의 객체 저장 가능
//		Object value = new Double(3.4); // 박싱 + 업캐스팅

		// 자동박싱 & 업캐스팅
//		Object value = 3.4; // 자동박싱 + 업캐스팅
		// double형(3.4)값을 Object형 변수(value)에 할당
		// -자동박싱 : 자동으로 기본 데이터타입(double)값을 (Double)Wrapper클래스로 변환하여 Object클래스 타입 변수로 할당
		// -업캐스팅 : Double객체가 Object클래스 타입 변수로 할당됨.

		
		// 자동박싱 + 업캐스팅
		// -자동박싱 : 자동으로 기본 데이터타입(double)값을 (Double)Wrapper클래스로 변환하여 Object클래스 타입 변수로 할당
		// -업캐스팅 : Double객체가 Object클래스 타입 변수로 할당됨.
		obj01.setValue(3.4);
		System.out.println("되돌리는 값은->" + obj01.getValue());
		// get()메소드를 통해 반환되는 값은 Object타입이기에, 실수로 사용하기 위해서는
		// 다운캐스팅 + 언박싱이 필요

		// method앞의 자료형이 Object인 경우
		// getValue()메소드로 반환된 Object 타입의 값을 double 데이터 타입으로 변환
		// -다운 캐스팅: ((Integer)(obj01.getValue()))
		// 반환되는 데이터 타입은 Object타입이지만, 실제 값은 Double클래스 객체이기에,
		// 원래 자료형인 Double로 다운 캐스팅 수행
		// -언박싱: .doubleValue()
		// Double객체에서 doubleValue()메소드를 호출해 Double객체가 감싸고 있는 double값으로 언박싱
		double d1 = ((Double) (obj01.getValue())).doubleValue(); // 언박싱

		// 다운 캐스팅 + 자동 언박싱
		// -자동 언박싱: Double객체가 double타입의 변수에 할당되어 자동으로 Double객체가 double값으로 언박싱됨
		double d2 = ((Double) (obj01.getValue())); // 언박싱

		// 자동박싱(문자열 -> Object타입) + 업캐스팅 발생
		// -자동박싱 : 자동으로 String타입의 값을 해당하는 Wrapper클래스로 변환하여 Object클래스 타입 변수로 할당
		// -업캐스팅 : String객체가 Object클래스 타입으로 할당됨.
		obj01.setValue("이해할 수 있다.");
		// get()메소드를 통해 반환된 값은 String객체가 되고, 이때 String객체의 toString()메소드를 호출하여 문자열로 변환
		System.out.println("되돌리는 값은->" + obj01.getValue());
		// get()메소드를 통해 반환되는 값은 Object타입이기에 필요 형태로 캐스팅해 사용해야 함

	}
}
