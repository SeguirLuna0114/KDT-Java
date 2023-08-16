package Method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 자연수 M과 N이 주어질 때, M이상 N이하 자연수 중 
// 소수인 것을 모두 골라 이를 소수의 합과 최솟값을 찾는 프로그램을 작성
public class PrimeNumber_Sum_Min {

	// 소수판별법3. 에라토스테네스의 체: 0~Max까지의 소수를 찾는 함수
	// : 여러개의 소수를 구하고 싶을 때 체를 거르듯이 하는 방법 사용
	// : 2를 제외한 2의 배수 거르고, 3을 제외한 3의배수를 거르고, (4는 2의배수에서 걸러졌기에 Pass), 5를 제외한 5의배수를 모두 거르고....반복
	// 구하려는 범위의 최댓값의 제곱근까지만 반복하면 됨
	static boolean[] get_PrimeArr(int Max) {
		
		// 배열 생성
		// // 0부터 시작하기에, Max+1까지(M <= N이기에 Max로 입력받은 N할당) 
		boolean[] Prime = new boolean[Max+1];
		
		// 0과 1은 소수가 아니기에 true
		Prime[0] = true;
		Prime[1] = true;
		
		// 인덱스가 소수인 경우에는 false로, 소수가 아닌 경우에는 true로 초기화되게 설정
		for(int i = 2; i <= Math.sqrt(Prime.length); i++) {
			// 이미 걸러진 배열의 경우(소수가 아님) 다음 반복문으로 건너뜀
			if(Prime[i] == true) {
				continue;
			}
			// if문으로 걸러지지 않은 경우, Prime[i]=false라면 이 숫자는 소수
			// 정석대로는 j = i * 2부터 시작이지만,
			// 이미 2의 배수가 걸러졌기 때문에 i의 제곱수부터 시작해도 됨
			for(int j = i*i; j < Prime.length; j+=i) {	// j+=i  = j=j+i
				// i의 제곱수 ~ i의 배수들을 모두 소수가 아닌것으로 표시
				Prime[j] = true;
			}
		}
		// 배열 index가 소수라면 false로, 아니면 true로 완성된 배열 Prime을 반환
		return Prime;		
	}
			
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("M이상 N이하 자연수 중 소수의 합과 최솟값을 찾는 프로그램");
		System.out.println("자연수 M과 N을 입력하세요.(1000이하의 자연수, M <= N)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// get_PrimeArr()메소드 호출하여 boolean[] Prime 얻음
		// 생성된 배열은 index가 소수라면 false로, 아니면 true로 완성됨
		boolean[] Prime = get_PrimeArr(N);
		
		// Prime배열 출력
		for(int i=M; i <= N; i++) {
			if(!Prime[i]) {
				sb.append(i).append('\t');
			}
		}
		System.out.println(sb);
		
		// 소수 합 및 최소값
		int sum = 0;
		int min = Integer.MAX_VALUE;	// 최솟값을 임의대로 정수 최대값으로 설정함
		
		for (int i=M; i <=N; i++) {
			if(Prime[i] == false) {	// false = 소수
				// 소수이면 합하고
				sum += i;
				// 첫번째 소수를 최소값으로 설정
				if(min == Integer.MAX_VALUE) {
					min = i;
				}
			}
		}
		
		// 소수가 없다면 -1을 출력
		if(sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println("소수의 합계: "+sum);
			System.out.println(M+"과 "+N+"사이 소수의 최소값: "+min);
		}

	}

}
