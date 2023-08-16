package p2023_07_24;

import java.util.Scanner;
//MemberInfo - MemberInput클래스
//키보드를 통해 각 회원들의 정보를 입력받는 클래스
//새로운 정보를 저장하는 클래스의 멤버변수에 저장시킨 후, 출력

public class Report_0721_MemberInput01_proff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 객체 배열: 객체의 주소를 저장하는 배열
		MemberInfo01[] m = new MemberInfo01[5];	// MemberInfo01객체의 배열m을 크기5로 선언
		
		// 변수 선언
		int i = 0;
		String yn;	// 사용자가 입력을 계속할것인지

		// 사용자가 회원정보를 반복해서 입력할 수 있도록 do-while루프를 사용
		do {
			Scanner sc = new Scanner(System.in);			
			System.out.print("성명을 입력하세요? ");
			String name = sc.nextLine();
			System.out.print("나이를 입력하세요? ");
			int age = sc.nextInt();	
			sc.nextLine();
			System.out.print("E-Mail을 입력하세요? ");
			String email = sc.nextLine();
			System.out.print("주소를 입력하세요? ");
			String address = sc.nextLine();

//			m[i] = new MemberInfo(name, age, email, address);
			// m.name="홍길동";
			
			// 새로운 MemberInfo01객체를 생성하고, 해당 객체를 m배열의 인덱스i에 할당
			m[i] = new MemberInfo01();
			m[i].setName(name);
			m[i].setAge(age);
			m[i].setEmail(email);
			m[i].setAddress(address);
			
			i++;	// 인덱스를 증가시켜 다음 회원 정보를 입력받을 배열의 위치로 이동

			// 사용자가 입력을 계속할지 여부 선택하게 함
			System.out.print("계속할려면 y, 멈출려면 n을 입력?");
			yn = sc.next();
			if (yn.equals("y") || yn.equals("Y")) {
				continue;
			} else if (yn.equals("n") || yn.equals("N")) {
				break;
			}

		} while (true);

		// MemberInfo01의 객체배열 m을 출력
		for (int j = 0; j < i; j++) {
			System.out.println("성명:" + m[j].getName());
			System.out.println("나이:" + m[j].getAge());
			System.out.println("E-Mail:" + m[j].getEmail());
			System.out.println("주소:" + m[j].getAddress());
		}
	}

}

// 데이터 전송 객체 DTO(Data Transfer Object): 필드(멤버변수)를 저장하는 객체

//MemberInfo01클래스
//회원 정보를 나타내는 클래스
class MemberInfo01 {
	
	// 필드
	private String name;	// private접근제어자로 선언됨 => 메소드를 통해 접근
	private int age;
	private String email;
	private String address;
	
	// 생성자
//	public MemberInfo(String name, int age, String email, String address) {
//		this.name = name;
//		this.age = age;
//		this.email = email;
//		this.address = address;
//	}	
	
	// getters & setters메소드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	

}
