package p2023_07_24;

//문자열 관련 클래스 - String, StringBuffer, StringTokenizer

// trim()메소드 : 문자열 좌, 우의 공백을 없애주는 역할
// boolean equals()메소드 : 문자열 값을 비교하는 역할
public class String_Trim_method {

	public static void main(String[] args) {
		
		// 공백도 메모리상에 공간을 차지
		String str1 = new String("gemini   ");
		String str2 = new String("   gemini ");

		// str1과 str2의 실제값을 비교 - equals()메소드
		System.out.println(str1.equals(str2));
		// 공백에 의해 가리키는 실제값이 다름
		System.out.println(str1.trim().equals(str2.trim()));
	}
}
