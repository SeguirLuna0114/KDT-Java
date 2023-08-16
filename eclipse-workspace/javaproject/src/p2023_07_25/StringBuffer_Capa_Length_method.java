package p2023_07_25;

// StringBuffer클래스
// -문자열을 저장하기는 하지만, StringBuffer는 시작주소값이 바뀌지X => append처리O

// capacity()메소드: StringBuffer 객체의 내부 버퍼의 용량(capacity)을 반환
// length(): StringBuffer 객체의 문자열 길이를 반환
public class StringBuffer_Capa_Length_method {
	
	public static void main(String[] args) {
		// 1. "문자열"로 초기화 된 객체 생성
		// StringBuffer(String str) 생성자를 호출
		// gemini"이라는 문자열로 초기화된 StringBuffer 객체 sb1을 생성
		StringBuffer sb1 = new StringBuffer("gemini");
		
		System.out.println("sb1.length() : " + sb1.length());
		// gemini의 문자열 길이는 6
		System.out.println("sb1.capacity() : " + sb1.capacity());
		// StringBuffer의 기본 capa(16)+gemini매개변수의 길이(6)=22

		sb1.append("A string buffer implements" + "a mutable sequence of characters");
		System.out.println("sb1.length() : " + sb1.length());
		System.out.println("sb1.capacity() : " + sb1.capacity());

		// 2. 기본 생성자를 사용하여 빈 객체 생성
		// StringBuffer의 기본생성자를 호출하는 코드를 이용해, StringBuffer객체 생성
		StringBuffer sb2 = new StringBuffer();
		// 빈 StrinBuffer객체 생성 => 초기에 아무런 문자열 포함X, 비어있는 상태
		
		System.out.println("sb2.length() : " + sb2.length());
		// sb2의 문자가 없기에, 길이는 0으로 출력
		System.out.println("sb2.capacity() : " + sb2.capacity());
		// heap메모리 상에 16글자를 저장할 수 있는 용량을 생성(capacity of 16 characters)
	}
}
