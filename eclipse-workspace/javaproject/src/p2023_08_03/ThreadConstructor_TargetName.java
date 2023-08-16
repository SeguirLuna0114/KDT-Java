package p2023_08_03;

/*
	Thread(스레드) : 1개의 process를 구성하는 논리적인 작업단위

	자바에서 Thread를 생성하는 방법
	1. Thread 클래스를 상속(extends)받아서 만드는 방법
	2. Runnable 인터페이스를 상속(implements)받아서 구현하는 방법
	
	Thread(Runnable target, String threadName) 생성자
	: 스레드를 생성할 때 스레드의 실행 내용을 Runnable 객체로 지정하면서, 
	  스레드의 이름을 설정
	  - target: Runnable인터페이스를 구현한 클래스의 객체명. 스레드가 실행할 작업 내용을 정의
	  - threadName: 생성되는 스레드의 이름을 지정
*/
// 멀티 스레드 프로그램
public class ThreadConstructor_TargetName implements Runnable {
	// Runnable 인터페이스를 상속받아서 구현한 스레드 생성

	@Override		// 메소드 오버라이딩
	// run()메소드 구현 - 스레드가 실행할 작업내용을 정의
	public void run() {
		
		for (int i = 1; i < 21; i++) {
			// thread의 이름과 정수 출력
			System.out.println(Thread.currentThread().getName() + " number = " + i);
		}
	}

	public static void main(String[] args) {
		
		// Runnable인터페이스를 구현한 클래스의 객체 생성
		ThreadConstructor_TargetName tl = new ThreadConstructor_TargetName();

		// Runnable 객체를 전달하여 새로운 스레드 생성
		// Thread(Runnable target, String threadName) 생성자
		// 첫 번째 Thread 생성
		Thread first = new Thread(tl, "first1");
		// 두 번째 Thread 생성
		Thread second = new Thread(tl, "second1");
		// 세 번째 Thread 생성
		Thread third = new Thread(tl, "third1");

		// Runnable(실행 가능)상태 :  새로 생성한 Thread를 start하면 Runnable 상태가 됨
		// start() 메서드를 호출하여 스레드를 시작 => 실행가능한 상태가 되어 run()메소드 자동 호출
		second.start();
		
		first.start();
		
		third.start();
		
		//  세 개의 스레드를 생성하고 실행하는데, 
		// 스레드의 실행 순서가 보장되지 않기 때문에 스레드가 실행되는 순서는 무작위로 결정됨
	}
}
