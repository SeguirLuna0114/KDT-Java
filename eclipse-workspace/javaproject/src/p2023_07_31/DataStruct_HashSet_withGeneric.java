package p2023_07_31;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// p568 ~ 569
// Set 자료구조 with generic<E>
// 제네릭(Generic) <>
// : 자료구조에 1가지 자료형의 데이터만 저장할 수 있도록 함

//* Set 인터페이스 자료구조 사용
//1. 여러가지 자료형의 Data를 모두 저장할 수 있다.
//	ex) int, double, char, boolean, String etc
//2. 순서없이 입.출력 한다.(수학적인 집합과 유사한 개념)
//3. 중복된 Data를 저장하지 못한다.(중복된 값은 1번만 저장)
//	- ***중복 알고리즘을 처리하는 경우 사용(중복 문제 해결 시 사용)
//		"유일한 값을 갖는 자료구조로 사용됨"
public class DataStruct_HashSet_withGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 제네릭(Generic) <>
		// : 자료구조에 1가지 자료형의 데이터만 저장할 수 있도록 함
		
		// set인터페이스의 구현체인 HashSet클래스를 사용하여 Set 객체 생성
		Set<String> set = new HashSet<String>();
		
//		set.add(30);			// String형의 데이터만 저장 가능 => 오류발생
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");		// 중복된 데이터를 저장할 수 없음
		set.add("iBatis");
		
		int size = set.size();				// 저장된 원소의 개수 출력
		System.out.println("총 객체수: "+size);			// 4
		
		// 반복자 Iterator를 통해 요소에 접근
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.print("\t" + element);
			// 순차적인 자료구조가 아니기에, 순서X
		}
		System.out.println();
		
		// remove()메소드: 특정 원소를 삭제할 경우 사용
		set.remove("JDBC");
		set.remove("iBatis");
		System.out.println("총 객체수: "+set.size());		// 2
		
		// 반복자 Iterator를 통해 요소에 접근
//		iterator = set.iterator();
		for (String element : set) {
			System.out.print("\t" + element);
			// 순차적인 자료구조가 아니기에, 순서X
		}
		System.out.println();
		
		// clear()메소드 : 모든 원소를 삭제하는 역할
		set.clear();
		// isEmpty()메소드: 해당 자료구조가 비어있을 때 true리턴
		if (set.isEmpty()) {
			System.out.println("비어 있음");
		}
		
	}

}
