package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 링의 반지름이 주어진다. 
 * 이때, 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 돌아가는지 구하는 프로그램
 *
 * 각각의 링이 앞에 있는 링과 뒤에 있는 링과 접하도록 바닥에 내려 놓았다.
 * 첫 번째 링을 돌리면, 나머지 링도 같이 돌아간다
 * 
 * 첫 번째 링을 제외한 각각의 링에 대해서,
 * 첫 번째 링을 한 바퀴 돌리면 그 링은 몇 바퀴 도는지 기약 분수 형태 A/B로 출력
 */
public class Ring_GCD {
	
	// 최대공약수 구하는 메소드
	static int checkGCD(int a, int b) {
		
		while(b != 0) {
			// 나머지를 구해줌
			int r = a % b;	// (단, a >= b)
			
			// GCD(a,b) = GCD(b,r)이기에 변환
			a = b;
			b = r;
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("링의 개수 N을 입력하고(3 ≤ N ≤ 100)\n"
				+ "다음 줄에는 링의 반지름을 바닥에 놓은 순서대로 입력하세요.(단, 반지름은 1과 1000를 포함하는 사이의 자연수)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		// 입력된 링의 반지름
		String[] radiusR = br.readLine().split(" ");
		
		int firstRing = Integer.parseInt(radiusR[0]);
		for (int i=1; i<N; i++) {
			int otherRing = Integer.parseInt(radiusR[i]);
			
			// 기약분수로 만들기 위한 최대공약수 찾기
			int gcd = checkGCD(firstRing, otherRing);
			
			// 분모와 분자를 최대공약수로 나눠주기
			sb.append(firstRing / gcd).append('/').append(otherRing / gcd).append('\n');
		}
		System.out.println(sb);
	}
}
