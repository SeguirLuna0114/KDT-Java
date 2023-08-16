package BufferedReader;

// 주어진 수가 10보다 작다면, 앞에 0을 붙여 2자리수로 만들고, 각 자리 수를 더함
// 주어진 수의 가장 오른쪽 자리 수와 
// 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙여 새로운 수 생성
// 이 사이클을 몇번 반복해야 원래의 수로 돌아오는지 사이클 수를 구하는 프로그램
// ex)26: 2+6=8 => 68
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 알고리즘
// N이라는 정수가 주어진다면, N의 1의자리수(N%10)는 새로운 수의 10의자리((N%10)*10)로,
// N의 1의자리수(N%10)와 10의자리수((N/10)를 더한 값의 1의자리수 => 새로운 수의 1의자리수((N/10)+(N%10))%10
// 만일, N이 한자리 정수라면 앞에 0을 붙여 더함
class AddCycle {
	
	// while 무한루프 사용
	static void countCycle(BufferedReader br, int N) {
		// 반복횟수
		int count=0;
		// 기존에 입력받은 정수
		int copyN = N;
		
		// 반복을 수행해야 하기에, while문-무한루프 작성
		while(true) {
			// 새롭게 정의된 정수N을 update
			N = ((N%10)*10)+(((N/10)+(N%10))%10);
			// 위와 다른 방법 - 새로 생성된 정수를 New변수에 할당한뒤, N변수에 New를 대입
//			int New = ((N%10)*10)+(((N/10)+(N%10))%10);
//			N = New;
			
			count++;
			
			// 무한루프 탈출을 위한 코드
			// 새롭게 만들어진 숫자가 처음 입력받은 숫자와 같다면 반복문 탈출
			if (N == copyN) {
				break;
			}
		}
		System.out.println(copyN+"이 반복 시행된 횟수: "+count);
	}
	
	// do-while 루프 사용
	static void countCycle2(BufferedReader br, int N) {
		// 반복횟수
		int count = 0;
		// 새로 생성된 숫자
		int copyN = N;
		
		do {
			N = ((N%10)*10)+(((N/10)+(N%10))%10);
			count++;
			
		} while (copyN != N);
		
		System.out.println(copyN+"이 반복 시행된 횟수: "+count);
	}
}


public class AddCycle_BufferedReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 0 <= 입력값 <= 99
		System.out.println("0보다 크거나 같고, 99보다 작거나 같은 정수를 입력하세요?");

		// BufferedReader클래스를 사용하여 입력 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력받은 값을 readLine()메소드를 사용하여 문자열로 받고,
		// Integer.parseInt()메소드로 문자열-> int(정수) 변환

		int N = Integer.parseInt(br.readLine());
		
		// 방법1. countCycle메소드 호출
		AddCycle.countCycle(br, N);
		
		System.out.println();
		
		// 방법2. countCycle2메소드 호출
		AddCycle.countCycle2(br, N);
	}

}
