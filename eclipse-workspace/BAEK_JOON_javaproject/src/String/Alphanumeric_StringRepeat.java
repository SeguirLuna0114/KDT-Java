package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Alphanumeric_StringRepeat {

	// BufferedReader클래스를 활용하여 문자열을 읽어올 경우
	static void UseBuffReader() throws IOException {
		
		// BufferedReader클래스의 readLine()메소드는 한줄을 통째로 입력받기에,
		// StringTokenizer클래스 or split()메소드를 활용하여 구분해줘야 함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받은 첫째줄은 테스트케이스
		int T = Integer.parseInt(br.readLine());
		
		// 테스트케이스 수만큼 입력받은 케이스를 반복문으로 받아옴
		for (int i=0; i<T; i++) {
			// split()메소드를 활용하여 문자열 사이 공백을 구분
			String[] strArr = br.readLine().split(" ");
			
			// 구분된 값을 각 변수에 할당
			int R = Integer.parseInt(strArr[0]);
			// String[]배열의 값은 문자열이기에, 문자 -> 숫자로 변환
			String S = strArr[1];
			
			// 입력받아온 문자열의 길이만큼 문자열 순회
			for (int j=0; j<S.length(); j++) {
				// 반복횟수는 입력받은 R의 크기만큼 진행
				for (int k=0; k<R; k++) {
					// charAt()메소드를 활용해 문자열을 하나의 문자로 받아옴
					System.out.print(S.charAt(j));
				}
			}
			// 첫번째 테스트케이스가 끝나면 행변환
			System.out.println();
		}
	}
	
	
	// Scanner클래스를 활용하여 문자열을 읽어올 경우
	static void UseScanner() {
		
		Scanner sc = new Scanner(System.in);
		// 입력받은 첫째줄은 테스트케이스
		int T = sc.nextInt();	// 정수값으로 읽어옴
		
		// 테스트케이스 수만큼 입력받은 케이스를 반복문으로 받아옴
		for (int i=0; i<T; i++) {
			int R = sc.nextInt();
			String S = sc.next();
			// 이 경우, nextLine()을 활용하여 문자열을 입력받아오면 안됨!
			// Scanner.next(): 문자열을 입력받을 때 띄어쓰기(공백)을 기준으로 하나의 문자열을 입력받음
			// Scanner.nextLine(): 문자열을 입력받을 때 개행문자 이전까지 한줄을 입력받음(한 줄씩 입력받음 => 공백까지 읽음)
			
			// 입력받아온 문자열의 길이만큼 문자열 순회
			for (int j=0; j<S.length(); j++) {
				// 반복횟수는 입력받은 R의 크기만큼 진행
				for (int k=0; k<R; k++) {
					// charAt()메소드를 활용해 문자열을 하나의 문자로 받아옴
					System.out.print(S.charAt(j));
				}
			}
			// 첫번째 테스트케이스가 끝나면 행변환
			System.out.println();
		}
	}
	
	
	// 첫째줄에 테스트 케이스의 개수T(1 <= T <= 1,000)가 주어짐
	// 각 테스트 케이스는 반복횟수 R(1 <= R <= 8) 문자열S가 공백으로 구분됨
	// 문자열의 길이는 적어도 1이며, 20글자를 넘지 않음
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫째줄에 테스트 케이스의 개수T와 각 테스트케이스 반복횟수R 및 문자열을 입력해주세요?");
		
		// Scanner클래스를 활용하여 문자열 입력받는 방법
		UseScanner();
		
		// BufferedReader클래스를 활용하여 문자열 입력받는 방법
		UseBuffReader();
	}

}
