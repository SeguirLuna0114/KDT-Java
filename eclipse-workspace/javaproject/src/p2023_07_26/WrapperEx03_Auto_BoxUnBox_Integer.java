package p2023_07_26;

// 자동 박싱(AutoBoxing)
// : 기본 데이터 타입 값을 해당 Wrapper클래스 객체로 "자동" 형변환

// 자동 언박싱(Auto-unboxing)
// : Wrapper클래스 객체를 해당하는 기본 데이터타입으로 자동 변환
// - Integer 클래스의 객체인 obj를 int변수에 할당 => 자동 언박싱 발생
// - Integer 클래스의 객체인 obj와 문자열과 함께 사용되면, 자동으로 문자열로 변환됨
// - int와 Integer 타입이 연산되는 경우, Integer 타입의 값이 자동으로 int로 변환

public class WrapperEx03_Auto_BoxUnBox_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 박싱 - new연산자를 사용해 Integer객체 생성
		Integer ob = new Integer(100);	// 박싱
		
		// 자동 박싱(AutoBoxing)
		// int값을 Integer객체로 자동 변환하여 Integer객체의 변수에 저장
		// int값(100)을 Integer객체에 대입할 때, 자동박싱이 발생함
		Integer obj = 100;				// 자동 박싱
		
		// 자동 언박싱(Auto-unboxing)
		// Integer객체(obj)에 저장된 값(int 100)을 
		// int변수(value1)에 대입할 때 자동 언박싱 이루어짐
		// Integer클래스 객체 값 -> int형 변수에 할당
		int value1 = obj.intValue();	// 언박싱
		System.out.println("언박싱: "+obj.intValue());
		
		// Integer 클래스의 객체인 obj를 int변수에 할당 => 자동 언박싱 발생
		int value2 = obj;				// 자동 언박싱
		
		// Integer 클래스의 객체인 obj와 문자열과 함께 사용되면, 자동으로 문자열로 변환됨
		System.out.println("자동 언박싱: "+obj);
		
		// int와 Integer 타입이 연산되는 경우, Integer 타입의 값이 자동으로 int로 변환
		// Integer 클래스의 객체인 obj를 int변수에 할당 => 자동언박싱 발생
		// int형으로 변환된 obj와 정수 100과의 연산이 가능 => 100+100=200
		int result = obj + 100;			// 자동 언박싱
		System.out.println("result: "+result);
	}

}
