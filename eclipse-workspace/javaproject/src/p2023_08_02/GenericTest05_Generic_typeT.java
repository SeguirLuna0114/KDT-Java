package p2023_08_02;

//* 제네릭(Generic): 자료구조에 한가지 자료형의 데이터만 저장 하도록 해주는 역할

// 제네릭 타입 매개변수 T를 도입하여, 타입에 대한 제한 없이 다양한 데이터 타입을 지원하는 범용적인 클래스로 확장
// - T(Type): 클래스나 메소드를 정의할 때 실제로 사용할 타입을 나타내는 역할
// - 타입 매개변수화(Parametric Polymorphism): T를 사용하여 클래스나 메서드를 정의하면, 
// 	  해당 클래스나 메서드에서는 T가 실제로 사용되는 곳에서 사용된 타입으로 대체되어 동작
class GenericClass<T> {
	
	// 제네릭타입'T': 클래스가 생성될 때 실제로 사용될 타입으로 대체되는 타입 매개변수
	//	- 해당 클래스가 객체 생성시, 어떤 타입으로 사용할 지 결정 가능
	private T member;

	public void setValue(T value) {
		// 매개변수로 전달된 값을 멤버변수에 저장
		member = value;
	}

	public T getValue() {
		// 멤버변수에 저장된 값 반환
		return member;
	}
}

// GenericClass클래스의 객체를 각각 int, double, string타입으로 생성하여
class GenericTest05_Generic_typeT {
	
	public static void main(String[] args) {
		
		// 생성자 호출 시 직접 타입 매개변수를 명시하는 방법
		// Diamond 연산자"를 사용하여 객체를 생성하는 방법
//		GenericClass<Double> obj01 = new GenericClass<>();
		
		// GenericClass 클래스를 Double 타입으로 인스턴스화하여 obj1객체 생성
		GenericClass<Double> obj01 = new GenericClass<Double>();
		obj01.setValue(3.4);	// 값 저장
		System.out.println("되돌리는 값은->" + obj01.getValue());	// 값 출력

		// GenericClass 클래스를 Integer 타입으로 인스턴스화하여 obj2객체 생성
		GenericClass<Integer> obj02 = new GenericClass<Integer>();
		obj02.setValue(new Integer(10));
		System.out.println("되돌리는 값은->" + obj02.getValue());

		// GenericClass 클래스를 String 타입으로 인스턴스화하여 obj03 객체를 생성
		GenericClass<String> obj03 = new GenericClass<String>();
		obj03.setValue("이해할 수 있다.");
		System.out.println("되돌리는 값은->" + obj03.getValue());
	}
}