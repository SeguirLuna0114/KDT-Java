package sample04;

public class MessageBeanImpl implements MessageBean {
	// 필드
	private String name;
	private String greet;

	// 생성자(생성자 주입을 통해 외부에서 인스턴스의 상태를 설정)
	public MessageBeanImpl(String name, String greet) {
		this.name = name;		// 도깨비
		this.greet = greet;		// 안뇽
	}

	public void sayHello() {
		System.out.println(name + " ! " + greet);
	}
}