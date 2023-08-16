package p2023_07_17;

// 무한루프 : for문
// 조건식이 항상 참인경우로 평가되어 반복이 끝나지 않는 반복문

// break: 반복문을 빠져 나오는 역할
//	for (;;) {
//	 // 무한 루프의 반복 내용
//	}
public class Break01_For_infiniteLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 무한루프 - for문
//		for(;;) {	// 세미콜론(;)사이에 조건식이 비어있어 항상 참으로 평가됨 => 무한히 반복
		
		// '무한출력'을 100번 출력
		// for문(초기화식; 조건식; 증감식)
		for (int i=1;; i++) {
			System.out.println(i+". 무한출력");
			if (i==100) break;	// 100번째인 경우 무한루프 종료
		}
		
		
	}

}
