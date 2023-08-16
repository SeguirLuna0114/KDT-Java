package Method;

// 계차수열
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 입력으로 주어진 방까지 최소 개수의 방을 지나서 갈때, 몇개의 방을 지나는지 출력하는 프로그램
// 육각형 벌집의 중앙의 방에서부터 1시작하여 이웃하는 방에 1씩 증가하는 번호를 매김
// 숫자 N이 주어졌을 때, 벌집의 중앙에서 N번방까지의 최소 개수의 방을 지나 갈때 몇개의 방을 지나가는지
// 시작과 끝을 포함하여 계산하는 프로그램
// ex) 13까지는 3개, 58까지는 5개를 지남

// 알고리즘
// N=1: 1개
// N=2~7(6개): 2개
// N=8~19(12개): 3개
// N=20~37(18개): 4개		(방 개수는 6개씩 늘어남)
// 계차수열: 1+(6n(n-1)/2)
public class Hexagon_DifferenceSequence {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 첫째 줄에 N(1 <= N <= 1,000,000,000)이 주어짐
		System.out.println("숫자 N을 입력하세요.(1 <= N <= 1,000,000,000)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		
		// 최소루트 값
		int shortway = 1;
		// 최소값 기준
		int limitRange = 2;
		
		// N이 1일 경우에는 최소경로 1 출력
		if (N==1) {
			System.out.println(1);
		}
		else {
			// 범위가 N보다 커지기 직전까지 최솟값 limitRange를 계속 증가
			while (limitRange <= N) {
				// 다음 범위의 최소값으로 초기화
				// 각 루트마다 범위가 6씩 증가
				// 계차수열: 공차는 6이고, N값까지 첫항limitRange을 업데이트
				limitRange = limitRange + (6 * shortway);
				// 최소루트 1 증가
				shortway++;
			}
			// 위 코드를 for문으로 작성
//			for (; limitRange <=N; shortway++) {
//				limitRange += (6 * shortway);
//			}
			System.out.println(shortway);
		}
		
	}

}
