package p2023_08_01;

import java.util.*;

// * Map 인터페이스  - HashMap, HashTable (상속받는 클래스)
// -Map은 인터페이스이기에, 자체저으로 객체 생성 할 수 X
//	1. 여러가지 자료형의 Data를 모두 저장할 수 있다.
//		ex) int, double, char, boolean, String etc
//	2. Data를 저장할 때 Key, Value 를 동시에 저장한다.
//	3. key 값은 중복이 되면 안된다.
// 		만약에 중복된 key가 있으면, 가장 마지막에 설정된 value만 사용할 수 있다.
//	4. value값은 중복이 되어도 상관없다.

// -HashMap은 Map 인터페이스를 구현한 클래스 중 하나로, 키-값 쌍을 저장하는 자료 구조
//# HashMap
//" Map인터페이스를 구현한 해시맵 자료구조"
//" 데이터를 빠르게 검색하고 관리하기 위해 많이 사용"
//" 키(key)와 값(value)쌍을 저장하며, 키를 기반으로 데이터에 빠르게 접근 가능"
//- 동기화되지 않음: HashMap은 스레드에 안전하지 않음
//		=> 멀티스레드 환경에서 동시에 접근하여 수정하는 경우 문제가 발생
//- 제네릭(Generic) 타입 사용하여 HashMap 선언하는 것 권장
//- null 허용: 키와 값에 null을 허용
//		=> null 키를 사용하여 값을 저장할 수 있고, null 값을 가진 키로부터 값을 조회가능
//- 순서 보장 X: HashMap은 데이터를 순서대로 저장X
public class Map_HashMap_keySet_get {
	
	public static void main(String[] args) {
		
		// Map은 인터페이스이기에, 자체저으로 객체 생성 할 수 X
//		Map m = new Map();				// 오류발생
		
		// HashMap 객체 생성 - HashMap 객체를 생성하고 변수 hm에 할당
		Map hm = new HashMap();			// 업캐스팅	
//		HashMap hm = new HashMap();		
		
		// Map에 자료 저장할 경우에는 put()메소드 사용
		// put(Object key, Object value):  키(Key)와 값(Value) 쌍을 hm 객체에 저장/삽입
		// key값이 중복되면, 가장 마지막 value값만 사용됨
		hm.put("woman", "gemini");
		hm.put("man", "johnharu");
		hm.put("age", new Integer(10));
		hm.put("city", "seoul");
		hm.put("city", "busan");

		// HashMap에 있는 객체들을 출력
		// HashMap객체에 저장된 모든 key-value를 출력
		System.out.println(hm);

		// 키 값만 출력
		System.out.println(hm.keySet());

		// 키를 이용해 해당 데이터를 출력
		System.out.println(hm.get("woman"));
		System.out.println(hm.get("city"));
	}
}
