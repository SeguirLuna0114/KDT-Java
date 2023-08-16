package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Switch-case문 : 특정한 조건이 불규칙적일 때 "가독성"이 좋아서 사용

// 전화를 걸기 위해 필요한 시간을 구하는 프로그램
public class Swtich_Case_IrregularCase {
	
	static int CntTime(String AlphabetStr) {
		int cnt=0;
		// 숫자1을 걸려면 2초가 걸림
		for (int i=0; i < AlphabetStr.length(); i++) {
			//Switch case문 작성
			switch (AlphabetStr.charAt(i)) {
				// charAt()메소드로 가져오기에 반환타입 char('')
				case 'A': case 'B': case 'C':
					// 숫자 2에 위치: 숫자 1에 걸리는 시간+1초
					cnt += 3;
					break;
				case 'D': case 'E': case 'F':
					// 숫자 2에 위치: 숫자 1에 걸리는 시간+2초
					cnt += 4;
					break;
				case 'G': case 'H': case 'I':
					// 숫자 2에 위치: 숫자 1에 걸리는 시간+3초
					cnt += 5;
					break;
				case 'J': case 'K': case 'L':
					// 숫자 2에 위치: 숫자 1에 걸리는 시간+4초
					cnt += 6;
					break;
				case 'M': case 'N': case 'O':
					// 숫자 2에 위치: 숫자 1에 걸리는 시간+5초
					cnt += 7;
					break;
				case 'P': case 'Q': case 'R': case 'S':
					// 숫자 2에 위치: 숫자 1에 걸리는 시간+6초
					cnt += 8;
					break;
				case 'T': case 'U': case 'V':
					// 숫자 2에 위치: 숫자 1에 걸리는 시간+7초
					cnt += 9;
					break;
				case 'W': case 'X': case 'Y': case 'Z':
					// 숫자 2에 위치: 숫자 1에 걸리는 시간+8초
					cnt += 10;
					break;
			}
		}
		return cnt;
	}
	
	
	
	// Buffer을 두고 입력받지 않아도 되는 메소드
	// 원시 입력의 문자값만 알아내 count하면 됨
	static int CntWithoutBuffer() throws IOException {
		int cnt = 0;
		
		int value;
		// 무한반복문 while(true)를 사용하여 입력받은 문자열 값 순회
		while(true) {
			
			// System.in.read() : 표준 입력 스트입의 데이터를 읽어와 해당 문자의 아스키코드값을 바이트의 정수값으로 반환(0~255)
			// 만일 입력값이 없는경우 -1을 반환
			value = System.in.read();
			
			// 반환되는 아스키코드 값이 'a'= 65 ~ 'z'=90
			if (value < 68) cnt += 3 ;
			else if (value < 71) cnt += 4 ;
			else if (value < 74) cnt += 5 ;
			else if (value < 77) cnt += 6 ;
			else if (value < 80) cnt += 7 ;
			else if (value < 84) cnt += 8 ;
			else if (value < 87) cnt += 9 ;
			else if (value < 91) cnt += 10;
			
			if (value == '\n') {
				break;
			}
		}
		return cnt;
	}

	
	
	// 첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어(2~15글자)
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("2~15글자의 알파벳 대문자로 이루어진 단어를 입력해주세요.");
		
		// CntTime()메소드를 활용하여 소요시간 계산
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String AlphabetStr = br.readLine();
		
		System.out.println(AlphabetStr+"소요시간= "+CntTime(AlphabetStr));

		// Buffer을 두고 입력받지 않아도 되는 메소드. 원시 입력의 문자값만 알아내 cnt++
		// 해당 메소드는 bufferedReader클래스 사용할 필요X => System.in.read으로 바로 읽어옴
//		System.out.println("소요시간= "+CntWithoutBuffer());
	
	}

}
