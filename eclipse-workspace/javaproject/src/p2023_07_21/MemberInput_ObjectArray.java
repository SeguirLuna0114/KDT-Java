package p2023_07_21;

import java.util.Scanner;

public class MemberInput_ObjectArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// MemberInfo[] 객체 배열 생성
		// MemberInfo 객체를 담을 수 있는 객체배열 m 생성
		MemberInfo[] m = new MemberInfo[5];

		// 변수 초기화
		int i = 0; // 배열에 저장된 현재 회원수(i)
		String yn; // 사용자로부터 입력을 계속 받을지 여부

		// 사용자 입력을 받기 위한 Scanner객체 생성
		Scanner sc = new Scanner(System.in);

		String name, email, address;
		int age;

		// do-while 루프
		// 사용자에게 회원정보를 입력받는 루프. 사용자가 입력을 계속할지 여부
		do {
			System.out.print("성명을 입력하세요? ");
			name = sc.nextLine();
			System.out.print("나이를 입력하세요? ");
			age = sc.nextInt();// 숫자를 입력받은후에 enter키를
			sc.nextLine(); // 누르면 null값을 return하게 됨
			// Enter키를 구분자로 사용할 경우,
			// nextInt()메서드는 숫자를 입력받은 후에 Enter를 누르면 개행문자로 읽어 null값을 Enter하게됨
			// => 개행문자 소비를 위해 nextLine()을 호출

			System.out.print("E-Mail을 입력하세요? ");
			email = sc.nextLine();
			System.out.print("주소를 입력하세요? ");
			address = sc.nextLine();

			// 생성자 호출
			m[i] = new MemberInfo(name, age, email, address);
			// m.name="홍길동";
			i++;

			System.out.print("계속할려면 y, 멈출려면 n을 입력?");
			yn = sc.nextLine();
			if (yn.equals("y") || yn.equals("Y")) {
				continue; // 루프 반복
			} else if (yn.equals("n") || yn.equals("N")) {
				break; // 루프를 종료하고 입력을 멈춤
			}

		} while (true); // 무한루프

		for (int j = 0; j < i; j++) {
//			System.out.println("성명:" + m[j].getName());
//			System.out.println("나이:" + m[j].getAge());
//			System.out.println("E-Mail:" + m[j].getEmail());
//			System.out.println("주소:" + m[j].getAddress());
			
			// print()메소드 사용하여 간단히 출력
			m[j].print();
		}
	}

}

// 데이터 전송 객체 DTO(Data Transfer Object): 필드(멤버변수)를 저장하는 객체
// -데이터베이스로부터 데이터를 가져와 비즈니스 로직계층으로 전달
// -클라이언트와 서버 사이에서 데이터를 전달하는데 사용
// -데이터를 효율적으로 전송하고 처리하기 위해 사용되는 패턴
// -데이터 객체로, 데이터의 저장과 전달을 위한 목적으로 사용됨
class MemberInfo {

	// 필드
	// private접근제어자 사용 => 멤버변수(필드)보호 - 클래스내에서만 사용가능
	private String name;
	private int age;
	private String email;
	private String address;

	// public 생성자
	// private이기에 direct로 접근X => 생성자를 활용해서 변수에 값을 입력
	public MemberInfo(String name, int age, String email, String address) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.address = address;
	}
	
	// print 메소드 => 좀 더 쉽게 출력 가능
	public void print() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(email);
		System.out.println(address);
	}

	// getters 메소드 => 각 변수(필드)의 값을 외부로부터 읽어올 수 있게
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

}
