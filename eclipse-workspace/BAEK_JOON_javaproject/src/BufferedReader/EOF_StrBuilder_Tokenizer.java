package BufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Plus - 두 정수를 입력받은 다음 합을 출력하는 프로그램
// 종료시점이 주어지지 않은 경우 => 더이상 읽을 수 있는 데이터(EOF)가 없을 때 종료

// EOF(End Of File): 데이터가 더이상 존재하지 않는 경우(파일의 끝)
// 실행후, 입력을 끝내려면 [Ctrl]+[z] 사용

// BufferedReader의 경우 null을 반환 => null인지 아닌지만 구분
// 문자열 분리방법1. StringTokenizer클래스를 이용하여 분리
class Use_StrTokenizer {
	
	static StringBuilder sb = new StringBuilder();
	
	static void StrTokenizer(BufferedReader br) throws IOException {
		
		// 입력받은 문자열을 받을 변수 선언
		String str;
		
		// 입력받은 값을 readLine()메소드를 사용해 읽어옴
		// 단, EOF의 경우 null을 반환하기에, 종료시점으로 사용
		while ((str = br.readLine()) != null) {
			// [Ctrl+z]입력종료
			
			// 입력값을 공백(" ")구분자로 파싱
			StringTokenizer st = new StringTokenizer(str, " ");
			
			// 입력받은 문자를 숫자로 변환(ex. "21" -> 21)
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			// 결과값을 sb에 한번에 입력
			sb.append(n1+n2).append("\n");
		}
		System.out.println(sb);
		
	}
}

public class EOF_StrBuilder_Tokenizer {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		// BufferedREader로 데이터를 읽어옴
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("두 정수를 입력해주세요.");
		
		// StrTokenizer메소드 호출
		Use_StrTokenizer.StrTokenizer(br);

	}

}
