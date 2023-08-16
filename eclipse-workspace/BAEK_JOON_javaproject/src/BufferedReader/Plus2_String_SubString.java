package BufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// StringTokenizer가 속도가 빠르긴 하지만, 시간 지연 우려 존재
// 시간 줄이는 향상된 코드
class Plus_StringSubString {
	
	// StringBuilder클래스 사용
	static StringBuilder sb = new StringBuilder();
	
	static void StrSubstring(BufferedReader br, int N) throws IOException {
		
		// String.substring()메소드 사용
		for (int i=0; i<N; i++) {
			String str = br.readLine();		// 입력한 값을 바로 readLine()메소드로 문자로 받은 경우 사용
			
			// 문자열 분리 => " "(공백)
			int target = str.indexOf(" ");
			int result = Integer.parseInt(str.substring(0, target))
					+Integer.parseInt(str.substring(target+1));
			sb.append(result+"\n");
		}
		System.out.println(sb);
		
	}
}


public class Plus2_String_SubString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("테스트 케이스의 개수T를 입력하고, A+B출력을 위한 숫자를 입력해주세요");

		// 첫째줄에 입력된 숫자를 readLLine()메소드로 문자로 받아서 -> int변환
		/// br.readLine()을 통해 데이터를 읽은 후에는 다시 데이터로 읽을 수 없음
		int N = Integer.parseInt(br.readLine());
			
		// StrSubstring()메소드 사용
		Plus_StringSubString.StrSubstring(br, N);

	}
}
