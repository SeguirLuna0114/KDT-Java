package BufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Gugudan {
	
	// 일반적인 출력
	static void printGugudan(int a) {
		for (int i=1; i<10; i++) {
			System.out.println(a+" * "+i+" = "+(a*i));
		}
	}
	
	// 향상된 성능 코드(성능 개선 코드)
	// 보통 출력문자 많을경우 StringBuilder 또는 BufferedWriter 사용
	// StringBuilder: 객체에 문자열을 하나로 이어서 데이터 전송 방식
	// BufferedWriter: 버퍼에 담아두었다가 한번에 데이터 전송
	static void StringBuilder(int a) {
		// StringBuilder 객체 생성
		StringBuilder sb = new StringBuilder();
		
		for (int i=1; i < 10; i++) {
			sb.append(a).append(' ').append('*').append(' ').append(i);
			sb.append(' ').append('=').append(' ').append(a*i).append('\n');
		}
		System.out.println(sb);
	}
	
}


// 구구단 출력하는 프로그램
public class Gugudan_BufferReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("숫자를 입력 해주세요.");
		
		// 입력한 숫자를 한줄의 문자열로 (개행문자이전까지)입력받아 문자열로 반환
		// Integer.parseInt()메소드를 활용하여 문자열 -> 숫자로 변환 
		int a = Integer.parseInt(br.readLine());
		br.close();
		
		// printGugudan메소드 사용
		// 일반적인 케이스
		Gugudan.printGugudan(a);
		
		// StringBuilder 메소드 사용
		// 성능 개선 코드
		Gugudan.StringBuilder(a);
		
	}

}
