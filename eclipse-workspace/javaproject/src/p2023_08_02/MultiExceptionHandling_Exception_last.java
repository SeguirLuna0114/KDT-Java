package p2023_08_02;

// 예외처리
// 3. NumberFormatException : 문자열을 숫자로 변환할 때 발생
// 		- RuntimeException 클래스를 상속받은 예외, 명시적인 예외 처리가 강제되지 X
// 1) parseXXX 메소드를 사용하여 문자열을 숫자로 변환할 경우, 
//    문자열이 올바르게 구성되지 않으면 발생
//	  (parseInt, parseLong, parseFloat, parseDouble)
//	ex)	String str2 = "abc";	// 숫자로 변환 불가능한 문자열
//		int number2 = Integer.parseInt(str2); // NumberFormatException 발생
//
//	2) 숫자로 변환 가능한 문자열이지만, 범위를 벗어난 경우에도 발생
//	ex)	String str = "2147483648"; // int 범위를 벗어나는 문자열
//		int number = Integer.parseInt(str); // NumberFormatException 발생

// * Exception 클래스 : 모든 예외 클래스의 최상위 클래스인 추상클래스
// 1) Exception 예외 클래스는 예외처리 클래스 중 최상위클래스이기에
//	  모든 자식들의 예외를 받아서 처리할 수 있음
// 2) catch구문에서 Exception클래스로 예외를 받을 때는 가장 마지막 catch구문에서 사용해야 함

// [Run] -> [Run Configurations] -> 'arguments'탭 -> 'program arguments'창에 매개변수 입력 -> 'apply' ->'run'
public class MultiExceptionHandling_Exception_last {

	public static void main(String[] args) {
		// 입력한 값이 args[] 문자열 배열에 저장됨
		
		int var = 50;	
						// args[0] = "5" 예외발생 X
						// args[0] = "a" 예외발생 O
						// args[0] = "0" 예외발생 O

		try {
			// args[0] = "5"(문자) -> args[0] = 5 (숫자)
			int data = Integer.parseInt(args[0]);

			// 50 / 5 => 10(예외 발생하지X)
			System.out.println(var / data);

			// Exception 예외 클래스가 하위 예외 클래스들을
			// 모두 가지고 있기 때문에 먼저 정의해서는 안된다.

		} catch (NumberFormatException ne) {
			System.out.println("숫자가 아닙니다.");
		} catch (ArithmeticException ae) {
			System.out.println("0으로 나눌순 없죠?");
		} catch (Exception e) {
			// 예외처리 최상위 클래스인 Exception클래스의 경우에는 
			// 다른 예외 클래스와 같이 사용시, 가장 마지막에 작성해야 함
			System.out.println("Exception !!");
		}
		System.out.println("프로그램 종료!");
	}
}
