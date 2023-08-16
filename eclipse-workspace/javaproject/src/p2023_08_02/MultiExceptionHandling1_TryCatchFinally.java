package p2023_08_02;

// 예외 처리 - try ~ catch ~ finally 형식
// 1. finally 안에 들어있는 내용은 예외 발생 여부와 상관없이 무조건 실행됨
// 2. finally 안에 들어있는 내용은 주로 파일을 닫거나, 데이터베이스 연결을
//	  끊는 내용이 주로 사용됨
//	  ex) file.close(), con.close()
public class MultiExceptionHandling1_TryCatchFinally {
	
	public static void main(String[] args) {

		int value = 20;
		int div = 0;

		int[] intArray = { 1, 2, 3 };
//		intArray[0] = 1, intArray[1]=2, intArray[2]=3

		try {
			// 두수의 나눗셈을 구함
			// 예외 발생됨(정수를 0으로 나누는 경우 => ArithmeticException)
			//  ArithmeticException : 산술 연산이 잘못되었을 때 발생
			int result = value / div;
			System.out.println(result);

			// 배열의 특정 값을 저장
			// 예외 발생(배열의 범위를 벗어남 => ArrayIndexOutOfBoundsException)
			// ArrayIndexOutOfBoundsException : 배열의 범위를 벗어났을때 발생
			int arrayValue = intArray[4];
			System.out.println(arrayValue);

		} catch (ArithmeticException ae) {
			System.out.println(ae.toString());
			// java.lang.ArithmeticException: / by zero
			System.out.println("0으로 나눌 수 없습니다.");

		} catch (ArrayIndexOutOfBoundsException ai) {
			ai.printStackTrace();
			// java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 3
			// at javaproject/p2023_08_02.MultiExceptionHandling1_TryCatchFinally.main(MultiExceptionHandling1_TryCatchFinally.java:26)
			System.out.println("배열의 범위를 벗어났습니다.");

		} finally {
			// 예외 발생과 관계없이 항상 실행됨
			// 주로 파일을 닫거나, 데이터베이스 연결을 끊는 내용이 주로 사용됨
			System.out.println("예외가 발생했음!");

		}
	}
}
