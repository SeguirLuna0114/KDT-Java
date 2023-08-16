package p2023_07_13;

// p74 예제
// 자동 형변환
// 허용 범위 순: byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
// char(2): 부호없는 2바이트 정수 타입
// short(2): 부호 있는 2바이트 정수 타입
public class PromotionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// byte(1바이트) -> int(4바이트)
		byte byteValue = 10;
		int intValue = byteValue;	// 자동 형변환: byte(1바이트) -> int(4바이트)
		System.out.println("intValue: " + intValue);	// intValue: 10
				
		// char(2바이트) -> int(4바이트)
		char charValue = '가';
		intValue = charValue;	// 자동 형변환: char(2바이트) -> int(4바이트)
		// (자바에서 변수의 재할당이 가능(덮어 씌워짐) => intValue가 중복 사용되어도 괜찮음)
		System.out.println("'가'의 유니코드: " + intValue);	// '가'의 유니코드: 44032
		// 유니코드는 세계 각국의 문자를 2바이트로 표현할 수 있는 숫자(0~65535)로
		// 매핑한 국제 규약		
		
		// 음수 short(2바이트) -> char(2바이트)
		short shortValue = -100;
//		charValue = shortValue;	// 음수의 경우, char 타입은 부호가 없기에, 강제형변환을 해줘야 함
		charValue = (char)shortValue;	// 강제 형변환: short -> char
		System.out.println("charValue: "+ charValue);	// charValue: ﾜ
		
		// int(4바이트) -> long(8바이트)
		intValue = 50;
		// 변수 타입을 이미 선언하였기에, (이전 선언된 타입과 일치한다면) 다시 선언할 필요X
		long longValue = intValue;	// 자동 형변환: int(4바이트) -> long(8바이트)
		System.out.println("longValue: " + longValue);	// longValue: 50

		// long(정수형, 8바이트) -> float(실수형, 4바이트)
		longValue = 100;
		float floatValue = longValue;	// 자동 형변환: long(8바이트) -> float(4바이트)
		System.out.println("floatValue: " + floatValue);	// floatValue: 100.0
		
		// float(4바이트) -> double(8바이트)
		floatValue = 100.5F;
		double doubleValue = floatValue;	// 자동 형변환: float(4바이트) -> double(8바이트)
		System.out.println("doubleValue: " + doubleValue);	// doubleValue: 100.5
	
	}

}
