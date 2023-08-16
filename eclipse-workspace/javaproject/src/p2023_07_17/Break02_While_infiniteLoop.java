package p2023_07_17;

// 무한루프: while문
//조건식이 항상 참인경우로 평가되어 반복이 끝나지 않는 반복문

// break: 반복문을 빠져 나오는 역할

public class Break02_While_infiniteLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// '무한출력'을 100번 출력하는 무한루프
		int i=1; 	//변수 초기값
		while(true) {
			System.out.println(i+". 무한출력");
			if (i==100) break;	// 100번째인 경우 무한루프 종료
			i++;				// 증감식
		}
		
		
	}

}
