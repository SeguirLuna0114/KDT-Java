package p2023_08_03;


/*
	throw 키워드: 예외를 "강제로 발생시킬 때" 사용. 특정 조건에 따라 예외 발생시킴
	- 예외를 발생시켜야 할 상황에서 예외 객체를 생성하고, 해당 예외를 호출 스택을 따라 위로 던짐
	- 호출 스택 상에 있는 다른 메소드들은 이 예외를 적절히 처리하거나 
	  더 높은 호출 스택 단계에게 예외 전달 가능
	- 예외 발생 방법)	1) throw키워드를 사용해 발생시킬 예외 객체 생성
				   		- 해당 예외클래스의 생성자를 호출해 객체 생성
				   		  throw new 예외클래스();
					2) throw문 사용: throw키워드를 사용하여 
									예외 객체를 호출 스택으로 던짐
					=> 이후의 코드는 실행되지 않고, 
				   		예외 발생 지점에서 예외처리 메커니즘 동작
				   		
	ArrayIndexOutOfBoundsException : 배열의 범위를 벗어났을때 발생(인덱스가 유효X경우)
	- 배열의 길이가 N이라면 인덱스는 0부터 N-1까지 유효함.
 */
public class ExceptionHandling_Throw_new {

	public void exceptionMethod() throws ArrayIndexOutOfBoundsException {
		// 배열 선언
		int[] intA = { 1, 2, 3, 4 };

		// 배열의 저장된 값을 출력
		for (int i = 0; i < 10; i++) {
			// 예외를 던짐(프로그래머가 예외를 발생시킴)
			if (i == 2)
				throw new ArrayIndexOutOfBoundsException();
			System.out.println(intA[i]);
		}
	}

	public static void main(String[] args) {
		
		// 해당 클래스의 객체 생성
		ExceptionHandling_Throw_new te = new ExceptionHandling_Throw_new();

		try {
			te.exceptionMethod();
			
		} catch (ArrayIndexOutOfBoundsException ab) {
			
			System.out.println("배열의 index를 초과했습니다.");
			ab.printStackTrace();
		}

	}// main() end
}