package Method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 무한히 큰 배열에 분수가 지그재그순서대로 1/1, 2/1, 1/2, ... 과 같이 주어진 경우
// X가 주어졌을 때 X번 째 분수를 구하는 프로그램을 작성

// 분모값과 분자값의 합을 T라고 하면 대각선으로 합이 T=2, T=3, T=4...와 같은 규칙이 생김
// 1/1 1/2 1/3 1/4 1/5 ...
// 2/1 2/2 2/3 2/4 ...
// 3/1 3/2 3/3 ...
// T = 분자 + 분모
// 각 대각선의 칸의 개수= T-1
// 
public class Fraction_find {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 첫째 줄에 X(1 <= X <= 10,000,000)가 주어짐
		System.out.println("X를 입력하세요(1 <= X <= 10,000,000)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		// T가 짝수(대각선 칸의 개수가 홀수)인 경우 왼쪽 아래에서 오른쪽 위 방향으로 진행
		// T가 홀수(대각선 칸의 개수가 짝수)인 경우 오른쪽 위에서 왼쪽 아래방향으로 진행
		
		// 직전 대각선 합과 현재 대각선(T) 개수 변수 설정
		int prev_count_sum = 0, cross_count = 1;
		// 해당 범위의 대각선 칸 개수: cross_count
		// 해당 대각선 직전 대각선까지의 칸의 누적합: prev_count_sum
		
		// ex) X=14인 경우
		// 분자+분모(T)가 2일 경우(1/1)에는 prev_count_sum=0
		// 분자+분모(T)가 3일 경우(1/2) or (2/1)에는 prev_count_sum=1
		// 분자+분모(T)가 4일 경우(1/3), (2/2), (3/1)에는 prev_count_sum=3
		// 분자+분모(T)가 5일 경우(1/4), (2/3), (3/2), (4,1)에는 prev_count_sum=6
		// 분자+분모(T)가 6일 경우(1/5), (2/4), (3/3), (4,2), (5/1)에는 prev_count_sum=10
		// 따라서, T=6일때, X(14)-prev_count_sum(10) 하면 4이고, 이는 현재 대각선의 4번째 원소라는 뜻
		//	=> 4번째 원소라는 건 분자 or 분모가 4 
		// 	=> T=6으로 짝수이기에, 왼쪽->오른쪽 진행되고 재각선으로 진행되는 분자는 반비례관계이기에
		// 현재 대각선 원소의 개수(cross_count: T=6일때 T-1(5개))에서 몇번째 원소인지를 빼주면됨
		// 따라서 X-prev_count_sum이 분모라면 현재 대각선 개수에서 분모값을 빼주고
		// 반대로 X-prev_count_sum이 분자라면 역으로 cross_count - (X - prev_count_sum)을 해줌
		// 다만, 대각선 개수와 분자+분모 합은 1씩 차이가 나기에 전체 수식에 +1
		
		while(true) {
			
			// 직전 대각선 누적합 + 해당 대각선 개수 이용한 범위 판별
			if (X <= prev_count_sum + cross_count) {
				
				// 대각선 개수가 홀수인 경우
				if(cross_count % 2 == 1) {
					// 분자가 큰 수부터 시작
					// 분자는 대각선 상 내의 블록개수 - (X번째 - 직전 대각선까지의 블록개수 -1)
					// 분모는 X번째 - 직전 대각선까지의 블록 개수
					System.out.println((cross_count - (X - prev_count_sum) + 1) + "/" +(X - prev_count_sum));
					break;
				} else {
					// 대각선 상의 블록개수가 짝수인 경우
					// 홀수일때와 출력을 반대로 설정
					// 분자는 X번째 - 직전 대각선까지의 블록 개수
					// 분모는 대각선 상 내의 블록개수 - (X번째 - 직전 대각선까지의 블록개수 -1)
					System.out.println((X - prev_count_sum) + "/" + (cross_count - (X - prev_count_sum) + 1));
					break;
				}
				
			} else {
				prev_count_sum += cross_count;
				cross_count++;
			}
		}
		

	}

}
