package BufferedReader;

// 덧셈 연산 - 단, 입력의 마지막에는 0 두 개가 입력됨
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BufferedReader.readLine()을 통해 입력받게 되면 이는 문자열 한 줄을 한번에 입력받음
// 따라서 공백을 기준으로 문자열 분리 필요
// 1. String.split()메소드 사용하여 문자열 분리
// 2. StringTokenizer로 문자열 분리해 토큰으로 저장하여 받아오는 방법
class Plus_EndTwoZero {
	
	// StringBuilder클래스 사용
	static StringBuilder sb = new StringBuilder();
	
	// 1. StringTokenizer로 문자열 분리해 토큰으로 저장하여 받아오는 방법
	static void Br_Tokenizer(BufferedReader br) throws IOException {
		
		// while(true)문으로 무한반복을 진행
		// 입력된 숫자 2개가 전부 0일경우 break문 사용하여 반복문 종료
		while (true) {
			// 공백을 기준으로 문자열 분리
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			// 입력된 숫자 2개가 0 0일 경우 break를 통해 반복문 종료
			if (n1==0 && n2==0) {
				break;
			}
			sb.append(n1+n2).append("\n");
		}
		System.out.println(sb);
	}
	
	// 2. String.split()메소드 사용하여 문자열 분리
	static void StrSubString(BufferedReader br) throws IOException {
		
		// while(true)문으로 무한반복을 진행
		// 입력된 숫자 2개가 전부 0일경우 break문 사용하여 반복문 종료
		while (true) {
			// 공백을 기준으로 문자열 분리
			String str = br.readLine();
			int target = str.indexOf(" ");
			
			int A = Integer.parseInt(str.substring(0, target));
			int B = Integer.parseInt(str.substring(target+1));
			
			// 입력된 숫자 2개가 0 0일 경우 break를 통해 반복문 종료
			if (A==0 && B==0) {
				break;
			}
			sb.append(A+B).append("\n");
		}
		System.out.println(sb);
		
	}
}


public class Plus4_EndTest_Input_Zero {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("A+B출력을 위한 숫자를 입력해주세요");
		
		// BufferedReader.readLine()을 통해 입력받게 되면 이는 문자열 한 줄을 한번에 입력받음
		// 따라서 공백을 기준으로 문자열 분리 필요
		// 1. StringTokenizer로 문자열 분리해 토큰으로 저장하여 받아오는 방법
		// 2. String.split()메소드 사용하여 문자열 분리
		
		// 두 메소드 중 하나만 사용하여 출력
		// 1. Br_Tokenizer()메소드 호출
		Plus_EndTwoZero.Br_Tokenizer(br);
		
		// 2. StrSubString()메소드 호출
		Plus_EndTwoZero.StrSubString(br);
		
	}

}
