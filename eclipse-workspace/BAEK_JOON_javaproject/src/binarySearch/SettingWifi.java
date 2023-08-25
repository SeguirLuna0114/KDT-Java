package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 최대거리를 구하는 프로그램
 * 
 * 도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고,
 * 한 집에는 공유기를 하나만 설치할 수 있고, 
 * 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치
 */
public class SettingWifi {
	
	/**
	 * N개의 좌표(집 위치)와 M개의 공유기를 설치하는 동안,
	 * 최대한 설치되는 집 간 거리를 벌리는 것
	 * => "직전에 설치했던 집의 위치와 거리를 비교하는 것"
	 * 
	 * 최소 거리에 대해 설치 가능한 공유기'가 문제에서 주어지는 '설치 해야 할 공유기의 개수(M)'와
	 * 같은 거리 중 최대로 가질 수 있는 '최소 거리'를 찾는 것
	 * => 거리를 탐색 범위로 잡고 이분탐색을 하면서, 
	 *   해당 거리에 대해 설치 가능한 공유기의 개수에 따라 
	 *   탐색하는 거리의 범위를 좁혀나가면 된다는 것
	 *   +  '최대로 가질 수 있는' 최소 거리이기 때문에 Upper Bound 형식을 따르면 된다
	 * 
	 * 만일, 바로 이전의 집과 거리를 비교하게 되면 각 집간의 거리가 1이기에,
	 * 		첫번째 집을 설치하고 난 후 와이파이를 설치할 수 없게 됨
	 * 		=> 직전에 설치를 했던(가장 최근에 설치했던) 집과 현재 집과의 거리를 기준으로 판단
	 */
	static void Upperbound(int C) {
		
		// 탐색범위의 최대 인덱스와 최소 인덱스 설정
		// 최소 거리가 가질 수 있는 최솟값
		long low = 1;		
		// 최소 거리가 가질 수 있는 최댓값
		long high = house[house.length -1] - house[0] + 1;		
		
		// 이분탐색
		while(low < high) {
			
			// 중간값 설정
			long mid = low + (high - low)/2;
			
			/** mid 거리에 대해 설치 가능한 공유기 개수가 C개수에 못미치면
			 * 거리가 너무 길어서 설치 가능한 대수가 작다는 것
			 * => 거리를 좁혀야 하기 때문에 hi 를 줄인다.
			 */
			if (cabInstall(mid) < C) {
				high = mid;
			}
			/**
			 * 설치 가능한 공유기 개수가 M 개수보다 크거나 같으면
			 * 거리가 작다는 의미이기에,
			 * 거리를 벌리면서 최소거리가 가질 수 있는 최대 거리를 찾아낸다.
			 * => 하한을 mid+1로 변경
			 */
			else {
				low = mid+1;
			}
		}
		
		/**  Upper Bound는 탐색 값을 초과하는 첫 번째 값을 가리키므로, 
		 *  1을 빼준 값이 조건식을 만족하는 최댓값이 된다.
		 */
		System.out.println(low -1);
	}
	
	
	// distance에 대해 설치 가능한 공유기 개수를 찾는 메소드
	static int cabInstall(long distance) {
		/** 거리를 '줄이면' 설치 가능한 공유기 대수가 늘어나고, 
		 * 거리를 '늘리면' 설치 가능한 공유기 대수가 줄어들 것
		 */
		
		// 첫번째 집은 무조건 설치한다고 가정
		int count = 1;
		// 공유기를 설치한 지난집의 위치를 설정할 변수
		long lastLocate = house[0];
		
		for(int i=1; i<house.length; i++) {
			
			long locate = house[i];
			
			/**  현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가
			 *  최소 거리(distance)보다 크거나 같을 때 공유기 설치 개수를 늘려주고
			 *  마지막 설치 위치를 갱신해준다. 
			 */
			if( locate - lastLocate >= distance) {
				count++;		// 공유기를 설치하고
				lastLocate = locate;	// 현재 위치를 지난 위치로 변경
			}
		}
		
		return count;
	}
	

	static long[] house;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)을 하나 이상의 빈 칸을 사이에 두고 입력하고,\n"
				+ "둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)를 한줄에 하나씩 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		// N개의 줄에 입력받은 집의 좌표
		house = new long[N];
		
		// 집의 좌표 중 최대값(범위의 최대값)을 구하는 변수
		long max = 0;
		
		for(int i=0; i<N; i++) {
			house[i] = Long.parseLong(br.readLine());
		}
		
		// 이분탐색을 하기 위해 정렬
		Arrays.sort(house);
		
		// 이분탐색을 통해 공유기 사이 최대거리를 구하는 메소드 실행
		Upperbound(C);
	}
}
