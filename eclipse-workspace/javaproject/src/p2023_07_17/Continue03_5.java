package p2023_07_17;

// continue문
// 1.반복문 안에서 사용되며, 다시 반복문으로 돌아가라는 의미를 가짐
// 2. continue문이 실행되면, continue문 아래쪽의 내용들은 실행X
//	 	=> 다시 반복문으로 돌아가게 됨
public class Continue03_5 {

	// continue문을 이용해서 1~100까지 정수 중 5의 배수만 출력하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 5의배수가 아닌경우 continue구문 실행
		int count=0;
		for (int i=1; i<=100; i++) {
			if (i%5!=0) {
				continue;
			}
			count++;
			System.out.println("1~100까지 정수 중 5의배수: "+i);
		}
		System.out.println("1~100까지 정수 중 5의배수 개수: "+count);
		
		//5의 배수의 합을 구하는 구문
		int sum=0;
		for (int i=1; i<=100; i++) {
			if (i%5!=0) {
				continue;
			}
			sum += i;
		}
		System.out.println("1~100까지 정수 중 5의 배수의 합: "+sum); 
		
	}

}
