package p2023_07_17;

public class MethodEx02_sum {

	// 1~n까지의 합을 구하는 정적메소드 - sum()메소드
	static void sum(int n) {
		int accum=0;	// 초기값 설정
		for (int i=1; i<=n; i++) {
			accum += i;		// accum = accum + i
		}
		System.out.println("1~"+n+"="+accum);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// sum메소드를 호출
		sum(3);			// int n=3
		sum(5);
		sum(10);
		sum(30);
		sum(100);
		sum(1000);
		sum(10000);
		
	}

}
