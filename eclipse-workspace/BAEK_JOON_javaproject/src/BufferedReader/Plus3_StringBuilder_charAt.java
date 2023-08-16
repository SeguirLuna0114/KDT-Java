package BufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// String클래스의 charAt()메소드 : 문자열에서 특정 인덱스(위치)에 있는 문자를 가져옴
// 메소드 시그니처 : char charAt(int index) - 인덱스를 매개변수로 받음. 문자 하나를 반환
class Plus_StrBuildCharAt {
	
	// StringBuilder클래스 사용
	static StringBuilder sb = new StringBuilder();
	
	// charAt()메소드는 "문자 하나만 반환"하기에, 입력값이 1자리 숫자일때만 사용 가능
	static void SB_CharAt(BufferedReader br, int N) throws IOException {
		
		// String클래스의 charAt()메소드 사용 => 문자열에서 특정 인덱스(위치)에 있는 문자를 가져옴
		for (int i=1; i<=N; i++) {
			// i값은 N번째까지 계속되며 입력받은 케이스의 번호 의미
			
			// 입력받은 값을 한줄의 문자열로 읽어옴
			String str = br.readLine();
			
			// 입력받은 값이 한자리수일때만 사용 가능
			// Character.isDigit(char ch)메소드 : 주어진 문자가 (0~9까지의)숫자인지 확인하여 true/false 반환
			// 메소드 시그니처 : boolean isDigit(char ch)
			if (Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(2))) {
				
				// 입력받은 값이 A + " " + B와 같이 무조건 한 자릿수만 입력받음
				// => 문자열로 입력받을 경우, 공백이 들어가는 위치는 무조건 고정되어 있음
				// ***따라서, 문자열의 특정 위치를 반환해주는 charAt()메소드 사용 가능
				sb.append("Case #").append(i).append(": ")
				.append(str.charAt(0)-'0'+str.charAt(2)-'0').append("\n");
				// 입력받은 문자열의 0번째인덱스에 해당하는 숫자와 2번째 인덱스에 해당하는 숫자를 가져옴
				// -'0': ASCII코드를 사용하여 '0'을 빼주면, 해당 문자를 정수값으로 변환(String -> int)
			} else {
				System.out.println("한자리수의 정수만 입력해주세요.");
				return;
				// return문 : 메소드 실행을 즉시 종료하고 메소드를 호출한 곳으로 돌아가는 역할
			}
			
		}
		//한번에 출력
		System.out.println(sb);
	}
}


public class Plus3_StringBuilder_charAt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("테스트 케이스의 개수T를 입력하고, A+B출력을 위한 숫자를 입력해주세요");

		// 첫째줄에 입력된 숫자를 readLLine()메소드로 문자로 받아서 -> int변환
		/// br.readLine()을 통해 데이터를 읽은 후에는 다시 데이터로 읽을 수 없음
		int N = Integer.parseInt(br.readLine());
		
		// BufferedReader_Tokenizer()메소드 사용
		Plus_StrBuildCharAt.SB_CharAt(br, N);
		
	}
}
