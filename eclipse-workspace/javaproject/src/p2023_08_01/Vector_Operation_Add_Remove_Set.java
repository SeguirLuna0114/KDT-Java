package p2023_08_01;

import java.util.*;

// Vector 메소드 - 원소 추가 / 삭제 / 반환
//- indexOf(Object e): e 값을 가진 객체의 인덱스를 찾아 반환
// 						해당 값이 없으면 -1을 반환
//- isEmpty(): Vector가 비어있는지 확인
//- remove(int index): 인덱스가 2인 객체를 Vector에서 삭제
//- Object elementAt(int index):  Vector에서 특정 인덱스에 해당하는 요소를 반환
//- set(2, "park"): 인덱스가 2인 객체의 값을 "park"로 설정
public class Vector_Operation_Add_Remove_Set {
	public static void main(String[] args) {

		// Vector 객체 생성
		// 초기 capa를 1로 지정하고 증가 capa를 1로 지정
		Vector v = new Vector(1, 1);

		// Vector에 객체 저장
		v.add("gemini");
		// addElement() 메서드는 add() 메서드와 동일한 기능수행
		v.addElement(new Integer(10));		// Vector에 정수 10을 추가
		v.addElement("johnharu");
		v.addElement("gracedew");

//		벡터 출력방법1. vector 자료구조에 저장된 데이터를 출력
		System.out.println(v);

		// Vector에 저장된 객체의 개수를 구함
		int length = v.size();

//		벡터 출력방법2. get()메소드를 활용해서 인덱스에 접근해 출력***
		// 처음부터 순차적으로 객체를 꺼냄
		// for (int i = 0; i < v.size(); i++) {		// 아래와 같은 코드
		for (int i = 0; i < length; i++) {
			// get(i)메소드를 통해 해당 인덱스 요소를 가져와 출력
			System.out.println(v.get(i));
		}

		// firstElement(): Vector의 첫 번째 요소를 반환
		System.out.println(v.firstElement());
		
		// indexOf(Object e): e 값을 가진 객체의 인덱스를 찾아 반환
		// 						해당 값이 없으면 -1을 반환
		System.out.println(v.indexOf("johnharu"));
		
		// isEmpty(): Vector가 비어있는지 확인
		System.out.println(v.isEmpty());

		// Vector요소 수정
		// remove(int index): 인덱스가 2인 객체를 Vector에서 삭제
		v.remove(2);
		// Object elementAt(int index):  Vector에서 특정 인덱스에 해당하는 요소를 반환
		System.out.println(v.elementAt(2));

		// set(2, "park"): 인덱스가 2인 객체의 값을 "park"로 설정
		v.set(2, "park");
		System.out.println(v);
	}
}
