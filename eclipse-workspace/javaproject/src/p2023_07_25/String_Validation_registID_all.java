package p2023_07_25;

import java.util.Scanner;

//유효성검사 : 데이터나 정보가 주어진 규칙, 조건 또는 목적에 부합하는지를 확인하는 과정

// substring()메소드 : 문자열에서 특정 범위에 해당하는 "부분" 문자열을 추출하는 역할
// charAt(int index) 메소드 : 문자열에서 지정한 index번호에 해당하는 문자 1개를 반환
// indexOf()메소드 : 문자열 내에서 특정 문자 또는 문자열의 인덱스를 찾을 때 사용
public class String_Validation_registID_all {

	// 키보드로 주민번호를 입력받고, 남자인지 여자인지 판별하는 프로그램
	// 단, 주민번호 앞자리는 6자리, 뒷자리는 7자리인지 유효성 검사를 실행
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("주민번호를 입력해주세요(ex. nnnnnn-nnnnnnn");
		Scanner sc = new Scanner(System.in);
		
		// 입력받은 주민번호를 문자열로 받음
		String IDString = sc.nextLine();
		
		// 주민번호 문자열에서 index=6에 입력된 문자가 '-'인지 확인
		char hyphen = IDString.charAt(6);
		// 주민번호 문자열에서 구분자(-)가 입력된 인덱스번호가 6인지 확인
		int hyphenIdx = IDString.indexOf('-');
		
		// 주민번호 문자열의 앞자리와 뒷자리로 나눠서 확인
		String IDString1 = IDString.substring(0, 6);
		String IDString2 = IDString.substring(7);
		
	}

}
