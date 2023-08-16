package p2023_07_18;

// p198
// 향상된 for문(확장 for문)
// 형식: for( 변수타입 변수 : 순차적인 자료구조(배열, 컬렉션)) {
//			실행될 문자;	// 반복 실행될 코드
//		}
// 		- 변수타입: 배열 또는 컬렉션에 포함된 개별 요소의 타입
//		- 변수: 현재 순회/반복중인 변수
//		- 순차적 자료구조: 반복하고자 하는(반복 가능한) 객체(배열, 리스트, 집합)

// -주로 배열, 컬렉션과 같은 반복 가능한 객체를 순회하는데 사용
// - for-each 루프라고도 불림. 기본 for문보다 간결하고 가독성 높음
// -1. 요소에 대한 반복: 확장 for문은 배열 또는 컬렉션의 각 요소에 대해 반복
//					각 요소는 '변수'에 할당되고, 반복 실행될 코드블록이 실행됨
// -2. 순서 보장: for문은 배열 또는 컬렉션의 순서를 보존
//				=> 순차적인 처리가 불필요한 경우 유용
// -3. 수정 불가능한 요소: 확장 for문은 읽기전용으로 요소 처리=>값 변경X
public class ArrayEx06_ForEachLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] scores = {95, 71, 84, 93, 87};
		
		// scores배열의 원소값 출력
		// 방법1) 기본적인 for문 활용
		int sum = 0;
		for (int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("총합: "+sum);
		
		// 확장 for문 형식
//		for (element_type element : scores배열) {
//			 반복 실행할 구문
//		}
		// 방법2) 향상된 for문
		int sum2 = 0;
		// scores배열의 각 요소를 's'변수에 할당하여 출력
		for (int s : scores) {	
			sum2 += s;
		}
		System.out.println("총합: "+sum2);
		
	}

}
