package p2023_08_04;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

// 키보드로 입력한 문장을 파일(result.txt)로 저장하는 프로그램을 작성
//키보드 입력 : BufferedReader
//파일 출력 : FileWriter
public class Report_0804_FileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// BufferedReader클래스 사용하여 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("문장을 입력하세요.");
		
		// FileWriter 클래스 사용하여 입력받은 문자열을 파일에 작성
		FileWriter filewrite = null;
		
		try {
			// 입력받은 문자열
			String inputStr = br.readLine();
			
			// 읽어온 문자열을 저장할 파일 설정
			filewrite = new FileWriter("d:/result.txt");
			
			// 읽어들인 문자열을 모두 파일에 작성하여 저장
			for(char charinput : inputStr.toCharArray()) {
				// 화면에 출력
				System.out.print(charinput);
				// 저장할 파일에 작성
				filewrite.write(charinput);
			}
			
			filewrite.close();
		} catch (Exception err) {
			err.printStackTrace();
		} 
	}

}
