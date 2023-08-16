package p2023_08_03;

/*
	Thread(스레드) : 1개의 process를 구성하는 논리적인 작업단위
	
	자바에서 Thread를 생성하는 방법
	1. Thread 클래스를 상속받아서 만드는 방법
	2. Runnable 인터페이스를 상속받아서 만드는 방법
 */
public class Thread_Extends_ThreadClass extends Thread {
	// Thread 클래스를 상속받아서 스레드 생성

	@Override
	public void run() {
		// thread가 시작되면 실행되는 문장
		for (int i = 1; i <= 20; i++) {
			System.out.println("run number = " + i);
		}
	}

	public static void main(String[] args) {
		
		// 새롭게 생성한 스레드 클래스의 객체 생성
		Thread_Extends_ThreadClass tt = new Thread_Extends_ThreadClass();
		
		// start() 메서드를 호출하여 thread를 실행시킴
		// start()메소드 호출 시, run()메소드가 자동으로 호출됨(run()메소드를 바로 호출하면X)
		tt.start();		// 실행 가능한 상태 : run()메소드가 자동으로 호출됨

		// main()내에서 화면에 101부터 120까지 출력
		for (int i = 101; i <= 120; i++) {
			System.out.println("-------> main number = " + i);
		}
		
		// 멀티스레드이기에, run()메소드와 println()메소드가 번갈아 호출됨
	}

}
