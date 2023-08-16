package p2023_08_11;

// 8의 약수를 구하는 프로그램
public class Test_No3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N = 8;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(N).append("의 약수: ");
		for (int i=1; i<=N; i++) {
			// 8이 i로 나누어 떨어지는 경우
			if(N % i == 0) {
				sb.append(i).append(' ');
			}
		}
		System.out.println(sb);
	}
}
