package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// StringBuilder의 reverse()메소드 활용하여 문자열을 뒤집는 프로그램
public class ReverseString {

	static void StringBuilder_Reverse() throws IOException{
		
		// 입력값을 문자열로 받아옴
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받은 문자열을 공백(" ")을 기준으로 구분
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// StringBuilder클래스: 문자열을 다루는 클래스
		// StringBuilder클래스의 reverse메소드를 활용하여 쉽게 문자열을 뒤집을 수 있음
		int n1 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		int n2 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		
		// Math.max()메소드를 활용하는 방법
		System.out.println(Math.max(n1, n2));
		// 삼항 연산자를 사용하는 방법
		System.out.println( (n1 > n2) ? n1 : n2);
	}
	
	// 원시 입력인 System.in.read()를 활용
	// - 입력되는 수는 세자리수로 고정되어있기에, 빠르고 쉽게 가능
	// - read()메소드는 한 자리씩 반환되기에, 문자열뒤집을 필요X
	static void System_InRead() throws IOException {
	
		// 두 수를 할당할 변수의 초기값 선언
		int n1 = 0;
		int n2 = 0;
		
		// read()메소드는 한 자리씩 반환되기에, 문자열뒤집을 필요X
		// System.in.read()메소드는 사용자의 입력을 바이트단위로 읽고, ASCII코드값을 반환
		// ASCII코드에서 숫자'0' = 48이기에, 사용자가 '0'을 입력시 48 - 48로 0으로 입력 받아들임
		n1 += System.in.read() - 48;	// 입력받은 바이트단위 숫자를 문자 -> 숫자 변환
//		n1 += System.in.read() - '0';	// 위와 동일한 결과를 얻음(단, 숫자 -> 문자 변환)
		n1 += (System.in.read() - 48)*10;
		n1 += (System.in.read() - 48)*100;
		
		// 공백으로 구분되어 숫자 입력됨
		System.in.read();		// 공백
		
		n2 += System.in.read() - 48;
		n2 += (System.in.read() - 48)*10;
		n2 += (System.in.read() - 48)*100;
		
		// Math.max()메소드를 활용하는 방법
		System.out.println(Math.max(n1, n2));
		// 삼항 연산자를 사용하는 방법
		System.out.println( (n1 > n2) ? n1 : n2);
		
	}
	
	
	// 수를 거꾸로 읽어서 큰수를 출력
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		System.out.println("두 세자리 수를 입력해주세요");
		
		// StringBuilder_Reverse()메소드 사용
		StringBuilder_Reverse();
		
		System.out.println();
		
		// System_InRead() 메소드 사용
		System_InRead();
	}

}
