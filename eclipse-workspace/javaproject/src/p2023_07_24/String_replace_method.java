package p2023_07_24;

//문자열 관련 클래스 - String, StringBuffer, StringTokenizer

// p494
// replace(oldChar, newChar) 메소드
// : oldChar를 newChar로 변경해주는 역할
public class String_replace_method {

	// 자바를 JAVA로 치환하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String oldStr = "자바는 객체지향 언어 입니다.";
		System.out.println(oldStr);
		
		// oldStr.replace("자바", "JAVA") : 자바를 JAVA로 변환
		String newStr = oldStr.replace("자바", "JAVA");
		System.out.println(newStr);

	}

}
