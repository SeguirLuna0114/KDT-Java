package p2023_07_13;

// 산술 연산자: +, -, *, /(몫), %(나머지)
// int형과 int형을 산술연산 수행하면, 결과는 int형으로 처리됨
public class Oper01_arithmetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int 변수 선언
		int a=10, b=3, c;
		
		c = a + b;	// a+b 연산결과를 c변수에 저장
		System.out.println("a + b = " + c);			// a + b = 13(c는 int형)
		System.out.println("a + b = " + (a + b));	// a + b = 13
		System.out.println("a - b = " + (a - b));	// a - b = 7
		System.out.println("a * b = " + (a * b));	// a * b = 30
		System.out.println("a / b = " + (a / b));	// a / b = 3(몫)
		System.out.println("a % b = " + (a % b));	// a % b = 1(나머지)
		
		
	}

}
