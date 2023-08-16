public class ThreadPriority implements Runnable{
    
    public void run() {
		for( int i=1 ; i<21 ; i++ ) {
			// thread의 이름과 정수 출력
System.out.println( Thread.currentThread().getName() +
										" number = " + i );
		}
    }

    public static void main( String[] args ) {
	
		ThreadPriority tl = new ThreadPriority();

		// 첫번째 Thread 생성
		Thread first = new Thread( tl, "first1" );
		// 두번째 Thread 생성
		Thread second = new Thread( tl, "second1" );
		// 세번째 Thread 생성
		Thread third = new Thread( tl, "third1" );
		
		// thread의 우선순위를 출력하는 부분
		// 프로그램에서 우선 순위를 지정하지 않으면 
		// 우선 순위가 5로 출력됨
		//최고순위(MAX_PRIORITY:10), 
		//순위 미지정(NORM_PRIORITY:5), 
		//최저순위(MIN_PRIORITY:1)
System.out.println("first priority ="+first.getPriority());
System.out.println("second priority ="+second.getPriority());
System.out.println("third priority ="+third.getPriority());
	
    }
}

