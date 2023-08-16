package p2023_08_04;

import java.io.*;

/*
 * 바이트 스트림(System.in)을 문자 스트림으로 변환하고, 입력된 데이터를 문자 배열에 읽는 예제
 * 
	InputStreamReader클래스
	: 바이트스트림(InputStream)을 받아 문자스트림(Reader)로 변환해주는 클래스

	- 바이트 단위로 읽히는 데이터를 문자단위로 읽을 수 있도록 도와주는 중간다리 역할
	- 바이트를 문자로 변환하는데에는 기본 인코딩(UTF-8)을 사용
		다른 인코딩 사용하려면 생성자에 추가적으로 인코딩 지정
	- 2바이트씩 읽어들이기 때문에 한글은 1자 밖에 입력이 안됨
*/
public class CharStream_InputStreamReader2_charArr_read {
	
	public static void main(String[] args) {

		// byte Stream인 is 선언
		// System.in은 표준 입력 장치로부터 입력을 받는 바이트 스트림(InputStream)을 의미
		InputStream is = System.in;

		// InputStreamReader 객체 선언
		// 바이트 스트림인 is를 문자 스트림으로 변환
		InputStreamReader isr = new InputStreamReader(is);

		// 입력된 데이터의 길이를 저장할 변수
		int inputValue = 0;
		
		// 길이가 10인 문자 배열 temp를 선언
		// 배열의 크기:10, char형 2byte
		char[] temp = new char[10];

		System.out.print("Input Value : ");

		try {
			// 입력된 문자의 개수를 inputValue 변수에 저장
			inputValue = isr.read(temp);
			// isr.read(temp): 입력된 문자 개수만큼만 문자를 읽고, temp배열에 저장
			
		} catch (IOException io) {
		}

		// 입력받은 데이터의 길이를 출력
		System.out.println("InputValue : " + inputValue);

		// char[]의 값을 출력(temp 배열에 저장된 문자들을 출력)
		// 입력받은 데이터의 길이인 inputValue만큼 반복
		for (int i = 0; i < inputValue; i++) {
			System.out.print(temp[i]);
		}

		// char[]을 String type으로 변환
		System.out.println("char[] -> String : " + new String(temp));
	}
}
