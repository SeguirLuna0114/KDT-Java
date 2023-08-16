package p2023_08_01;

import java.util.*;

// Vector.size(): Vector의 크기. 즉, Vector에 저장된 요소의 개수 의미
// Vector.capacity(): Vector의 용량 반환. 즉, Vector가 현재 저장가능한 최대 요소 개수
public class Vector_Constructor_Size_Capacity {
	public static void main(String[] args) {

		// 기본적인 vector 생성 방법
		// 비어있는 Vector객체 생성. 
		// 기본 capa=10으로 설정되며 요소 추가될때 capa가 부족하면 자동으로 늘어남
		Vector vector1 = new Vector();
		System.out.println("size1=" + vector1.size());			// 0
		System.out.println("capacity1=" + vector1.capacity());	// 10

		// 초기 capacity만 지정한 생성 방법
		// 초기 capa를 3으로 지정하여 Vector객체 생성
		Vector vector2 = new Vector(3);
		System.out.println("size2=" + vector2.size());			// 0
		System.out.println("capacity2=" + vector2.capacity());	// 3
		// 초기 capa를 3으로 지정했기에, 3(단, 요소를 추가하면 자동으로 증가)

		// vector에 값을 추가
		vector2.add("gemini");
		vector2.add("johnharu");
		vector2.add("gracedew");
		vector2.add("bidon");
		
		// size는 추가된 요소의 개수
		System.out.println("size2=" + vector2.size());			// 4(추가된 요소개수)
		// 값을 추가하면, capa가 부족할 경우 자동으로 capa가 증가
		System.out.println("capacity2=" + vector2.capacity());	// 6

		// 초기 capacity와 증가 capacity를 지정한 생성 방법
		// 초기 capa를 1로 지정하고, 증가 capa를 1로 지정하여 Vector 객체를 생성
		// 증가 capa: Vector의 크기가 초과될 때, capa를 얼마 증가시킬지 의미
		Vector vector3 = new Vector(1, 1);
		
		vector3.add("opendb");
		System.out.println("size3 = " + vector3.size());		// 1(추가된 요소 개수)
		// capa는 초기 1이었지만, 요소를 추가하면서 자동적으로 증가
		System.out.println("capacity3=" + vector3.capacity());	// 1

		vector3.add("moon");
		System.out.println("size3 = " + vector3.size());		// 2(추가된 요소 개수)
		// capa는 초기 1이었지만, 요소를 추가하면서 자동적으로 증가
		System.out.println("capacity3=" + vector3.capacity());	// 2
	}
}
