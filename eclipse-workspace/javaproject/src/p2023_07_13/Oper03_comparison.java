package p2023_07_13;

// 비교 연산자: >, >=, <, <=, ==, !=
// 비교 연산자의 결과가 참이면 true, 거짓이면 false
public class Oper03_comparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 기본 자료형 => 지역변수(class내에)이기에, heap메모리 영역에 따로 저장됨
		int num1 = 10;
		int num2 = 10;
		
		boolean result1 = (num1 == num2);	// 기본자료형 int는 주소값이 서로 같음 => result1: true
		boolean result2 = (num1 != num2);	// result2: false
		boolean result3 = (num1 <= num2);	// result3: true
		
		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);
		System.out.println("result3: " + result3);
		
		System.out.println(num1 < num2);	// false
		
		char c1 = 'A';		// 65(10진수 아스키코드 값)
		char c2 = 'B';		// 66
		boolean result4 = (c1 < c2);
		System.out.println("result4: " + result4);	// result4: true
		
		
	}

}
