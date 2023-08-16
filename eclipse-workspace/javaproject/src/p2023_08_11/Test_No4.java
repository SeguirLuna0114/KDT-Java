package p2023_08_11;

// 1부터 100까지 정수 중에서 5의 배수 합과 7의 배수의 합을 구하는 프로그램
public class Test_No4 {

	static void SumOfNum(int N) {
		
		int sum = 0;

		for (int i = 1; i < 101; i++) {
			if (i % N == 0) {
				sum += i;
			}
		}
		System.out.println(N+"의 배수의 합: "+sum);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 5의배수의 합 출력
		SumOfNum(5);

		// 7의 배수의 합 출력
		SumOfNum(7);
	}

}
