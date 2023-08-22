package greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여
 * 회의실 사용표를 만들Eo, 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고,
 * 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 구하는 프로그램
 * 
 * - 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 
 * - 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있음
 * 		(= 회의의 시작시간과 끝나는 시간이 같을 수도 있다)
 */
public class MeetingRoom_Activity_Selection_Problem {
	
	/** 활동 선택 문제(Activity Selection problem)
	 * : 시간표를 최대한 많이 배정하거나 선택하는 문제
	 * - 한 사람이 하나의 활동에 대해서만 작업할 수 있을 때 최대한 많은 활동을 할 수 있는 수를 선택하는 문제
	 * - 하나의 활동을 완료하기 전까지는 다른 활동을 선택할 수 없다
	 * - 하나의 활동을 선택하면 나머지 겹치지 않는 활동에 대해서 독립적이고,
	 * 	 '탐욕 선택이 이후의 결과에 영향을 미치지 않는다'
	 */
	
	/** 회의실 사용 그리디 알고리즘
	 * - 선택 결과가 이후의 결과에 영향을 미치지 않으려면 
	 * 	 '이전 선택의 종료 시간'과 '이후 선택의 시작 시간'이 서로 겹치지 않으면 됨
	 * - 최대한 많은 활동을 선택하려면 종료시간이 빨라야 할 수 밖에 없을 것
	 *  "서로 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아진다"
	 *  
	 *  => 1. "종료시간"을 기준으로 정렬
	 *  		- 단, 종료시점이 같을경우 시작시점을 오름차순으로 정렬
	 *     2. 이전 종료시간에 대해 겹치는 것들은 제외하고, 남은 것중 선택
	 */
	
	// 회의의 시작시간과 끝나는 시간 입력받을 배열
	/*
	  time[][0] 은 시작시점을 의미 
	  time[][1] 은 종료시점을 의미 
	*/
	static int[][] time;
	
	static void GreedyActivSel(int N) {
		
		// 활동 개수 변수
		int count = 0;
		
		// 이전 선택의 종료시간
		int prev_end_time = 0;
		
		for(int i=0; i<N; i++) {
			
			// 직전 종료시간이 다음 회의 시작시간보다 작거나 같으면 갱신
			if(prev_end_time <= time[i][0]) {
				// 현재 종료시간으로 직전 종료시간 갱신
				prev_end_time = time[i][1];
				// 활동 개수변수 ++
				count++;
			}
		}
		
		System.out.println(count);
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)을 입력하고, \n"
				+ "둘째 줄부터 N+1 줄까지 각 회의의 정보를 공백을 사이에 두고 회의의 시작시간과 끝나는 시간으로 입력하세요.\n"
				+ "(단, 시작 시간과 끝나는 시간은 2^(31)-1보다 작거나 같은 자연수 또는 0)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 입력받은 회의 시작/종료 정보 입력
		time = new int[N][2];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 1. 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				
				// 종료시간이 같을 경우 시작 시간이 빠른순으로 정렬
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				// 그 외에는 끝나는 시간이 빠른순으로 정렬
				return o1[1] - o2[1];
			}
		});
		
		
		// 2. 이전 종료시간에 대해 겹치는 것들은 제외하고, 남은 것중 선택
		GreedyActivSel(N);
	}
}
