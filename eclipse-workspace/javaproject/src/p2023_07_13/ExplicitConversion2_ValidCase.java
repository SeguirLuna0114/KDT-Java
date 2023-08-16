package p2023_07_13;

//자료형변환 - 강제형변환
//강제 형변환 : 프로그래머가 직접 자료형 변환을 해야되는 변환을 의미
//형변환 연산자를 사용하여 한 자료형을 다른 자료형으로 명시적으로 변환
//큰 자료형 데이터를 작은 자료형 변수에 저장하는 경우

//byte(1바이트) < short(2바이트) < int(4바이트=32비트) < long(8바이트) < float(4바이트) < double(8바이트)
//char(2바이트=16비트) => char -> int
public class ExplicitConversion2_ValidCase {

    public static void main( String[] args ) {
    	
    // int형 변수를 97로 초기화
    int intValue = 97;

    // int형 변수 값을 char형으로 변환 후 할당
    char charValue = ( char )intValue;	// 강제 형변환: int -> char
    System.out.println( "charValue = " + charValue );	// charValue = a

    // float형 변수 초기화.
    float floatValue = 3.14F;

    // float형 변수 값을 int형으로 변환 후 할당
    int intValue2 = ( int )floatValue;	// 강제 형변환: float -> int 
    System.out.println( "intValue2 = " + intValue2 );	// intValue2 = 3: 소수점 아래를 버림

    // float형 변수 초기화
    double doubleValue = 21.12345;
    
    // double형 변수 값을 float형으로 변환 후 할당
    float floatValue2 = ( float )doubleValue;	// 강제 형변환: double -> float
    System.out.println( "floatValue2 = " + floatValue2 );	// floatValue3 = 21.12345

    }
}