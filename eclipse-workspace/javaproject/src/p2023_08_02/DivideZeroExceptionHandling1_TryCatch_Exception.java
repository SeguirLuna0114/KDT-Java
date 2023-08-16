package p2023_08_02;

// 예외처리
// 1. try ~ catch 구문으로 예외처리
//	try{
//		예외가 발생할 가능성이 있는 문장;
//	}catch(예외클래스명  매개변수){
//		예외 메시지;
//	}

// - try ~ catch구문에서 예외처리 클래스를 잘 모를경우에는.
//	 최상위 클래스인 Exception클래스로 모든 예외를 받을 수 있음
public class DivideZeroExceptionHandling1_TryCatch_Exception {
	
	public static void main(String[] args) {

		// int type의 변수 선언
		int b = 20;
		int a = 0;
		int c = 0;

		// try ~ catch 구문으로 예외처리
		// 두 수의 나눗셈 결과를 구한다
		try {
			// 예외 발생(20을 0으로 나누는 경우)
			c = b / a;
			
			// 예외가 발생하면, 예외가 발생한 라인 아랫쪽은 실행되지X
			int total = a + b;
			int sub = b - a;

		} catch (Exception e) {
			// Exception으로 명시 => 예외 처리 최상위클래스이기에,
			// (발생하는 예외의 유형 모르는 경우) 모든 예외를 받을 수 있음
			a = 2;
			c = b / a;
		}

		System.out.println(c);
	}
}
