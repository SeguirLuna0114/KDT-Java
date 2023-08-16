package p2023_08_01;
// VO(Value Object) 클래스
// " 데이터의 저장 및 전달을 위해 사용(데이터의 여러 속성을 나타내는데 사용)"
// - 값 객체는 주로 속성들의 집합으로 구성. 단순히 데이터를 보유하고 기능을 제공하지 않는 객체
// - 데이터를 보유하고 특정조건을 만족하는지 확인하기 위해 사용됨

// DTO(Data Transfer Object) 클래스
// "데이터 전송을 위해 순수한 데이터만을 담고, 비즈니스 로직은 포함X(불변성 강제X)"
// - DTO는 데이터 전송 객체(Data Transfer Object)를 의미
// - 주로 데이터의 전송을 목적으로 사용. 계층간 데이터 교환에 사용
//	(여러 데이터를 묶어서 한번에 전달 or 여러 속성을 담은 객체 전달)
//- Getter 및 Setter메소드 : 주로 데이터 전송을 위해 사용되기에,
//			 필드 접근을 위한 Getter 및 Setter메소드를 가짐

// VO클래스인 BoardVO를 구현한 프로그램
// -단, BoardVO클래스는 setter메소드 존재해 불변성X
//		즉, 전통적인 VO클래스보다 DTO클래스에 더 가까움

// 게시판(Board)의 정보를 저장하는데 사용
// -BoardVO는 데이터 저장과 접근을 위한 멤버변수와 Getter/Setter 메소드를 포함

// BoardVO클래스는 게시판과 관련된 데이터를 담는 VO(Value Object)로 활용
// 게시물 등록, 조회, 수정, 삭제 등의 기능이 가능
// 데이터베이스와의 상호작용이 필요한 경우, 이를 DTO 등 다른 객체와 함께 사용하여 데이터 전송/처리 가능

// BoardVO클래스는 Object클래스를 상속받음
// 단, 자바에서 모든 클래스는 암묵적으로 Object클래스를 상속받기에, 'extends Object'를 생략해도 됨
public class ArrayList_BoardVO_VO_DTO extends Object {

	// 멤버변수
	private String register;	// 게시물 작성자 이름을 저장하는 문자열변수
	private String subject;		// 게시물 제목을 저장하는 문자열변수
	private String email;		// 게시물 작성자의 이메일을 저장하는 문자열변수
	private String content;		// 게시물 내용을 저장하는 문자열 변수
	private String passwd;		// 게시물 접근을 위한 비밀번호를 저장하는 문자열변수

	// 생성자 - 멤버변수(필드)의 값을 초기화(초기값 설정)
	// BoardVO클래스에는 매개변수를 받는 생성자가 하나 존재
	public ArrayList_BoardVO_VO_DTO(String register, String subject, String email, String content, String passwd) {
		super();
		this.register = register;
		this.subject = subject;
		this.email = email;
		this.content = content;
		this.passwd = passwd;
	}

	// Getter(멤버변수의 값을 반환) & Setter메소드(멤버변수의 값 설정)
	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	// toString()메소드 재정의 - 객체의 정보를 문자열로 표현
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// 게시물 작성자, 이메일, 제목, 내용을 문자열로 반환하는 구현
		return "작성자:" + register + ",이메일:" + email + ",제목:" + subject + ",글내용:" + content;
	}

}
