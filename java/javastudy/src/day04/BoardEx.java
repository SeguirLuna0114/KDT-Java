package day04;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//DTO(Data Transfer Object)
class Board{
	// 필드 : Board 클래스로 객체를 생성할때 heap메모리상에 공간을 할당 받아서
	//       값을 저장하는 역할
	private String writer;
	private String subject;
	private String content;
	private Timestamp register;
	
	// 생성자
	// 1.생성자는 클래스명과 동일한 이름을 가지고 있다.
	// 2.생성자는 객체를 생성할때 호출되며, 매개변수를 통해서 전달된 값을 
	//   필드의 값으로 초기화 시켜주는 역할
	public Board(String writer, String subject, String content, Timestamp register) {
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.register = register;
	}

	//1.필드값을 출력하는 역할
	public void print() {
		System.out.println(writer);
		System.out.println(subject);
		System.out.println(content);
		System.out.println(register);
	}
	
	//2.getter 메소드 : 메소드를 호출할 곳에 return구문으로 값을 돌려주는 역할
	public String getWriter() {
		return writer;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getRegister() {
		return register;
	}

	//3.setter 메소드 : 매개변수로 전달된 값을 필드의 값으로 수정,변경하는 역할
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setRegister(Timestamp register) {
		this.register = register;
	}
	
}

public class BoardEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("작성자명 입력?");
		String writer = sc.nextLine();
		System.out.println("제목 입력?");
		String subject = sc.nextLine();
		System.out.println("내용 입력?");
		String content = sc.nextLine();
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		// Board 클래스로 객체 생성
		Board  board = new Board(writer, subject, content, ts);
//		board.writer = "홍길동";
		
		board.print();
		
		SimpleDateFormat sf = 
		 new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE요일");
		
		System.out.println("작성자명:"+ board.getWriter());
		System.out.println("제목:"+ board.getSubject());
		System.out.println("내용:"+ board.getContent());
		System.out.println("날짜1:"+ board.getRegister());
		
		Timestamp tP = board.getRegister();
		System.out.println("날짜2:"+ sf.format(tP));
		
		
		
		
	}

}
