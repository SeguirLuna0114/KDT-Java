package p2023_08_04;

/*
	멀티스레딩 환경에서 화장실(Toilet)을 여는(Family) 스레드를 정의
	=> 화장실을 여는 행동을 스레드로 동작하도록 구현함
 */
public class ThreadSync_Family_extendThread extends Thread {
	// Thread 클래스를 상속받아 Family클래스를 정의
	// => Family클래스는 스레드로 동작할 수 있게됨
	
	// Toilet 객체 생성 =>toilet객체를 사용하여 화장실에 접근
	ThreadSync_Toilet_LockMethod toilet;
	
	// 스레드가 누구인지 나타내는 문자열 변수
	String who;
	
	// 락의 상태를 나타내는 변수
	boolean key; // 초기값: false

	// 생성자
	public ThreadSync_Family_extendThread(String name, ThreadSync_Toilet_LockMethod t) {
		// 이름과 화장실 객체를 전달받아 초기화
		who = name;
		toilet = t;
	}

	@Override
	// Thread 클래스를 상속받았기 때문에, run()메서드를 반드시 구현해야 함 
	public void run() {
		// 화장실 객체(toilet)의 openDoor() 메서드를 호출하여 화장실 문을 열게됨
		toilet.openDoor(who, key);
		// who 변수는 스레드가 누구인지, key 변수는 락의 상태
	}
}