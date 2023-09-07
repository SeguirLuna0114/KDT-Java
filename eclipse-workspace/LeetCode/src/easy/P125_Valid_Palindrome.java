package easy;

/** Palindrome인지 여부 알아보는 프로그램
 * 입력값에서 스페이스와 부호들을 다 빼고, 모든 글자를 소문자로 바꾼 후 체크
 * 
 * -Alphanumeric characters include letters and numbers
 * - if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters
 * - it reads the same forward and backward.
 * - If it is a palindrome, return true. or false.
 * 
 * ex) s = "A man, a plan, a canal: Panama" => true
 */
public class P125_Valid_Palindrome {
	
	/** StringBuilder클래스의 reverse메소드를 사용하여
	 *  palindrome인지 확인
	 */
	
//	방법1) replaceAll()메소드를 사용하여 알파벳과 숫자 이외의 값을 제거
	static boolean isPalindrome(String s) {
		
		/* String replaceAll(String regex, String replacement)메소드
		 * : 문자열에서 지정된 정규 표현식(Regex) 패턴의 모든 발생을 
		 *   주어진 대체 문자열로 교체
		 * => 문자열에서 모든 공백(예: 공백, 탭, 개행)을 제거
		 *    이때 정규표현식 패턴의 모든 공백문자는 "\\s" (\는 이스케이프문자이기에 2번 사용)
		 */
		s = s.replaceAll("\\s", "");	// 공백을 빈 문자열로 대체
		
		/* 알파벳 (대소문자) 및 숫자를 제외한 모든 문자를 제거
		 * "[^a-zA-Z0-9]" : 알파벳 (대소문자) 및 숫자를 제외한 다른 모든 문자
		 *  - ^는 부정(negation)
		 *  - a-zA-Z0-9는 알파벳 대문자, 소문자 및 숫자
		 */
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		
		// 알파벳 대문자를 소문자로 변환하여 체크
		s = s.toLowerCase();
		
		// StringBuilder클래스의 reverse메소드를 사용하여 palindrome인지 확인
		StringBuilder rev_s = new StringBuilder(s).reverse();
		
		if(rev_s.toString().equals(s)) {
			return true;
		}
		return false;
	}
	
	
//	방법2) Character.isLetterOrDigit()메소드를 사용하여 숫자와 알파벳으로만 이루어진 문자인지 확인
	static boolean isPalindrome2(String s) {
		
		// StringBuilder클래스를 사용하여 영문자와 숫자로만 이루어진 문자열을 확인
		StringBuilder sb = new StringBuilder();
		
		// 문자열을 하나의 문자 단위로 파싱한 배열을 탐색
		for(char ch : s.toCharArray()) {
			
			/** boolean isLetterOrDigit(char ch)메소드
			 * : ch가 영문자(알파벳) 또는 숫자인 경우 true를 반환하고, 
			 *   그렇지 않은 경우 false를 반환
			 *  - 문자가 영문자 또는 숫자인지 여부를 확인하는데 사용
			 */
			if(Character.isLetterOrDigit(ch)) {
				// 해당 문자를 소문자로 변경하여 추가
				sb.append(Character.toLowerCase(ch));
			}
		}
		
		// 해당 문자열을 reverse하여 palindrome인지 확인
		s = sb.toString();
		String rev_s = sb.reverse().toString();
		
		return s.equals(rev_s);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "A man, a plan, a canal: Panama";
		
//		방법1) replaceAll()메소드를 사용하여 알파벳과 숫자 이외의 값을 제거
		System.out.println(isPalindrome(s));
		
//		방법2) 
		System.out.println(isPalindrome2(s));
	}
}
