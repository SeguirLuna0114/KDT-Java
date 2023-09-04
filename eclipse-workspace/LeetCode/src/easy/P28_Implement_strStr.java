package easy;

/** Implement strStr() "건초더미에서 바늘찾기"
 * Needle이 haystack에 포함되어 있다면 몇번째에 needle이 시작하는지 return
 * 
 * -Given two strings needle and haystaack
 * -return the index of the first occurence of needle in haystack
 * -if needle is not part of haystack, return -1
 * - when needle is an empty string, then return 0
 * 
 * ex) haystack = "hello", needle = "ll" -> 2
 * 	   haystack = "aaaaa", needle = "bba" -> -1
 */
public class P28_Implement_strStr {
	
	// String.split()메소드를 사용해서 문자열을 파싱
	static int strStr(String haystack, String needle) {
		
		// 입력받은 haystack을 needle을 기준으로 파싱
		String[] haySplit = haystack.split(needle);
		
		// boolean contains(CharSequence s)메소드를 사용해서 해당 문자열을 포함하는지 여부 확인
		if(!haystack.contains(needle)) {
			// 없다면 -1을 리턴
			return -1;
		}
		// needle과 haystack문자열이 같거나, split메소드로 파싱한 문자열 배열이 비어있거나, 입력받은 needle이 없다면 0 리턴
		else if(haystack.equals(needle) || haySplit.length == 0 || needle.isEmpty()) {
			return 0;
		}
		/** 그 외에 파싱한 문자열 배열이 존재한다면, 파싱한 문자열 배열의 길이를 출력
		 * ex) "hello"를 "ll"기준으로 파싱한다면, haySplit = ["he", "o"]이기에, 
		 *		해당 첫번째 원소의 길이 = needle문자열 시작 인덱스 이므로, 해당 문자열 길이 반환
		 */
		else {
			return haySplit[0].length();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 해당 메소드 실행
		System.out.println(strStr(args[0], args[1]));
	}
}
