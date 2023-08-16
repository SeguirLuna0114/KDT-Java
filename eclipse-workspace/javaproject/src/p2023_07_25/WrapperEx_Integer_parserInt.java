package p2023_07_25;

// Wrapper 클래스 : 다른 데이터타입을 감싸서(래핑하여) 새로운 객체를 만드는 클래스
// - Integer 클래스: int에 대응되는 클래스. 정수 값을 포함하고 처리
//	기본생성자 형태를 지원하지 않음 => 기본생성자 형태로 객체 생성시 오류 발생

// # Wrapper클래스의 Integer클래스 메소드
// Integer.MAX_VALUE: 데이터 타입의 최대값을 나타내는 상수
// Integer.MIN_VALUE: 데이터 타입의 최소값을 나타내는 상수

// Integer.parserInt(String s) 메서드: 문자열을 정수(int)로 변환하는 정적 메서드

// Integer.toBinaryString()메소드: 10진수를 2진수로 변환
// Integer.toOctalString() : 10진수를 8진수로 변환
// Integer.toHexString() : 10진수를 16진수로 변환
public class WrapperEx_Integer_parserInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int형 변수의 최대값과 최소값
		System.out.println("max= "+Integer.MAX_VALUE);
		// max= 2147483647
		System.out.println("min= "+Integer.MIN_VALUE);
		// min= -2147483648
		
		// String형을 int형으로 형변환 : "20" -> 20
		int n = Integer.parseInt("20");	// "20"
		System.out.println(n);			// 20 (정수)
		// 정수이기에, 산술연산이 가능함
		System.out.println(n+10);		// 30 = 20 + 10
		
		// Integer.parseInt(String s)메소드에서
		// String s는(메소드 안에는) 숫자로 형변환이 가능한 문자만 사용해야 함
		// (ASCII코드 사용 불가)
//		int n2 = Integer.parseInt("a");		// 문자 a는 숫자로 변환X => 오류
		
		
		// Integer.toBinaryString()메소드: 10진수를 2진수로 변환
		System.out.println("2진수: "+Integer.toBinaryString(10));
		// 2진수: 1010
		
		// Integer.toOctalString() : 10진수를 8진수로 변환
		System.out.println("8진수: "+Integer.toOctalString(10));
		// 8진수: 12
		
		// Integer.toHexString() : 10진수를 16진수로 변환
		System.out.println("16진수: "+Integer.toHexString(10));
		// 16진수: a
		
		// 기본생성자 형태를 지원하지 않음 => 기본생성자 형태로 객체 생성시 오류 발생
//		Integer integer = new Integer();
		
	}

}
