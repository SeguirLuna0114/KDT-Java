package divide_Conquere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 히스토그램에서 가장 넓이가 큰 직사각형을 구하는 프로그램
 * 가장 넓이가 큰 직사각형의 넓이를 출력
 */
/** 히스토그램에서 가장 큰 직사각형의 넓이을 구하는 프로그램
 * 방법1) 분할정복으로 문제 풀이
 * 방법2) 스택 자료구조를 이용해 문제 풀이
 */
public class Histogram_getsqrMaxArea {
	
	/** 방법1) 재귀를 활용한 분할정복으로 문제 풀이
	 * "가운데 index를 기준으로 왼쪽과 오른쪽으로 분할 정복하여 막대의 넓이가 1 일 때 까지 재귀 과정"
	 * 
	 * - 높이를 고정시켜 풀이할 수도 있고, 
	 * - 구간 내 가장 작은 높이의 블럭을 기준으로 분할하여 풀이할 수 있으며,
	 * - 그냥 구간 내의 가운데를 기준으로 분할하여 풀이하는 방법도 존재
	 * 
	 * 그 중, "구간 범위 [lo : hi] 내 가운데를 기준으로 분할하는 방식을 사용"
	 * 1. 가운데 위치를 구한다. ( mid = (lo + hi) / 2 )
	 * 2. 가운데 위치를 기준으로 분할하여 왼쪽 구간의 넓이([lo : mid])와 
	 * 	  오른쪽 구간의 넓이([mid : hi])를 구한다.
	 * 3. 왼쪽과 오른쪽 중 큰 넓이를 변수에 저장한다. 
	 * 4. 변수에 저장된 넓이와 두 구간을 합친 구간([lo : hi])의
	 *    가장 큰 넓이를 구해 두 개 중 가장 큰 넓이를 반환한다.
	 *    - 왼쪽 및 오른쪽으로 "분할되어" 얻어진 최대 넓이가 
		   	전체 구간(lo~hi) 내의 최대 넓이라는 보장이 없기 때문
		   	=> 양쪽 구간을 합친 구간 내에서 
		   	   mid를 기준으로 양쪽으로 뻗어나가면서 두 구간 사이의 겹친 넓이를 탐색
		   	  
		  - 넓이가 크다는 것 = 높이가 크거나 폭이 크거나 혹은 둘 다일 경우
		    => 최대한 높이가 높으면서 폭이 큰 쪽으로 탐색
		  		단, 양쪽의 막대 중 높이가 높을쪽을 택하되, 
		  			기존의 높이(height)와 새로 탐색한 막대의 높이 중 작은 것으로 갱신
		  1) 양쪽 다음 인덱스 중 높이가 큰 쪽으로 확장(padding)
		  2) 갱신되는 높이는 기존의 높이와 확장한 막대의 높이 중 작은것 선택
		  3) 기존의 넓이와 확장한 넓이 중 큰 값으로 갱신
	 */
	// 입력받은 직사각형의 높이 배열
	static long[] histogram;
	
	// 구간 범위 [lo : hi] 내 가운데를 기준으로 분할하는 방식의 메소드
	static long getArea(int low, int high) {
		
		// 막대 폭(넓이)이 1일 경우 높이가 넓이가 되기에, 바로 반환
		if(low == high) {
			return histogram[low];
		}
		
		// 1. 가운데 위치를 구한다. ( mid = (lo + hi) / 2 )
		int mid = (low + high) / 2;
		
		/* 2. 가운데 위치를 기준으로 분할하여 왼쪽 구간의 넓이와 오른쪽 구간의 넓이를 구함
		 * 		왼쪽 부분: [low : mid]
		 * 		오른쪽 부분: [mid+1 : high]
		 */
		long leftArea = getArea(low, mid);
		long rightArea = getArea(mid+1, high);
		
		// 3. 양쪽 구간 중 큰 넓이를 변수에 저장
		long max = Math.max(leftArea, rightArea);
		
		/* 4. 변수에 저장된 넓이 max와, 두 구간을 합친 [lo : hi] 구간 내 최대넓이를 구해
		 	  비교하여 두개 중 더 큰 넓이로 max 갱신
		*/
		max = Math.max(max, getMidArea(low, high, mid));
		
		return max;
	}
	
	// 중간지점 영역의 넓이를 구하는 메소드
	static long getMidArea(int low, int high, int mid) {
		
		// mid부터 왼쪽(<-)으로 갈 변수
		int toLeft = mid;
		// mid부터 오른쪽(->)으로 갈 변수
		int toRight = mid;
		
		// 높이
		long height = histogram[mid];
		
		// 초기 넓이 (구간 폭이 1이기에 넓이는 높이가 면적이 됨)
		long maxArea = height;
		
		// 양 끝 범위를 벗어나기 전까지 반복
		while(low < toLeft && toRight < high) {
			
			/*
			 *  양쪽 다음칸의 높이 중 높은 값을 선택하되, 
			 *  갱신되는 height는 기존 height보다 작거나 같아야 한다.
			 */
			if(histogram[toLeft -1] < histogram[toRight+1]) {
				toRight++;
				height = Math.min(height, histogram[toRight]);
			}
			else {
				toLeft--;
				height = Math.min(height, histogram[toLeft]);
			}
			
			// 최대 넓이 갱신
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
		}
		
		// 오른쪽 구간을 끝까지 탐색하지 못한 경우 마저 탐색
		while(toRight < high) {
			toRight++;
			height = Math.min(height, histogram[toRight]);
			// 최대 넓이 갱신
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
		}
		
		// 왼쪽 구간을 끝까지 탐색하지 못한 경우 마저 탐색
		while(low < toLeft) {
			toLeft--;
			height = Math.min(height, histogram[toLeft]);
			// 최대 넓이 갱신
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
		}
		
		// 최대넓이 반환
		return maxArea;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("직사각형의 수 n(1 ≤ n ≤ 100,000)을 입력하고, 그 다음 n개의 정수(0 ≤ hi ≤ 1,000,000,000)을 입력하세요.\n"
				+ "이 숫자들은 히스토그램에 있는 직사각형의 높이이며, 왼쪽부터 오른쪽까지 순서대로 주어진다\n"
				+ "모든 직사각형의 너비는 1이고, 입력의 마지막 줄에는 0이 하나 주어진다");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			
			if (n == 0) {
				break;
				// 해당 반복문 종료
			}
			
			histogram = new long[n];
			
			for(int i=0; i<n; i++) {
				histogram[i] = Long.parseLong(st.nextToken());
			}

			// 직사각형의 넓이를 구하는 메소드
			sb.append(getArea(0, n-1)).append('\n');
			
			histogram = null;
		}
		System.out.println(sb);
	}
}
