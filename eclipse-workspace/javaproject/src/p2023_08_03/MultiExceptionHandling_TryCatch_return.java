package p2023_08_03;

// p456
/*
	예외처리 try ~ catch(return) & try ~ catch ~ finally
	- finally 안에 들어있는 내용은 예외 발생 유무와 관계없이 무조건 실행됨
	
	* ArrayIndexOutOfBoundsException: 배열의 범위를 벗어난 경우 발생하는 예외
	* NumberFormatException: 숫자로 변환이 불가능한 문자를 입력한 경우 발생하는 예외
							 (숫자 외의 값을 입력할 경우 발생하는 예외)
	
	* return구문으로 해당 메소드의 실행을 종료하고 빠져나감 => 아랫쪽의 내용 실행X
 */
public class MultiExceptionHandling_TryCatch_return {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String data1 = null;
		String data2 = null;
		
		try {
			data1 = args[0];
			data2 = args[1];
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개 값의 수가 부족합니다.");
			return;
			// return구문으로 해당 메소드의 실행을 종료하고 빠져나감 => 아랫쪽의 내용 실행X
			// cf> break구문은 반복문 안에서 사용되며, 해당 반복문 전체를 즉시 종료하는데 사용
		}
		
		try {
			// data에 숫자로 변환할 수 없는(문자)가 입력된 경우 예외발생
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1+"+"+data2+"="+result);
			
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다.");
			
		} finally {
			// finally 안에 들어있는 내용은 예외 발생 유무와 관계없이 무조건 실행
			System.out.println("다시 실행하세요.");
		}
	}
}
