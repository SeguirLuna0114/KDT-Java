package p2023_08_03;
/*
 	** throws 키워드 사용 in 메소드 선언부
 	public void MethodName(E o) throws Exception {
 		// 해당 예외(Exception class)가 발생할 가능성이 있는 작업
 	}
	- 하나의 클래스 내에 동일한 형식의 메소드가 여러개 있는 경우,
	   throws로 예외를 던져서 예외를 한꺼번에 처리하기 위함
		ex) 메소드들은 모두 파일과 관련된 작업을 수행하는 경우
	=> 예외 처리를 각 코드마다 중복 작성하는 대신, 
  	예외를 던지고 호출자에서 한 곳에 예외처리 가능(코드 중복 최소화)
*/
public class ExceptionHandling_Throws_declareMethod {
	
	// throws 키워드 사용 => throws ArithmeticException 구문으로 선언
	// occurException()메소드를 호출한 곳으로 예외처리를 양도하겠다(떠넘기겠다)는 의미
	public void occurException() throws ArithmeticException {

		// ArithmethicException 발생
		int result = 3 / 0;			// 예외 발생
		System.out.println(result);
	}

	public static void main(String[] args) {
		
		// 객체를 생성
		ExceptionHandling_Throws_declareMethod te = new ExceptionHandling_Throws_declareMethod();

		// try-catch 블록으로 예외 처리
		try {
			// occurException()메소드를 호출
			te.occurException();
			
		} catch (ArithmeticException ae) {
			// ArithmeticException이 발생하면, catch 블록으로 제어가 이동
			System.out.println("Exception이 발생 : " + ae.toString());
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}
}
