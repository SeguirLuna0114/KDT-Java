package p2023_08_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Report_0802_MemberInput_List_proff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 멤버 정보를 저장하기 위한 ArrayList 객체 생성
		ArrayList li = new ArrayList();
		
		// MemberInfo클래스 변수 mm 선언(주소값은 아직 할당x)
		// - 출력시 임시로 사용할 변수(이후 객체를 생성해 할당할 것)
		MemberInfo mm;
		// 입력 지속 관련 문자열 변수 생성
		String yn;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("성명을 입력하세요? ");
			String name = sc.nextLine();
			System.out.print("나이를 입력하세요? ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.print("E-Mail을 입력하세요? ");
			String email = sc.nextLine();
			System.out.print("주소를 입력하세요? ");
			String address = sc.nextLine();

			// 입력받을 정보를 저장할 MemberInfo객체 생성
			MemberInfo m = new MemberInfo();
			// set메소드를 활용해 정보를 객체에 저장
			// m.name="홍길동";
			m.setName(name);
			m.setAge(age);
			m.setEmail(email);
			m.setAddress(address);

			// 입력받은 정보를 MemberInfo m 객체변수를 통해 List에 추가
//			boolean add(Object e)
//			Object e = new MemberInfo();
			li.add(m);

			System.out.println("계속할려면 y, 멈출려면 n을 입력?");
			yn = sc.nextLine();
			if (yn.equals("y")) {
				continue;
			} else if (yn.equals("n")) {
				break;
			}

		} while (true);

		// 입력된 정보를 저장한 List객체 li를 순회하면서 저장 정보 출력
		for (int i = 0; i < li.size(); i++) {
			mm = (MemberInfo) li.get(i);
//			MemberInfo mm = (MemberInfo) li.get(i);		// 이렇게 작성해도 되기는 함(위에서 이미 생성한 변수가 아니라면)

			System.out.println("성명:" + mm.getName());
			System.out.println("나이:" + mm.getAge());
			System.out.println("E-Mail:" + mm.getEmail());
			System.out.println("주소:" + mm.getAddress());
		}
	}

}

// DTO(Data Transfer Object)
class MemberInfo extends Object {
	private String name;
	private int age;
	private String email;
	private String address;

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
