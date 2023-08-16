package p2023_08_01;

import java.util.*;

// 업캐스팅을 하면 안되는 경우
// 1. 업캐스팅이 되면 참조 가능한 영역의 축소가 일어난다.
// 2. 업캐스팅이 되면 부모가 상속해준 메소드만 접근 가능

// Hashtable: Map 인터페이스를 구현한 클래스로, 
// 		      키(Key)와 값을(Value) 쌍으로 저장하는 해시 테이블 자료 구조
class Map_HashTable_NoUpcast {
	public static void main(String[] args) {

		// 업캐스팅을 하면 안되는 경우
		// 1. 업캐스팅이 되면 참조 가능한 영역의 축소가 일어난다.
		// 2. 업캐스팅이 되면 부모가 상속해준 메소드만 접근 가능
		// 3. key()메소드는 부모인 Map이 상속해준 메소드가 아니기 때문에,
		//	  업캐스팅 방식으로 Map객체를 생성하면 사용할 수 없음
		
		// Map인터페이스를 구현한 클래스인 Hashtable클래스를 활용하여 객체 생성
//		Map ht = new Hashtable();				// 업캐스팅
		Hashtable ht = new Hashtable();
		
		// 해쉬 테이블에 키/데이터를 입력한다.
//		put(Object key, Object value): 데이터를 ht 객체에 키(Key)와 값(Value)을 함께 저장
//		데이터는 중복될 수X
		ht.put("딸기", "StrawBerry");				// 업캐스팅
		ht.put("사과", "Apple");
		ht.put("포도", "Grapes");
		ht.put("count", 10);

//	방법1. key를 알고 있는 경우 - get(Object key) 메서드를 사용하여 키를 이용하여 해당 데이터를 조회
		// Object get(Object key)
		// 해쉬 테이블의 값을 키를 이용하여 얻는다.
		// Object obj = ht.get("포도");
		String Val = (String) ht.get("포도");		// 다운캐스팅
		if (Val != null) {
			System.out.println("포도-> " + Val);
		}
		
		// 다운캐스팅시 자료형 생략 불가능
		String s = (String) ht.get("딸기");		// 다운캐스팅
		String a = (String) ht.get("사과");		// 다운캐스팅
		
		Integer it = (Integer) ht.get("count");		// 다운캐스팅(Object -> Integer)
		int i = it.intValue();						// 언박싱(Integer -> int)

		// 다운캐스팅 + 언박싱
		int ii = ((Integer) ht.get("count")).intValue();
		
		
//	방법2. key값을 모르는 경우
		// 열거형(Enumeration) : Hashtable의 키(Key)를 열거하는데 사용되는 인터페이스
		// keys() 메서드를 사용하여 Hashtable의 모든 키를 가져옴
		Enumeration Enum = ht.keys();		// Map의 모든 key를 구해옴
		
		while (Enum.hasMoreElements()) {
			// Object형으로 저장해도 처리되기는 함.
			// Hashtable은 무인자 타입으로 선언되었기 때문에 키와 값이 모두 Object 타입으로 반환됨
			// => 각 값을 다운캐스팅하여 원하는 타입으로 반환하여 사용
			Object k = Enum.nextElement();
			Object v = ht.get(k);
			
			// 한가지 자료형으로 작성되지X. 여러 자료형으로 작성됨(자료형이 혼용됨)
			// => 따라서, Object형으로 작성해야 함
//			String k = (String)Enum.nextElement();		// 오류
//			String v = (String)ht.get(k);				// 오류
			
			System.out.println(k + " : " + v);
			
		}
	}
}
