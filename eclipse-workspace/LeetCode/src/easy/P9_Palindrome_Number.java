package easy;

/** Palindrome Number : 앞으로 해도 뒤로 해도 똑같은 숫자
 * : An Integer is a palindrome when it reads the same backward as forward.
 * - Given an integer x, return true if x is palindrome integer.
 * 
 * ex) 121 is a palindrome while 123 is not
 */
public class P9_Palindrome_Number {
	
//	방법1) charAt()메소드를 사용해서 문자 하나씩 확인
	static boolean checkPalindrome(int x) {
		
		// 입력받은 x를 문자열로 변환
		String Strx = Integer.toString(x);
		
		// 맨 처음과 끝 인덱스 값(Strx의 범위) 설정
		int left = 0;
		int right = Strx.length() -1;
		
		while(left < right) {
			// 맨 왼쪽과 오른쪽 값이 다르면 false
			if(Strx.charAt(left++) != Strx.charAt(right--)) {
				return false;
			}
		}
		// 만일 맨 왼쪽과 오른쪽 값이 "전부" 같다면 
		return true;
	}
	
//	방법2)StringBuilder클래스의 reverse()메소드 &  String클래스의 equals()메소드 사용
	static boolean isPalindrome(int x) {
		
		// 입력받은 x를 문자열로 변환
		String Strx = Integer.toString(x);
		
		// StringBuilder(String str)생성자를 사용해 객체 생성
		StringBuilder Strx_rev = new StringBuilder(Strx).reverse();
		
		// String클래스의 equals메소드 사용하여 두 값이 같은지 확인
		return Strx_rev.toString().equals(Strx);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = Integer.parseInt(args[0]);
		
		// Palindrome Number인지 확인하는 메소드 실행
//		방법1) charAt()메소드를 사용해서 문자 하나씩 확인
		System.out.println(checkPalindrome(x));
		
//		방법2)StringBuilder클래스의 reverse()메소드 &  String클래스의 equals()메소드 사용
		System.out.println(isPalindrome(x));

	}
}
