package p2023_07_20;

// p260

// 클래스 내부에서 메소드 호출 - 일반 메소드 안에서 다른 메소드 호출
// main()메소드 안에서 다른 클래스의 method를 호출하기 위해서는 method를 가진
// 클래스로 객체를 생성한 후, 생성된 객체를 이용하여 method를 호출해야 함
class Calculator1{
	
	// 메소드
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	// 동일 클래스 내부에서 다른 메소드 호출 => 메소드명 만으로 호출 가능
	double avg(int x, int y) {
		// plus()메소드 호출
		double sum = plus(x, y);
		double result = sum / 2;
		return result;
	}
	
	// 실행을 위한 메소드
	void execute() {
		// avg()메소드 호출
		double result = avg(7, 10);
		// println()메소드 호출
		println("실행결과: "+result);
	}
	
	void println(String message) {
		System.out.println(message);
	}
}


public class CalculatorEx1_CallMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Calculator1클래스의 객체(mycal)생성
		Calculator1 mycal = new Calculator1();
		
		// main()메소드 안에서 다른 클래스의 method를 호출하기 위해서는 method를 가진
		// 클래스로 객체를 생성한 후, 생성된 객체를 이용하여 method를 호출해야 함
		mycal.execute();	// execute()메소드 호출
		
//		execute();			// 오류발생
		
	}

}
