package p2023_07_24;

import java.util.Scanner;

//MemberInfo클래스
//키보드로 입력한 회원의 정보를 
//새로운 정보를 저장하는 클래스의 멤버변수에 저장시킨 후, 출력
class MemberInfo_ObjArr {
	
	// 필드
	private String name;
	private int age;
	private String email;
	private String address;
	
	// 생성자
//	public MemberInfo_ObjArr(String name, int age, String email, String address) {
//		this.name = name;
//		this.age = age;
//		this.email = email;
//		this.address = address;
//	}
	
	// 메소드 -  객체배열 출력 메소드
	public static void printInfo(MemberInfo_ObjArr[] Objarr) {
		for (int i = 0; i < Objarr.length; i++) {
			System.out.print("성명: "+Objarr[i].getName()+"\t");
			System.out.print("나이: "+Objarr[i].getAge()+"\t");
			System.out.print("E-mail: "+Objarr[i].getEmail()+"\t");
			System.out.print("주소: "+Objarr[i].getAddress()+"\t");
			System.out.println();
		}
	}
	
	// getters 메소드
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
public class Report_0721_MemberInput_ObjArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("입력하실 회원수와 각 회원정보를 입력해주세요(성명, 나이, 이메일, 주소) : ");
		
		Scanner sc = new Scanner(System.in);
		
		// 입력받은 회원수
		int N = sc.nextInt();
		sc.nextLine();		// 개행문자 소비
		
		// MemberInfo_ObjArr 클래스의 객체배열 생성
		MemberInfo_ObjArr[] memberObjArr = new MemberInfo_ObjArr[N];

		// sc.nextInt()메소드 - 정수값 입력받을 경우 사용. 개행문자(Enter키)
		// sc.next()메소드 - 공백X 문자열 입력받을 경우 사용. 공백으로 구분
		// sc.nextLine()메소드 - 한줄의 문자열 입력받을 경우 사용. 개행문자(Enter키)
		for (int i=0; i<N; i++) {
			String name = sc.next();
			int age = sc.nextInt();
			String email = sc.next();
			String address = sc.nextLine();
			
			// 새로운 MemberInfo_ObjArr객체를 생성하고, 
			// 해당 객체를 객체배열 memberObjArr의 인덱스i에 할당
			memberObjArr[i] = new MemberInfo_ObjArr();
			memberObjArr[i].setName(name);
			memberObjArr[i].setAge(age);
			memberObjArr[i].setEmail(email);
			memberObjArr[i].setAddress(address);
		}
		
		//객체배열 출력
		MemberInfo_ObjArr.printInfo(memberObjArr);
	}
}
