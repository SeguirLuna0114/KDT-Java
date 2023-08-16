package p2023_08_03;

/*
	예외처리 try ~ catch ~ catch ~ finally
	
	* ArrayIndexOutOfBoundsException: 배열의 범위를 벗어난 경우 발생하는 예외
	* NumberFormatException: 숫자로 변환이 불가능한 문자를 입력한 경우 발생하는 예외
							 (숫자 외의 값을 입력할 경우 발생하는 예외)
 */
public class MultiExceptionHandling_TryCatchFinally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// args[0]="10", args[1]="20" : 예외발생X
		// args[0]="a", args[1]="b" : 예외발생(NumberFormatException)

		
		try {
			// 예외발생 - ArrayIndexOutOfBoundsException
			// : 배열에 입력가능한 인덱스 범위를 벗어난 경우
			String data1 = args[0];
			String data2 = args[1];
			
			// 예외발생 - NumberFormatException
			// : 숫자로 변환할 수 없는 문자가 입력된 경우
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			
			System.out.println(data1+"+"+data2+"="+result);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개 값의 수가 부족합니다.");
			
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다.");
			
		} finally {
			// 예외발생과 관계없이 항상 실행
			System.out.println("다시 실행하세요.");
		}
	}

}
