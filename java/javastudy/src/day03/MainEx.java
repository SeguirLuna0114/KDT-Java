package day03;

class Member2{
	// 필드
	//1.필드는 Member2클래스로 객체를 생성할 때 heap메모리상에 공간을 할당
	//  받아서 값을 저장하는 역할을 한다.
	private int age;			
	private String name;
	private String email;
	private String address;
	
	public Member2() {			// 기본 생성자
	}
	
	// 생성자
	// 1.생성자는 클래스명과 동일한 이름으로 만들어야 한다.
	// 2.생성자는 객체를 생성할때 호출되면서, 필드값을 초기화 시키는 역할을 한다. 
	public Member2(int age, String name, String email, String address) {
		this.age = age;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	//1.필드값을 출력하는 역할
	public void print() {
		System.out.println(age);
		System.out.println(name);
		System.out.println(email);
		System.out.println(address);
	}
	
	//2. getter 메소드 : 메소드를 호출한 곳에 값을 돌려주는 역할
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

//	3. setter 메소드 : 매개변수로 전달된 값을 필드값으로 수정해주는 역할
	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
public class MainEx {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member2 m = new Member2();
		// 필드의 접근 제어자가 private 접근제어자로 되어 있기 외부클래스에서
		// 직접 접근할 수 없다.
//		m.age = 25;     오류발생

		Member2 m1 = 
		 new Member2(25,"홍길동","test@naver.com","서울시 강남구");
//		System.out.println(m1.age);   오류발생
		
		// 필드값을 출력
		m1.print();
		
		// name을 안화수로 수정하는 역할
		m1.setName("안화수");
		
		// 필드값을 출력
		m1.print();
		
		String email = m1.getEmail();
		System.out.println("돌려받은 email="+ email);
	}

}




