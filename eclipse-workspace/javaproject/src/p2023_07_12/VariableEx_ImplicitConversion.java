package p2023_07_12;

// 자료형변환 - 자동형변환(묵시적변환)
public class VariableEx_ImplicitConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// char 변수 선언 및 초기화
		char charValue = 'a';
		System.out.println("charValue = " + charValue);	// charValue = a
		
		// int 변수 선언 및 charValue 변수 값 할당
		int intValueOfChar = charValue;	// char('a') -> int
		System.out.println("intValueOfChar = " + intValueOfChar);	// intValueOfChar = 97
		
		// float 변수 선언 및 intValueOfChar 변수 값 할당
		float floatValueOfint = intValueOfChar;	// int(97) -> float
		System.out.println( "floatValueOfint = " + floatValueOfint );		// floatValueOfint = 97.0
		
		// double 변수 선언및 floatValue,intValue 변수 값 할당
		double doubleValue1 = floatValueOfint;	// float(97.0) -> double
		double doubleValue2 = intValueOfChar;	// int(97) -> double
		System.out.println("doubleValue1 =" + doubleValue1);	// doubleValue1 =97.0
		System.out.println("doubleValue2 =" + doubleValue2);	// doubleValue2 =97.0
		
	}

}
