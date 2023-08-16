package p2023_08_03;

/*
	Thread(스레드) : 1개의 process를 구성하는 논리적인 작업단위

	자바에서 Thread를 생성하는 방법
	1. Thread 클래스를 상속(extends)받아서 만드는 방법
	2. Runnable 인터페이스를 상속(implements)받아서 구현하는 방법
*/
public class Thread_Implements_Runnable implements Runnable {
	// Runnable 인터페이스를 상속받아서 구현한 스레드 생성

	@Override
	// run()메소드 구현 - 스레드가 실행할 작업내용을 정의
	public void run() {
		// TODO Auto-generated method stub
		// 1부터 20까지 화면에 출력시키는 메소드
		for (int i = 1; i <= 20; i++) {
			System.out.println("number = " + i);
		}
	}
	
	
	public static void main(String[] args) {
		
		// Runnable인터페이스를 구현한 클래스의 객체 생성
		Thread_Implements_Runnable tt = new Thread_Implements_Runnable();
		
		// 2. Thread 클래스의 생성자에 myRunnable 객체를 전달하여,
	    //	  새로운 스레드 클래스의 객체 t 생성
		Thread t = new Thread(tt);
		
		// start() 메서드를 호출하여 스레드를 시작
		t.start();		// 실행 가능한 상태: run()메소드가 자동으로 호출됨
		
		// main()내에서 화면에 101부터 120까지 출력
		for (int i = 101; i <= 120; i++) {
			System.out.println("-------> main number = " + i);
		}
		
		// 멀티스레드이기에, run()메소드와 println()메소드가 번갈아 호출됨
	}
}
