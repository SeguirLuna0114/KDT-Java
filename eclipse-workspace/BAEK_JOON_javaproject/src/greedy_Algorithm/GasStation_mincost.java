package greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 각 도시에 있는 주유소의 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아
 * 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램
 * "표준 출력으로 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력"
 * 
 * 처음 출발할 때 자동차에는 기름이 없어서 주유소에서 기름을 넣고 출발하여야 한다. 
 * 기름통의 크기는 무제한이어서 얼마든지 많은 기름을 넣을 수 있다. 
 * 도로를 이용하여 이동할 때 1km마다 1리터의 기름을 사용한다. 
 * 각 도시에는 단 하나의 주유소가 있으며, 도시 마다 주유소의 리터당 가격은 다를 수 있다. 
 * 가격의 단위는 원을 사용한다.
 * - 원 안에 있는 숫자는 그 도시에 있는 주유소의 리터당 가격
 * 
 * - 제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수
 * - 리터당 가격은 1 이상 1,000,000,000 이하의 자연수
 */
public class GasStation_mincost {
	
	/** 도시 A부터 D까지 도착하는데 총 비용을 최소화 하는 방법
	 * - 비용을 최소화 하는 방법 => '리터당 가격이 싼 기름을 넣는 것'
	 * - 최소비용으로 가는 방법 => 리터당 기름 값이 '내림차순'일 경우에 주유
	 * 
	 * 1. 입력받은 도시별 기름 가격을 내림차순으로 만들어 
	 * 2. 각 도시별 거리를 곱하여 더해주면 되는 것
	 */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫 번째 줄에는 도시의 개수를 나타내는 정수 N(2 ≤ N ≤ 100,000)\n"
				+ "다음 줄에는 인접한 두 도시를 연결하는 도로의 길이를 제일 왼쪽 도로부터 N-1개의 자연수로 입력하고\n"
				+ "그 다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수로 입력하세요.\n"
				+ "(제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수)\n"
				+ "(리터당 가격은 1 이상 1,000,000,000 이하의 자연수)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 도시의 개수를 나타내는 정수 N
		int N = Integer.parseInt(br.readLine());
		
		// 인접한 두 도시를 연결하는 도로의 길이 및 주유소의 리터당 가격을 입력할 배열 생성
		long[] dist = new long[N-1];	// 도로의 길이는 도시의 개수-1 만큼 입력됨
		long[] cost = new long[N];		// 비용의 개수와 도시의 개수는 같음
		
		// 도로의 길이(거리) 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 도로의 길이는 도시의 개수-1 만큼 입력됨
		for(int i=0; i<N-1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		
		// 리터당 기름값 입력
		st = new StringTokenizer(br.readLine());
		// 기름 비용은 도시의 개수만큼 입력됨
		for(int i=0; i<N; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
		
		// 비용의 총합을 구할 변수
		long sum = 0;
		// 이전 까지의 과정 중 주유 최소 비용
		long minCost = cost[0];
		
		for(int i=0; i< N-1; i++) {
			
			/*
			 *  현재 주유소가 이전 주유소의 기름값보다 쌀 경우
			 *  minCost를 갱신해준다. 
			 */
			if(cost[i] < minCost) {
				minCost = cost[i];
			}
			
			sum += (minCost * dist[i]);
		}
		System.out.println(sum);
	}
}
