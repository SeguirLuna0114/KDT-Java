package p2023_08_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// DTO(Data Transfer Object)
// 회원정보를 저장하는 MemberInfo클래스
class MemberInfo_List {
	
	// 멤버변수
	private String name;
	private int age;
	private String email;
	private String address;
	
	// getter메소드
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
	
	// Setter메소드
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
    @Override
    // toString()메소드 재정의 - 객체의 정보를 문자열로 표현
    public String toString() {
        return "이름: " + getName() + ", \n나이: " + getAge() + ", \n이메일: " + getEmail() + ", \n주소: " + getAddress();
    }
	
    // 회원 정보 출력 메소드
	static void toString(List<MemberInfo_List> list) {
			for (int i=0; i<list.size(); i++) {
				// System.out.println() 메서드 호출 시에 객체 정보가 기본적으로 문자열로 변환되어 출력되는 것이 아니라, 
				// 재정의된 toString() 메서드가 호출되어 정의한 형식으로 출력
				System.out.println(list.get(i));
				System.out.println();
			}
	}
}

// 회원들의 정보를 입력받는 MemberInput클래스
// 성명, 나이, 이메일, 주소를 입력받음
// 단, 2명 이상의 정보를 처리할 경우 List 자료구조를 이용해서 해결
public class Report_0802_MemberInput_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 입력받기위한 Scanner객체 생성
		Scanner sc = new Scanner(System.in);
		
		String YesNo;
		
		// MemberInfo클래스를 활용하여 객체 생성
		// name, age, email, address 멤버변수를 갖는 클래스 객체 생성
		List<MemberInfo_List> list = new ArrayList<MemberInfo_List>();
		
		// do-while루프문을 활용하여 회원정보 입력
		do {
			System.out.println("성명을 입력하세요:");
			String name = sc.nextLine();
			
			System.out.println("나이를 입력하세요:");
			int age = sc.nextInt();
			
			sc.nextLine();	// 개행문자 소비
			
			System.out.println("E-mail을 입력하세요:");
			String email = sc.nextLine();
			
			System.out.println("주소를 입력하세요:");
			String address = sc.nextLine();
			
			// MemberInfo_List객체 생성
			MemberInfo_List member = new MemberInfo_List();
			member.setName(name);
			member.setAge(age);
			member.setEmail(email);
			member.setAddress(address);
			
			// List에 데이터 추가
			list.add(member);
			
			System.out.println("입력을 계속 할것인가요? (continue: y, stop: n)");
			YesNo = sc.nextLine().toUpperCase();
			
		} while (YesNo.equals("Y"));

		// 입력한 회원정보 출력방법1. MemberInfo_List의 toString()메소드 호출
//		MemberInfo_List.toString(list);
		
		// 입력한 회원정보 출력방법2. List의 get()메소드와 MemberInfo_List의 get메소드 사용
		// 입력된 정보를 저장한 ArrayList 객체 list를 순회하면서 정보 출력
		for (int i=0; i<list.size(); i++) {
			MemberInfo_List memlist = (MemberInfo_List)list.get(i);
			
			System.out.println("성명:" + memlist.getName());
			System.out.println("나이:" + memlist.getAge());
			System.out.println("E-Mail:" + memlist.getEmail());
			System.out.println("주소:" + memlist.getAddress());
			System.out.println();
		}
	}

}
