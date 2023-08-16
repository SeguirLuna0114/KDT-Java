package p2023_08_01;

// DAO(Data Access Object) 클래스
// " 데이터베이스의 CRUD작업을 수행하기 위해 사용 "
// - 데이터베이스와 상호작용을 담당하는 클래스
// - 애플리케이션과 데이터베이스 사이에서 데이터를 접근, 조작, 저장, 삭제하는 작업 수행

import java.util.ArrayList;
import java.util.Scanner;

// BoardSVC클래스는 DAO(Data Access Object)역할을 하는 클래스
// 게시판(Board)에 관련된 데이터 접근 기능을 구현
// 게시물을 작성, 조회, 삭제하는 기능 제공

// ArrayList를 이용하여 게시물을 저장하고, 사용자의 입력을 받아 게시물을 등록/삭제하는 기능 제공
// (게시판의 기본적인 기능 구현하는 클래스)
public class ArrayList_BoardSVC_DAO_CRUD {

	// 멤버변수
	// ArrayList객체를 참조하기 위한 boardList변수를 선언
	ArrayList<ArrayList_BoardVO_VO_DTO> boardList;	// 게시판에 작성된 게시물을 관리하는 기능

	// 생성자
	public ArrayList_BoardSVC_DAO_CRUD() {
		// new연산자로 ArrayList 객체를 생성하고, 객체의 참조를 boardList변수에 할당
		boardList = new ArrayList<ArrayList_BoardVO_VO_DTO>();
	}

	// 글 입력 처리 메소드
	// -사용자로부터 게시물 정보(작성자, 이메일, 비밀번호, 제목, 내용)을 입력받아 BoardVO객체 생성
	// -addArticle()메소드를 호출하여 게시물을 등록
	public void writeArticle(Scanner sc) {
		System.out.println("게시판에 글을 작성 하세요?");
		System.out.print("작성자:");
		String register = sc.next();

		System.out.print("이메일:");
		String email = sc.next();

		System.out.print("비밀번호:");
		String passwd = sc.next();

		System.out.print("제목:");
		String subject = sc.next();

		System.out.print("글내용:");
		String content = sc.next();

		// BoardVO클래스의 객체를 생성하고, 생성자를 호출해서 객체를 초기화
		// - 사용자가 입력한 정보를 생성자의 매개변수로 전달하여 객체를 초기화(초기값 할당)
		ArrayList_BoardVO_VO_DTO boardVO = new ArrayList_BoardVO_VO_DTO(register, subject, email, content, passwd);
		// -생성된 BoardVO객체는 boardVO변수에 저장됨
		// -boardVO변수는 생성된 BoardVO객체를 참조해, 이후 해당 객체에 접근하여 사용 가능
		
		// addArticle()메소드를 호출하여 BoardVO객체를 boardList에 추가
		addArticle(boardVO);
	}

	// 글 작성 -BoardVO객체를 boardList에 추가하는 기능 수행
	// 	(즉, 새로 작성된 게시물을 게시판에 등록)
	private void addArticle(ArrayList_BoardVO_VO_DTO boardVO) {
		boardList.add(boardVO);
	}

	// 메소드의 매개변수로 Scanner객체를 인자로 받는 이유
	// 1. 메소드 외부에서 스캐너 객체를 생성하고, 사용자 입력을 처리해 메소드로 전달하기 때문
	//		(메소드의 인자로 객체를 전달해 메소드 내에서 사용자의 입력 처리하게 함)
	// 2. 스캐너 객체를 메소드 인자로 전달하여 모든 메소드가 같은 스캐너 객체를 사용하도록 함
	//		(여러 메소드 간에 스캐너 객체를 공유하여 입력 처리가 일관됨)
	
	// 글목록 출력 -boardList에 저장된 모든 게시물 정보를 출력
	// -단, 등록된 게시물이 없는경우 메시지 출력
	public void listArticles(Scanner sc) {
		// Scanner클래스의 객체를 인자로 받아, 사용자의 입력을 받을 수 있도록 설계
		// (BoardSVC 클래스 다른 메소드에서 사용할 가능성 존재)
		// ArrayList.size()메소드 - 리스트의 요소 개수를 반환
		if (boardList.size() > 0) {	// 리스트에 저장된 게시물이 하나 이상인 경우
			// for루프를 이용해 리스트에 저장된 모든 게시물 순회
			for (int i = 0; i < boardList.size(); i++) {
				// 인덱스에 해당하는 게시물을 가져오고, 해당 게시물을 문자열로 변환
				// BoardVO클래스에서 toString()메소드를 오버라이드해서 원하는 형식으로 반환되게 재정의함
				System.out.println(boardList.get(i).toString());
			}
		} 
		// 리스트에 저장된 게시물이 없는 경우(글이 하나도 등록되지 않은 경우)
		else {
			System.out.println("등록된 글이 없습니다.");
		}
	}

	// 삭제할 글의 작성자 및 비밀번호 입력하는 메소드
	// -삭제할 게시물의 작성자와 비밀번호를 사용자로부터 입력받아
	// -removeArticle()메소드를 호출하여 삭제기능 수행
	public void removeArticle(Scanner sc) {
		// Scanner클래스의 객체를 인자로 받아, 사용자의 입력을 받을 수 있도록 설계
		System.out.println("저장할 글의 작성자와 비밀번호를 입력 하세요?");
		System.out.print("작성자:");
		// Scanner.next()메소드를 사용하여 공백을 포함하지 않는 문자열 입력받음
		//	(공백을 구분자로 문자열을 하나씩 입력)
		String register = sc.next();

		System.out.print("비밀번호:");
		String passwd = sc.next();
		// Scanner.next()메소드를 사용하여 공백을 포함하지 않는 문자열 입력받음
		//	(공백을 구분자로 문자열을 하나씩 입력)

		// 입력받은 작성자와 비밀번호를 removeArticle()메소드로 전달하여 실제 게시물 삭제
		removeArticle(register, passwd);
	}

	// 글 삭제
	// -BoardList에서 주어진 작성자와 비밀번호에 해당하는 게시물을 찾아 삭제하는 기능 수행
	// -만일 주어진 작성자와 비밀번호에 해당하는 게시물 업는 경우, 메시지 출력
	public void removeArticle(String register, String passwd) {
		// Scanner객체를 사용하지 않고, 이미 입력받은 작성자명과 비밀번호를 인자로 받아 사용
		
		// 삭제할 글이 있으면(리스트에 저장된 게시물이 하나 이상 존재하는 경우)
		if (boardList.size() > 0) {
			// 삭제할 게시물의 인덱스를 저장하는 변수 index 초기화
			// 삭제할 게시물을 찾지 못하면 index는 -1로 유지
			int index = -1;
			// 직접 입력한 작성자 명과 비번을 메모리상에 저장된 값과 비교
			for (int i = 0; i < boardList.size(); i++) {
				// boardList.get(i): 리스트에서 인덱스 i에 해당하는 게시물의 
				// .getRegister(): 작성자명을 가져와서,
				// .equals(register): 입력받은register와 "문자열"비교
				if (boardList.get(i).getRegister().equals(register)) {
					// boardList.get(i).getPasswd(): 리스트에서 인덱스 i에 해당하는 게시물의 비밀번호를 가져와서
					// .equals(passwd): 입력받은 비밀번호와 일치하는지 "문자열"비교
					if (boardList.get(i).getPasswd().equals(passwd)) {
						// 작성자명과 비밀번호가 일치한다면, 리스트에서 i번째에 해당하는 게시물을 삭제
						boardList.remove(boardList.get(i));
						// 삭제한 게시물의 인덱스를 index변수에 저장(인덱스 업데이트)
						index = i;
					}
				} 
			}
			// 작성자 명과 비번이 일치하지 않아, 삭제할 게시물을 찾지 못한 경우(index가 그대로 -1인 경우)
			if (index == -1) {
				System.out.println("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.");
				// return: 메소드 실행을 즉시종료. 메소드를 호출한 곳으로 돌아감 -> 해당 메소드 이후의 부분 실행
				//			(이후의 코드는 실행되지X)
				// 만일, break문을 작성할 경우, "반복문"만 종료되고, 그 아래의 else문을 실행할것
				return;
			}
		} else {	// 삭제할 게시물을 찾고(index가 -1이 아닌경우) 이미 삭제 끝난 후에는
			// 삭제할 글이 존재하지 않는 경우, 종료
			System.out.println("작성된 글이 존재하지 않습니다.");
		}
	}
}
