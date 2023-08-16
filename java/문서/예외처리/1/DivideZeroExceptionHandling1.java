public class DivideZeroExceptionHandling1 {
    public static void main( String[] args ) {
    	
	// int type의 변수 선언
 	int b = 20;
	int a = 0;
	int c = 0;

	// 두 수의 나눗셈 결과를 구한다

	try {
		c = b/a;
		int total = a + b;
		int sub = b-a;
		
	} catch ( Exception e ) {
		a = 2;
		c = b/a;
	}

		System.out.println( c );
    }
}

		