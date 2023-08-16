package queue_deque_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
	Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 문서가 몇번째로 인쇄되는지 알아내는 프로그램
	
	프린터기는 다음과 같은 조건에 따라 인쇄됨
	1. 현재 Queue의 가장 앞에 있는 문서의 '중요도'를 확인
	2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면,
		이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치
	
	맨 왼쪽이 0번째, 두번째줄에는 N개의 문서가 정수인 중요도(1<= 중요도 <=9)에 따라 주어진다. 
 */
public class Queue_Print_byimportance {
	
	/*
	 * 알고리즘 - '중요도'가 높은것부터
	 * 맨 처음 poll()된 원소가 가장 큰경우
	 * => 해당원소의 첫 위치기 M과 같은지 판단
	 * 
	 * 맨 처음 poll()된 원소가 가장 크지 않은경우
	 * => 그 원소 앞에있던 원소들을 뒤로 보낸 후, 다시 첫 원소를 poll()하여 비교
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 첫 줄에 테스트케이스의 수가 주어진다. 각 테스트케이스는 두 줄로 이루어져 있다.
		// 테스트케이스의 첫 번째 줄에는 문서의 개수 N(1 ≤ N ≤ 100)과, 
		// 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지 나타내는 정수 M(0 ≤ M < N)이 주어진다.
		System.out.println("각 테스트케이스에 대해 문서가 몇번째로 인쇄되는지 출력하는 프로그램");
		System.out.println("첫 줄에 테스트케이스의 수를 입력하고,\n"
				+ "테스트케이스의 첫줄에는 문서의 개수N(1 ≤ N ≤ 100)과,\n"
				+ "문서가 Queue의 몇번째에 놓여있는지나타내는 정수 M(0 ≤ M < N)을 입력하세요");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 첫줄에 입력된 테스트케이스의 수
		int TestN = Integer.parseInt(br.readLine());
		
		// 두번재줄부터 입력된 테스트케이스
		while (TestN-- >0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 문서의 개수N(1 ≤ N ≤ 100)
			int N = Integer.parseInt(st.nextToken());
			// 문서가 Queue의 몇번째에 놓여있는지나타내는 정수 M(0 ≤ M < N)
			int M = Integer.parseInt(st.nextToken());
			
			// Queue로 활용할 연결리스트 - 인덱스를 이용해 중간탐색(get)을 해야하기에, LinkedList로 객체 생성
			LinkedList<int[]> queue = new LinkedList<int[]>();
			
			// StringTokenizer의 기본 구분자는 공백 =>" " 생략 가능
			st = new StringTokenizer(br.readLine());
			// int[] 배열에 {초기위치, 중요도} 형태로 입력
			for (int i=0; i<N; i++) {
				queue.offer(new int[] {i, Integer.parseInt(st.nextToken())} );
			}
			
			// 출력할 횟수
			int count = 0;
			
			// 문서의 개수만큼 입력한 queue가 비어있게 될때까지 반복
			while (!queue.isEmpty()) {
				// 한 케이스에 대한 반복문
				// 가장 맨 앞의(첫번째) 원소
				int[] front = queue.poll();
				// front원소가 가장 큰 원소인지 판단하는 변수
				boolean MaxPriority = true;
				
				// queue에 남아있는 원소들과 중요도 비교
				for(int i=0; i<queue.size(); i++) {
					// 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 더 큰 경우
					// int[] {초기위치, 중요도}임을 이용하여 비교
					if(front[1] < queue.get(i)[1]) {
						// 인덱스를 이용해 중간탐색 => get(index)메소드: 지정한 인덱스에 위치한 요소를 반환
						
						// 뽑은 원소 및 i 이전의 원소들을 뒤로 보냄
						queue.offer(front);
						for (int j=0; j<i; j++) {
							queue.offer(queue.poll());
						}
						
						// front의 원소가 가장 큰 원소가 아니었기에, false로 값 업데이트
						MaxPriority = false;
						// 해당 for문(반복문)을 "즉시 종료" => 반복문을 빠져나감
						break;
					}
				}
				// 처음 뽑은 원소의 중요도가 가장 큰 경우(MaxPriority = true)
				
				// front의 원소가 가장 큰 원소가 아니었기에, 다음 반복문으로 이동
				if(MaxPriority == false) {		// if(!MaxPriority) {
					// 해당 i값 탐색을 마친 후(그 이후의 코드를 무시하고), 다음 for문으로 넘어감
					continue;	// 현재 반복단계를 건너뛰고 다음 반복문으로 넘어감
				}
				
				// front원소가 가장 큰 원소였기에, 해당 원소는 출력해야 함
				count++;	// count를 0으로 설정했기에, 일단 증가시켜줌
				// 찾고자하는 문서라면 해당 테스트케이스 종료
				if(front[0] == M) {
					break;
				}
			}
			// 해당 카운트값을 sb에 입력
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
}
