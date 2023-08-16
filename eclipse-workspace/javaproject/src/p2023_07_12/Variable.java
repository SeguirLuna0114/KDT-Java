package p2023_07_12;

import java.util.ArrayList;
import java.util.List;

// java로 작성된 class인 Variable 정의
// 그 안에 main 메소드를 포함
public class Variable { // Variable클래스 정의
// public: 다른 클래스에서도 접근 가능
	
	public static void main(String[] args) {
		// main 메소드: 자바프로그램 실행이 시작되는 부분.
		// String[] args: 명령행 인수를 전달받는 매개변수. 실행시 전달되는 인수들을 문자열 배열로 받아옴

// 변수: 메모리상에 데이터를 저장하기 위한 기억 공간의 이름
// 변수를 만드는 방법: 자료형 변수명 = 데이터(값);
		
// 기본 자료형 변수
// 1.정수형 변수
	byte b1 = 10;			// -128 ~ 127
//	byte b2 = 130;			// 오버플로우 발생=>오류메시지 출력됨
	short s = 100;			// -32768 ~ 32767
	int i = 1000;			// -21억 ~ 21억 정수값(대부분 int형 변수 사용)
	long l = 100000L;		// 끝에'L'이 붙어야만 long형 변수로 처리됨(그렇지 않을경우, int형으로 처리됨)
	
	System.out.println("정수형변수 - byte, short, int, long");
	System.out.println("b1="+b1);
	System.out.println("s="+s);
	System.out.println("i="+i);
	System.out.println("l="+l); //int형으로 처리되지 못하는 정수형의 경우에만 long형 사용
	
// 2.실수형 변수
	//float타입: 소수점 아래 7자리까지 정확
	float ft1 = 3.14f;			// 끝에 'f'를 붙여야만 float형으로 처리됨(그렇지 않을경우, double형으로 처리)
	float ft2 = 3.14F;			// 끝에 'f' 또는 'F'를 붙이면 됨
	float ft3 = (float)3.14;	//double형(3.14)를 float형으로 강제 형변환
	
	//double타입: 소수점 아래 15자리까지 정확
	double d = 42.195;			//실수값 저장시 많이 사용
	
	System.out.println("\n"+"실수형변수 - float, double");	
	System.out.println("ft1="+ft1);
	System.out.println("ft2="+ft2);
	System.out.println("ft3="+ft3);
	System.out.println("d="+d);
	
	System.out.printf("%.1f\n", d);	// %.1f: 반올림되어 소수 첫째자리까지 출력됨(42.2)
	System.out.printf("%.2f\n", d);	// %.2f: 반올림되어 소수 둘째자리까지 출력됨(42.20)
		
// 3.문자형 변수
	char c1 = 'A';
//	char c2 = 'AB';				//오류발생
	char c3 = '안';
	
	System.out.println("\n"+"문자형변수 - char");
	System.out.println("c1="+c1);
	System.out.println("c3="+c3);
	
// 4.논리형 변수(논리값 저장시 사용)
	boolean bn1 = true;
	boolean bn2 = false;
	
	System.out.println("\n"+"논리형변수 - boolean");
	System.out.println("bn1="+bn1);
	System.out.println("bn2="+bn2);

// 문자열을 저장하기 위해 사용 => 참조형 변수
// 참조형 변수 : 클래스(Class) - 객체를 생성하기 위한 설계도
	//참조형 변수는 변수가 실제 데이터("자바")를 직접 포함하지 않고, 데이터에 대한 주소(참조)를 가지는 변수
	String s1 = "자바";	//문자열 "자바"는 문자열 풀(String Pool)이라는 특별 영역에 저장됨
	String s2 = new String("자바");	//new 연산자(Operator): 새로운 String 객체 생성하여 할당
	//이 경우, 문자열 풀이 아닌, 새로운 힙(heap)메모리영역에 문자열이 저장됨
	
	//스택(Stack)에서의 참조형 변수: 참조형 변수의 주소(주소값)를 저장
	//힙(heap)에서의 참조형 변수: 참조형 변수의 실제 데이터(값)가 저장됨
	
	System.out.println("\n"+"참조형변수 : 클래스");
	System.out.println("s1="+s1);
	System.out.println("s2="+s2);
	
	if(s1 == s2) {			//s1과 s2의 주소를 비교
		System.out.println("같은 주소");	
	} else {
		System.out.println("다른 주소"); //s1이 가리키는 주소: 문자열 풀에서 "자바", s2가 가리키는 주소: 힙메모리에 생성된 새 주소
		//s1과 s2는 서로 다른 주소를 가리킴(힙에 객체가 생성될 때마다 주소 다르게 할당됨)
	}
	
	if(s1.equals(s2)) {		//equals()메서드: 데이터(값)이 같은지 비교
		System.out.println("같은 값");	//s1이 가리키는 값=자바, s2가 가리키는 값=자바
	} else {
		System.out.println("다른 값");
	}
	
// 참조형 변수 : 배열(Array) - 동일한 자료형의 여러 데이터를 저장하는 정적인 자료구조(크기가 고정됨)
	//배열 변수 - score
	int[] score = {80, 90, 100};	//int형 값들만(한가지 자료형) 사용하여 배열 생성
	
	//인덱스를 사용하여 각 배열의 요소에 접근 가능
	System.out.println(score[0]); 	//80
	System.out.println(score[1]);	//90
	System.out.println(score[2]);	//100
	System.out.println();
	
	for (int j=0; j<score.length; j++) {
		System.out.print(score[j]+"\t");
	}	
	System.out.println();	//줄바꿈 수행
	System.out.println();	//빈 줄을 출력함
//	System.out.println("\n"); //\n: for문이 끝나고 줄바꿈 + 빈줄 추가
	
// 참조형 변수 : 인터페이스(List) - 메서드의 집합을 정의하는 추상타입
// 변수 -(확장형)-> 배열 -(확장형)-> 리스트
// 1.순차적인 자료구조
// 2.여러가지 자료형의 데이터를 모두 저장 가능
// 3.동적으로 공간의 크기를 늘릴 수 있음(배열은 크기가 고정됨)
	
	// 인터페이스는 자체적으로 객체 생성X
//	List list = new List(); // 오류발생
	List list = new ArrayList();
	//List: 부모 인터페이스
	//ArrayList: List인터페이스를 구현하는 구체적인 클래스. 내부적으로 배열을 사용하여 요소 저장=>인덱스를 기반으로 요소에 접근
	
	list.add(30);
	list.add(3.14);
	list.add('j');
	list.add(true);
	list.add("자바");
	
	for (int k=0; k<list.size(); k++) {
		System.out.print(list.get(k)+"\t");
	}
	
	
	}

}
