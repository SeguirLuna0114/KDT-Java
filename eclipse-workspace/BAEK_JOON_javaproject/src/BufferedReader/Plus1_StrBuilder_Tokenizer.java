package BufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//StringTokenizer 클래스 사용
class Plus_BufferedReader {
	
	// StringBuilder클래스 사용
	static StringBuilder sb = new StringBuilder();
	
	static void BR_Tokenizer(BufferedReader br, int N) throws IOException {
		
		// nextToken()메소드로 가져오는 String 토큰을 int형 변환
		// append()메소드를 활용하여 계산한 식을 넣어준 뒤, 한번에 출력
		for (int i=0; i<N; i++) {
			
			// StringTokenizer 클래스 사용
			// 사용자로부터 입력받은 한 줄을 공백으로 분리하여 각 토큰으로 나누기 위해
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 첫번째 토큰과 두번째토큰을 '+'더하기 연산 수행
			sb.append(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
			sb.append('\n');
			
		}
		//한번에 출력
		System.out.println(sb);
	}
}


public class Plus1_StrBuilder_Tokenizer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("테스트 케이스의 개수T를 입력하고, A+B출력을 위한 숫자를 입력해주세요");

		// 첫째줄에 입력된 숫자를 readLLine()메소드로 문자로 받아서 -> int변환
		/// br.readLine()을 통해 데이터를 읽은 후에는 다시 데이터로 읽을 수 없음
		int N = Integer.parseInt(br.readLine());
		
		// BufferedReader_Tokenizer()메소드 사용
		Plus_BufferedReader.BR_Tokenizer(br, N);
		
	}
}
