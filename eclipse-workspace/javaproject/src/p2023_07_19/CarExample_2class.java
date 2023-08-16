package p2023_07_19;

// p227
// 하나의 파일 내에 2개의 클래스 존재
// public을 붙이게 되면 오류가 발생(단일 파일에 하나의 public클래스만 포함해야 함)
class Car{	
	// 비공개 클래스로 작성 => 독립적으로 사용X(동일 파일 내 다른 클래스에서만 접근 가능)
	// 필드(field)
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;			// 초기값 0으로 설정됨
}


// main메서드를 가진 public클래스와 파일명이 일치되어야 함
// public클래스이기에, 다른 클래스에서 참조 가능함
public class CarExample_2class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Car클래스의 생성자를 호출하여 새로운 Car객체 생성 
		// => 해당 클래스의 인스턴스 생성&초기화
		Car mycar = new Car();	// 이후, mycar변수를 통해 해당 객체에 접근 가능
		
		// mycar변수가 참조하는 Car객체의 다른 필드 값을 가져옴
		System.out.println("제작회사: "+mycar.company);
		System.out.println("모델명: "+mycar.model);
		System.out.println("색깔: "+mycar.color);
		System.out.println("최고속도: "+mycar.maxSpeed);
		System.out.println("현재속도: "+mycar.speed);
		// 이때 Car클래스의 인스턴스인 mycar객체의 company, model, color, maxspeed는 인스턴스변수
		
		// 필드값 변경
		mycar.speed = 60;
		System.out.println("수정된 속도: "+mycar.speed);
		
	
	}

}
