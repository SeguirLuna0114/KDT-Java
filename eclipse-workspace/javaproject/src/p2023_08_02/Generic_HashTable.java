package p2023_08_02;

import java.util.*;

//제네릭(Generic): 자료구조에 한가지 자료형의 데이터만 저장 하도록 해주는 역할

//제네릭을 사용한 경우
//- 제네릭을 사용하게 되면, 자료구조에서 데이터를 구해올 때
//	 제네릭으로 설정된 자료형은 생략할 수 있음
class Generic_HashTable {
	
	public static void main(String[] args) {
		
		// Generic(제네릭)을 설정해서 Hashtable객체를 생성
		// key의 자료형은 String형, value의 자료형은 String형으로 설정
		Hashtable<String, String> ht = new Hashtable<String, String>();
		
//		put(Object key, Obkect value)
		ht.put("사과", "Apple");
		ht.put("딸기", "StrawBerry");
		ht.put("포도", "Grapes");
		
		// 오류발생(String형 만 저장 가능)
//		ht.put("test", 30);
		
// 방법1.	key값을 알고있는 경우: get()메소드를 활용해 key값으로 value값을 가져옴
//		Object get(Object key) 메소드: 지정된 키에 해당하는 값을 반환
		// 제네릭으로 설정된 경우에는, get()메소드로 key값을 이요해 value값을 가져오고
		// Object형을 자식 클래스형으로 형변환 시 자료형을 생략할 수 있음
		
		// String자료형 생략 가능
//		String Val = (String)ht.get("포도");
		
		String Val = ht.get("포도");
		if (Val != null) {
			System.out.println("포도-> " + Val);
		}
		
// 방법2.	key를 모르는 경우에 사용하는 방법 - Enumeration 인터페이스 활용
//		- 열거형(Enumeration) : Hashtable의 키(Key)를 열거하는데 사용되는 인터페이스
		Enumeration<String> Enum = ht.keys(); // 해쉬 테이블의 키 요소들에 대한 Enumeration 객체 반환
		// Hashtable에 저장된 모든 키(key)들을 담고 있는 Enumeration 객체를 생성하여 반환
		
		while (Enum.hasMoreElements()) {
			// 제네릭을 사용하는 경우, (String)자료형 생략 가능
//			String k = (String) Enum.nextElement();
			String k = Enum.nextElement();
			// hashtable.keys()메소드로 받은 키값을 nextElement()메소드로 String k에 넘겨줌

			//			String v = (String) ht.get(k);
			String v = ht.get(k);
			// 넘겨받은 key값을 이용하여 value값을 반환
			
			System.out.println(k + " : " + v);
		}
	}
}