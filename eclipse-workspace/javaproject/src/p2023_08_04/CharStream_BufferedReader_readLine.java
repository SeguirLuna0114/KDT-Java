package p2023_08_04;

import java.io.*;

/*
	BufferedReader 클래스
	: Reader를 버퍼링하여 입력받은 데이터를 효율적으로 읽는 역할
	- Reader 클래스를 확장한 클래스. 문자 입력을 버퍼링하여 효율적으로 처리하는 기능을 제공
	
	o BufferedReader 클래스 객체생성 방법
	: BufferedReader 클래스와 InputStreamreader클래스를 함께 사용하는방법
	- System.in 또는 다른 InputStream을 읽기 위해 InputStreamReader를 사용
		-> BufferedReader의 생성자로 전달하여 BufferedReader를 초기화
	ex) BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

 */
public class CharStream_BufferedReader_readLine {
	
	public static void main(String[] args) {

		// InputStream, InputStreamReader, BufferedReader 객체 생성
		// System.in: 사용자로부터 입력받은 InputStream
		InputStream is = System.in;
		// InputStreamReader: 바이트 기반의 InputStream -> 문자기반의 Reader로 변환
		InputStreamReader isr = new InputStreamReader(is);
		// br을 통해 텍스트 데이터를 효율적으로 읽음
		BufferedReader br = new BufferedReader(isr);
		
		// 위 코드를 한줄로 작성가능
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		 
		System.out.print("Input Data : ");

		try {
			// readLine()메소드: 텍스트 데이터를 사용자로부터 "한줄로" 입력받음(개행문자 이전까지 입력받음)
			String inputString = br.readLine();
			System.out.println();
			
			System.out.println("Output String = " + inputString);
			
		} catch (IOException io) {
			// readLine() 메서드가 IOException을 던질 수 있으므로, 예외를 처리
			System.out.println(io.getMessage());
		}
	}// main() end
}
