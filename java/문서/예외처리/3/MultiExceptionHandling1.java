public class MultiExceptionHandling1 {
    public static void main( String[] args ) {
		
	int value = 20;
	int div = 0;

	int[] intArray = { 1, 2, 3 };

	try {
	    // 두수의 나눗셈을 구함
	    int result = value / div;
	    System.out.println( result );

	    // 배열의 특정 값을 저장
            int arrayValue = intArray[4];
			System.out.println( arrayValue );

	    } catch ( ArithmeticException ae ) {
			System.out.println( ae.toString() );

	    } catch ( ArrayIndexOutOfBoundsException ai ) {
			ai.printStackTrace();

	    } finally {
	    	System.out.println("예외가 발생했음!");

	    }	 
    }    
}



