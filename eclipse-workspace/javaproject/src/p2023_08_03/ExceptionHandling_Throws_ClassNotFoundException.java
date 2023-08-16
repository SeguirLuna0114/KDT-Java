package p2023_08_03;

// p462
// 예외처리 떠넘기기
/*
	** throws 키워드 사용 in 메소드 선언부
	"발생하는 예외를 해당 메소드를 호출한 곳으로 떠넘기는 역할"
	public void MethodName(E o) throws Exception {
		// 해당 예외(Exception class)가 발생할 가능성이 있는 작업
	}
	- 하나의 클래스 내에 동일한 형식의 메소드가 여러개 있는 경우,
   		throws로 예외를 던져서 예외를 한꺼번에 처리하기 위함
		ex) 메소드들은 모두 파일과 관련된 작업을 수행하는 경우
	=> 예외 처리를 각 코드마다 중복 작성하는 대신, 
		예외를 던지고 호출자에서 한 곳에 예외처리 가능(코드 중복 최소화)
*/
public class ExceptionHandling_Throws_ClassNotFoundException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// findClass()메소드 호출
			findClass();
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("클래스가 존재하지 않습니다.");
		}
	}

	// 메소드를 호출한 곳으로 예외를 떠넘김
	public static void findClass() throws ClassNotFoundException {
		// 예외 발생 가능한 코드
		Class clazz = Class.forName("java.lang.String2");
		// Class.forName(String className) 메소드: 문자열로 주어진 클래스이름을 사용하여 해당 클래스를 동적으로 로드하는 역할
		// java.lang패키지에 String2클래스가 존재하지 않음 => 예외발생
	}
	
}
