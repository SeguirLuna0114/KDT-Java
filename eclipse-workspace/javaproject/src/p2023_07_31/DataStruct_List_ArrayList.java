package p2023_07_31;

import java.util.*;

// * List 인터페이스 - ArrayList (상속받는 클래스)
// 		- List 인터페이스의 구현체인 ArrayList클래스를 사용하여 List객체 생성
// 1. 여러가지 자료형의 Data를 모두 저장할 수 있다.
//  	ex) int, double, char, boolean, String etc
// 2. 순서있는 입.출력 처리(index번호 순으로 저장됨)
//		- 순서가 있는 데이터의 집합
//		- 가변적인 크기를 가짐.
// 3. 중복된 Data를 저장 할 수 있다.

class DataStruct_List_ArrayList {

	public static void main(String[] args) {
		
		// List는 인터페이스이기에, 자체적으로 객체 생성할 수 없음
//  	List list = new ArrayList();
		
		// List를 상속받는 구현클래스 중 ArrayList클래스를 활용하여 객체 생성
		List list = new ArrayList();		// 업캐스팅
//		ArrayList list = new ArrayList();		
		
//		boolean add(Object e): List의 끝에 요소 추가
		list.add("하나");
		list.add(2);
		list.add(2);
		list.add(3.42);
		list.add("넷");
		list.add("five");
		list.add(6);

		System.out.println(list);

	}
}
