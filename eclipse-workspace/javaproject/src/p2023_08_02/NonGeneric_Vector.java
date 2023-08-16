package p2023_08_02;

import java.util.*;

// 제네릭(Generic): 자료구조에 한가지 자료형의 데이터만 저장 하도록 해주는 역할

//	제네릭을 사용하지 않았을 경우
// - 여러 자료형의 데이터를 저장할 수 있음
// - 모든 데이터가 Object로 업캐스팅 되기 때문에, 컴파일러가 데이터타입을 확인X
// - 데이터를 꺼낼 때마다, 데이터 타입에 맞게 다운캐스팅을 수행해야 함

class NonGeneric_Vector {
	
	public static void main(String[] args) {

		// 제네릭을 사용하지 않으면, 여러 자료형의 데이터를 저장할 수 있음
		Vector vec = new Vector();
		
		// 문자열, 정수, 부동 소수점 숫자, 문자, 논리값을 추가
//		boolean add(Object e)
		// 업캐스팅 (String은 Object로 업캐스팅되어 저장됨)
		vec.add("Apple");		
		vec.add("banana");
		vec.add("oRANGE");
		
//		// 업캐스팅 (Integer는 Object로 업캐스팅되어 저장됨)
//		vec.add(50);
//		// 업캐스팅 (Double은 Object로 업캐스팅되어 저장됨)
//		vec.add(3.14);
//		// 업캐스팅 (Character는 Object로 업캐스팅되어 저장됨)
//		vec.add('k');
//		// 업캐스팅 (Boolean은 Object로 업캐스팅되어 저장됨)
//		vec.add(true);

		// 반복문을 사용하여 저장된 데이터를 순회하고, 
		// 다운 캐스팅을 통해 원래 자료형으로 형변환
//		Object get(int index)
		String temp;
		for (int i = 0; i < vec.size(); i++) {
			// temp라는 String변수에 할당하기 위해서는, 다운캐스팅 필요
			// 다운 캐스팅 (저장된 Object를 다시 String으로 다운 캐스팅)
			temp = (String) vec.get(i); // 다운 캐스팅
			
			// 여러 데이터타입으로 작성한 경우에는 다운캐스팅 할 수 X
			// => Object타입으로 출력
//			Object temp = vec.get(i);
			
			// 저장된 데이터 출력
			System.out.println(vec.get(i));
			// 다운 캐스팅된 문자열을 대문자로 출력
			System.out.println(temp.toUpperCase());
			System.out.println();
		}
	}
}
