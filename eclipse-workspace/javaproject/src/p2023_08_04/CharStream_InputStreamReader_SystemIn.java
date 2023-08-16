package p2023_08_04;

import java.io.*;

/*
 * InputStreamReader를 사용하여 바이트 스트림(System.in)을
 * 문자 스트림으로 변환하고, 사용자로부터 입력을 받아 출력하는 예제
 * 
	InputStreamReader클래스
	: 바이트스트림(InputStream)을 받아 문자스트림(Reader)로 변환해주는 클래스

	- 바이트 단위로 읽히는 데이터를 문자단위로 읽을 수 있도록 도와주는 중간다리 역할
	- 바이트를 문자로 변환하는데에는 기본 인코딩(UTF-8)을 사용
  		다른 인코딩 사용하려면 생성자에 추가적으로 인코딩 지정
	- 2바이트씩 읽어들이기 때문에 한글은 1자 밖에 입력이 안됨
 */

public class CharStream_InputStreamReader_SystemIn {
	
	public static void main(String[] args) {

		// 바이트 스트림(System.in)을 문자 스트림으로 변환
		// byte Stream인 is 선언
		InputStream is = System.in;

		// InputStreamReader 객체 선언
		InputStreamReader isr = new InputStreamReader(is);
//							InputStreamReader(System.in);
		// 입력된 데이터를 저장할 변수
		int inputValue = 0;
		
		// 사용자로부터 입력을 받아 출력하는 예제
		System.out.print("Input Value : ");
		
		try {
			// read() 메서드를 사용하여 사용자로부터 데이터를 읽음
			// 키보드로 부터 데이터를 입력
			// 2바이트씩 읽어들이기 때문에 한글은 1자 밖에 입력이 안됨.
			inputValue = isr.read();
			
		} catch (IOException io) {
			
			System.out.print(io.getMessage());
		}
		
		// 입력받은 데이타를 출력
		System.out.println("Input Result : " + inputValue);
		// (char)을 사용하여 정수 값을 문자로 형변환
		System.out.println("Input Result : " + (char) inputValue);
	}
}
