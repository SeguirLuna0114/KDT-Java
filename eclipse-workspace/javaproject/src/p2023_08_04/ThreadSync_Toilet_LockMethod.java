package p2023_08_04;

/* 
	Thread의 동기화(Synchronization)
	: key를 이용해서 Thread간에 충돌이 일어나지 않도록 실행순서를 맞추는 것
	
	* 락을 이용하여 멀티스레드 환경에서의 상호 배제와 동기화를 달성하는 방법
	1. 메소드의 동기화 방법(메소드에 lock 을 설정)
   		" 메서드에 synchronized 키워드 사용 "
		- 메서드 선언 앞에 synchronized 키워드를 붙이면, 
	  	  해당 메서드는 락을 획득하여 상호 배제를 적용
		1) 메서드 전체가 임계 영역으로 지정됨 
 		2) 메소드를 호출하는 모든 스레드들은 락을 얻기위해 경쟁
		3) 한번에 하나의 스레드만이 해당 메소드 실행 가능(한번 실행이 끝나야 다음 실행이 가능)
*/
public class ThreadSync_Toilet_LockMethod { 
	// 화장실을 사용하는 과정을 보여주는 클래스

	/*
	 *  메소드의 동기화 방법(메서드에 synchronized 키워드 사용)
	 *  synchronized로 선언된 openDoor() 메소드는 한번 실행이 끝나야 다음 실행이 가능함.
	 *  다른 Thread들은 한개의 Thread가 이 메소드의 실행을 끝낼때 까지 대기함.
	 *  => 여러 스레드가 이 메서드를 동시에 호출해도 순차적으로 실행됨
	 */
	// 화장실 문을 여는 작업을 수행
	public synchronized void openDoor(String name, boolean b) {
//	public void openDoor( String name, boolean b ) {
		// b매개변수: 락의 상태를 나타내는 변수.(스레드가 화장실에 접근하는지를 표시)
		if (b == false) {
			// 락이 열려있는 경우->화장실 사용
			System.out.println(name);
			// usingTime()메소드: 화장실 사용하는 시간을 가정한 무의미한 작업 수행
			usingTime();
			
			System.out.println("아~~~~! 시원해");
			System.out.println();
		} else {
			// 락이 닫힌 경우 -> 메시지 출력
			System.out.println("사용중");
		}
	}

	
	// usingTime()메소드: 화장실 사용하는 시간을 가정한 무의미한 작업 수행
	public void usingTime() { 
		// 화장실 사용 중인 것을 표현하기 위한 용도로 사용
		for (int i = 0; i < 100000000; i++) {
			if (i == 10000) {
				System.out.println("끄으응");
			}
		}
	}
}