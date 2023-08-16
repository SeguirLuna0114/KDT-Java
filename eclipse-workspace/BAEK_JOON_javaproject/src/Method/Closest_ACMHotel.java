package Method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 호텔 정문으로부터 걷는 거리가 가장 짧도록 방을 배정하는 프로그램
// 각 층에 W개의 방이있는 H층 건물(1 <= H, W <= 99)
// 엘리베이터는 가장 왼쪽에 위치. 모든 인접한 방사이 거리는 1. 엘리베이터에서부터 센 번호가 방번호

// 알고리즘 - 엘리베이터로부터 가까운 방 번호부터 배정
// 층수) 10번째 손님은 1층~건물 층(H층)까지 채워진 후, 다시 1층에서 시작하여 배정받음
//		따라서, N번째 손님은 N % H 값이 층수(나머지가 층수). 
//		단, N=H인 경우는 나머지가 0이기에, 나머지가 0인경우는 H층에 배정됨

// 거리) 엘리베이터로부터 떨어진 거리는 N번째 손님의 경우 N / H값이 거리(몫)
//		그리고 +1을 해야함(거리인 호수는 1부터 시작하기 때문)
//		단, N=H인 경우 몫이 1이어서 떨어진 거리는 1+1=2가 됨 => 예외처리
public class Closest_ACMHotel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 프로그램 입력을 테스트 할 T횟수를 입력받고, 각 테스트 데이터는 H, W, N 세정수를 입력
		// 단, H는 호텔의 층수, W는 각 층의 방의수, N은 N번째 손님 의미
		System.out.println("테스트 횟수를 입력하고, 호텔의 층수, 각 층의 방의 수, N번째 손님을 입력하세요");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		// 테스트 케이스T
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int H = Integer.parseInt(st.nextToken());
			
			// 우리는 W의 값을 사용하지 않기 때문에, W는 버려도 상관X
//			int W = Integer.parseInt(st.nextToken());
			st.nextToken();		// W값을 버림
			
			int N = Integer.parseInt(st.nextToken());
			
			// 가까운 거리부터 호수 배정
			if (N % H == 0) {
				sb.append((H*100) + (N / H)).append('\n');
				
			} else {
				sb.append(((N % H)*100) + ((N / H)+1)).append('\n');
			}
		}
		System.out.println(sb);
		
	}

}
