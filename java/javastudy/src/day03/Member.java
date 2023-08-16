package day03;

public class Member {
	
	private int age;			// 필드, 멤버변수
	String name;
	String email;
	String address;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = new int[3];
		
		String s = new String("자바");
		
		Member m = new Member();
		m.age = 25;
		m.name = "홍길동";
		m.email="test@naver.com";
		m.address="서울시 강남구";
		
		System.out.println("age="+ m.age);
		System.out.println("name="+ m.name);
		System.out.println("email="+ m.email);
		System.out.println("address="+ m.address);
		
		
		
	}

}
