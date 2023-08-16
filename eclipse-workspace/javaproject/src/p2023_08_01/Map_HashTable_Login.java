package p2023_08_01;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

//* Map 인터페이스  - HashMap, HashTable (상속받는 클래스)
//	1. 여러가지 자료형의 Data를 모두 저장할 수 있다.
//		ex) int, double, char, boolean, String etc
//	2. Data를 저장할 때 Key, Value 를 동시에 저장한다.
//	3. key 값은 중복이 되면 안된다.
//		만약에 중복된 key가 있으면, 가장 마지막에 설정된 value만 사용할 수 있다.
//	4. value값은 중복이 되어도 상관없다.

// p577 ~ 578
// 아이디와 비밀번호를 검사하는 프로그램

//# HashTable
//" Map인터페이스를 구현한 해시테이블 자료구조"
//" 키(key)와 값(value)쌍을 저장하며, 키를 기반으로 데이터에 빠르게 접근 가능"
//- Hashtable은 스레드에 안전한 컬렉션 => 여러 스레드 동시 접근 수정 가능
//- 무인자 타입(raw type)사용: 제네릭 도입 전이기에, 무인자타입으로 사용가능
//- Hashtable은 키와 값에 null을 허용
//- 순서 보장 X: Hashtable은 데이터를 순서대로 저장하지 않음
//- 주요 메소드: put(), get(), remove(), containsKey(), keySet()
//		(주로 키-값 쌍을 추가, 조회, 삭제, 확인)
public class Map_HashTable_Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Map객체 생성
		// Hashtable 객체를 생성하고 변수 map에 할당
		Map<String, String> map = new Hashtable<String, String>();
		
		// 데이터 추가 (put() 메서드 사용)
		map.put("Spring", "12");
		map.put("Summer", "123");
		map.put("Fall", "1234");
		map.put("Winter", "12345");
		
		// 사용자 입력받음
		Scanner sc= new Scanner(System.in);
		
		// 로그인 처리
		while(true) {
			System.out.println("아이디와 비밀번호를 입력하세요?");
			System.out.println("아이디: ");
			String id = sc.nextLine();
			
			System.out.println("비밀번호: ");
			String pw = sc.nextLine();
			System.out.println();
			
			// boolean containsKey(Object key):
			// : 사용자가 입력한 key값이 Map에 존재하는지 확인
			if (map.containsKey(id)) {
				// 만일, 입력한 아이디가 map에 존재하면 해당 아이디에 대응하는 비밀번호를 get()메소드로 가져옴
				// equals()메소드로 가져온 비밀번호와 일치하는지 확인
				if (map.get(id).equals(pw)) {
					// 비밀번호와 일치
					System.out.println("로그인 되었습니다.");
					break;		// break문으로 반복문을 빠져나옴(반복문 중지)
				} else {
					// 비밀번호와 일치하지 않음
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} else {
				// 입력한 아이디가 map에 존재하지X
				System.out.println("입력하신 아이디가 존재하지 않습니다.");
			}
			
		}

	}

}
