package p2023_07_26;

// Wrapper 클래스 Integer
// - Integer객체가 문자열과 함께 사용할 경우, 자동으로 문자열로 변한됨

// - 자동박싱이 지원되기에, Integer클래스로 변수가 선언된 경우
//    int를 Integer 객체로 변환할 때 명시적인 new Integer() 생성자를 사용할 필요X

// - 자동 언박싱이 지원되기 때문에, Integer를 int로 변환할 때 
//   명시적인 .intValue() 메소드를 사용할 필요가 없음
class WrapperTestA_BoxUnBox_forbidden {
	
	public static void main(String[] args) {
		
		int n01 = 10;
		int n02;
		
		// Integer Wrapper 클래스로 변수 num01을 선언
		// num01은 선언되기만 하고, 아직 "객체가 생성되지 않음" => 아무런 값 갖지X
		Integer num01; // Integer 객체 생성
		
		// Integer Wrapper 클래스로 변수 num02를 선언하고,
		// 생성자를 이용하여 값을 20으로 초기화
		Integer num02 = new Integer(20);

		// 오토 박싱 - int데이터타입이 Integer객체로 자동 박싱됨
		// num01(Integer)에 n01(int)을 대입
		num01 = n01; 
		
		// 수동 박싱 시도 - int형(n01)을 Integer객체로 수동 박싱하려 함
		// 자동박싱이 지원되기에, Integer클래스로 변수가 선언된 경우
		// int를 Integer 객체로 변환할 때 명시적인 new Integer() 생성자를 사용할 필요X
//		num01 = new Integer(n01);

		// 오토 언 박싱 -  Integer 객체의 값이 int 데이터 타입으로 자동 언박싱
		// n02(int)에 num02(Integer)을 대입
		n02 = num02; 
		
		// 수동 언박싱 시도 - Integer 객체(num02)의 값을 int로 수동으로 언박싱 시도
		// 자동 언박싱이 지원되기 때문에, Integer를 int로 변환할 때 
		// 명시적인 .intValue() 메소드를 사용할 필요가 없음
//		n02   = num02.intValue();

		// Integer객체가 문자열과 함께 사용할 경우, 자동으로 문자열로 변한됨
		// num01은 Integer객체이지만, 문자열과 함께 사용시 자동으로 문자열로 변환됨
		System.out.println(n01 + ", " + num01);
		// num02는 Integer객체이지만, 문자열과 함께 사용시 자동으로 문자열로 변환됨
		System.out.println(n02 + ", " + num02);

	}
}
