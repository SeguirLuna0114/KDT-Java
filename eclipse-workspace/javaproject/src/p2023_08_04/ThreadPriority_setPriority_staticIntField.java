package p2023_08_04;

/*
	Thread(Runnable target, String threadName) 생성자
	: 스레드를 생성할 때 스레드의 실행 내용을 Runnable 객체로 지정하면서, 
	  스레드의 이름을 설정
	  - target: Runnable인터페이스를 구현한 클래스의 객체명. 스레드가 실행할 작업 내용을 정의
	  - threadName: 생성되는 스레드의 이름을 지정
	
	Thread클래스 우선순위 메소드
	1. int getPriority(): 스레드의 현재 우선순위를 가져옴
	- 반환값은 Thread.MIN_PRIORITY (1)부터 
	  Thread.MAX_PRIORITY (10)까지의 우선순위를 나타내는 정수
	
	2. void setPriority(int newPriority); 스레드의 우선순위를 설정
		- newPriority 매개변수에는 스레드에 할당할 우선순위를 지정
	-우선순위는 Thread.MIN_PRIORITY(1)부터 Thread.MAX_PRIORITY(10)까지의 범위로 지정가능
	-기본적으로 스레드는 중간 우선순위인 Thread.NORM_PRIORITY (5)로 설정됨
	
	Thread클래스 우선순위 final 정적상수
	1. int MIN_PRIORITY = 1: 스레드의 "최저" 우선순위를 나타내는 정적 상수
	2. int NORM_PRIORITY = 5: 스레드의 "중간" 우선순위를 나타내는 정적 상수
	3. int MAX_PRIORITY = 10: 스레드의 "최고" 우선순위를 나타내는 정적 상수
 */

public class ThreadPriority_setPriority_staticIntField implements Runnable {

	public void run() {
		for (int i = 1; i < 11; i++) {
			// thread의 이름과 정수 출력
			System.out.println(Thread.currentThread().getName() + " number =" + i);
		}
	}

	public static void main(String[] args) {

		ThreadPriority_setPriority_staticIntField tl = new ThreadPriority_setPriority_staticIntField();

		// 최고순위(MAX_PRIORITY:10)
		// 순위 미지정(NORM_PRIORITY:5)
		// 최저순위(MIN_PRIORITY:1)

		// 첫 번째 Thread 생성
		Thread first = new Thread(tl, "first1");
		// 최저순위(1)로 설정하는 부분
		first.setPriority(Thread.MIN_PRIORITY);			// 우선순위: 1
		System.out.println("first priority = " + first.getPriority());

		// 두 번째 Thread 생성
		Thread second = new Thread(tl, "second1");
		// 최고순위(10)로 설정하는 부분
		second.setPriority(Thread.MAX_PRIORITY);		// 우선순위: 10
		System.out.println("second priority = " + second.getPriority());

		// 세 번째 Thread 생성(우선순위를 설정하지 않은 경우)
		Thread third = new Thread(tl, "third1");		// 우선순위: 5(NORM_PRIORITY:5)
		System.out.println("third priority = " + third.getPriority());

		first.start();
		second.start();
		third.start();
	}
}
