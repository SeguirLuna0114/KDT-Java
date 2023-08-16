package p2023_07_31;

import java.util.ArrayList;
import java.util.List;

// 레퍼런스 형변환(Reference Type Casting)
// -두 클래스 사이에 상속관계가 있어야 함

//* 다운 캐스팅(강제 형변환) "하위 클래스의 정보 복구"
//	: 기본 클래스의 객체를 파생 클래스 타입으로 형변환하는 것
//	"부모 클래스의 참조변수를 자식 클래스 타입으로 형변환하는 것"
//
// 1. 슈퍼클래스에서 서브클래스로 형변환 하는것
// 2. 참조 가능한 영역이 확대가 된다.
// 3. 컴파일러에 의해서 암시적 형변환(자동 형변환)이 되지 않기    
//    때문에 자료형을 생략할 수 없다.(강제 형변환)
// * 메소드의 반환되는 자료형이 최상위 클래스인 Object형인 경우 사용
// 4. 다운캐스팅을 하기 위해선, 자식클래스의 객체 생성 -> 상위 클래스로 업 캐스팅 한 후
//    다시 다운캐스팅을 해야 함

public class CastingEx_DowncastCase_List_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 다운캐스팅: 부모클래스 타입 -> 자식클래스 타입 변환
//	ex1. 메소드의 반환값이 Object타입인 경우 다운캐스팅 사용
//		(Object타입으로 반환되는 값을 문자열String 타입으로 변환)
		// ArrayList인스턴스를 List타입으로 참조하는 lt변수 생성
		List lt = new ArrayList();		// 업캐스팅
		// List타입으로 선언된 변수(lt)에는 ArrayList가 할 수 있는 모든 메소드 포함됨
		// => 선언된 변수타입이 상위 클래스 타입인 경우, 다운캐스팅 필요X
		
		// String 문자열을 바로 추가하기에, 박싱 발생X
		// 문자열은 String클래스로 처리되는 참조타입이기에, 추가적인 박싱은 필요X

		// 업캐스팅
//		add(Object e)메소드: List 인터페이스에 포함되며, list에 요소를 추가하는 메소드
		// 모든 클래스는 최상위 클래스인 Object클래스를 상속받으므로, String은 Object의 하위 클래스 => 업캐스팅 발생O
		lt.add(new String("자바")); 		// 업캐스팅
		lt.add("오라클");
		lt.add("JSP");
		lt.add("스프링");
		lt.add("파이썬");
		lt.add("텐스플로우");

		// 다운캐스팅 : Object타입으로 반환되는 값을 다시 원래타입(Object의 자식형태)으로 변환
		// 타입 캐스트 연산자(Type)을 사용하여 수행
//		Object get(int index) 메소드: List인터페이스에 정의되며, 리스트에서 지정된 인덱스에 해당하는 요소 가져옴
		// -반환값은 Object타입이기에, 실제로 사용하기 위해서는 적절한 형변환이 필요
		// -원시 타입의 데이터를 저장하는 경우, 해당 데이터 사용시 Wrapper클래스로 형변환 필요
		Object obj = lt.get(0);
		// get()이 반환하는 값이 Object타입이기에 다운캐스팅 발생X
		
		String s = (String)lt.get(0);		// 다운 캐스팅
		// get()이 반환하는 값 Object타입을 String타입 변수에 저장시,
		// (String) 타입캐스트 연산자를 사용하여 Object -> String 형변환
		
		// 반복문을 사용해 리스트의 모든 요소에 접근
		for (int i=0; i<lt.size(); i++) {
			Object ob = lt.get(i);
			
			String str = (String)lt.get(i);		// 다운 캐스팅
			// get()이 반환하는 값 Object타입을 String타입 변수에 저장시,
			// (String) 타입캐스트 연산자를 사용하여 Object -> String 형변환
			System.out.println(str);
		}
		
		
//	ex2. 메소드의 반환값이 Object타입인 경우 다운캐스팅 사용
//		(Object타입으로 반환되는 값을 기본자료형(int, boolean, double) 타입으로 변환
		// List인터페이스를 구현한 ArrayList를 생성하고, List타입으로 참조하는 ls변수 생성
		List ls = new ArrayList();		// 업캐스팅
		
//		add(Object e)메소드: List 인터페이스에 포함되며, list에 요소를 추가하는 메소드
		// 기본 데이터타입인 int를 Integer객체로 자동 변환하여 리스트에 저장
		// 오토박싱: 기본 데이터타입인 int를 Integer로 자동으로 박싱
		ls.add(10);						// 업캐스팅 + 오토박싱
		ls.add(200);
		ls.add(3000);
		ls.add(40000);
		ls.add(500000);

//		Object get(int index) 메소드: List인터페이스에 정의되며, 리스트에서 지정된 인덱스에 해당하는 요소 가져옴
		Integer it = (Integer)ls.get(0);	// 다운캐스팅
		// get메소드의 반환타입이 Object타입이기에, Integer로 다운캐스트
		int n1 = it.intValue();				// 언박싱
		// intValue()메소드를 사용하여 Integer객체의 기본값 -> int타입으로 언박싱
		
		// 다운캐스팅 + 언박싱(한 줄로 처리 가능)
		// get()메소드로 반환된 값을 Integer로 다운캐스팅한 후,
		// intValue()메소드로 언박싱
		int n2 = ((Integer)ls.get(0)).intValue();
		
		// 반복문으로 리스트의 모든 요소에 접근
		for (int i=0; i<ls.size(); i++) {
			Object ob = ls.get(i);
			
			Integer t = (Integer)ls.get(i);		// 다운캐스팅
			// 반환값 Object타입을 (Integer)타입캐스트 연산자로 Integer로 다운캐스팅
			int n3 = t.intValue();				// 언박싱
			// intValue()메소드를 사용하여 Integer객체의 값을 int형으로 언박싱
			
			// 다운캐스팅 + 언박싱
			int n4 = ((Integer)ls.get(i)).intValue();
			System.out.println(n4);
		}
		
	}

}
