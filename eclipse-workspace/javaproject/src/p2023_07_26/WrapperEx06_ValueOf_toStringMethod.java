package p2023_07_26;

// p498
// 숫자 데이터를 문자열로 변환 : 20 ---> "20"
// 기본 데이터타입 -> Wrapper 클래스 변환
// - 이 경우에는 wrapper클래스를 반드시 사용하지 않아도 됨

// String클래스의 valueof()메소드
// 기본데이터타입과 Wrapper클래스 객체를 "문자열"로 변환 시 사용
// 기본 데이터타입 -> Wrapper클래스로 변환하는 경우에도 사용
//	(모든 기본 데이터타입을 해당하는 Wrapper클래스로 변환 가능)

// Integer.toString(int i)메소드 
// : Integer객체 내부의 int값을 문자열로 반환
public class WrapperEx06_ValueOf_toStringMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// String클래스의 valueOf메소드
		// int(정수)형 10 -> 문자열 "10" 변환
		String str1 = String.valueOf(10);		// 문자열 "10"
		// double형(부동소수점 데이터) 10.5 -> 문자열 "10.5"
		String str2 = String.valueOf(10.5);		// 문자열 "10.5"
		// boolean(논리)형 true -> 문자열 "true"
		String str3 = String.valueOf(true);		// 문자열 "true"
		
		// Wrapper Class 객체 생성: Intger 30 -> 문자열 30
		// Integer: int의 Wrapper클래스로, 기본 데이터타입 int를 감싸주는 역할
		// int형 30 -> Integer객체로 변환
		Integer it = new Integer(30);			// Integer객체 30
		// Integer.toString(int i)메소드 : Integer객체 내부의 int값을 문자열로 반환
		String str4 = it.toString();			// 문자열 "30"
		// int값 30 -> 문자열 "30"
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);

	}

}
