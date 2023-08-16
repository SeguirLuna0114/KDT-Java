package p2023_08_07;

import java.io.*;

// 문자열을 입력받는 기능 구현
public class Socket_TalkStatement_BRreadLine {

	// readString 메서드는 사용자로부터 키보드로부터 문자열을 입력받아 반환하는 역할
	public static String readString() {

		// System.in을 이용하여 키보드로부터 입력받은 바이트 스트림을 
		// 문자 스트림으로 변환하는 InputStreamReader 객체를 생성
		InputStreamReader isr = new InputStreamReader(System.in);

		// InputStreamReader를 이용하여 입력된 문자 스트림을 
		// 버퍼를 사용하여 라인 단위로 읽기 위한 BufferedReader 객체를 생성
		BufferedReader br = new BufferedReader(isr);

		// 입력받은 데이터를 저장하기 위한 변수 선언
		String line = null;

		try {
			// 사용자로부터 입력받은 한 줄의 문자열을 읽어와 line 변수에 저장
			line = br.readLine();

		} catch (IOException io) {
			System.out.println(io);
			/*
			 * } finally{ if (br != null) try { br.close(); } catch(IOException iex) {}
			 */
		}

		// 입력받은 문자열을 반환
		return line;
	}
}
