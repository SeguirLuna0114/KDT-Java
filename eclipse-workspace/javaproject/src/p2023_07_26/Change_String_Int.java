package p2023_07_26;

// 문자열 <-> 숫자 변환

// 1. String.valueOf() 메소드: 기본 데이터 타입 -> 문자열로 변환
// 2. 문자열 결합(concatenation) : 정수 -> 문자열
//   : 문자열과 int(정수)를 연결(+) -> 문자열과 문자열로 인식되어 문자열 결합
// 3. Wrapper클래스 Integer 객체 활용 
// 	  - toString() 메소드 : Integer객체가 감싸고 있는 정수값 -> 문자열로 변환
// 	  - Integer.parseInt() 메소드: 문자열 -> int로 변환

public class Change_String_Int {
	
	public static void main(String[] args) {

		// 기본 데이터 형 선언
		int a = 10;
		System.out.println(a + 10);		// 20

		// String 형으로 변환 : 숫자 10 ---> 문자 "10"
		// String.valueOf() 메소드: 기본 데이터 타입 -> 문자열로 변환
		String sa1 = String.valueOf(a);	// String sal = "10"
		
		// 문자열과 int(정수)를 연결(+) -> 문자열과 문자열로 인식되어 문자열 결합(concatenation)
		// int(정수)를 자동으로 문자열로 형변환
		System.out.println(sa1 + 10);	// 1010

		// Wrapper Class 객체 생성	: 숫자 10 ---> 문자 "10"
		Integer oint = new Integer(10);

		// String 형으로 변환
		// toString() 메소드: Integer객체가 감싸고 있는 정수 값인 10을 문자열로 변환
		String sa2 = oint.toString();	// 10 -> "10"
		
		// 문자열과 int(정수)를 연결(+) -> 문자열과 문자열로 인식되어 문자열 결합(concatenation)
		// int(정수)를 자동으로 문자열로 형변환
		System.out.println(sa2 + 10);	// "1010"

		// String형을 int형으로 변환
		// Integer.parseInt() 메소드: 문자열 "10"을 int(10)으로 변환
		int k =  Integer.parseInt(sa2);
		System.out.println(k);			// 10
	}
}