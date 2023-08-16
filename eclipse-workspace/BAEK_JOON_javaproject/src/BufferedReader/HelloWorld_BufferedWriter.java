package BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class HelloWorld_BufferedWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// ##BufferedWriter를 이용하는 방식
		// BufferedWriter/BufferedReader : 데이터를 하나씩 읽어오는 것이 아니라
		// 임시 공간(버퍼)에 저장해두었다가 한번에 출력 또는 데이터를 보내오는 방식
		// -Scanner는 BufferedReader보다 상당히 느림
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("Hello World!");
		bw.flush();
		bw.close();
	
	}

}
