package p2023_07_14;

// for문
//	for(초기값; 조건식; 증감식){
//	    반복 실행할 문장;
//	}
public class For01_messagePr {

	// 사랑해요 메시지를 10번 출력하세요
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// with 증감연산자 i++
		for (int i=1; i<=10; i++) {
			System.out.println(i+".\t사랑해요.");
		}
		System.out.println("종료");
		System.out.println();

		//실행될 문장이 1줄인 경우에는 중괄호{}를 생략 가능
		for (int i=1; i<=10; i++) 
			System.out.println(i+". 사랑해요.");
		System.out.println("종료");
		
	}

}
