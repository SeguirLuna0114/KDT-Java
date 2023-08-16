package p2023_07_18;

// p195
// 객체 배열 : 객체를 참조하는 배열(배열의 각 항목이 객체인 경우)
public class ArrayEx09_StrArray {

	// 참조 타입 배열: 요소의 값(정수, 실수, 논리값)을 저장X,주소값을 저장O
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String객체를 저장하기 위한 배열 선언
		String[] strArray = new String[3];
		// "Java"라는 String객체를 생성하여 객체배열에 저장
		strArray[0] = "Java";	// 첫번째 항목에 새로운 객체 할당
		strArray[1] = "Java";
		strArray[2] = new String("Java");
		
		// 비교연산자(==): 배열의 "주소값" 비교
		// new연산자를 사용할 경우, 새로운 공간을 형성해서 "java"라는 문자열 저장
		// => 서로 다른 주소값을 가짐
		System.out.println(strArray[0]==strArray[1]);	// true(같은 주소값 참조)
		System.out.println(strArray[0]==strArray[2]);	// false(다른 주소값 참조)
		
		// equals메소드 이용: 배열의 "값" 비교
		// 배열의 객체의 값은 "Java"로 같음
		System.out.println(strArray[0].equals(strArray[2]));	//true
		
		
	}

}
