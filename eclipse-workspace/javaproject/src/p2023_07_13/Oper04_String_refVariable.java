package p2023_07_13;

//비교 연산자: >, >=, <, <=, ==, !=
//비교 연산자의 결과가 참이면 true, 거짓이면 false
public class Oper04_String_refVariable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String은 참조형 변수(기본 자료형X) - 공통되는 자료값을 가짐
		// 값이 저장되는 영역과, 주소값이 저장되는 영역이 분리되어 있음
		// String 변수 자체는(Str1,Str2...) stack에 저장됨)
		// 실제 문자열은 heap 영역의 String Pool에 저장됨
		// (동일한 문자열 리터럴을 가진 String 객체는 동일한 메모리 주소를 참조)
		
		// (stack에는 str1이라는 String변수 자체가 저장되고, heap에는 "자바"가 저장됨)
		String str1 = "자바";
		// (stack에는 str2가 저장되고,
		//  heap에는 '기존에 저장된' "자바"라는 값을 str2가 return되어 갖게됨)
		String str2 = "자바";
		// new연산자에 의해 "자바"라는 값을 heap에 새로이 저장하게 되고,
		// stack에 str3가 new에 의해'새로 생성된'"자바"값을 return되어 갖게됨)
		String str3 = new String("자바");
		
		// 비교대상1-주소값: 비교 연산자로 주소값을 비교
		if (str1 == str2) {
			System.out.println("같은 주소");	// 같은 주소
		} else {
			System.out.println("다른 주소");
		}
		// String 참조형 변수 => 동일한 문자열 값을 가진 문자열들은 같은 주소값을 참조함
		// (String-Pool(heap영역 내 특정영역)이라는 영역에 문자열("자바")을 저장하고, 이는 재사용되기 때문)
		
		// new연산자를 사용하여 새로운 문자열 객체를 생성한 경우,
		// 새로운 메모리공간에 문자열이 저장됨 => 기존의 주소값과 다른 주소값을 갖게됨
		if (str1 == str3) {
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소");	// 다른 주소
		}
		
		// 비교대상2-(실제)값: equals메소드로 값(문자열의 내용)을 비교
		System.out.println(str1.equals(str2));	// true(자바 = 자바)
		System.out.println(str1.equals(str3));	// true(자바 = 자바)
		
		
	}

}
