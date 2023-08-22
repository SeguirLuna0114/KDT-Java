package greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 줄을 서 있는 사람의 수 N과 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어졌을 때, 
 * 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하는 프로그램
 * 
 * ATM앞에 N명의 사람들이 줄을 서있다. 
 * 사람은 1번부터 N번까지 번호가 매겨져 있으며, 
 * i번 사람이 돈을 인출하는데 걸리는 시간은 Pi분
 */
public class ATM_Active_Selection_CountingSort {

	/** '대기 시간의 총합'을 구하는 문제
	 * - 대기시간을 줄이려면 앞 사람이 일찍 끝내야 그만큼 대기시간을 줄일 수 있음
	 * - 각각의 사람이 돈을 인출할 때에는 다른 사람이 개입할 수 없으므로 
	 * 	 그리디 알고리즘의 조건인 독립성과 전체 최적해가 부분 최적해를 만족함 (둘 다 만족)
	 * 
	 * => 입력받은 각각의 인출하는데 걸리는 시간을 오름차순으로 정렬하여 
	 *    대기시간을 구해주면 되는 전형적인 활동 선택 문제
	 */
	// 걸리는 시간
	static int[] time;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000)를, \n"
				+ "둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi(1 ≤ Pi ≤ 1,000)를 입력하세요.");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		/** Counting Sort를 이용해 정렬
		 * : 입력받은 값을 index로 활용하는 방법
		 * ex) 입력이 3이라면, index 3을 1++
		 */
		// 입력의 범위는 1 ~ 1000이므로 1001개의 index를 둔다.
		time = new int[1001];
		
		// Counting Sort
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(N-- > 0) {
			// 입력받은 값을 index로 활용하여 값++
			time[Integer.parseInt(st.nextToken())]++;
		}
		
		// 이전까지 대기시간 누적합
		int prevSum = 0;
		// 사람별 대기시간 총합
		int sum = 0;
		
		for(int i=0; i<time.length; i++) {
			
			// 해당 i인덱스가 0이 될때까지 반복
			while(time[i]-- >0) {
				
				// 이전까지의 대기시간과 현재 사람이 걸리는 시간을 더함
				sum += (i + prevSum);
				
				// 이전 누적합에 현재 걸리는 시간(인덱스)을 더함
				prevSum += i;
			}
		}
		
		System.out.println(sum);
	}
}
