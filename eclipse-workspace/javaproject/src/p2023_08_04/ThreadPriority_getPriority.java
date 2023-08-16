package p2023_08_04;

/*
	Thread(Runnable target, String threadName) 생성자
	: 스레드를 생성할 때 스레드의 실행 내용을 Runnable 객체로 지정하면서, 
  	 스레드의 이름을 설정
  	- target: Runnable인터페이스를 구현한 클래스의 객체명. 스레드가 실행할 작업 내용을 정의
  	- threadName: 생성되는 스레드의 이름을 지정

	Thread클래스 우선순위
	1. int getPriority(): 스레드의 현재 우선순위를 가져옴
	- 반환값은 Thread.MIN_PRIORITY (1)부터 
	  Thread.MAX_PRIORITY (10)까지의 우선순위를 나타내는 정수
	
	2. void setPriority(int newPriority); 스레드의 우선순위를 설정
		- newPriority 매개변수에는 스레드에 할당할 우선순위를 지정
	-우선순위는 Thread.MIN_PRIORITY(1)부터 Thread.MAX_PRIORITY(10)까지의 범위로 지정가능
	-기본적으로 스레드는 중간 우선순위인 Thread.NORM_PRIORITY (5)로 설정됨
*/
public class ThreadPriority_getPriority implements Runnable {
	// Runnable 인터페이스를 구현하여 스레드가 실행할 작업을 정의

	public void run() {
		// 1~20 반복문에서 숫자 출력
		for (int i = 1; i < 21; i++) {
			// thread의 이름과 정수 출력
			System.out.println(Thread.currentThread().getName() + " number = " + i);
		}
	}

	public static void main(String[] args) {

		// 생성한 스레드 클래스의 객체를 생성
		// => 멀티스레드 환경에서 여러 스레드에 공유됨
		ThreadPriority_getPriority tl = new ThreadPriority_getPriority();

		// 첫 번째 스레드인 first를 생성
		Thread first = new Thread(tl, "first1");	// 스레드이름 first1
		// 두 번째 스레드인 second를 생성
		Thread second = new Thread(tl, "second1");	// 스레드이름 second1
		//  세 번째 스레드 third를 생성
		Thread third = new Thread(tl, "third1");	// 스레드이름 third1

		// thread의 우선순위를 출력하는 부분
		// 프로그램에서 우선 순위를 지정하지 않으면
		// 우선 순위가 5로 출력됨
		// 최고순위(MAX_PRIORITY:10),
		// 순위 미지정(NORM_PRIORITY:5),
		// 최저순위(MIN_PRIORITY:1)
		
		// getPriority()메소드로 스레드의 우선순위 출력
		// - 이때, 스레드의 우선순위는 기본적으로 5(NORM_PRIORITY)로 지정됨
		System.out.println("first priority =" + first.getPriority());
		System.out.println("second priority =" + second.getPriority());
		System.out.println("third priority =" + third.getPriority());
		// =>  우선순위를 따로 설정하지 않았기 때문에 모든 스레드의 우선순위는 기본값인 5(NORM_PRIORITY)로 출력
		// 		스레드들이 순차적으로 실행되는 것이 아닌 병렬로 실행됨
	}
}
