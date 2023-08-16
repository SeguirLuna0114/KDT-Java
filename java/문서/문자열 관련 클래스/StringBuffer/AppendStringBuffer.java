public class AppendStringBuffer {
    public static void main( String[] args ) {
		
	// StringBuffer 객체 생성
	StringBuffer sb1 = new StringBuffer( "gemini" );
	System.out.println( "sb1 = " + sb1 );

	// StringBuffer sb1에 문자열을 추가해 새로운 객체 생성
	StringBuffer sb2 = sb1.append( " is beautiful" );
	System.out.println( "sb2 = " + sb2 );
	System.out.println( "sb1 = " + sb1 );

	// 정수형 데이타 형을 추가
	System.out.println( sb1.append( 1004 ));
	System.out.println( "sb1 = " + sb1 );
	System.out.println( "sb2 = " + sb2 );

	String str = new String(sb1); // StringBuffer를 String으로 변환
	System.out.println(str.toUpperCase());
    }
}


