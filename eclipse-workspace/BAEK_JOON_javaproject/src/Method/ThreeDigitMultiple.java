package Method;

import java.util.Scanner;

// (세자리수)*(세자리수) 과정 출력
// 곱할 세자리수가 주어지면, 각 자리수 계산하는 값을 출력하고 결과를 출력하는 프로그램
// - 이때 문자열로 입력받는 경우에는, 가장 마지막 출력에서 연산하기 위해 int형으로 변환

// 세자리수 * 세자리수 계산의 과정을 출력
class ThreeDigit {

	// 1. 문자열로 입력받아 charAt() 으로 하나씩 꺼내 쓰는 방법
	static void StringCharAt(int A, String B) {

		// char charAt(int index)메소드
		// -'0'을 해주는 이유 => ASCII코드값이 아닌 숫자 그대로의 값을 저장하기 위함

		// B.charAt(2) - '0';
		System.out.println(A * (B.charAt(2) - '0'));

		// B.charAt(1) - '0';
		System.out.println(A * (B.charAt(1) - '0'));

		// B.charAt(0) - '0';
		System.out.println(A * (B.charAt(0) - '0'));

		// Integer.parseInt()메소드 활용: 문자열 B -> 정수형 B로 변환
		System.out.println(A * Integer.parseInt(B));

		System.out.println();

	}

	// 2. 나머지와 나눗셈 연산을 통해 각 자릿수를 구하여 쓰는 방법
	static void IntDiv(int A, int B) {

		// % : 나머지 연산자 => (int)형 계산시, 소수점 아래 버림
		// B % 10 : B의 첫째자리수(= B의 맨 뒤에서 첫번째자리 수)
		System.out.println(A * (B % 10));

		// B % 100 : B의 뒤에서 두번째자리 수까지
		// (B % 100) / 10 : B의 뒤에서 두번째자리 수
		System.out.println(A * ((B % 100) / 10));

		// B / 100 : B의 뒤에서 세번째자리 수
		System.out.println(A * (B / 100));

		// 실제 결과값
		System.out.println(A * B);

		System.out.println();

	}

	// 3. 문자열을 char배열로 한 자리씩 넣어주어 이용
	static void StrToCharArr(int A, String B) {

		// str.toCharArray()메소드 사용하여 String -> char[] 배열 변환
		char[] charBarr = B.toCharArray();
		// ex) 325 => charBarr[0]='3'; charBarr[1]='2'; charBarr[2]='5';

		// 세자리수 * 세자리수 계산의 과정을 출력
		// 문자열 배열의 앞에서 세번째자리 수 - '0'
		System.out.println(A * (charBarr[2] - '0'));

		// 문자열 배열의 앞에서 세번째자리 수 - '0'
		System.out.println(A * (charBarr[1] - '0'));

		// 문자열 배열의 앞에서 세번째자리 수 - '0'
		System.out.println(A * (charBarr[0] - '0'));

		// Integer.parseInt()메소드 활용: 문자열 B -> 정수형 B로 변환
		System.out.println(A * Integer.parseInt(B));

		System.out.println();

	}
}

public class ThreeDigitMultiple {

	public static void main(String[] args) {
		
		System.out.println("세자리 수 2개를 입력해주세요?");

		Scanner sc = new Scanner(System.in);

		// 1. 문자열로 입력받아 charAt() 으로 하나씩 꺼내 쓰는 방법
		int A = sc.nextInt();		// 첫번째 입력 세자리수
		// nextInt()는 엔터는 처리하지 않음 
		sc.nextLine();
		String B = sc.nextLine();	// 두번째 입력 세자리수

		// 세자리수 * 세자리수 계산의 과정을 출력
		ThreeDigit.StringCharAt(A, B);

		// 2. 나머지와 나눗셈 연산을 통해 각 자릿수를 구하여 쓰는 방법
		int IntB = Integer.parseInt(B); // 두번째 입력값을 정수형으로 변환

		// 세자리수 * 세자리수 계산의 과정을 출력
		ThreeDigit.IntDiv(A, IntB);

		// 3. 문자열을 char배열로 한 자리씩 넣어주어 이용
		ThreeDigit.StrToCharArr(A, B);

	}
}