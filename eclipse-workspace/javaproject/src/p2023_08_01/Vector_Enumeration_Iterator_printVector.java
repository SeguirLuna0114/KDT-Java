package p2023_08_01;

import java.util.*;

// 벡터 출력방법1. vector 자료구조에 저장된 데이터를 출력
// 벡터 출력방법2. get()메소드를 활용해서 인덱스에 접근해 출력***
// 벡터 출력방법3. 나열형(Enumeration) - Vector의 Object의 나열형을 리턴
// 벡터 출력방법4. 반복자(Iterator) - Vector의 Object를 반복하며 리턴
public class Vector_Enumeration_Iterator_printVector {

	public static void main(String[] args) {

		// Vector 객체 생성
		Vector v = new Vector(1, 1);	// 초기capa=1, 증가capa=1

		// Vector에 Object 저장
		v.add(30);
		// vector에 정수 10을 저장(기존 add메소드와 동일)
		v.addElement(new Integer(10));
		v.addElement("johnharu");
		v.addElement("gracedew");
		
		// 벡터는 멀티스레드 처리할 경우 사용
		// 벡터는 다양한 출력방식을 제공(순차적인 자료구조이기에 가능)
//		벡터 출력방법1. vector 자료구조에 저장된 데이터를 출력
		System.out.println(v);				// [30, 10, "johnharu", "gracedew"]

//		벡터 출력방법2. get()메소드를 활용해서 인덱스에 접근해 출력***
		for(int i=0; i<v.size(); i++) {
			// get(i)메소드를 통해 해당 인덱스 요소를 가져와 출력
			System.out.print(v.get(i)+"\t");
		}
		System.out.println();
		
//		벡터 출력방법3. 나열형(Enumeration)
		// Vector의 Object의 나열형을 리턴
		// element()메소드를 활용하여 벡터의 값을 받음
		Enumeration e = v.elements();
		// v.elements()를 통해 Vector의 Object를 나열하는 Enumeration 얻음

		// Enumeration을 이용해 Vector의 Object를 출력
		// hasMoreElements()메소드를 활용 => 가져올 데이터가 있을 경우 true리턴
		while (e.hasMoreElements()) {
			// nextElement() 메서드를 통해 값을 받아 출력
			System.out.print(e.nextElement()+"\t");
		}
		System.out.println();

//		벡터 출력방법4. 반복자(Iterator)
		Iterator ie = v.iterator();
		// v.iterator()를 통해 Vector의 Object를 반복하는 Iterator룰 얻음

		// Iterator을 이용해 Vector의 Object를 출력
		// hasNext()메소드를 활용 => 가져올 데이터가 있을 경우 true리턴
		while (ie.hasNext()) {
			// next() 메서드를 통해 값을 받아 출력
			System.out.print(ie.next()+"\t");
		}
		System.out.println();

	} // main end
}
