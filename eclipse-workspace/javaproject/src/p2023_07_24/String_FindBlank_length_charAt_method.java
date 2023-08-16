package p2023_07_24;

// 문자열 관련 클래스 - String, StringBuffer, StringTokenizer
// length()메소드 : 문자열의 길이를 구해주는 역할
// charAt(int index)메소드 : index번호에 해당하는 문자 1개를 구해주는 역할
public class String_FindBlank_length_charAt_method {

	public static void main(String[] args) {

		String message = "Java program creates many objects.";

		// message의 길이를 구함.
		int len = message.length();

		System.out.println(len); // len = 34;

		// message 중에서 ' '(공백)을 찾음
		for (int i = 0; i < len; i++) {
			// charAt()메소드 사용 => i번째 인덱스에 있는 문자를 가져옴
			char c = message.charAt(i);
			// c변수에 저장된 문자가 공백인지 확인
			if (c == ' ') {
				System.out.println("index = " + i);
			}
		} // for end
	}
}
