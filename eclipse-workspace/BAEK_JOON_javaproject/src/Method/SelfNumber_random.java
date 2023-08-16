package Method;

import java.util.Scanner;

// 셀프넘버 = 양의 정수 중에서 자기 자신을 제외한 모든 양의 정수와 합으로 표현 안되는 숫자
// (생성자가 없는 숫자)
// ex) 33으로 시작할경우, 39=33+3+3, 51=39+3+9,...
//		33은 39의 생성자, 39는 51의 생성자
// 10000보다 작거나 같은 셀프넘버를 한줄에 하나씩 출력하는 프로그램

// 입력받은 수보다 작거나 같은 셀프넘저를 한 줄에 증가하는 순서로 출력하는 프로그램
class Constructor {

	// 메소드
	// cnstNum()메소드 - 매개변수로 받은 number의 각 자리수를 더한 값을 반환하는 함수
	static int cnstNum(int number) {

		// sum변수의 초기값은 number로 설정 -> 이후 반복문으로 각 자리수를 더해줌
		int sum = number; // sum변수 = 각 자리수를 더한 값

		// 셀프넘버를 찾기위한 반복문 작성
		// 각 자리수를 더해주기 위해 %(나머지)와 /(몫)연산자를 활용 => 10단위씩 줄여줌
		while (number != 0) { // number 0이 아닐때까지 반복
			// number의 첫번째 자리수를 구하기 위함
			sum = sum + (number % 10); // %연산자를 사용해 sum을 더해줌
			number = number / 10; // number를 10으로 나눠 첫째자리를 없앰
			// if) number = 1234 => sum = 1234 초기화
			// 반복문1) sum = 1234 + (4) = 1238
			// number / 10 = 123 -> (number가 0일때까지 반복)
			// 반복문2) sum = 1238 + (3) = 1241, number / 10 = 12
			// 반복문3) sum = 1241 + (2) = 1243, number / 10 = 1
			// 반복문4) sum = 1243 + (1) = 1244, number / 10 = 0 => 반복문 탈출
		}
		return sum;
	}

	static void printArr(boolean[] arr, int N) {
		int count = 1;
		for (int i = 1; i <= N; i++) {
			if (!arr[i]) {
				if (count % 10 == 0) {
					System.out.println(i);
				} else {
					System.out.print(i + "\t");
				}
				count++;
			}
		}
	}
}

public class SelfNumber_random {
	// 메인 메소드
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("정수를 입력해주세요(1과 입력받은 수 사이 셀프넘버가 출력됩니다.)");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// boolean 배열
		boolean[] check = new boolean[N+1];

		// cnstNum()메소드를 호출하여 return된 수는 생성자 있는 수
		// 따라서, 출력해서는 안되기에 boolean배열을 통해 true로 바꿔줌
		for (int i=1; i<=N; i++) {
			// cnstNum메소드에 숫자를 1~입력받은숫자(N)까지 대입
			int returnN = Constructor.cnstNum(i);

			// 만일 입력값N보다 큰 수일경우에는 필요X
			if (returnN <= N) {
				// check배열을 true로 바꿔 출력X
				check[returnN] = true;
			}
		}
		Constructor.printArr(check, N);
		
	}
}