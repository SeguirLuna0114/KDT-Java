package p2023_07_24;

//문자열 관련 클래스 - String, StringBuffer, StringTokenizer

// substring()메소드 : 전체 문자열에서 특정 범위의 문자를 추출하는 역할
// String substring(int beginIndex) : beginIndex번호부터 끝까지 문자 추출
// String substring(int beginIndex, int endIndex)
// : beginIndex번호부터 endIndex-1번까지 문자를 추출
public class String_substring_method {
	
	public static void main(String[] args) {

		String message = "Java program creates many objects.";

		// 인덱스번호 13번 부터 끝까지 문자를 추출
		String str1 = message.substring(13);
		System.out.println(str1);	// creates many objects.

		// 인덱스번호 13번 부터 15번까지 문자를 추출
		String str2 = message.substring(13, 16);
		System.out.println(str2);	// cre
		
	}
}
