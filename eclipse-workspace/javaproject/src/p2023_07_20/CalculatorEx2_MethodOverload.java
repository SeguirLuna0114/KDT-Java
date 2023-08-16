package p2023_07_20;

// p265
// 메소드 오버로딩(Method Overloading)
// : 한개의 클래스안에 동일한 이름을 가진 메소드를 여러개 정의하는 것

// 메소드 오버로딩 조건: 매개변수 타입, 개수, 순서 증 하나는 서로 다른경우 사용 가능
// 1. 매개변수의 "자료형"을 다르게 설정
// 2. 매개변수의 "갯수"를 서로 다르게 설정
// 3. 매개변수의 "순서"를 바꾸어서 설정(매개변수 자료형이 다를 경우)

class Calculator2 {
	
	// 메소드 오버로딩 - 매개변수의 갯수 상이함
	// areaRectangle - 정사각형의 넓이 구하는 메소드
	double areaRectangle(double width) {
		return width * width;
	}
	
	// areaRectangle - 직사각형의 넓이
	double areaRectangle(double width, double height) {
		return width * height;
	}
	
	
}

public class CalculatorEx2_MethodOverload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator2 mycal = new Calculator2();
		
		// 정사각형 넓이 구하기
		double result1 = mycal.areaRectangle(10);
		
		// 직사각형의 넓이 구하기
		double result2 = mycal.areaRectangle(10,20);
		
		System.out.println("정사각형의 넓이: "+result1);
		System.out.println("직사각형의 넓이: "+result2);

	}

}
