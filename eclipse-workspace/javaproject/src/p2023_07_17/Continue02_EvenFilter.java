package p2023_07_17;

// continue문
// 1.반복문 안에서 사용되며, 다시 반복문으로 돌아가라는 의미를 가짐
// 2. continue문이 실행되면, continue문 아래쪽의 내용들은 실행X
// 	 	=> 다시 반복문으로 돌아가게 됨
public class Continue02_EvenFilter {

	// continue문을 이용해서 1~100까지 정수 중 짝수만 출력하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 짝수 출력 프로그램
		for (int i=1; i<=100; i++) {
			if (i%2==1) {	// i가 홀수인 경우 continue문 실행
				continue;	// 홀수인 경우 아래의 구문 실행X->돌아감
			}
			System.out.println("1~100까지 정수 중 짝수: "+i);
		}
		
		// 짝수의 합 출력
		int sum=0;
		for (int i=1; i<=100; i++) {
			if (i%2==1) continue;
			sum += i;
		}
		System.out.println("1~100까지 정수 중 짝수의 합: "+sum);
		
		
	}

}
