package p2023_08_03;

// 문자열을 입력받아 첫문자가 숫자인지 확인하고, 
// 숫자일경우 해당 숫자에 대한 구구단을 출력하는 프로그램

/*	
 	throws 키워드 사용 in 메소드 선언부
	public void MethodName(E o) throws Exception {
		// 해당 예외(Exception class)가 발생할 가능성이 있는 작업
	}
	- 하나의 클래스 내에 동일한 형식의 메소드가 여러개 있는 경우,
	   throws로 예외를 던져서 예외를 한꺼번에 처리하기 위함
		ex) 메소드들은 모두 파일과 관련된 작업을 수행하는 경우
	=> 예외 처리를 각 코드마다 중복 작성하는 대신, 
	예외를 던지고 호출자에서 한 곳에 예외처리 가능(코드 중복 최소화)
	
	NumberFormatException : 문자열을 숫자로 변환할 때 발생
*/
public class ExceptionHandling_Throws_declareMethod2 {

	// throws 키워드 in 메소드 선언부 => throws NumberFormatException 구문으로 선언
	// 메소드 내에서 예외처리를 직접하지 않고,
	// setData()메소드를 호출부로 예외처리를 양도(예외를 떠넘김)
	public void setData(String n) throws NumberFormatException {
		// 문자열 길이가 1 이상인 경우
		if (n.length() >= 1) {						// String n="5";
			// substring()메소드로 문자열 일부를 추출
			//문자열의 첫번째문자 추출
			String str = n.substring(0, 1);			// String str="5";	
			printData(str);
		}
	}

	// throws 키워드 in 메소드 선언부 => throws NumberFormatException 구문으로 선언
	// 메소드 내에서 예외처리를 직접하지 않고,
	// printData()메소드를 호출부로 예외처리를 양도(예외를 떠넘김)
	private void printData(String n) throws NumberFormatException {
		
		// 입력받은 문자열 n("5") -> 정수 dan(5)으로 변환
		int dan = Integer.parseInt(n);				// 문자열이 숫자가 아닌경우, 예외발생가능
		
		// 정수로 변환된 숫자를 이용해 구구단 출력
		System.out.println(dan + "단");
		System.out.println("-----------");
		for (int i = 1; i < 10; i++) {
			System.out.println(dan + "*" + i + "=" + (dan * i));
		}
	}

	
	public static void main(String[] args) {
		
		// 클래스의 객체 생성
		ExceptionHandling_Throws_declareMethod2 t1 = new ExceptionHandling_Throws_declareMethod2();
					// args[0] = "a";   예외발생
					// args[0] = "5";	예외 발생하지X

		try {
			// setData메소드 호출
			t1.setData(args[0]);	// 명령행 매개변수로 입력받은 문자열을 메소드에 전달
		
		} catch (Exception e) {
			// setData메소드에서 발생한 예외를 catch블록을 통해 처리
			System.out.println("첫문자가 숫자가 아닙니다.");
		}
	}// main() end

}
