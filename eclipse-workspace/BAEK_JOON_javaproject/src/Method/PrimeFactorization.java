package Method;

// 정수N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력(N이 1인경우X)

// 소인수분해(Prime factorization) = 어떤 정수N을 소수들의 곱으로 나타냄
// N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력(단, N이 1인 경우 아무것도 출력하지 않음)

// 정수 N(1 <= N <= 10,000,000)이 주어진다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeFactorization {

	public static void main(String[] args) throws IOException {

		System.out.println("정수 N을 입력하세요.(1 <= N <= 10,000,000)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		// 임의의 정수 N에 대하여 곱셈으로 분해하면
		// 제곱근을 기준으로 대칭이 됨
		// ex. 9 => 1*9 3*3 9*1
		// 즉, i * i 가 N이하일 때 까지만 탐색해도 됨
		for (int i = 2; i * i <= N; i++) {
			while (N%i == 0) {
				sb.append(i).append('\n');
				N /= i;
			}
		}

		// 대신 제곱근까지만 탐색하면, 나머지가 발생할 수 있음
		// 이 나머지는 1 또는 소수이고, 반드시 1개임이 보장됨
		// ex. 6의 경우, 2는 저장되지만 3은 저장되지 않음 => 1이 아닐 경우에는 한번 더 추가해줘야 함
		// 해당 소수는 N의 제곱근보다 크다는 의미. 그 소수로 나눠진 수는 N의 제곱근보다 항상 작기에
		// 작은 수 들은 for문에서 걸러지고, 나머지는 유일한 소수가 됨
		if(N != 1) {
			sb.append(N);
		}

		System.out.println(sb);
	}
}





