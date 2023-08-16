package BufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Plus - 두 정수를 입력받은 다음 합을 출력하는 프로그램
//종료시점이 주어지지 않은 경우 => 더이상 읽을 수 있는 데이터(EOF)가 없을 때 종료

//EOF(End Of File): 데이터가 더이상 존재하지 않는 경우(파일의 끝)
//실행후, 입력을 끝내려면 [Ctrl]+[z] 사용

//BufferedReader의 경우 null을 반환 => null인지 아닌지만 구분
//문자열 분리방법2. charAt()메소드를 이용하여 한자리 문자 반환
// 				(단, 이는 입력받는 정수가 0<A,B<10인 경우에만 실행 가능)
class Use_charAt {
	
	static StringBuilder sb = new StringBuilder();
	
	static void StringCharAT(BufferedReader br) throws IOException {
		
		// 입력받은 문자열을 받을 변수 선언
		String str;
		
		// 입력받은 값을 readLine()메소드를 사용해 읽어옴
		// 단, EOF의 경우 null을 반환하기에, 종료시점으로 사용
		while ((str = br.readLine()) != null) {
			
			// charAt()은 해당문자의 아스키코드 값을 반환하기에,
			// 정수형태로 변경하기 위해 -48 또는 -'0' 사용
			int n1 = str.charAt(0) - 48;
			// int n1 = str.charAt(0) - '0';
			int n2 = str.charAt(2) - 48;
			// int n2 = str.charAt(2) - '0';
			sb.append(n1+n2).append("\n");
		}
		System.out.println(sb);
	}
}

public class EOF_StrBuilder_charAt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// BufferedREader로 데이터를 읽어옴
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("두 정수를 입력해주세요.(단, 0 < A,B <10)");
		
		// StringCharAT메소드 호출
		Use_charAt.StringCharAT(br);
	}

}
