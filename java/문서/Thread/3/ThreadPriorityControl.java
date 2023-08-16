public class ThreadPriorityControl implements Runnable {
	
    public void run() {
		for( int i=1 ; i<11 ; i++ ) {
			// thread의 이름과 정수 출력
System.out.println( Thread.currentThread().getName()+
										" number =" + i );
		}
    }

    public static void main( String[] args ) {
	
	ThreadPriorityControl tl = new ThreadPriorityControl();

		//최고순위(MAX_PRIORITY:10) 
		//순위 미지정(NORM_PRIORITY:5)
		//최저순위(MIN_PRIORITY:1)

		// 첫 번째 Thread 생성
		Thread first = new Thread( tl, "first1" );
		//최저순위(1)로 설정하는 부분
		first.setPriority( Thread.MIN_PRIORITY ); 
		System.out.println( "first priority = "	+ first.getPriority());

		// 두 번째 Thread 생성
		Thread second = new Thread( tl, "second1" );
		//최고순위(10)로 설정하는 부분
		second.setPriority( Thread.MAX_PRIORITY ); 
		System.out.println("second priority = "	+second.getPriority());

		//세 번째 Thread 생성(우선순위를 설정하지 않은 경우)
		Thread third = new Thread( tl, "third1" );
		System.out.println( "third priority = "	+ third.getPriority());
	
		first.start();
		second.start();
		third.start();
    }
}

	