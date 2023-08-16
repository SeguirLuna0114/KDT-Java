package p2023_07_31;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

// 레퍼런스 형변환(Reference Type Casting)
//-두 클래스 사이에 상속관계가 있어야 함

// # 업캐스팅(Upcasting)(자동 형변환)
//	" 자식클래스의 객체를 부모클래스의 참조 변수에 할당하는 것"
// 1. 서브클래스에서 슈퍼클래스로 형변환 하는것
// 2. 참조 가능한 영역이 축소가 된다.(업 캐스팅 후에는 부모로부터 상속받은 메서드만 호출할 수 있음)
// 3. 컴파일러에 의해서 암시적 형변환(자동 형변환) 된다.
public class CastingEx_UpcastingCase_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 매개변수의 자료형이 Object형이기에, 모든 자료형 혼용 저장 가능
		// (내부적으로 업캐스팅을 진행하며 저장하는 것)
		
//	ex1. Calendar와 GregorianCalendar
		// Calendar 클래스가 추상 클래스이기에, new키워드를 사용해 자체적으로 객체생성X
//		Calendar c = new Calendar();		// 오류 발생
		
		// 대신, Calendar클래스에서 제공되는 getInstance()메소드 사용하여 캘린더의 인스턴스 가져옴
		Calendar c1 = Calendar.getInstance();
		
		// 업캐스팅: 상속받는 하위 클래스 GregorianCalendar클래스를 사용하여 
		// 			GregorianCalendar의 객체를 만들고, 부모클래스 타입의 변수에 할당
		// 			=> 자식클래스 GregorianCalendar 객체를 마치 부모클래스 Calendar객체처럼 다룰 수 있음
		Calendar c2 = new GregorianCalendar();	// 자식객체 -> 부모클래스 변수
//		Calendar c2 = (Calendar)new GregorianCalendar();	// 자동 형변환 되기에, (Calendar) 생략 가능
		
		// 업캐스팅이 되면 GregorianCalendar클래스만으로 객체 생성했을 경우와는 달리
		// Calendar클래스가 상속해주는 메소드만 호출 가능(참조 가능한 영역의 범위가 축소됨)
		GregorianCalendar c3 = new GregorianCalendar();
		
		
//	ex2. List와 ArrayList
		// List는 인터페이스이기에, new키워드를 사용하여 자체적으로 객체 생성X
//		List li = new List();			// 오류 발생
		
		// 대신, List인터페이스를 구현한(상속받은) 하위 클래스의 객체를 생성 가능
		// ArrayList클래스는 List인터페이스를 구현한(상속받은) 클래스
		List list = new ArrayList();	// 업캐스팅
		// ArrayList객체를 생성하여 List객체처럼 다룰 수 있음
		
		// ArrayList는 구체적인 클래스이기에, 자체적으로 객체 생성O
		ArrayList a1 = new ArrayList();	
		
		
//	ex3. 메소드의 매개변수가 최상위 클래스인 Object타입인 경우 업캐스팅 사용
//		add(Object e)메소드: List 인터페이스에 포함되며, list에 요소를 추가하는 메소드
		// 기본 타입을 Wrapper클래스로 자동으로 박싱하여 list에 추가
		
		// int 10 -> Integer객체로 변환되어 list에 추가
		// Object e = new Integer(10) 박싱 + 업캐스팅(매개변수 Object타입)
		list.add(10);		
		
		// double 3.14 -> Double객체로 변환되어 list에 추가
		// Object e = new Double(3.14) 박싱 + 업캐스팅(매개변수 Object타입)
		list.add(3.14);
		
		// char 'j' -> Character객체로 변환되어 list에 추가
		// Object e = new Character('j') 박싱 + 업캐스팅(매개변수 Object타입)
		list.add('j');
		
		// boolean true -> Boolean객체로 변환되어 list에 추가
		// Object e = new Boolean(true) 박싱 + 업캐스팅(매개변수 Object타입)
		list.add(true);		// Object타입인 list에 그대로 추가됨
		
		// String은 기본 데이터타입X => 자동박싱X
		// 따라서, String("자바")라는 문자열 리터럴은 list에 바로 추가됨 => 박싱X
		// 박싱X + 업캐스팅(모든 클래스는 Object 클래스를 상속받으므로, String객체는 Object클래스의 하위클래스)
		list.add("자바");
		
		
//		boolean equals(Object e)메소드 : Object 클래스에서 상속된 메소드로, 두 객체가 같은지 비교하는데 사용

		// 1. equals()메소드로 문자열 비교
		// Object e = new String("java");		// 업캐스팅
		// "java"는 리터럴 방식으로 생성된 문자열 => 문자열 풀에 존재
		if ("java".equals(new String("java"))) {
			System.out.println("같은 값");	// true: 동일한 문자열
		} else {
			System.out.println("같은 값");
		}
		
		// 2. equals()메소드로 정수 비교
		// Object e = new Integer(30);		// 업캐스팅
		// Object e = 30;					// 자동 박싱 + 업캐스팅
		if (new Integer(30).equals(new Integer(30))) {
			// Integer클래스는 equals()메소드를 숫자의 내용 비교하게 재정의
			System.out.println("같은 값");	// 같은값
		} else {
			System.out.println("다른 값");
		}
		
		// 3. equals() 메소드로 부동소수점 비교
		// Object e = new Integer(3.14);	// 업캐스팅
		// Object e = 3.14;					// 자동 박싱 + 업캐스팅
		if (new Double(3.14).equals(new Double(3.14))) {
			// Double 클래스는 equals()메소드를 숫자의 내용을 비교하도록 재정의
			System.out.println("같은 값");	// 같은 값
		} else {
			System.out.println("다른 값");
		}
		
	}

}
