package p2023_08_04;

// 입출력에 관한 패키지 import
import java.io.*;

/*
	바이트 스트림을 이용하여 표준입력(System.in)으로부터 데이터를 읽는 프로그램

	o Byte Stream(바이트 스트림) : 1바이트(byte) 단위로 데이터를 처리하는 입출력 스트림
	- 모든 종류의 데이터를 처리할 수 있음. 주로 이진 파일(이미지, 동영상)을 처리하는데 사용
	- 자바에서 바이트 스트림을 다루는 기본적인 클래스
		: InputStream, OutputStream
		
	o int read() 메서드
	: 한 번에 1바이트씩 데이터를 읽어들이며, 읽어들인 데이터는 ASCII 코드 값으로 반환
		- read()메소드 호출 시, 예외처리가 필요
	 	=> try~catch구문 사용하여 catch (IOException e)예외처리
	 	
	ex) 'A'를 입력하면, ASCII코드 값인 65를 반환
 */

public class ByteStream_InputStream_SystemIn {

	public static void main(String[] args) {

		// System.in을 이용하여 InputStream 객체인 is를 생성
		InputStream is = System.in;
		/*
		 *  System.in은 표준입력 장치인 키보드로 부터 입력 받는것을 의미함.
		 *  - 정적필드 InputStream in : 일반적인 입력스트림
		 *  		=> System.in
		 *  - 정적필드 InputStream out : 일반적인 출력스트림
		 *  		=> System.out
		 */
		
		// 사용자가 입력한 값을 저장
		int inputValue = 0;

		System.out.print("Input Data : ");

		try {
			// 키보드로부터 값을 입력 받음
			inputValue = is.read();
			// read() 메소드: 사용자의 입력으로부터 1바이트를 읽어들임 -> ASCII코드값 반환
			
		} catch (IOException io) {
//			System.out.print(io.toString());
			// getMessage()를 이용하여 예외 메시지 출력
			System.out.print(io.getMessage());
		}

		//  ASCII 코드 값을 출력
		System.out.println("InputData is " + inputValue);
		// (char)데이터타입 캐스팅으로, ASCII코드값 -> 문자로 변환되어 출력
		System.out.println("InputData is " + (char) inputValue);
		// 한글처리를 지원하지 X(한글은 2바이트로 표현되는 문자이기에, 문자스트림을 사용해야함
	}
}
