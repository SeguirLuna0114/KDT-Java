package p2023_08_03;

/*
	Thread.sleep(milliseconds) 메서드
	: 주어진 시간동안 스레드를 강제로 block상태로 만들어주는 역할
	- 주로 스레드의 실행 간격을 조절하는데 사용
	- milliseconds 매개변수 : 스레드를 일시 중지할 시간을 밀리초(1/1000초) 단위로 지정
*/
public class Thread_Sleep_RunningNBlocked_paused implements Runnable {
	// Runnable 인터페이스를 상속받아서 구현한 스레드 생성

	@Override
	// run()메소드 구현 - 스레드가 실행할 작업내용을 정의 
	public void run() {
		// run() 메소드 내부에서 Thread.sleep(1000)을 호출하는 것은 각 스레드가 1초 동안 실행을 멈추도록 만드는 역할
		for (int i = 1; i < 10; i++) {
			/* 	현재 CPU를 점유한 Thread 출력
				getName()메소드를 활용해 각 스레드의 이름과 함께 출력 */
			System.out.println(Thread.currentThread().getName() + " : " + i);

			// 출력후,Thread.sleep(1000)을 호출하여 1초 동안 스레드를 block 상태
			try {
				// sleep() 메소드를 사용해 프로그래머가 강제로
				// block 상태로 만듦.
				// 1초 동안 thread을 block 상태에 빠트림
				Thread.sleep(1000); // (단위: 1/1000 초)
			} catch (InterruptedException ie) {
				System.out.println(ie.toString());
			}
		} // for end
	}// run() end

	public static void main(String[] args) {
		// ThreadSleep 클래스의 객체 ts를 생성
		// 이 객체를 이용하여 두 개의 스레드를 생성하고 실행
		Thread_Sleep_RunningNBlocked_paused ts = new Thread_Sleep_RunningNBlocked_paused();

		// ts를 Runnable target으로 전달하여 생성
		// 두 개의 Thread를 생성시켜 실행시킴
		// 2개의 Thread가 동일한 우선 순위로 실행됨.(5인 상태)
		Thread first = new Thread(ts, "first1");
		Thread second = new Thread(ts, "second1");
		
		// start() 메서드를 호출하여 스레드를 시작 => 실행가능한 상태가 되어 run()메소드 자동 호출
		first.start();
		second.start();
		
		// sleep()메소드를 사용해 1초간 block상태에 빠지게 하여,
		// 출력이 first1 -> second1 -> first1 -> second1...순으로 됨
	}
}
