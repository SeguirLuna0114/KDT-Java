package easy;

/* Function that Reverse String
 * - input : array of character s
 * 
 * - 1 <= s.length <= 10^5
 * - s[i] is a printable ascii character
 * 
 */
public class P344_Reverse_String {
	
	// 방법1. 반복문
	static void ReverseString(char[] s) {
		
		// 왼쪽 끝 & 오른쪽 끝 인덱스
		int left = 0;
		int right = s.length -1;
		
		while(left < right) {
			// s[left]의 값과 s[right]의 값을 바꾸는 메소드
			char temp = s[left];
			s[left++] = s[right];
			/** left++ :  left = left+1
			 * - left 가0 -> 이후  left + 1을 하면 left 가 1
			 * - 실행 순서는 s[0] = s[right]을 먼저 실행 한 다음에, left = left+1
			 * - s[0]에 s의 맨 마지막 값이 대입되고 난 후 left는 1
			 * - 다음 while 문 돌 때는 left가 0 이 아니라 1 
			 */
			s[right--] = temp;
			/** right-- : right = right -1 
			 * - s[right] = temp 가 먼저 실행된 후, s[right]에 s 의 맨 처음 값이 대입 
			 * - s[right-1] = temp이 실행됨 -> s[right-1]에 s 의 맨 처음에서 2번째 값이 대입 
			 */
		}
		
	}
	
	// 방법2. recursion방식 
	static void reverseString(char[] s, int idx) {
		
		if(idx < s.length / 2) {
			
			char temp = s[idx];
			s[idx] = s[(s.length -1) - idx];
			s[(s.length -1) - idx] = temp;
			
			reverseString(s, idx+1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		char[] s = args[0].toCharArray();
		
		// 메소드 실행
		// 방법1. 반복문 활용
		ReverseString(s);
		
		// 출력
		System.out.println(s);
		
		// 방법2. 재귀방식 사용
		reverseString(s, 0);
		
		System.out.println(s);
	}
}
