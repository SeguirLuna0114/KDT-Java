package p2023_08_01;

import java.util.List;
import java.util.Vector;

// Board클래스를 정의하고, Vector자료구조를 이용해 Board객체를 저장하고 관리

// p561 ~ 562
// 제네릭(Generic): 자료구조에 특정 자료형의 데이터만 저장할 수 있도록 만들어주는 역할
// 제네릭을 사용하면, 부모클래스인 Object형을 자식클래스인 Board클래스형으로
// 자료형 변환시, 제네릭으로 설정된 (Board)자료형 생략 가능
class Board {
	
	// 필드(멤버변수)
	// 접근제어자가 private으로 되어있는 경우에는, 반드시 생성자가 필요
	String subject;
	String content;
	String writer;
	
	// 생성자
	public Board(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
}

public class Vector_Generic_newObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Vector 클래스를 이용하여 Board 객체들을 저장할 리스트를 생성
		// 제네릭을 사용하여 Board클래스 타입으로 구체화됨
		// Vector 자료구조에는 Board클래스의 객체만 저장 가능 => Board클래스 객체만 추가 가능
		List<Board> list = new Vector<Board>();
		// 업캐스팅: Vector 클래스가 List 인터페이스를 구현한 구현체이기 때문에, 
		//		   Vector 객체를 List 인터페이스로 참조하는 것은 업캐스팅
		
		// Vector<Board>리스트에 String과 Integer타입의객체 추가하려 하면 오류
//		list.add("자바");
//		list.add(50);
		
		// Board클래스로 만든 객체만 저장 가능
//		boolean add(Object e)
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));

		list.remove(2);		// 인덱스 2번 원소(객체)를 삭제
		list.remove(3);		// 인덱스 3번 원소(객체)를 삭제
		
		// for루프를 사용하여 list의 모든 Board객체를 출력하기 위해 list에서 Board객체를 가져옴
		for (int i=0; i<list.size(); i++) {
			// 제네릭을 사용하면, 부모클래스인 Object형을 자식클래스인 Board클래스형으로
			// 자료형 변환시, 제네릭으로 설정된 (Board)자료형 생략 가능
			// 다운캐스팅
			Board board = list.get(i);
//			Board board = (Board)list.get(i);		// (Board)자료형 생략 가능
			
			System.out.print(board.subject+"\t"+
								board.content+"\t"+
								board.writer+"\t");
			System.out.println();
		}
	}
}
