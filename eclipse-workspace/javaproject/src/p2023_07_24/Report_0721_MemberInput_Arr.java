package p2023_07_24;

import java.util.Scanner;

//MemberInfo클래스
//키보드로 입력한 회원의 정보를 
//새로운 정보를 저장하는 클래스의 멤버변수에 저장시킨 후, 출력
class Report_MemberInfo {
	
	// 필드
	private String name;
	private int age;
	private String email;
	private String address;
	
	// 생성자
//	public Report_MemberInfo(String name, int age, String email, String address) {
//		this.name = name;
//		this.age = age;
//		this.email = email;
//		this.address = address;
//	}
	
	// 메소드
	public void printInfo() {
		System.out.println(name +"/"+age+"/"+email+"/"+address);
	}
	
	// setters 메소드 - 개별적으로 값 전달
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
	
}

// 키보드를 통해 각 회원들의 정보를 입력받는 클래스
public class Report_0721_MemberInput_Arr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("입력하실 회원수와 각 회원정보를 입력해주세요(성명, 나이, 이메일, 주소) : ");
		
		Scanner sc = new Scanner(System.in);
		
		// 입력받은 회원수
		int N = sc.nextInt();
		sc.nextLine();
		
		// 배열 생성
		String[] name = new String[N];
		int[] age = new int[N];
		String[] email = new String[N];
		String[] address = new String[N];
		
		for (int i=0; i<N; i++) {
			name[i] = sc.next();
			age[i] = sc.nextInt();
			email[i] = sc.next();
			address[i] = sc.next();
		}
		
		Report_MemberInfo member = new Report_MemberInfo();
		
		for (int i=0; i<N; i++) {
			member.setName(name[i]);
			member.setAge(age[i]);
			member.setEmail(email[i]);
			member.setAddress(address[i]);
			member.printInfo();
		}
	}
}
