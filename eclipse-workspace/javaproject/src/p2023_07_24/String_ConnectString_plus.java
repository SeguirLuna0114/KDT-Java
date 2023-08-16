package p2023_07_24;

//문자열 관련 클래스 - String, StringBuffer, StringTokenizer

// 문자열 결합/연결(String concatenation)
//- 문자열 연결은 '+'연산자를 사용해서 수행
//- 문자열 연결 연산('+')은 heap메모리에 새로운 문자열 객체를 생성하여 결과 반환
public class String_ConnectString_plus {

	public static void main(String[] args) {
		// String 객체 선언
		String gemini = "gemini";
		// gemini (in Stack메모리)	---->	"gemini"(in heap메모리)
		String johnharu = "johnharu";
		// johnharu (in Stack메모리)	---->	"johnharu"(in heap메모리)

		// 두 String 객체를 "+" 연산 수행
		// 가리키는 값들끼리 연산되어 새로운 객체에 형성됨
		String tempString1 = gemini + johnharu;
		// tempString1 (in Stack메모리)	---->	"geminijohnharu"(in heap메모리)
		System.out.println(tempString1);
		
		// 기존 String객체를 문자열 리터럴 방식으로 연결
		// heap메모리에 새로운 문자열 객체를 생성하지 X
		System.out.println("gemini" + "johnharu");
		// tempString1과는 다른 주소값을 참조

		// String + 정수형
		String tempString2 = tempString1 + 100;
		System.out.println(tempString2);
	}
}
