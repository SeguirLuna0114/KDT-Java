package p2023_08_04;

import java.io.*;

/*
	o FileInputStream클래스
	: 파일을 바이트 단위로 읽기 위해 사용되는 바이트 기반 입력 스트림(InputStream) 클래스
	- 파일로부터 바이트 데이터를 읽을 때 유용
	- 이미지, 비디오, 오디오 등의 바이너리 데이터를 처리할 때 사용

	o FileInputStream클래스 생성자
	FileInputStream(String name): 주어진 파일 경로(문자열)에 해당하는 파일을 열어 읽어옴
	- 파일의 경로를 나타내는 문자열을 인자로 받음 => 직접전달
	ex)	FileInputStream fis = new FileInputStream("example.txt");
	
	o FileInputStream클래스 주요 메소드
	int read()메소드: FileInputStream으로부터 한 바이트를 읽고, 읽은 바이트값을 반환
	 			- 만일 더이상 읽을 바이트가 없다면 -1을 반환
 */

public class ByteStream_FileInputStream_read {
	public static void main(String[] args) {

		// 입력을 받아들이는 변수 선언
		int inputValue = 0;

		// FileInputStream 객체 선언
		// (try문 밖에서 선언하여, finally문 내에서 사용)
		FileInputStream file = null;

		try {
			// "read.txt"와 InputStream 형성
			file = new FileInputStream("read.txt");		// 상대경로(본인의 위치를 기준으로 작성)
//			file = new FileInputStream("C:/read.txt");		// 절대경로(최상위 디렉토리로부터 작성)

			// file의 끝을 만날 때까지 데이터를 읽어 들임
			// read() 메소드는 File에서 한 byte씩 데이터를 읽어옴.
			// 읽어온 데이터를 int로 변환해서 리턴,파일의 끝을
			// 만나면 -1을 반환함.
			while ((inputValue = file.read()) != -1) {
				System.out.print((char) inputValue);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			
			if(file != null) {
				try {
					// stream을 형성한 file을 닫음
					file.close();
				} catch(Exception e) {
					System.out.println(e.toString());
				}
			}
		}
	}
}
