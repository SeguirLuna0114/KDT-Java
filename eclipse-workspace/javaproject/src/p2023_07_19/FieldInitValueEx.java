package p2023_07_19;

// p228
class FieldInitValue {
	// 필드
	byte byteField;			// 정수형: 0으로 초기화
	short shortField;
	int intField;
	long longField;
	
	boolean booleanField;	// false로 초기화
	char charField;			// char타입은 \u0000(아무것도 참조하지 않은 기본 문자 값)로 초기화
	
	float floatField;		// 실수형: 0.0으로 초기화
	double doubleField;		// 0.0으로 초기화

	int[] arrField;			// null로 초기화
	String referenceField;	// null로 초기화
	// null: 참조할 주소값이 없다는 의미
}

public class FieldInitValueEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// FieldInitValue클래스의 인스턴스 객체 fiv 생성
		// 클래스로부터 객체 생성한 후 필드 사용
		FieldInitValue fiv = new FieldInitValue();
		
		System.out.println("byteField: "+fiv.byteField);
		System.out.println("shortField: "+fiv.shortField);
		System.out.println("intField: "+fiv.intField);
		System.out.println("longField: "+fiv.longField);
		System.out.println("booleanField: "+fiv.booleanField);
		System.out.println("charField: "+fiv.charField);
		System.out.println("floatField: "+fiv.floatField);
		System.out.println("doubleField: "+fiv.doubleField);
		System.out.println("arrField: "+fiv.arrField);
		System.out.println("referenceField: "+fiv.referenceField);

	}

}
