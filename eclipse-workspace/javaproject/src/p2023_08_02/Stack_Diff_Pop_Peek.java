package p2023_08_02;

import java.util.*;

// vi. 스택(Stack) 클래스
// " 후입선출(LIFO - Last-In-First-Out) 원칙에 따라 요소를 저장하는 자료구조 "
// - LIFO(Last Input First Output) 구조
//   : 마지막(최근에)으로 입력된 자료가 가장 먼저 출력되는 구조

// boolean empty(): 스택이 비어 있는지 여부를 확인하는 메소드
// E push(E item): 스택에 새로운 요소(데이터)를 추가하는 메소드
// E peek() (또는 Top): 스택의 맨 위에 있는 요소를 반환하는 메소드
// E Pop: 스택에서 맨 위에 있는 요소를 제거하고 반환하는 메소드
public class Stack_Diff_Pop_Peek {
	
	public static void main(String[] args) {
		
		// Stack 객체 생성
		// 제네릭을 사용하지 않았기에, 모든 종류의 객체를 저장 가능
		Stack s = new Stack();
		
		// boolean empty(): 스택이 비어 있는지 여부를 확인하는 연산
		// 비어있는 stack객체를 생성했기 때문에 empty()메소드는 true반환
		System.out.println(s.empty());		// true

		// E push(E item): 스택에 새로운 요소(데이터)를 추가하는 메소드
		s.push("gemini");
		
		// Date 객체인 d를 생성하여, Stack에 추가
		Date d = new Date();
		s.push(d);
		
		// 정수값 10을 new Integer(10)으로 명시적으로 래핑한 뒤 스택에 추가
		s.push(new Integer(10));	// Integer 객체로 포장하여 스택에 저장
//		s.push(10);			
		// 자동으로 오토박싱이 일어나기 때문에 
		// 정수값 10이 자동으로 new Integer(10)으로 래핑되어 스택에 저장
		
		s.push("johnharu");

		// Stack의 값을 출력
		System.out.println(s.empty());		// 요소가 추가되었기에 false출력
		
		// E peek() (또는 Top): 스택의 맨 위에 있는 요소를 반환하는 메소드
		// 단, peek()메소드는 요소 조회만 할 뿐, 제거하지는X
		System.out.println(s.peek());
		
		// E Pop: 스택에서 맨 위에 있는 요소를 제거하고 반환하는 메소드
		System.out.println(s.pop());			// johnharu
		System.out.println(s.pop());			// 10
		System.out.println(s.pop());			// Date객체 d
		System.out.println(s.pop());			// gemini
		
		// boolean empty(): 스택이 비어 있는지 여부를 확인하는 연산
		System.out.println(s.empty());			// true
	}
}
