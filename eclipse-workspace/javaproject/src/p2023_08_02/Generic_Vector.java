package p2023_08_02;

import java.util.*;

//제네릭(Generic): 자료구조에 한가지 자료형의 데이터만 저장 하도록 해주는 역할

// 제네릭을 사용한 경우
// - 제네릭을 사용하게 되면, 자료구조에서 데이터를 구해올 때
//	 제네릭으로 설정된 자료형은 생략할 수 있음

class Generic_Vector {
	
	public static void main(String[] args) {
		
		// 제네릭(Generic): 자료구조에 한가지 자료형의 데이터만 저장 하도록 해주는 역할
		Vector<String> vec = new Vector<String>();

//		boolean add(Object e)
		vec.add("Apple");
		vec.add("banana");
		vec.add("oRANGE");
		
		// String형 데이터만 저장 가능
//		vec.add(50);

		// 제네릭을 사용하게 되면, 자료구조에서 데이터를 구해올 때
		// 제네릭으로 설정된 자료형은 생략할 수 있음
//		Object get(int index)
		String temp;
		for (int i = 0; i < vec.size(); i++) {
			// 다운캐스팅X
			//temp = (String)vec.get(i); 처럼 형변환을 명시적으로 할 필요X
			// 다운캐스팅 없이 그대로 String 타입으로 할당 가능
			temp = vec.get(i);			// 자료형 생략 가능
			System.out.println(temp.toUpperCase());
		}
	}
}
