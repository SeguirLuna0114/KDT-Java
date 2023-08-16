package p2023_08_01;

import java.util.*;

// 큐(Queue): FIFO(First In First Output) 구조
// 1. FIFO(First Input First Output) 구조
//	: 먼저 입력된 자료가 먼저 출력되는 구조
//
// 2. Queue 인터페이스를 구현하는 주요 클래스
//	: LinkedList, ArrayDeque, PriorityQueue
//	- LinkedList와 ArrayDeque는 일반적으로 FIFO 큐를 구현하는데 사용
//	- PriorityQueue는 우선순위 큐를 구현하는데 사용
class Queue_LinkedList {

	public static void main(String[] args) {

		// Queue는 인터페이스이기 때문에, 자체적으로 객체 생성이 불가능
//		Queue q = new Queue();
		
		// LinkedList 클래스를 사용하여 큐 객체 생성
		Queue my = new LinkedList();		// 업캐스팅
		
		// LinkedList 클래스 자체적으로 객체 생성도 가능
		LinkedList myQue = new LinkedList();
		
		// boolean offer(E element): 큐에 요소를 추가. 용량제한 초과시 false반환
		myQue.offer("1-자바");
		myQue.offer("2-C++");
		myQue.offer("3-API");
		myQue.offer("4-MFC");
		
		// E poll(): 큐의 맨 앞의 요소를 제거하고 반환. 비어있는 경우 null 반환
		// 입력된 순서대로 값이 출력됨
		System.out.println(myQue.poll());		// 1-자바
		System.out.println(myQue.poll());		// 2-C++
		System.out.println(myQue.poll());		// 3-API
		System.out.println(myQue.poll());		// 4-MFC
		
		// 큐(Queue)가 비어있기에 null값을 리턴
		System.out.println(myQue.poll());		// null값을 반환
		
		// E peek(): 큐의 맨 앞의 요소를 반환. 삭제하지 않고도 해당 요소를 확인가능.
	    // 큐가 비어있는 경우 null을 반환
		while (myQue.peek() != null) // 큐가 비어있지 않다면
			System.out.println(myQue.poll()); // 큐에서 데이터를 꺼내온다.
	}
}