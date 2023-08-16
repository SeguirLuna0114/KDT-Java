package p2023_08_04;

// 5개의 Thread를 만들어 실행 시키는 클래스
public class ThreadSync_ManageToilet_main {

	//main 메서드에서 스레드를 생성하고 실행
	public static void main(String[] args) {
		// 화장실 객체를 생성 -> 이 객체를 Family스레드에 전달하여 화장실사용하는 과정 출력
		ThreadSync_Toilet_LockMethod t = new ThreadSync_Toilet_LockMethod();

		/* 	thread 생성
			Family 클래스의 객체를 생성하고, 
			생성자를 통해 스레드의 이름과 화장실 객체를 전달
		 */
		// Thread 클래스를 상속은 Family클래스의 객체 생성
		ThreadSync_Family_extendThread father = new ThreadSync_Family_extendThread("아버지", t);	// '아버지'스레드 생성
		ThreadSync_Family_extendThread mother = new ThreadSync_Family_extendThread("어머니", t);	// '어머니'스레드 생성
		ThreadSync_Family_extendThread sister = new ThreadSync_Family_extendThread("누나", t);	// '누나'스레드 생성
		ThreadSync_Family_extendThread brother = new ThreadSync_Family_extendThread("형", t);	// '형' 스레드 생성
		ThreadSync_Family_extendThread me = new ThreadSync_Family_extendThread("나", t);			// '나'스레드 생성

		/***
		 * 우선 순위 적용안됨 
		 * father.setPriority(10); 
		 * mother.setPriority(7);
		 * sister.setPriority(5); 
		 * brother.setPriority(3); 
		 * me.setPriority(1);
		 */

		// 각 Thread는 Runnable 상태에 들어감(오버라이딩된 run메소드가 실행됨)
		/* Thread 클래스를 상속받은 Family클래스의 객체를 이용해서,
		 * start()메소드를 호출해 오버라이딩한run()메소드를 자동적으로 실행하고,
		 * run()메소드에 의해 실행된 Toilet클래스의 openDoor()메소드를 실행
		 * 
		 * 이때, openDoor()메소드는 동기화되어있어, 여러 스레드가 호출해도 순차적으로 실행됨
		 */
		father.start();		// 이 시점에서 key = false
		mother.start();		// 이 시점에서 key = false
		sister.start();		// 이 시점에서 key = false
		brother.start();	// 이 시점에서 key = false
		me.start();			// 이 시점에서 key = false
	}
}