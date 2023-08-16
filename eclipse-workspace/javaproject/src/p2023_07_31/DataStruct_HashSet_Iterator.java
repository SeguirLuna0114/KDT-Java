package p2023_07_31;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// * Set 인터페이스 자료구조 사용
// 1. 여러가지 자료형의 Data를 모두 저장할 수 있다.
//	ex) int, double, char, boolean, String etc
// 2. 순서없이 입.출력 한다.(수학적인 집합과 유사한 개념)
// 3. 중복된 Data를 저장하지 못한다.(중복된 값은 1번만 저장)
//	- ***중복 알고리즘을 처리하는 경우 사용(중복 문제 해결 시 사용)
//		"유일한 값을 갖는 자료구조로 사용됨"

// * Iterator 인터페이스
//	: 여러요소를 담는 객체(List, Set, Map)를 순회하며 요소에 접근하는데 사용
// - boolean hasNext(): Iterator가 순회하면서 가져올 요소가 남아있는지 확인
// - Object next(): Iterator가 다음 요소를 반환하는 메서드
// - void remove(): 현재 순회중인 요소 삭제하는 메소드
class DataStruct_HashSet_Iterator {
	
	public static void main(String[] args) {
		
		// Set은 인터페이스이기에, 자체적으로 객체 생성이 불가
//		Set s = new Set();			// 오류 발생
		
		// set인터페이스의 구현체인 HashSet클래스를 사용하여 Set 객체 생성
		Set set = new HashSet();	// 업캐스팅
		// set인터페이스의 하위상속을 받는 HashSet클래스만으로도 객체 생성 가능
//		HashSet	set = new HashSet();
		
		// Set.size()메소드: Set에 저장된 요소의 개수 출력
		System.out.println("요소의 갯수->" + set.size());
		
//		boolean add(Object e): 중복된 데이터는 추가되지 X(false값 리턴)
		// -최상위 자료형(Object형)으로 되어있기에, 모든 자료형을 모두 저장 가능
		set.add("하나");				// 업캐스팅
		set.add(2);
		set.add(3.42);
		set.add("넷");
		set.add("five");
		set.add(6);
		set.add(6);		// 중복 데이터 저장X: 6을 2번 입력해도, 1번만 출력됨
		
		// Set은 중복 데이터를 저장할 수 X
		System.out.println("요소의 갯수->" + set.size());		// 6개
		// Set객체 출력(Set은 순서가 없기에, 순서에 상관없이 저장된 요소가 출력됨
		System.out.println(set);

//		Iterator(반복자) : 2, 6, 넷, 하나, 3.42, five
		// Set.iterator()메소드를 사용하여, Set에 저장된 요소를 순회하기 위한 Iterator객체 생성
		Iterator elements = set.iterator();
		
		// Iterator를 사용하여 Set에 저장된 요소를 순회
		// Iterator.hasNext()메소드: 가져올 데이터(요소)가 남아있을때만 true리턴
		while (elements.hasNext()) {
			// Iterator.next()메소드: 다음 데이터(요소)를 1개씩 가져오는 메소드
			System.out.println("\t\t" + elements.next());
		}

		/*
		 * Vector에만 적용 Enumeration enu = set.elements(); while( enu.hasMoreElements()){
		 * System.out.println( enu.nextElement() ); }
		 */
	}
}
