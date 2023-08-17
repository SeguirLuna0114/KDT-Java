package backTracking;

/** 백트래킹
 * 모든 가능한 상태를 탐색하는 알고리즘
 * - 해를 찾기위해 선택한 경로가 유효하지 않으면, 더이상 탐색X -> 이전 단계로 되돌아감
 * 
 * * 여기서는 팀 조합을 생성하면서 백트래킹이 사용
 *  선택한 조합이 유효하지 않은 경우에는, 이전 단계로 돌아가며 다른 선택지를 검색
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하는 프로그램
 * 
 * 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다.
 * 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다. 
 * Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 
 * 팀에 더해지는 능력치는 Sij와 Sji
 * 
 * i번 줄의 j번째 수는 Sij 이다. 
 * Sii는 항상 0이고, 나머지 Sij는 1보다 크거나 같고, 100보다 작거나 같은 정수
 */
public class Combination_Difference {

	static int N;
	static int[][] map;
	static boolean visit[];
	static int Min = Integer.MAX_VALUE;
	
	/**
	 * 모든 조합의 경우의 수를 탐색하여 두 팀의 능력치가 최소가 되는 수를 찾고 이를 출력
	 * 조합을 하기 위해 반복문과 반복문 내 재귀호출 사용 
	 */
	// idx는 인덱스, count는 조합 개수(=재귀 깊이)
	static void CntCombination(int idx, int count) {
		// 팀 조합이 완성될 경우
		if(count == N/2) {
			/**
			 방문한 팀과 방문하지 않은 팀을 각각 나누어
			 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
			*/
			ScoreDiff();
			return;
		}
		
		for(int i=idx; i < N; i++) {
			// 방문하지 않은 경우(아직 팀의 일원이 아닌경우)
			if(!visit[i]) {
				// 방문으로 변경(해당 멤버를 팀에 추가)
				visit[i] = true;
				
				// 재귀 호출 - 다음 인덱스와 증가된 카운트를 사용해 함수에 재귀호출
				CntCombination(i+1, count+1);
				
				// 재귀호출이 끝나면 비방문으로 변경 => 현재 팀에서 해당 멤버를 제거
				// 다른 팀 조합을 탐색하고, 현재 멤버를 제외한 다른 멤버로 구성된 팀을 탐색
				visit[i] = false;
			}
		}
	}
	
	// 스타트 팀과 링크 팀의 능력치를 계산하고 두 팀 간의 능력치 차이를 구하는 역할
	static void ScoreDiff() {
		
		// 각 팀의 능력치 변수
		int team_start = 0;
		int team_link = 0;
		
		// 스타트 팀과 링크 팀의 능력치 누적
		for(int i=0; i<N-1; i++) {
			for (int j=i+1; j<N; j++) {
				// i번째 사람과 j번째 사람이 true라면 두 사람 모두 모두 스타트 팀에 속하고,
				// i번째 사람과 j번째 사람의 능력치를 스타트팀으로 점수++
//				if(visit[i] == true && visit[j] == true) {
				if(visit[i] && visit[j]) {
					// i 번째 사람과 j 번째 사람이 true라면,(즉 Sij 가 true 라면) 스타트팀의 능력치(Sij 와 Sji) ++
					team_start += map[i][j];
					team_start += map[j][i];
				}
				
				// i번째 사람과 j번째 사람이 false라면 두 사람이 모두 링크 팀에 속하고,
				// i번째 사람과 j번째 사람의 능력치를 링크팀으로 점수++
//				if(visit[i] == false && visit[j] == false) {
				if(!visit[i] && !visit[j]) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
		
		// 두 팀 간의 능력치 차이를 계산(절댓값)
		int val = Math.abs(team_start - team_link);
		
		/*
		 * 두 팀의 점수차가 0이라면 두 팀의 능력치가 같으므로 가장 낮은 최솟값이기 때문에
		 * 더이상의 탐색 필요없이 0을 출력하고 종료하면 된다.
		 */
		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		// Min 변수를 이용하여 계속해서 최소 점수 차이를 업데이트
		Min = Math.min(val, Min);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫째 줄에 N(4 ≤ N ≤ 20, N은 짝수)을, \n"
				+ "둘째 줄부터 N개의 줄에 S를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// 조합 점수표 - 2차원 배열
		map = new int[N][N];
		// 방문 여부를 표시할 배열
		visit = new boolean[N];
		
		// 입력받은 값을 사용해서, 조합 점수표 초기화
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 조합의개수 구함
		CntCombination(0, 0);
		System.out.println(Min);
	}
}
