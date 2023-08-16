package day01;

public class Member {

	//1.멤버변수(필드)는 method 바깥쪽에 정의된 변수
	//2.필드는 Member클래스로 객체를 생성할때 heap메모리 상에 필드가 저장되기
	//   위한 기억공간을 할당 받게되고, 기본 자료형들은 자동으로 초기화가 된다.
	//   int형은 0, double형은 0.0, boolean형은 false값으로 초기화 된다.
	int age;     		// 멤버변수, field
	             		// : method 바깥쪽에 정의된 변수
	double left;
	boolean b;
	
	//1.생성자는 클래스명 같은 이름으로 만들어야 한다.
	//2.생성자는 클래스로 객체를 생성할때 호출된다. 
	public Member() {	// 생성자
		System.out.println("생성자 호출 성공");
		System.out.println("age="+ age);		// 0
		System.out.println("left="+ left);      // 0.0
		System.out.println("b="+ b);   			// false
	}
	
	//1.필드값을 출력하는 역할
	public void print() {
		System.out.println(age);
		System.out.println(left);
		System.out.println(b);
	}
	
	//2.필드값을 수정
	public void setAge(int age) {
		this.age = age;		// age = 10
	}
	
	//3.필드값을 돌려주는 역할
	public int getAge() {
		return age;
	}	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = new String("자바");
// new연산자 : heap메모리상에 '자바' 객체를 생성하기 위한 기억공간을 생성해주는 역할		
		
		Member  m1        = new    Member();
//      클래스	레퍼런스 변수   연산자   생성자 호출	 		
// new연산자 : heap메모리상에 age필드를 저장하기 위한 기억공간을 생성해주는 역할		
		
		m1.print();		
		m1.setAge(10);
		int result  = m1.getAge();
		System.out.println("돌려 받은값1:"+ result);
		System.out.println("돌려 받은값2:"+ m1.getAge());
		
		
	}

}
