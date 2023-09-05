package easy;

/** Length of Last Word
 * 입력된 문장 중에서 맨 마지막 단어의 알파벳 개수를 알아내는 문제
 * 
 * - Given a string s consisting of words and spaces,
 * 	 return the length of the last word in the string.
 * - A word is a maximal substring consisting of non-space characters only.
 * 
 * ex) s = "Hello World" => output : 5
 * 	   s = "   fly   me   to   the   moon   " => output : 4
 * 
 */
public class P58_Length_of_Last_Word {
	
	
//	방법1) 공백을 기준으로 String.split()메소드를 사용해 String[]배열로 만듬
	static int lengthOfLastWord(String s) {
		
		// String.split(String regex)메소드를 사용하여 문자열 파싱
		String[] splitStr = s.split(" ");	// 공백 기준으로 파싱
		
		// 문자열 배열의 가장 마지막 문자열의 길이를 반환
		return splitStr[splitStr.length - 1].length();
	}
	
	
//	방법2) 문장의 맨 끝에서 앞으로 이동하며 공백을 찾는 방법
	static int lengthOfLastWord_findBlank(String s) {
		/**
		 * 문장의 맨 마지막으로 이동한 후, 공백이 아니면 문자의 앞으로 이동하고, 
		 * 공백이 나왔다면 멈춤 = 마지막 단어의 첫 알파벳에서 멈춤
		 * 위 과정을 반복하는 동안 length++를 해줌 => 그 값을 return
		 */
		// 공백을 건너뛰어 문자열의 마지막 단어의 첫 번째 알파벳 위치(인덱스)를 찾음
		int idx = s.length()-1;		// s의 마지막 인덱스로 설정
		while(idx>=0 && s.charAt(idx) == ' ') {
			idx--;
		}
		
		// 마지막 단어의 길이 계산
		int length = 0;
		while(idx>=0 && s.charAt(idx) != ' ') {
			idx--;
			length++;
		}
		
		return length;
	}
	
	
//	방법3) 문장의 맨 끝에서 앞으로 이동하며 공백을 찾는 방법_간소화
	static int lengthOfLastWord_findBlank2(String s) {
		
		int idx = s.length()-1;		// s의 마지막 인덱스로 설정
		int length = 0;		// 마지막 단어의 길이 계산
		
		while(idx > 0) {
			
			// 마지막 단어 내부라면(공백이 아니라면)
			if(s.charAt(idx--) != ' ') {
				length++;
			}
			
			// 공백이고 마지막단어의 길이가 갱신된 이후라면
			else if(length > 0) {
				return length;
			}
			
		}
		
		// 공백이 나오지 않았다면(한 단어로만 이루어진 문자열인 경우) 갱신된 문자열 길이를 반환
		return length;
	}
	
	
//	방법4) trim()메소드를 사용하는 방법 + lastIndexOf()메소드로 마지막 공백 인덱스 위치 활용
	static int lengthOfLastWord_trim(String s) {
		/** String.trim()메소드로 문자열의 앞뒤 공백을 없앤 후
		 * 문장의 전체 알파벳 개수를 통해 마지막 인덱스를 구하고(공백이 포함됨), 
		 * 거기에 이 문장의 마지막 공백 위치(인덱스)를 구해서 
		 * 문자열 마지막 인덱스 - 마지막 공백 인덱스 = 마지막 단어의 알파벳 개수
		 */
		 //문자열 앞뒤 공백 제거
		s = s.trim();
		
		// 문자열 마지막 인덱스 - 마지막 공백 인덱스
		// int lastIndexOf(String str)메소드를 사용해서 마지막 공백의 인덱스 값을 구함
		return (s.length()-1) - s.lastIndexOf(" ");
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "   fly   me   to   the   moon";
		
//		방법1) 공백을 기준으로 String.split()메소드를 사용해 String[]배열로 만듬
		System.out.println(lengthOfLastWord(s));
		
//		방법2) 문장의 맨 끝에서 앞으로 이동하며 공백을 찾는 방법
		System.out.println(lengthOfLastWord_findBlank(s));

//		방법3) 문장의 맨 끝에서 앞으로 이동하며 공백을 찾는 방법_간소화
		System.out.println(lengthOfLastWord_findBlank2(s));
		
//		방법4) trim()메소드를 사용하는 방법 + lastIndexOf()메소드로 마지막 공백 인덱스 위치 활용
		System.out.println(lengthOfLastWord_trim(s));
	}
}
