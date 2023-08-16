package p2023_07_26;

// p502
// 문자열을 기본 자료형으로 변환하는 프로그램: "20" -> 20
// parseXxx()메소드 : "문자열"을 해당하는 기본 데이터 타입으로 변환
// - Integer.parseInt()메소드 : 문자열 -> int(정수)로 변환
//
// - Double.parseDouble()메소드 : 문자열 -> double(부동소수점값)으로 변환
//
// - Boolean.parseBoolean()메소드: 문자열 -> boolean(논리형)으로 변환
//	 -문자열의 대소문자는 무시
//	 -true 또는 false와 같은 키워드가 아니면(논리값이 아니면) false로 처리

public class WrapperEx05_String_To_parseMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Integer.parseInt()메소드 : 문자열 -> int(정수)로 변환
		int value1 = Integer.parseInt("10");	// "10" -> 10
		
		// Double.parseDouble()메소드 : 문자열 -> double(부동소수점값)으로 변환
		double value2 = Double.parseDouble("3.14");
		
		// Boolean.parseBoolean()메소드: 문자열 -> boolean(논리형)으로 변환
		// -문자열의 대소문자는 무시 
		// -true 또는 false와 같은 키워드가 아니면(논리값이 아니면) false로 처리
		boolean value3 = Boolean.parseBoolean("true");
		boolean value4 = Boolean.parseBoolean("TRUE");
		boolean value5 = Boolean.parseBoolean("TEST");
		
		System.out.println("value1: "+value1);	// value1: 10
		System.out.println("value2: "+value2);	// value2: 3.14
		System.out.println("value3: "+value3);	// value3: true
		System.out.println("value4: "+value4);	// value4: true
		
		// "TEST"라는 문자는 논리값X
		// => boolean형으로 형변환X => false로 처리됨
		System.out.println("value5: "+value5);	// value5: false

	}

}
