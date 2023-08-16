package p2023_08_03;

// try ~ catch 구문으로 예외처리
//	try{
//		예외가 발생할 가능성이 있는 문장;
//
//	}catch(예외클래스명  매개변수){
//		예외 메시지;
//		예외 처리 코드;
//		// 예외가 발생하지 않으면 catch블록은 실행되지x
//	}
public class ExceptionHandling_TryCatch_Arithmetic {

	// 나눗셈을 구하는 메소드
	public void occurException() {
		
		try {
			// 정수를 0으로 나누었기 때문에 예외 발생
			// ArithmeticException: / by zero
			int result = 3 / 0;				// 예외처리
			System.out.println(result);
			
		} catch(ArithmeticException e) {
//			e.printStackTrace();
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}

	public static void main(String[] args) {
		
		// ThrowsException 클래스의 객체를 생성
		ExceptionHandling_TryCatch_Arithmetic te = new ExceptionHandling_TryCatch_Arithmetic();

		// occurException 메소드를 호출
		te.occurException();
		// 메소드 호출로 인해 occurException메소드 내부 코드가 실행되고,
		// 메소드 내에서 0으로 나누는 연산을 시도하며 예외가 발생
		// 예외처리를 하지 않으면, 프로그램이 비정상적으로 종료됨
	}
}
