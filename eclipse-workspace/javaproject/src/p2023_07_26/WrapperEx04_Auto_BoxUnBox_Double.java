package p2023_07_26;

// Double 클래스를 사용하여 데이터 형변환
// 1. 박싱: Double클래스 생성자를 사용해서 객체 생성
// 		Double(double value) : 매개변수가 double형인 객체생성자
// 		Double(String s) : 매개변수가 String형인 객체생성자
// 1-1. 자동박싱: 기본 데이터 타입 값을 해당 Wrapper클래스 객체로 "자동" 형변환

// 2. 언박싱: Wrapper클래스의 객체로 감싸져 있는 값을 다시 기본 데이터타입으로 변환
// 2-1. 자동언박싱: Wrapper클래스 객체를 해당하는 기본 데이터타입으로 자동 변환
public class WrapperEx04_Auto_BoxUnBox_Double {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Double 객체 생성자는 기본생성자X
//		Double d = new Double();	// 오류발생
		
		
		// Double(double value) : 매개변수가 double형인 객체생성자
		// Double클래스의 생성자를 사용하여 double값을 Double객체로 박싱
		Double d1 = new Double(3.14); 	// 박싱
		
		// 자동박싱 - 기본데이터타입(double형)을 Wrapper클래스(Double)에 대입
		Double d11 = 3.14;				// 자동 박싱
		
		// 자동 언박싱 - 주로, Wrapper클래스가 제공하는 메소드를 사용하여 이루어짐
		// Double클래스+doubleValue()메소드 
		// => Double객체에 저장된 실수값 -> double변환
		double n1 = d1.doubleValue();	// 언박싱
		double n11 = d11;				// 자동 언박싱
		
		// 문자 "42.195" --> 숫자 42.195
		// 1. 자료형 변환 : 객체 생성 -> 메소드 활용
		// doubleValue()메서드 : Double객체에 저장된 실수값을 double변환
		// Double클래스의 생성자를 사용하여, 문자열("42.195")를 double객체로 박싱
		Double d2 = new Double("42.195");	// 박싱
		// d2변수에 Double객체 생성되고, 그 안에는 42.195 들어있음
		
		// 문자 데이터의 경우에는 자동 박싱이 지원되지X => 박싱만 가능
//		Double d22 = "42.195";			// 오류발생
		
		// 문자("42.195")가 실수값 42.195로 자료형변환 발생
		double n2 = d2.doubleValue();		// 언박싱
		double n22 = d2;					// 자동 언박싱
		
		// 2. 자료형 변환 : Double클래스 내 메서드 활용
		// double parseDouble(String s)메서드: 문자열을 실수값으로 변환하는 정적 메소드
		// Wrapper클래스 사용 없이 문자열과 실수값 사이 변환 가능
		double num = Double.parseDouble("42.195");
		System.out.println("num="+num);
		
	}

}
