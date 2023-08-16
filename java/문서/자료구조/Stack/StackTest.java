import java.util.*;

public class StackTest {
    public static void main( String[] args ) {
    // Stack 객체 생성
	Stack s = new Stack();
	System.out.println( s.empty() );
		
	// Stack에 값을 넣음
	s.push( "gemini" );
	 Date d = new Date();
	s.push( d );
	s.push( new Integer( 10 ));
	s.push( "johnharu" );

	// Stack의 값을 출력
	System.out.println( s.empty() );
	System.out.println( s.peek() );
	System.out.println( s.pop() );
	System.out.println( s.pop() );
	System.out.println( s.pop() );
	System.out.println( s.pop() );
	System.out.println( s.empty() );
    }	
}

