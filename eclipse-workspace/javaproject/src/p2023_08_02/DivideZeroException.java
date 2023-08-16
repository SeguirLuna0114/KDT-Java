package p2023_08_02;

// ArithmeticException: / by zero
public class DivideZeroException {
	
	public static void main(String[] args) {

		// int type의 변수 선언
		int b = 20;
		int a = 0;

		// 두 수의 나눗셈 결과를 구한다
		// 정수를 0으로 나누는 경우 예외발생(ArithmeticException)
		int c = b / a;
		
		int total = a + b;
		int sub = b - a;

		System.out.println(c);
	}
}
