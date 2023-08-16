package p2023_07_20;

// p236 ~ 237
// 필드와 생성자만으로 Korean클래스 형성
// 이때, main메소드가 없는 경우 실행X, 컴파일만 가능
class Korean {
	
	// 필드(field), 멤버변수(하나의 코드를 구성하는 멤버라는 의미)
	// - 객체가 생성될 때 heap 메모리상에서 값을 저장하는 역할
	String nation = "대한민국";
	String name;
	String ssn;
	
	// 생성자 - 객체 생성시 호출, 필드값 초기화
	public Korean(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	
}

public class KoreanEx_FieldnConst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Korean클래스 객체생성
		Korean k1 = new Korean("박자바", "011225-1234567");
		System.out.println("k1.name: "+k1.name);
		System.out.println("k1.ssn: "+k1.ssn);
		
		Korean k2 = new Korean("김자바", "930525-0654321");
		System.out.println("k1.name: "+k2.name);
		System.out.println("k1.ssn: "+k2.ssn);
		
	}

}
