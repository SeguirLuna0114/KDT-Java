package p2023_08_01;

import java.util.*;

// 벡터의 크기와 용량확인 메소드
// - size(): 현재 벡터에 저장된 요소의 개수를 반환합니다.
// - capacity(): 벡터의 용량(capacity)을 반환합니다. (즉, 벡터가 현재 저장할 수 있는 최대 요소 개수를 의미)

// 벡터의 요소 접근 메소드
// - firstElement(): 벡터의 첫 번째 요소를 반환하는 메소드
// - get(int index): 해당 인덱스에 위치한 요소값을 반환
// - lastElement(): 벡터의 마지막 요소를 반환하는 메소드
public class Vector_firstElement_lastElement {
	
	public static void main(String[] args) {

		// 4개의 요소를 저장할 수 있는 벡터 객체 생성, 3개씩 증가
		// 용량(capacity)이 4이고 증가 capacity가 3인 Vector 객체를 생성
		Vector vec = new Vector(4, 3);
		
		System.out.println("벡터의 크기는 " + vec.size()); // 벡터에 저장된 요소의 개수를 알려줌
		System.out.println("벡터의 용량은 " + vec.capacity());// 벡터의 용량을 반환

		// for반복문을 통해 정수에 10을 곱한 값을 벡터에 추가
		for (int i = 0; i < 5; i++)
			vec.add(i * 10);		// 0, 10, 20, 30, 40이 저장됨
		
		System.out.println("벡터의 크기는 " + vec.size());
		System.out.println("벡터의 용량은 " + vec.capacity());
		
		// 벡터 요소 접근
		// firstElement(): 벡터의 첫 번째 요소를 반환하는 메소드
		System.out.println("첫 번째 요소는 " + vec.firstElement());		// 0
		// get(int index): 해당 인덱스에 위치한 요소값을 반환
		System.out.println("두 번째 요소는 " + vec.get(1)); 			// 인덱스는 0부터 시작=> 10이 반환됨
		// lastElement(): 벡터의 마지막 요소를 반환하는 메소드
		System.out.println("마지막 요소는 " + vec.lastElement());

		// for문을 통해 벡터에 저장된 모든 요소를 출력
		System.out.println("\n >> 저장된 요소 전체 출력 <<");
		for (int i = 0; i < vec.size(); i++)
			// vec.get(i)를 사용하여 인덱스에 접근하고, 그 값을 출력
			System.out.print("   " + vec.get(i));
		System.out.println();
	}
}