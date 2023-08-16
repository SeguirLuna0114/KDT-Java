package p2023_07_27;

// 1. 부모클래스에 있는 필드를 자식 클래스에서 재정의(동일한 이름의 변수)하면,
//		자식 클래스에서 재정의한 필드만 사용 가능
// 2. 부모클래스의 필드는 더 이상 사용될 수 없기 때문에
//		은닉변수, 쉐도우변수라고 부름

//1. 부모클래스
class Point2D_03 {
	
	// protected로 선언되어, 자식 클래스에서도 접근 가능(자식클래스에 상속됨O)
	// 단, Point3D_03에서 다시 한번 정의되었기에 은닉변수가 됨
	protected int x = 10; // Point3D에서 다시 한번 정의되므로 은닉 변수가 됨
	protected int y = 20; // 은닉 변수는 쉐도우 변수라고도 함
}

//2. 자식 클래스
class Point3D_03 extends Point2D_03 {
	
	// protected로 선언되어, 자식 클래스에서도 접근 가능(자식클래스에 상속됨O)
	protected int x = 40; // 슈퍼 클래스에 존재하는 멤버변수를
	protected int y = 50; // 서브 클래스에 다시 한 번 정의함

	protected int z = 30;

	public void print() {
		
		System.out.println(x + ", " + y + ", " + z); // x와 y는 재 정의된 Point3D 클래스 소속
	}
}

//3. 메인클래스
class SuperTest03_FieldOverriding_ShadowVar {
	
	public static void main(String[] args) {
		
		// Point3D_03클래스(자식클래스)의 객체를 생성
		Point3D_03 pt = new Point3D_03();
		
		// 객체를 통해 메소드 호출
		pt.print();
	}
}