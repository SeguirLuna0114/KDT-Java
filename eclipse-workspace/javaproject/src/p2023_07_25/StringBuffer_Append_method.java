package p2023_07_25;

//StringBuffer클래스
// -문자열을 저장하기는 하지만, 시작주소값이 바뀌지X (새로운 공간을 만들지는X)
// => append처리O
// - append()메소드: 기존 문자열에 새로운 문자열 추가하는 메소드
// - 부모클래스(Object클래스)의 메소드 상속받아 사용가능
public class StringBuffer_Append_method {
	
    public static void main( String[] args ) {
		
	// StringBuffer 객체 생성
    // "gemini"이라는 문자열로 초기화된 StringBuffer 객체 sb1을 생성
	StringBuffer sb1 = new StringBuffer( "gemini" );
	System.out.println( "sb1 = " + sb1 );

	// append()메소드: 기존문자열(sb1)에 문자열 추가하는 메소드
	// StringBuffer sb1에 문자열을 추가해 기존 객체를 수정
	StringBuffer sb2 = sb1.append( " is beautiful" );
	//   sb1         ----->	   gemini  is beautiful1004
	//   sb2         ----->
	// (Stack영역)	                 (Heap영역)

	// 가변적이기에, 원래 객체의 상태를 변경/수정해도, 새로운 문자열 객체를 생성하지X
	//  기존에 할당된 heap메모리 영역의 버퍼를 변경
	System.out.println( "sb2 = " + sb2 );
	// sb2 = gemini is beautiful
	System.out.println( "sb1 = " + sb1 );
	// sb1 = gemini is beautiful
	// append()메소드는 자기 자신을 반환하기에, sb2와 sb1은 동일한 객체를 가리킴
	
	// sb1과 sb2의 주소값을 비교
	// append메소드를 사용해 처리했기에, 같은 주소값을 가짐
	if (sb1 == sb2) {
		System.out.println("같은 주소값");
	} else {
		System.out.println("다른 주소값");
	}

	// 정수형 데이타 형을 추가
	System.out.println( sb1.append( 1004 ));
	
	System.out.println( "sb1 = " + sb1 );
	// sb1 = gemini is beautiful1004
	System.out.println( "sb2 = " + sb2 );
	// sb2 = gemini is beautiful1004

	// StringBuffer클래스에서는 대문자로 변환하는 메소드X
	// String 클래스의 생성자 중 하나인 String(StringBuffer buffer)를 활용해서,
	//  StringBuffer객체를 -> String객체로 변환하여 사용
	String str = new String(sb1); // StringBuffer를 String으로 변환
	
	System.out.println(str.toUpperCase());

    }
}