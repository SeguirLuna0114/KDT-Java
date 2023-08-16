package p2023_07_25;

import java.util.StringTokenizer;

// String클래스의 split(String regex)메소드
// - 반환되는 값은 구분자로 구분된 문자열이 배열 String[]형태로 반환됨
// -StringTokenizer클래스와 비슷
public class String_Split_method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String IdStr = "950101-1234567";
		
		// 1. StringTokenizer클래스 활용
		// StringTokenizer 객체 생성 => IdStr문자열을 "-"구분자로 파싱
		StringTokenizer str = new StringTokenizer(IdStr, "-");
		String IdStr1 = str.nextToken();
		String IdStr2 = str.nextToken();
		System.out.println("주민번호 앞자리: "+IdStr1);
		System.out.println("주민번호 뒷자리: "+IdStr2);
		
		// 구분자 포함하여 파싱하는 StringTokenizer객체 생성
		StringTokenizer strtrue = new StringTokenizer(IdStr, "-", true);
		String IdStrTrue1 = strtrue.nextToken();
		String Delim = strtrue.nextToken();
		String IdStrTrue2 = strtrue.nextToken();
		System.out.println("주민번호 앞자리: "+IdStrTrue1);
		System.out.println("구분자: "+ Delim);
		System.out.println("주민번호 뒷자리: "+IdStrTrue2);
		
		System.out.println();
		
		// 2. String클래스의 split()메소드
		String[] IDSplit = IdStr.split("-");
		System.out.println("주민번호 앞자리: "+IDSplit[0]);
		System.out.println("주민번호 뒷자리: "+IDSplit[1]);
		// 기본 for문 사용
		for (int i=0; i < IDSplit.length; i++) {
			System.out.println(IDSplit[i]);
		}
		System.out.println();
		// 확장 for문
		for (String s : IDSplit) {
			System.out.println(s);
		}
		
		System.out.println();
		
		// hyphen(-) 구분기호로 작성된 문자열
		String tel = "010-1234-5678";
		String[] telArr = tel.split("-");
		System.out.println("전화번호 앞자리: "+telArr[0]);
		System.out.println("전화번호 중간자리: "+telArr[1]);
		System.out.println("전화번호 뒷자리: "+telArr[2]);
		
		// @기호를 구분자로 사용하여 작성된 문자열 split
		String email = "totor@naver.com";
		String[] emailArr = email.split("@");
		System.out.println("아이디: "+ emailArr[0]);
		System.out.println("도메인: "+ emailArr[1]);
		
	}

}
