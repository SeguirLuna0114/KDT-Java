package p2023_08_02;

import java.util.*;

// vi. 스택(Stack) 클래스
// " 후입선출(LIFO - Last-In-First-Out) 원칙에 따라 요소를 저장하는 자료구조 "
// - LIFO(Last Input First Output) 구조
//	 : 마지막(최근에)으로 입력된 자료가 가장 먼저 출력되는 구조

// boolean empty(): 스택이 비어 있는지 여부를 확인하는 메소드
// E push(E item): 스택에 새로운 요소(데이터)를 추가하는 메소드
// E peek() (또는 Top): 스택의 맨 위에 있는 요소를 반환하는 메소드
// E Pop: 스택에서 맨 위에 있는 요소를 제거하고 반환하는 메소드
public class Stack_Pop_isEmpty {
	
	public static void main(String[] args) {
		
		// Stack 객체 생성
		Stack myStack = new Stack();
		
		// E push(E item): 스택에 새로운 요소(데이터)를 추가하는 메소드 
		myStack.push("1-자바");
		myStack.push("2-C++");
		myStack.push("3-API");
		myStack.push("4-MFC");

		// E Pop: 스택에서 맨 위에 있는 요소를 제거하고 반환하는 메소드
		// E peek() (또는 Top): 스택의 맨 위에 있는 요소를 반환하는 메소드
//		System.out.println(myStack.pop());	// 4-MFC
//		System.out.println(myStack.pop());	// 3-API
//		System.out.println(myStack.pop());	// 2-C++
//		System.out.println(myStack.pop());	// 1-자바
//		System.out.println(myStack.pop());	// EmptyStackException
		
		// boolean isEmpty()메소드: stack이 비어있지 않으면 false리턴, 비어있으면 true리턴
		while (!myStack.isEmpty()) {
			
			System.out.println(myStack.pop());
		}
	}
}
