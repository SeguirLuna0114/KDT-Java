package p2023_07_24;

// 문자열 관련 클래스 - String, StringBuffer, StringTokenizer
// String 클래스
// Str변수는 stack에 할당되고, heap메모리에 있는 해당 문자열을 가리킴
class String_new_equalMethod {

	public static void main(String[] args) {
		
		// new연산자 사용시, String클래스의 생성자를 호출하여 heap메모리에 매번 "새로운" 문자열 객체 생성
		String str1 = new String("Java Programming");
		// str1 (in Stack메모리)	---->	"java Programming"(in heap메모리)
		String str2 = new String("Java Programming");
		// str2 (in Stack메모리)	---->	"java Programming"(in heap메모리)

		// str1과 str2의 주소값은 "다르다"
		// new연산자를 사용했기 때문
		if (str1 == str2) {	// 새로운 주소값을 리턴받음
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		// new연산자를 사용하지 않을 경우 이미 형성되어있는 heap메모리 주소값을 참조
		String str3 = "Java Programming";
		String str4 = "Java Programming";

		// str3와 str4의 주소값은 "같음"
		if (str3 == str4) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
	}
}