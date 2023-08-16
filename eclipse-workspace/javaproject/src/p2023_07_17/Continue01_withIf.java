package p2023_07_17;

// continue문
// 1.반복문 안에서 사용되며, 다시 반복문으로 돌아가라는 의미를 가짐
// 2. continue문이 실행되면, continue문 아래쪽의 내용들은 실행X
//	 	=> 다시 반복문으로 돌아가게 됨
public class Continue01_withIf {

	// continue구문은 "조건문"과 함께 사용됨
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i=1; i<=10; i++) {
			// continue문을 만나면 반복문으로 돌아감
			if (i==5) {
				continue;	// i=5인 경우에는 continue아래쪽의 문장 실행X
			}				
			// i=5인 경우를 제외하고 실행
			System.out.println("출력: "+i);	//i=5인 경우에는 실행X
		}
		
	}

}
