package p2023_08_01;

import java.util.Scanner;

// 게시판 기능을 실행하는 메인클래스
// - 사용자가 입력한 메뉴에 따라 게시판 기능을 실행하게 함
public class ArrayList_BoardMain_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean isStop = false;
		
		// 사용자의 입력을 받기위해 Scanner객체 생성
		Scanner sc = new Scanner(System.in);
		
		// BoardSVC클래스의 객체 생성
		// -BoardSVC는 게시판(Board)에 관련된 기능을 구현한 클래스
		// 	게시물 등록, 목록조회, 게시물삭제의 기능 존재
		ArrayList_BoardSVC_DAO_CRUD boardSVC = new ArrayList_BoardSVC_DAO_CRUD();

		// do-while 루프(사용자가 종료메뉴 선택할때까지 루프 실행)
		do {
			// 메뉴 출력 및 선택(사용자에게 메뉴를 출력하고, 입력에따라 해당 기능 수행)
			System.out.println("메뉴를 입력 하세요?");
			System.out.println("1.게시판 글쓰기");
			System.out.println("2.글 목록 보기");
			System.out.println("3.글 삭제");
			System.out.println("4.종료");

			// 사용자의 입력을 문자로 받아(공백 구분자) menu변수에 할당
			String menu = sc.next();

			switch (menu) {
			case "1":
				// boardSVC.writeArticle()메소드를 호출 => 게시물 작성
				boardSVC.writeArticle(sc);
				break;
				
			case "2":
				// boardSVC.listArticles()메소드 호출해서 게시물 목록 조회하는 기능 실행
				// 이때 저장된 게시물을 모두 출력
				boardSVC.listArticles(sc);
				break;
				
			case "3":
				// boardSVC.removeArticle()메소드를 호출해서 게시물을 삭제
				// 삭제할 게시물의 번호를 사용자로부터 입력받아 해당 게시물 삭제
				boardSVC.removeArticle(sc);
				break;
				
			case "4":
				// isStop = true를 통해 루프를 종료
				isStop = true;
			}

		} while (!isStop);
	}

}
