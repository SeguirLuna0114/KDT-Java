package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* * 666은 종말을 나타내는 수
 * - N번째 종말의 수를 출력하는 프로그램
 * - 작은 종말의 수는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 
 */
public class EndOfWorld_666 {

	/*
	 * *방법1) 브루트포스 방식 - N 의 최솟값은 1 이니 결국 666부터 시작하여, 1 씩 증가 해당 문자열에 666이 담겨 있을 경우
	 * count 를 1씩 증가시키고, N 이 count 랑 같아지면 해당 숫자를 출력 * 숫자를 증가시킬 때는 int 형으로, 666이
	 * 포함되는지를 검사할 때는 문자열로 검사 1) charAt()메소드 사용 => 문자열 내에서 '문자' 추출 2) contains()메소드
	 * 사용 => 해당 문자열 내에 검사하려는 문자열 포함되었는지
	 */
	static void start666plus(int N) {
		// 숫자 666부터 시작
		int num = 666;
		// 숫자 666이 담겨있을 경우, 해당 숫자num은 몇번째인지
		int count = 1; // 종말의수 666은 1번째임

		if (N > 1) {
			// 찾으려는 N번째 종말의수 이전까지 num++ => 666포함되는지 검사
			while (count != N) {
				num++;

				// num에 666이라는 문자열이 담겨있는지 검사
				if (String.valueOf(num).contains("666")) {
					count++;
				}
			}
		}
		// 해당 종말의 수 출력
		System.out.println(num);
	}

	
	/*
	 * * 방법2) 666인 구간만 찾아서 경우의 수를 생각하여 각 자릿수 값만 증가 - N은 10,000보다 작거나 같은 자연수이기에, N 이
	 * 10000일 때 결과값은 2666799 => 따라서, 최대 자릿수는 7자리수
	 * 
	 * - prev_digit(가장 선수에 있는 자릿수)을 증가시키면서 count -> prev_digit 이 6이 될 경우 6660 이라고
	 * 가정하여 따로 반복문에 0~9 까지 count 를 증가 - prev_digit이 66 일경우 위와 같이 하되, 0~100까지 반복하면서
	 * count -> 위 과정중 N==count이면, prev_digit뒤에 나머지 수 붙여 출력
	 */
	static void prevDigit666(int n) {
		/**
		 * 선수 자릿수_그 뒤 자릿수로 표현 (prev_digit) _ behindnum
		 * 이때 자릿수에 따라 behindnum은 0 또는 600, 660, 666을 가짐
		 */
		// 숫자 666부터시작하기에, 종말의 수 첫번째는 1
		int count = 1;
		
		// 선수 자릿수
		int prev_digit = 0;
		// 선수 자릿수를 제외한 나머지 뒷 자리수
		int num = 0;
		
		// 선수 자릿수와 나머지 자리의 수를 조합하여 666이 포함되어 있는 경우만 count
		if (n > 1) {
			
			while (true) {
				/** 7자리수
				 *  선수 자릿수가 X...666X 이면서 X...6666 이 아닐 경우
				 * "666x_XXXX" 
				 * (ex. 6660_000, 6660_001, ...)
				 */
				if (((prev_digit % 10000) / 10) == 666 && prev_digit % 10 != 6) {
					for (int i = 0; i < 1000; i++) {
						if (count == n) {
							System.out.print(prev_digit * 1000 + num);
							return;
						}
						num++;
						count++;
					}
					prev_digit++;
				}

				/** 6자리수
				 *  선수 자릿수가 X...666 일 경우 
				 *  (ex. 666_000, 1666_004, ...)
				 */
				else if (prev_digit % 1000 == 666) {
					num = 0;
					for (int i = 0; i < 1000; i++) {
						
						if (count == n) {
							System.out.print(prev_digit * 1000 + num);
							return;
						}
						count++;
						num++;
					}
					prev_digit++;
				}

				/** 5자리수
				 *  선수 자릿수가 X...66 일 경우 
				 *  (ex. 66_600, 166_600, ...)
				 */
				else if (prev_digit % 100 == 66) {
					num = 600;
					for (int i = 0; i < 100; i++) {
						if (count == n) {
							System.out.print(prev_digit * 1000 + num);
							return;
						}
						count++;
						num++;
					}
					prev_digit++;
					
				}

				/** 4자릿수
				 *  선수 자릿수가 X...6 일 경우 
				 *  (ex. 6_660, 16_663, ...)
				 */
				else if (prev_digit % 10 == 6) {
					num = 660;
					for (int i = 0; i < 10; i++) {
						if (count == n) {
							System.out.print(prev_digit * 1000 + num);
							return;
						}
						num++;
						count++;
					}
					prev_digit++;
				}

				/** 그 외의 경우
				 *  (ex. 241_666, 23_666...)
				 */
				else {
					num = 666;
					if (count == n) {
						System.out.print(prev_digit * 1000 + num);
						return;
					}
					count++;
					prev_digit++;
				}
			}
		} else {
			// 첫번째 종말의수의 경우에는 666 출력
			System.out.println(666);
		}
	}

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫째 줄에 N을 입력하세요.(N은 10,000보다 작거나 같은 자연수)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 방법1) 브루트포스 방식 - N 의 최솟값은 1 이니 결국 666부터 시작하여, 1 씩 증가
		start666plus(N);

		System.out.println();

		// 방법2) 666인 구간만 찾아서 경우의 수를 생각하여 각 자릿수 값만 증가
		prevDigit666(N);
	}
}
