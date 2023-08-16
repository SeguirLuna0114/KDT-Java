package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 각 알파벳에 대해서, 
// 단어에 포함된 경우에는 처음 등장하는 위치를, 포함되지 않은 경우에는 -1을 출력하는 프로그램
public class FindAlphabet {

	// BufferedReader클래스 활용
	static void UseBuffReader() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받은 문자열 S
		String S = br.readLine();
		
		// 알파벳이 등장하는 위치 및 유무(-1)를 확인할 수 있는 배열 생성
		int[] AlphaArr = new int[26];
		for (int i=0; i < AlphaArr.length; i++) {
			// 알파벳이 한번도 포함되지 않는 경우에는 -1이 출력되어야 하기에,
			// 초기값을 -1로 설정
			AlphaArr[i] = -1;
		}
		
		// 각 알파벳에 대해서 처음등장하는 위치를 공백으로 구분해서 출력
		// 단어의 첫번째 글자는 0번째 위치, 두번째 글짜는 1번째위치
		for (int i=0; i < S.length(); i++) {
			// charAt()메소드를 활용해서 문자열의 문자를 하나씩 ASCII코드값으로 받아옴
			char charAlpha = S.charAt(i);
			
			// 만일 받아온 문자값이 나온적 없는 경우(처음 등장하는 경우), 등장위치 출력
			if (AlphaArr[charAlpha-'a'] == -1) {
				// 배열의 초기값(-1)으로 설정된 값을 해당 인덱스번호(i)값으로 업데이트
				AlphaArr[charAlpha-'a'] = i;	// 단어 첫글자의 위치를 0으로 설정
			}
		}
		
		// 해당 배열을 출력(공백을 구분자로 사용)
		for (int value : AlphaArr) {
			System.out.print(value+" ");
		}
	}
	
	// 알파벳 소문자로만 주어진 단어 S가 주어짐. 단어의 길이는 100을 넘지 않으며, 소문자로 이루어짐
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("알파벳 소문자로 이루어진 단어S를 입력하세요(단, 단어의 길이는 100을 넘지X)");

		// BufferedReader클래스를 활용한 UseBuffReader()메소드 사용
		UseBuffReader();
		
	}

}
