package basic;

/** Reverse words in a Sentence.
 * - String reverse를 하는데, letter별로가 아닌 "Words"단어 별로
 * 
 * ex) input = "Reverse words in a sentence."
 * 		=> output = "sentence. a in words Reverse"
 * 
 */
public class Reverse_Words_In_a_Sentence {
	
	static String reverseWords(String input) {
		
		// String.split(String regex)메소드를 사용해서 입력받은 문자열을 공백 기준으로 파싱
		String[] inputArr = input.split(" ");
		
		int left = 0;	// 가장 왼쪽 인덱스
		int right = inputArr.length -1;		// 가장 오른쪽 인덱스
		
		while(left < right) {
			
			// 왼쪽과 오른쪽 인덱스 값을 교환
			String temp = inputArr[left];
			inputArr[left++] = inputArr[right];
			inputArr[right--] = temp;
		}
		
		// reverse한 문자열이 담긴 배열 -> 공백을 포함한 문자열로 변환
		// 배열의 맨 첫번째 값을 담는다.
		String returnStr = inputArr[0];
		// 그 이후 각 배열의 값들을 공백을 포함해서 문자열로 만든다
		for(int i=1; i<inputArr.length; i++) {
			returnStr += " " + inputArr[i];
		}
		
		return returnStr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "Reverse String in a sentence.";
		
		// 단어별로 뒤집는 메소드 실행
		System.out.println(reverseWords(input));
	}
}
