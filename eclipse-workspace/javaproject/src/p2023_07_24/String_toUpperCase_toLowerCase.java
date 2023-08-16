package p2023_07_24;

// 문자열 관련 클래스 - String, StringBuffer, StringTokenizer
// toUpperCase()메소드 : 문자를 대문자로 변환하는 역할
// toLowerCase()메소드 : 문자를 소문자로 변환하는 역할

// String클래스
// 1. String객체를 생성한 후에 메소드에 의해 값의 변화가 일어나면
//	  변경된 값을 heap메모리 영역에 다시 저장
// 2. heap메모리 영역에 변경된 값을 재사용 하기 위해서는,
//	  새로운 변수에 변경된 값을 저장하여 사용
//		ex) String str2 = str1.toUpperCase();
// 3. heap메모리 영역에 변경된 값을 재사용 할 수 없는 경우에는 쓰레기로 인식하고
//	  heap메모리 영역의 데이터를 가비지 콜렉터 프로그램이 모아서 지워버림 
//  	ex) str1.toUpperCase();	// 참조가능한 주소가 없어서 지워버림
// 4. Garbage Collection 기능(쓰레기 수집 기능)
//	  재사용할 수 없는 heap메모리 영역의 데이터를 모아서 지워주는 기능
//		*heap메모리에 접근 불가 = 더이상 참조가능한 주소값이 없는 경우
class String_toUpperCase_toLowerCase {

	public static void main(String[] args) {

		String str1 = "Java Programming";

		str1.toUpperCase(); // 메서드 호출 후에도
		System.out.println(str1); // str1의 내용은 수정되지 않는다.
		System.out.println(str1.toUpperCase());
		System.out.println(str1.toLowerCase());

		// 수정된 내용 재사용을 위해선, 변수에 변경된 값을 저장
		String str2 = str1.toUpperCase(); // 메소드의 처리 결과를 str2에 저장
		System.out.println(str2);
		
		String str3 = str1.toLowerCase(); // 메소드의 처리 결과를 str3에 저장
		System.out.println(str3);
		
	}
}