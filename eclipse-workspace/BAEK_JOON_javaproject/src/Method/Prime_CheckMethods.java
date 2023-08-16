package Method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수찾기- 주어진 수 N개 중에서 소수가 몇개인지 찾아서 출력하는 프로그램
// 첫줄에 주어진 수의 개수N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데, 1000이하의 자연수이다.

// 1은 소수가 아님 => 예외처리

class Prime_CheckMethods {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 소수 판별법1. 1과 자신만을 약수로 갖기에, 2부터 판별하려는 수 직전까지 하나씩 나눠보면서 나누어 떨어지는 수가 없다면 소수
	// 2~(N-1)까지의 값을 N에 나눠서 나머지가 있는지 검사
	static boolean checkPrime1_def(int Number) {
		
		// 1은 소수가 아니다.
		if(Number == 1) {
			return false;
		}
		
		// 2~Number-1까지 중에 나누어 떨어지는 약수가 있는지 판별
		// Number=2인 경우에는 자연스럽게 for문을 검사하지 않아도 됨
		for(int i=2; i<Number; i++) {
			if(Number % i == 0) {
				// 나누어 떨어지는 약수가 존재하면 소수X
				return false;
			}
		}
		// 어떤 약수도 발견되지 않으면, 해당 수는 소수임
		return true;
	}


	// 소수판별법2. 제곱근 이용: 소수를 판별할 때는 Number의 제곱근까지만 검사하면 됨
	// 어떤 수 N이 소수가 아니라면, N은 a와 b라는 두 정수의 곱으로 나타낼 수 있고, a또는 b는 제곱근보다 작거나 같은 정수
	// Number을 A*B의 합성수(Number = A*B)라고 볼때, 1 <= A, B < Number)
	// 만약 A, B > sqrt(Number)처럼 Number의 제곱근보다 커지면 모순(A*B > Number)
	// 따라서, 소수가 아닌 합성수(Number = A * B)에서 A와 B중 적어도 하나는 Number의 제곱근보다 작거나 같음
	// ex. 12(1, 2, 3, 4, 6, 12) => 12의 제곱근(3.46)이기에, 1~3까지 나누어 떨어지는 수는 12, 6, 4에 대응
	static boolean checkPrime2_sqrt(int Number) {
		
		// 1은 소수가아니다
		if(Number == 1) {
			return false;
		}
		
		// 2~Number의 제곱근까지 중에 나누어 떨어지는 약수가 있는지 판별
		// Number=2인 경우에는 자연스럽게 for문을 검사하지 않아도 됨
		for(int i=2; i <= Math.sqrt(Number); i++) {
			if(Number % i == 0) {
				// 나누어 떨어지는 약수가 존재하면 소수X
				return false;
			}
		}
		// 어떤 약수도 발견되지 않으면, 해당 수는 소수임
		return true;
	}

	
	// 소수판별법3. 에라토스테네스의 체: 0~Max까지의 소수를 찾는 함수
	// : 여러개의 소수를 구하고 싶을 때 체를 거르듯이 하는 방법 사용
	// : 2를 제외한 2의 배수 거르고, 3을 제외한 3의배수를 거르고, (4는 2의배수에서 걸러졌기에 Pass), 5를 제외한 5의배수를 모두 거르고....반복
	// 구하려는 범위의 최댓값의 제곱근까지만 반복하면 됨
	static boolean[] Sieve_of_Eratosthenes(int Max) {

		// 0부터 시작하기에, Max+1까지
		boolean[] Prime = new boolean[Max+1];	// 초기값은 false로 설정됨

		// 0과 1은 소수가 아니기에 true
		Prime[0] = true;
		Prime[1] = true;
//		Prime[0] = Prime[1] = true;		// 이렇게 한번에 적어도 됨

		// 인덱스가 소수인 경우에는 false로, 소수가 아닌 경우에는 true로 초기화되게 설정
		for(int i = 2; i <= Math.sqrt(Prime.length); i++) {	
			// 이미 걸러진 배열의 경우(소수가 아님) 다음 반복문으로 건너뜀
			if(Prime[i] = true) {
				continue;	// 거른다는 뜻
				// continue문으로 for문의 처음으로 돌아가 다음 i번째를 실행(아래의 코드는 실행x)
			}
			// if문으로 걸러지지 않은 경우, Prime[i]=false라면 이 숫자는 소수
			// 정석대로는 j = i * 2부터 시작이지만,
			// 이미 2의 배수가 걸러졌기 때문에 i의 제곱수부터 시작해도 됨
			for(int j = i*i; j < Prime.length; j=j+i) {		// j=j+i => j+=i
				// i의 제곱수 ~ i의 배수들을 모두 소수가 아닌것으로 표시
				Prime[j] = true;
			}
		}
		// 배열 index가 소수라면 false로, 아니면 true로 완성된 배열 Prime을 반환
		return Prime;		
	}


	public static void main(String[] args) throws IOException {
		
		// 입력받음
		System.out.println("주어진 수의 개수N(N <= 100)과 N개의 수를 입력해주세요.(단, 1000이하의 자연수)");
			
		// 입력받은 N은 사용하지 않음
		br.readLine();
		int count = 0;
		
		// 입력받은 문자열을 공백 기준으로 파싱
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		// 객체인 sb를 생성하여 소수를 찾아서 저장
		StringBuilder sb = new StringBuilder();
		
		// 메소드 호출하여 소수 구하기
		// 토큰이 있을때까지 반복(st.hasMoreTokens())
		while(st.hasMoreTokens()) {

			// 소수판별 변수 - 소수인 경우true, 아닌경우 false
			boolean isPrime = true;

			// 입력받은 토큰을 소수판별할 숫자로 사용
			int checkNum = Integer.parseInt(st.nextToken());

			// 제곱근을 이용하는 방법2 사용
			// 1은 소수가 아니다
			if(checkNum == 1) {
				// 1인경우는 반복문의 처음으로 돌아가서, 다음 숫자를 판별
				// 소수 판별에 영향을 주지 않게하기 위해 continue문 사용
				continue;
//				isPrime = false;	// 이렇게 적어도 되기는 함
			}
			// 2 ~ Number의 제곱근까지 중 나누어 떨어지는 약수가 있는지 판별
			// Number = 2 의 경우는 자연스럽게 for문을 검사하지 않게 됨
			for (int i=2; i<= Math.sqrt(checkNum); i++) {
				
				if(checkNum % i == 0) {
					isPrime = false;
					break;
				}
			}
			// 소수인 경우, count증가
			if(isPrime) {
				sb.append(checkNum).append('\t');
				count++;
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}
}