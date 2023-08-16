package c;

// 서로 다른 패키지 안에 들어있는 클래스 - import 필요
// 1)  다른 패키지 안에 들어 있는 클래스에 접근 하기 위해서는 
//     해당 클래스의 멤버(필드, 메소드)의 접근 제어자가 public 접근 제어자로 되어야 한다.
// 2)  다른 패키지 안에 들어 있는 클래스에 접근 하기 위해서는 해당 클래스를      
//	   import 를 해야된다.
//		(import를 해서 해당 클래스를 명시적으로 가져와야 함)
import a.b.Called;

public class Calling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// import하려는 클래스의 멤버(필드, 메소드)가 public으로 되어야 함
		Called c = new Called();
		
		c.check();
		
	}

}
