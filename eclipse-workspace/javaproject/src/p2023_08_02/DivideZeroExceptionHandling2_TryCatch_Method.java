package p2023_08_02;

// 예외처리 try~catch문

// - 예외 처리하는 catch 구문에서 사용되는 예외 처리 메소드
// 1. void printStackTrace()메소드: 예외 발생 경로(스택 트레이스) 출력
//	ex)	e.printStackTrace();
//	- 스택 트레이스: 예외가 발생한 원인을 알려주는 메소드 호출의 순서를 보여줌
//		       디버깅 및 예외가 발생했을 때 프로그램 실행 흐름을 이해하는 데 유용
//
// 2. String getMessage(): 예외와 관련된 에러 메시지를 문자열로 반환함
//	ex)	String errorMessage = e.getMessage();
//	- 예외가 발생하면 일반적으로 원인에 대한 설명이 포함된 메시지가 반환됨
//	- 오류의 원인을 이해하는 데 도움
//
// 3. String toString(): 예외의 클래스 이름 뒤에 오류메시지를 포함한 간단한 설명문을 반환함.
//	ex)	 String exceptionString = e.toString();
//	- 예외 객체를 문자열로 변환하여 반환
//	- 예외 객체를 사람이 읽을 수 있는 문자열로 변환하여 로깅이나 디버깅 목적으로 활용
public class DivideZeroExceptionHandling2_TryCatch_Method {

	public static void main(String[] args) {

		// int type의 변수 선언
		int b = 20;
		int a = 0;
		int c = 0;

		// 두 수의 나눗셈 결과를 구한다
		try {
			// 20을 0으로 나누면 예외 발생
			c = b / a;

			// 예외 발생 시, 아래의 코드는 실행되지X -> catch구문으로 넘어감
			int total = a + b;
			int sub = b - a;
			System.out.println(c);

		} catch (Exception e) {
			// java.lang.Throwable의 메소드
			// void printStackTrace()메소드: 예외 발생 경로 출력
			e.printStackTrace();
			
			// 메소드 자체적으로 예외를 출력하는 메소드가 존재
//			System.out.println(e.printStackTrace());

			// String getMessage(): 예외 정보를 문자열로 반환함.
			System.out.println(e.getMessage());

			// String toString(): 예외의 간단한 설명문을 반환함.
			System.out.println(e.toString());
			
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}// main end
}
