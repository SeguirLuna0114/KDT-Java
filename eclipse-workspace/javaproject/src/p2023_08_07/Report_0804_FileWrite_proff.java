package p2023_08_07;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

// 키보드로 입력한 문장을 파일(result.txt)로 저장하는 프로그램을 작성하세요?
// 키보드 입력 : BufferedReader
// 파일 출력 : FileWriter
public class Report_0804_FileWrite_proff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문장을 입력하세요?");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// 입력받은 문자열
			String input = br.readLine();

			// 읽어온 문자열 저장할 파일 설정
			FileWriter fw = new FileWriter("d:/result_proff.txt");
			// void write(String str)메소드 사용
			fw.write(input);

			fw.close();
			System.out.println("저장 성공~!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
