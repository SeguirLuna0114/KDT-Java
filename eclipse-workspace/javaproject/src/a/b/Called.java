package a.b;

//서로 다른 패키지 안에 들어있는 클래스 - import 필요
//- import하려는 클래스의 멤버(필드, 메소드)가 public으로 되어야 함
public class Called {
	
	// check()메소드
	public void check(){
		System.out.println("메소드 호출 성공");
	}

}
