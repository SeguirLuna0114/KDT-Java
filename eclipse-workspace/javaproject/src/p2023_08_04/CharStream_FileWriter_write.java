package p2023_08_04;

import java.io.*;

/*
	o FileReader 클래스
	:  파일에 문자 단위로 데이터를 쓰기 위해 사용
	(파일에 문자데이터를 작성 가능)

	o 생성자
	1. FileWriter(String fileName) throws IOException
	: 주어진 파일 경로를 나타내는 문자열로부터 파일을 생성하거나 염
	ex)	// FileWriter 객체 생성
        FileWriter fw = new FileWriter("example.txt");

	2. FileWriter(File file) throws IOException
	: 주어진 File 객체로부터 파일을 생성하거나 염
 */
public class CharStream_FileWriter_write {
	
	public static void main(String[] args) {
		try {
			// 명령행 첫번째 인수로 들어오는 값을
			// 인수로 받아 들여 FileReader 객체 생성
			FileReader fr = new FileReader("data.txt");

			// 명령행 두번째 인수를
			// 생성자의 argument로 받아 들여 FileWriter 객체 생성
			FileWriter fw = new FileWriter("data1.txt");
//			FileWriter fw = new FileWriter("d:/data1.txt");

			int input = 0;

			// File에 저장된 모든 데이터를 스트림을 통해
			// 읽어 들여 다른File에 저장
			while ((input = fr.read()) != -1) {
				System.out.print((char) input); // 화면에 출력 부분
				fw.write(input); // 다른 파일에 쓰는 부분
			}

			// FileInputStream, FileOutputStream을 해제
			fr.close();
			fw.close();
		} catch (IOException io) {
			System.out.println(io);
		}
	}// main() end
}
