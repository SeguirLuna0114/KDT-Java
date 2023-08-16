package p2023_07_13;

// p78
// 서로 다른 자료형의 변수를 산술연산을 수행하면 큰 자료형으로
// 자동 형변환이 됨
public class CastingEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte value1 = 10;		// 1 byte
		int value2 = 100;		// 4 byte
		long value3 = 1000L;	// 8 byte
		long result1 = value1 + value2 + value3;	//가장 큰 자료형 long 타입으로 형 변환됨
		System.out.println(result1);	// 1110
		
		
		int i = 100;			// 4 byte
		double d = 3.14;		// 8 byte
		double result2 = i + d;
		System.out.println(result2); 	// 103.14
		
		// 1. 같은 자료형의 변수를 산술연산을 수행하면 같은 자료형으로 처리됨
		// 2. 서로다른 자료형의 변수를 산술연산 했을경우 큰 자료형으로 자동형변환 됨
		int total = 93;			// 4 byte
		System.out.println(total / 5);		// 18: 5(int형)이고, total(int형)이기에, 결과값 18.6이 int형으로 처리되어 출력됨
		System.out.println(total / 5.0);	// 18.6: 5.0(double형)이고, total(int형)이기에, 결과값은 더 큰 자료형 double형으로 처리되어 출력됨
		
		double result3 = total / 5;		// int형과 int형의 산술연산에 의해 int형 값(18)이 출력되었으나, double형으로 자동 형변환되어 18.0
		double result4 = total / 5.0;	// int형과 double형의 산술연산에 의해 double형 값이 출력됨
		System.out.println(result3);	// 18.0: 18로 처리된 result3값을 double형으로 자동 형변환하여 18.0으로 출력됨
		System.out.println(result4);	// 18.6: 18.6으로 처리된 double형 result4값이 출력됨
		
		
	}

}
