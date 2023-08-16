package p2023_07_24;

//문자열 관련 클래스 - String, StringBuffer, StringTokenizer

//substring()메소드 : 전체 문자열에서 특정 범위의 문자를 추출하는 역할
//String substring(int beginIndex) : beginIndex번호부터 끝까지 문자 추출
//String substring(int beginIndex, int endIndex)
//: beginIndex번호부터 endIndex-1번까지 문자를 추출
public class String_SubstringEx_registrationNum {

	// 아래와 같은 주민번호가 있을 때, 남자인지 여자인지를 판별하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 주민번호 문자열 작성
		String jumin = "950101-2234567";
		
		// substring()메소드 사용
		String identi = jumin.substring(7, 8);
//		if (identi == "1") {	// 문자열비교시, equals()메소드 사용
		
		if (identi.equals("1") || identi.equals("3")) {
			System.out.println("남자입니다.");
		} else if (identi.equals("2") || identi.equals("4")) {
			System.out.println("여자입니다.");
		} else {
			System.out.println("잘못된 정보입니다.");
		}
		
		// charAt(int index)메소드 사용
		char gender = jumin.charAt(7);
		// char 문자열 비교시 ==연산자 사용
		if (gender == '1' || gender == '3') {
			System.out.println("남자입니다.");
		} else if (gender == '2' || gender == '4') {
			System.out.println("여자입니다.");
		} else {
			System.out.println("잘못된 정보입니다.");
		}
		

	}

}
