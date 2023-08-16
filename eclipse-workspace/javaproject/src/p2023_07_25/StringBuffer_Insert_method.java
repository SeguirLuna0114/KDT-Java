package p2023_07_25;

// StringBuffer클래스
//-문자열을 저장하기는 하지만, 시작주소값이 바뀌지X (새로운 공간을 만들지는X)
//- insert(int offset, String str): 지정한 offset위치에 문자열 삽입
public class StringBuffer_Insert_method {
	public static void main(String[] args) {
		
		StringBuffer sb1 = new StringBuffer("gemini is beautiful");
		System.out.println(sb1);
		// gemini is beautiful

		// insert메소드를 사용해서 문자열 삽입
		sb1.insert(10, "very");
		System.out.println(sb1);
		// gemini is verybeautiful

		// insert메소드를 사용해서 숫자 삽입
		sb1.insert(0, 1004);
		System.out.println(sb1);
		// 1004gemini is verybeautiful
	}
}
