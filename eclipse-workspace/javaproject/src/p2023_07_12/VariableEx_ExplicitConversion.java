package p2023_07_12;

//자료형변환 - 강제형변환
// 자동 타입 변환이 되기 위해선, 작은 타입 변수-> 큰 타입 변수
// byte(1바이트) < short(2바이트) < int(4바이트=32비트) < long(8바이트) < float(4바이트) < double(8바이트)
// char(2바이트=16비트) => char -> int
public class VariableEx_ExplicitConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// int형 변수를 97로 초기화
		int intValue = 97;
		System.out.println("intValue = " + intValue); // intValue = 97
		
		// char형 변수에 int형 변수 값을 할당
//		char charValue = intValue;
//		System.out.println("charValue = "+ charValue); // int(32비트) > char(16비트)이기에, int -> char(x)

		// char형 변수에 int형 변수를 char형으로 변환 후 할당
		char charValue = (char)intValue;	//int타입을 char타입으로 강제 변환
		System.out.println("#int-typeValue to char-typeValue");
		System.out.println("charValue = "+ charValue); // charValue = a
		
		
		// float형 변수 초기화
		float floatValue = 3.14F;
		System.out.println("\nfloatValue = " + floatValue);	// floatValue = 3.14
		
		
		// int형 변수에 float형 변수 값을 할당
//		int intValue2 = floatValue;	// float(4바이트) > int(32비트) 이기에, float -> int(x)
//		System.out.println("intValue2 = " + intValue2);
		
		// int형 변수에 float형 변수 값을 int형으로 변환 후 할당
		int intValue2 = (int)floatValue;	// float타입을 int타입으로 강제 변환
		System.out.println("#float-typeValue to int-typeValue");
		System.out.println("intValue2 = " + intValue2);	// intValue2 = 3(소수점 이하 부분은 버려지고, 정수부분만 저장)
		
		
		// double형 변수 초기화
		double doubleValue = 21.12345;
		System.out.println("\ndoubleValue = " + doubleValue);	// doubleValue = 21.12345
		
		// float형 변수에 double형 변수 값을 할당
//		float floatValue2 = doubleValue;	// double(8바이트) > float(4바이트)이기에, double -> float(x)
//		System.out.println("floatValue2= " + floatValue2);	// double형에서 float형으로 형변환 불가
		
		
		// float형 변수에 double형 변수 값을 float형으로 변환 후 할당
		float floatValue2 = (float)doubleValue;	// double타입을 float타입으로 강제 변환
		System.out.println("#double-typeValue to float-typeValue");
		System.out.println("floatValue2= " + floatValue2);	// floatValue2= 21.12345
		
	}

}
