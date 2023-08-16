package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 단어의 개수
public class CountWords {

	// BufferedReader클래스 & StringTokenizer클래스 활용
	static void BufferedReaderMethod() throws IOException {
		// 입력값을 BufferedReader클래스를 사용하여 읽음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// br.readLine()메소드로 문자열로 한번에 입력받아온 값을 
		// StringTokenizer클래스로 띄어쓰기를 구분자로 사용해 문자열을 토큰으로 파싱
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// st.countTokens()메소드를 활용해 받아온 토큰의 개수를 출력
		System.out.println(st.countTokens());
	}

	// Buffer을 사용하지 않고 원시 입력상태로 문자를 하나씩 읽어들이면서 
	// 읽어들인 문자가 공백인지 아닌지에 따라 count++해주는 방법
	static void System_in_readMethod() throws IOException {

		int count = 0;
		// 이전의 문자를 저장할 pre_str과 현재 입력받은 문자를 저장하는 curr_str변수 활용
		int pre_str = 32;	// 이전 입력받은 문자의 초기값을 공백으로 설정
		int curr_str;		// 현재 읽어온 바이트단위 문자를 의미
		
		// System.in.read()메소드는 문자를 한 바이트씩 읽어서 ASCII코드값을 반환
		// ASCII코드 공백=32
		while(true) {
			// 현재 입력받아온 한 문자를 curr_str변수에 할당
			curr_str = System.in.read();
			
			// 만일 입력받은 문자(ASCII코드)가 공백일 경우
			if (curr_str == 32) {
				// 이전의 문자가 공백이 아니면 count++;
				// 초기 설정한 pre_str = 공백으로 설정하여 비교해야 함
				if (pre_str != 32) {
					// 첫문자와 마지막문자가 공백일 경우 count되는것 방지하기 위함
					count++;
				}
				// 이전문자가 공백일 경우는 pass
			}
			// 현재 입력받은 문자(ASCII코드)가 개행일때('\n')
			// ASCII코드 개행('\n') = 10
			else if(curr_str == 10) {
				// 이전의 문자가 공백이 아니면 count++;
				if (pre_str != 32) {
					count++;
					// 그리고 반복문을 끝냄
					break;
				}
				// 이전문자가 공백일 경우는 pass
			}
			// 입력받은 문자가 공백도 아니고 개행도 아닐 경우에는
			// 현재 입력받은 문자를 이전문자로 update
			pre_str = curr_str;
		}
		// 개행문자 사용으로 반복문이 끝난 경우
		// count된 단어 개수를 출력
		System.out.println(count);
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("영어 대소문자와 띄어쓰기로 이루어진 문자열을 입력하세요.(단, 문자열의 길이는 1,000,000을 넘지않는다.)");
		
		// BufferedReader클래스로 읽어오고 StringTokenizer클래스로 파싱
		BufferedReaderMethod();
		
		// Buffer을 사용하지 않고 원시 입력상태로 문자를 하나씩 읽어들이면서 
		// 읽어들인 문자가 공백인지 아닌지에 따라 count++해주는 방법
		System_in_readMethod();
		
	}

}
