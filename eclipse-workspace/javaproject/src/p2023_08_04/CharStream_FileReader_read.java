package p2023_08_04;

import java.io.*;

/*
	o FileReader클래스
	: 문자 기반 입력 스트림(Reader) 클래스로, 파일로부터 "문자 단위로 데이터를 읽기"위해 사용

	o 생성자
	1. FileReader(String fileName) throws FileNotFoundException
	: 주어진 "파일 경로"를 나타내는 문자열로부터 파일을 염
	2. FileReader(File file) throws FileNotFoundException
	: 주어진 "File객체"로부터 파일을 염

 */
public class CharStream_FileReader_read {
	
	public static void main(String[] args) {

		// FileReader 객체 선언
		FileReader file = null;
		int inputValue = 0;

		try {
			// "data.txt" File과 stream 형성
			file = new FileReader("data.txt");			// 상대경로(본인의 위치를 기준으로 작성)
//			file = new FileReader("c:/data.txt");		// 절대경로(최상위 디렉토리로부터 작성)
			

			// file의 끝을 만날 때까지 데이터를 읽어 들임
			while ((inputValue = file.read()) != -1) {
				System.out.print((char) inputValue);
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			
			if(file != null) {
				try {
					// stream을 닫음
					file.close();
				} catch(Exception e) {
					System.out.println(e.toString());
				}
			}
				
		}
	}// main() end
}
