package p2023_07_20;

import java.util.Scanner;

// MemberInfo2클래스
// 키보드로 입력한 회원의 정보를 
// 새로운 정보를 저장하는 클래스의 멤버변수에 저장시킨 후, 출력
class MemberInfo2 {
	
	// 필드
	private String name;
	private int age;
	private String email;
	private String address;
	
	public MemberInfo2(String name, int age, String email, String address) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.address = address;
	}
	
	// 메소드
	public void printInfo() {
		System.out.println(name +"/"+age+"/"+email+"/"+address);
	}
	
	// getters메소드
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

	// setters 메소드
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

//MemberInput클래스
//키보드를 통해 각 회원들의 정보를 입력받음
public class MemberInput2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("입력하실 회원수와 각 회원정보를 입력해주세요(성명, 나이, 이메일, 주소) : ");
		
		Scanner sc = new Scanner(System.in);
		// 입력받은 회원수
		int N = sc.nextInt();
		
		String[] name = new String[N];
		int[] age = new int[N];
		String[] email = new String[N];
		String[] address = new String[N];
		
		for (int i=0; i<N; i++) {
			name[i] = sc.next();
			age[i] = sc.nextInt();
			email[i] = sc.next();
			address[i] = sc.nextLine();	// nextLine(): 한줄 전체를 입력(띄어쓰기포함)
			
			MemberInfo2 meminfo = new MemberInfo2(name[i], age[i], email[i], address[i]);
			meminfo.printInfo();
			
//			if (N>1) {
//				meminfo.setName(name[i]);
//				meminfo.setAge(age[i]);
//				meminfo.setEmail(email[i]);
//				meminfo.setAddress(address[i]);
//				
//				meminfo.printInfo();
//			}
		}		

	}

}
