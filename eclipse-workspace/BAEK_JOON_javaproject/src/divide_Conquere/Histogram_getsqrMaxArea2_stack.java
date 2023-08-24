package divide_Conquere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* 히스토그램에서 가장 넓이가 큰 직사각형을 구하는 프로그램
 * 가장 넓이가 큰 직사각형의 넓이를 출력
 */
/** 히스토그램에서 가장 큰 직사각형의 넓이을 구하는 프로그램
 * 방법1) 분할정복으로 문제 풀이
 * 방법2) 스택 자료구조를 이용해 문제 풀이
 */
public class Histogram_getsqrMaxArea2_stack {
	
	/** 방법2) 스택 자료구조를 이용해 문제 풀이
	 * - histogram을 입력받을 때 배열에 이미 높이를 저장하게 되므로 
	 *   Stack에 높이 정보를 같이 저장할 필요 없이 index 정보만 기억하며
	 *   이전 막대들의 높이의 위치를 체인 형식으로 관리
	 * 
	 *  "구간 범위 [lo : hi] 내 가운데를 기준으로 분할하는 방식을 사용"
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
		  			(= 현재 막대가 이전 막대의 높이보다 작을 경우 현재 막대로 가질 수 있는 최대 높이는 현재 높이)
	 */
	/* 스택의 꼭대기 원소(top)이 가리키는 index의 막대 높이보다 현재 막대높이가 작은경우
	 * 현재 막대의 높이보다 크거나 같은 원소는 모두 삭제(pop)하고,<- 이 과정에서 삭제하며 넓이 구함
	 * 다음 현재 막대의 index를 넣음(push)
	 */
	// 입력받은 직사각형의 높이 배열
	static int[] histogram;
	
	// 구간 범위 [lo : hi] 내 가운데를 기준으로 분할하는 방식의 메소드
	static long getArea(int len) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		long maxArea = 0;
		
		for (int i=0; i<len; i++) {
			
			/*  이전 체인의 높이보다 현재 히스토그램 높이가 작거나 같을경우
			 *  i번째 막대보다 작은 이전 체인들을 pop하면서 최대 넓이를 구해준다.
			 */
			while(!stack.isEmpty() && histogram[stack.peek()] >= histogram[i])  {
				
				// 이전 체인의 높이
				int height = histogram[stack.pop()];
				
				/*
				 * pop한 뒤 그 다음의 이전체인이 만약 없다면 0번째 index 부터 (i-1)번째 인덱스까지가
				 * 유일한 폭이 된다. (폭은 i가 됨)
				 * 반면 스택이 비어있지 않다면 이는 pop한 높이보다 더 작은 높이를 갖는
				 * 체인이 들어있다는 것이므로 (i-1)번째 index에서 그 다음 이전 체인의 index를 
				 * 빼준 것이 폭이 된다.
				 */
				long width = stack.isEmpty() ? i : i-1-stack.peek();
				
				// 최대넓이 값 갱신
				maxArea = Math.max(maxArea, height* width);
			}
			/*
			 *  위 과정이 끝나면 스택에 저장되어있는 체인은 모두 i보다 작거나 같은
			 *  체인들 뿐이므로 i번째 index를 넣어준다.
			 */
			stack.push(i);
			
		}
		
		// 위 과정이 끝나고 Stack에 남아있는 체인들이 존재할 수 있으므로 
		// (순회가 다 끝나면 결국 스택에 잔여 데이터들이 존재할 수 밖에 없다)
		// 스택에 남겨져 있는 원소들에 대해서도 pop과정을 똑같이 거치면서 넓이를 계산
		while(!stack.isEmpty()) {
			
			int height = histogram[stack.pop()];
	 
			/*
			 * 만약 pop하고 난 뒤 스택이 비어있다면 이는 남아있는 체인이 없다는 뜻이고
			 * 고로 0 ~ (len - 1) 까지인 전체 폭이 width가 되는 것이다. 
			 */
			long width = stack.isEmpty() ? len: len - 1 - stack.peek();
			
			maxArea = Math.max(maxArea, width * height);
		}
		
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
			
			histogram = new int[n];
			for(int i=0; i<n; i++) {
				histogram[i] = Integer.parseInt(st.nextToken());
			}

			// 직사각형의 넓이를 구하는 메소드
			sb.append(getArea(n)).append('\n');
			
			// histogram재사용을 위해 null로 초기화
			histogram = null;
		}
		
		System.out.println(sb);
	}
}
