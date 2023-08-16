package p2023_07_31;

import java.util.ArrayList;
import java.util.List;

//* List 인터페이스 - ArrayList (상속받는 클래스)
//	- List 인터페이스의 구현체인 ArrayList클래스를 사용하여 List객체 생성
//1. 여러가지 자료형의 Data를 모두 저장할 수 있다.
//		ex) int, double, char, boolean, String etc
//2. 순서있는 입.출력 처리(index번호 순으로 저장됨)
//		- 순서가 있는 데이터의 집합
//		- 가변적인 크기를 가짐.
//3. 중복된 Data를 저장 할 수 있다.

//- boolean add(Object e): List의 끝에 요소 추가(중복 가능)
//- void add(int index, Object e): 지정된 인덱스에 요소 추가

//- Object get(int index): 지정된 인덱스에 있는 요소 반환

//- boolean remove(Object e): List에 특정 요소를 제거. 삭제 성공시 true반환
//- Object remove(int index): 지정된 인덱스에 있는 요소 삭제하고, 삭제된 요소를 반환
public class DataStruct_ArrayList_Generic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 업캐스팅
		// List를 상속받는 구현클래스 중 ArrayList클래스를 활용하여 객체 생성
		List<String> list = new ArrayList<String>();
		// <String>: ArrayList객체 생성시, 저장할 요소의 타입을 선언
		
		// boolean add(Object e): List의 끝에 요소 추가(중복 가능)
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		// void add(int index, Object e): 지정된 인덱스에 요소 추가
		list.add(2, "Database");	// 인덱스 2번위치에 Database추가(기존의 2번은 3번으로 밀려남)
		list.add("iBatis");

		int size = list.size();
		System.out.println("총 객체수: "+size);	// 5
		System.out.println();
		
		// 인덱스 2번 원소를 구해서 skill변수에 저장 후 출력
		// Object get(int index): 지정된 인덱스에 있는 요소 반환
		String skill = list.get(2);
		System.out.println("2: "+skill);		// 2: Database
		System.out.println();
		
		// 인덱스번호로 list 출력
		for(int i=0; i<list.size(); i++) {
			// 제네릭을 사용하여 String타입으로 지정했기에, list에 담긴 모든 요소는 String 형태
			String Str = list.get(i);
			System.out.println(i+": "+Str);
		}
		System.out.println();
		
		// Object remove(int index): 지정된 인덱스에 있는 요소 삭제하고, 삭제된 요소를 반환
		list.remove(2);			// 2번 인덱스에 위치한 "Database" 삭제
		list.remove(2);			// 2번 인덱스에 재위치한 "Servlet/JSP" 삭제
		
		// boolean remove(Object e): List에 특정 요소를 제거. 삭제 성공시 true반환
		list.remove("iBatis");		// "iBatis" 삭제
		
		// 인덱스번호로 list 출력
		for(int i=0; i<list.size(); i++) {
			// 제네릭을 사용하여 String타입으로 지정했기에, list에 담긴 모든 요소는 String 형태
			String Str = list.get(i);
			System.out.println(i+": "+Str);
		}
		System.out.println();
		
	}

}
