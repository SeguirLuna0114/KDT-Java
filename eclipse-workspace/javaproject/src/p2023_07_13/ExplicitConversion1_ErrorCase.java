package p2023_07_13;

//자료형변환 - 강제형변환
// 강제 형변환 : 프로그래머가 직접 자료형 변환을 해야되는 변환을 의미
// 형변환 연산자를 사용하여 한 자료형을 다른 자료형으로 명시적으로 변환
// 큰 자료형 데이터를 작은 자료형 변수에 저장하는 경우

//byte(1바이트) < short(2바이트) < int(4바이트=32비트) < long(8바이트) < float(4바이트) < double(8바이트)
//char(2바이트=16비트) => char -> int
public class ExplicitConversion1_ErrorCase {

    public static void main( String[] args ) {
    	
	// int형 변수를 97로 초기화
	int intValue = 97;
	
	// char(2바이트)형 변수에 int(4바이트)형 변수 값을 할당
//	char charValue = intValue;	// int(4) -(x)-> char(2)
	char charValue = (char)intValue;	// 강제 형변환: int -> char
	System.out.println( "charValue = " + charValue );	// charValue = a

	// char형은 정수형과 문자형 모두 처리 가능하기에, 97을 바로 할당 가능
	// 자바의 문자 데이터 타입인 char가 내부적으로 16비트(2바이트)의 0에서 65,535까지의 "부호 없는 정수"로 표현되기 때문
	// char 변수에 할당된 정수 값은 문자로 해석될 때 해당하는 유니코드 문자로 변환되어 출력
	// ex)char ch = 65;는 정수 65에 해당하는 유니코드 문자인 'A'를 ch에 할당
	char charValue2 = 97;	// char형에 정수값을 직접 할당하는 것 허용됨
	System.out.println( "charValue2 = " + charValue2 );	// charValue2 = a
	
	// float형 변수 초기화.
	float floatValue = 3.14F;
	
	// int(4바이트)형 변수에 float(4바이트)형 변수 값을 할당
//	int intValue2 = floatValue;	// float > int: float -(x)-> int
	int intValue2 = (int)floatValue;	// 강제 형변환: float -> int 
	System.out.println( "intValue2 = " + intValue2 );	// intValue2 = 3: 소수점 아래를 버림

	// float형 변수 초기화
	double doubleValue = 21.12345;
	
	// float(4바이트)형 변수에 double(8바이트)형 변수 값을 할당
//	float floatValue2 = doubleValue;	// double(8) -(x)-> float(4)
	float floatValue2 = (float)doubleValue;	// 강제 형변환: double -> float
	System.out.println( "floatValue3 = " + floatValue2 );	// floatValue3 = 21.12345

    }
}