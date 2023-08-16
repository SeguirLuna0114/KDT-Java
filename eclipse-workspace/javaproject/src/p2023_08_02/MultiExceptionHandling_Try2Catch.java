package p2023_08_02;

// 예외처리 - try ~ catch ~ catch 문으로 다중예외처리

// ArithmeticException : 숫자를 0으로 나눌 때 발생하는 예외
// ArrayIndexOutOfBoundsException : 배열의 범위를 벗어났을때 발생하는 예외
public class MultiExceptionHandling_Try2Catch {
	
	public static void main(String[] args) {

		int value = 20;
		int div = 0;
		int[] intArray = { 1, 2, 3 };
//		intArray[0]=1, intArray[1]=2, intArray[2]=3

		try {
			// 예외 발생(intArray는 index=2까지 존재) => ArrayIndexOutOfBoundsException 발생
			// 예외 발생된 구문 아래의 내용은 더이상 실행되지X
//			int arrayValue = intArray[4];	// 배열의 범위(인덱스)를 넘어섬
//			System.out.println(arrayValue);

			// 예외 발생(정수를 0으로 나누는 경우)
			// 두수의 나눗셈을 구함
			int result = value / div;
			System.out.println(result);

			// 배열의 특정 값을 저장
			int arrayValue = intArray[4];
			System.out.println(arrayValue);

		} catch (ArithmeticException ae) {
			System.out.println("0으로 나눌 수 없습니다.");
			// String toString(): 예외의 클래스 이름 뒤에 오류메시지를 포함한 간단한 설명문을 반환
			System.out.println(ae.toString());
			
		} catch (ArrayIndexOutOfBoundsException ai) {
			// 배열의 범위를 넘어선 경우 발생
			System.out.println("배열의 범위를 벗어났습니다.");
			// printStackTrace()메소드: 예외 발생 경로(스택 트레이스) 출력
			ai.printStackTrace();
		}
	}
}
