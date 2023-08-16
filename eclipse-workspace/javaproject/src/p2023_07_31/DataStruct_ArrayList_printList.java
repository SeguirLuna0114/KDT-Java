package p2023_07_31;

import java.util.*;

// * List 인터페이스 - ArrayList (상속받는 클래스)
//	- List 인터페이스의 구현체인 ArrayList클래스를 사용하여 List객체 생성
// 1. 여러가지 자료형의 Data를 모두 저장할 수 있다.
//		ex) int, double, char, boolean, String etc
// 2. 순서있는 입.출력 처리(index번호 순으로 저장됨)
//		- 순서가 있는 데이터의 집합
//		- 가변적인 크기를 가짐.
// 3. 중복된 Data를 저장 할 수 있다.

//* Iterator 인터페이스
//: 여러요소를 담는 객체(List, Set, Map)를 순회하며 요소에 접근하는데 사용
//- boolean hasNext(): Iterator가 순회하면서 가져올 요소가 남아있는지 확인
//- Object next(): Iterator가 다음 요소를 반환하는 메서드
//- void remove(): 현재 순회중인 요소 삭제하는 메소드
class DataStruct_ArrayList_printList {

	public static void main(String[] args) {
		
		// List를 상속받는 구현클래스 중 ArrayList클래스를 활용하여 객체 생성
		List list = new ArrayList();		// 업캐스팅
//		ArrayList list = new ArrayList();

//		boolean add(Object e): List의 끝에 요소 추가
		list.add("하나");
		list.add(2);
		list.add(3.42);
		list.add("넷");
		list.add("five");
		list.add(6);
		System.out.println(list);
		
		// Object get(int index): 지정된 인덱스에 있는 요소 반환
		System.out.println(list.get(2));	// 인덱스 2번 원소 추출: 3.42
		System.out.println(list.get(4));	// 인덱스 4번 원소 추출: five

//		List출력 방법
		// 1. for문과 Object get(int index)메소드를 활용
		// int size(): List의 크기(요소의 개수) 반환
		for (int i = 0; i < list.size(); i++) {
//  		System.out.println( i + " 번째 요소는 " + list.get(i));
			// Object get(int index)메소드: 지정된 인덱스에 있는 요소 반환
			// get()메소드는 Object를 반환함
			Object s = list.get(i);
			// String자료형이 아닌 경우에는, (String)으로 강제 형변환 하는 과정에서 오류 발생가능
//			String s =(String)(list.get(i));
			
			System.out.println(s);
		}
		
		// 2. 향상된 for문을 사용하여 반환
		// for (변수 : 순차적 자료구조) {
		for (Object element : list) {
			System.out.print(element + "\t");
		}
		
		// 3. 반복자 Iterator를 활용하여 출력
		Iterator elements = list.iterator();
		// hasNext(): 가져올 데이터가 있을 때만 true
		while (elements.hasNext()) {
			// next(): 데이터를 1개씩 가져오는 역할
			System.out.println("\t\t" + elements.next());
		}

	}
}
