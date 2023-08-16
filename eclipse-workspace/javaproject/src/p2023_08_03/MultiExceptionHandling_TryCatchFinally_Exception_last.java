package p2023_08_03;

/*
	예외처리 try ~ catch ~ catch ~ finally
	
	* ArrayIndexOutOfBoundsException: 배열의 범위를 벗어난 경우 발생하는 예외
	* NumberFormatException: 숫자로 변환이 불가능한 문자를 입력한 경우 발생하는 예외
							 (숫자 외의 값을 입력할 경우 발생하는 예외)
							 
	* Exception 클래스 : 모든 예외 클래스의 최상위 클래스인 추상클래스
	1) Exception 예외 클래스는 예외처리 클래스 중 최상위클래스이기에
		모든 자식들의 예외를 받아서 처리할 수 있음
 	2) catch구문에서 Exception클래스로 예외를 받을 때는 가장 마지막 catch구문에서 사용해야 함
 */
public class MultiExceptionHandling_TryCatchFinally_Exception_last {

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
			
		} catch (Exception e) {
			// 예외처리 최상위 클래스인 Exception클래스의 경우에는 
			// 다른 예외 클래스와 같이 사용시, 가장 마지막에 작성해야 함
			// (모든 자식클래스의 예외를 받아서 처리)
			System.out.println("실행에 문제가 있습니다.");
			
		} finally {
			// 예외발생과 관계없이 항상 실행
			System.out.println("다시 실행하세요.");
		}
	}

}
