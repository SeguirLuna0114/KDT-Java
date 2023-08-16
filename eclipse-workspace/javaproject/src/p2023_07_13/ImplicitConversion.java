package p2023_07_13;
// 다른 위치의 파일을 가져올 경우, 패키지명을 추가(오류 라인 마커 더블클릭)

// 타입변환 - 자동 형 변환
// 자동 형변환 : 컴파일러가 자동으로 한 자료형을 다른 자료형 변환해주는 변환을 의미
// 자동 타입 변환이 되기 위해선, 작은 타입 변수-> 큰 타입 변수
// byte(1바이트) < short(2바이트) < int(4바이트=32비트) < long(8바이트) < float(4바이트) < double(8바이트)
// char(2바이트=16비트) => char -> int
public class ImplicitConversion {

    public static void main( String[] args ) {
    	
	// char 변수 선언 및 초기화.
	char charValue = 'a';
	System.out.println( "charValue = " + charValue );	// charValue = a
 
	// int 변수 선언 및 'a'의 값으로 초기화.
//	int intValueOfChar = charValue;
	int intValueOfChar = 'a';	// 자동 형변환: char(2) -> int(4)	
	System.out.println( "intValueOfChar = " + intValueOfChar );	// intValueOfChar = 97

	// int 변수 선언 및 초기화.
	int intValue = 30;
	System.out.println( "intValue = " + intValue );	// intValue = 30

	// float 변수 선언 및 intValue 변수 값 할당
//	float floatValue = intValue;
	float floatValue = 30;	// 자동 형변환: int(4) -> float(4)
	System.out.println( "floatValue = " + floatValue );	// floatValue = 30.0

	// double 변수 선언및 floatValue,intValue 변수 값 할당
	double doubleValue1 = floatValue;	// 자동 형변환: float(4) -> double(8)
	double doubleValue2 = intValue;		// 자동 형변환: int(4) -> double(8)
	System.out.println("doubleValue1 ="+doubleValue1);	// doubleValue1 =30.0
	System.out.println("doubleValue2 ="+doubleValue2);	// doubleValue2 =30.0

    }//main end
}//class end



