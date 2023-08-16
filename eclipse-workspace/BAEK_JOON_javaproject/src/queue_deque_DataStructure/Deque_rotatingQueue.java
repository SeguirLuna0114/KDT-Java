package queue_deque_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
	Deque 메소드
	* boolean offerLast(E e); 주어진 요소 e를 덱의 오른쪽(->) 끝에 추가
	* boolean offerFirst(E e); 주어진 요소 e를 덱(Deque)의 왼쪽(<-) 끝에 요소를 추가
	* pollFirst(): 덱의 첫 번째 요소를 제거하고 반환
	* pollLast(): 덱의 마지막 요소를 제거하고 반환
	
	N개의 원소를 포함하는 양방향 순환 큐에서 몇개의 원소를 뽑아내려고 함
	뽑아내려는 원소의 위치가 주어지고, 그 원소를 뽑아내는데 2,3번 연산의 최솟값을 출력
	
	1. 첫번째 원소를 뽑아낸 후, 제거
	2. 왼쪽으로 한칸 이동(a1 a2 ... an) -> (a2 ... an a1)
	3. 오른쪽으로 한 칸 이동(a1 a2 ... an) -> (an a1 ... an-1)
	
	=> 뽑고자 하는 원소가 덱의 "중앙"에서 끝쫏에 가까운 방향으로 이동/연산하여 뽑으려는 원소가 첫번째 위치에 갈때까지
 */
public class Deque_rotatingQueue {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 큐에 처음에 포함되어 있던 수 N과 지민이가 뽑아내려는 원소의 위치가 주어짐
		System.out.println("첫째줄에 큐에 처음에 포함되어 있던 수 N과 "
				+ "둘째줄에는 지민이가 뽑아내려는 원소의 위치(1 <= 위치 <= N)를 입력하세요");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// N개의 원소(큐의 크기)
		int outN = Integer.parseInt(st.nextToken());	// 뽑으려는 숫자의 개수
		
		// 덱을 사용하여 위 연산 수행
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		// 1부터 N까지 덱에 담아둠
		for(int i=1; i <= N; i++) {
			deque.offer(i);
		}
		
		// 뽑고자 하는 수를 담은 정수배열 형성
		int[] selectedN = new int[outN];
		
		// 둘째줄에 입력받은 지민이가 뽑아내려는 원소의 위치를 입력받음
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<outN; i++) {
			selectedN[i] = Integer.parseInt(st.nextToken());
		}
		
		// 2,3번 연산 횟수
		int count23=0;
		
		// 덱에서 뽑고자 하는 숫자의 위치(index) 찾기 
		for (int i=0; i<outN; i++) {
			int target_idx = deque.indexOf(selectedN[i]);
			// 뽑고자 하는 원소가 덱의 "중앙"에서 끝에 가까운 방향으로 이동/연산
			int half_idx;
			
			/*
			 * 	중간지점 인덱스 설정
			 *  만약 현재 덱의 원소가 짝수 개라면 중간 지점을 
			 *  현재 덱의 절반 크기에서 -1 감소시킨다. 
			 *  ex) {1, 2, 3, 4} 일 때, 2를 중간지점(인덱스는 1)이기 때문
			 *  ex) {1, 2, 3, 4, 5} 일 때는, 3이 중간지점(인덱스2)으로
			 */
			if(deque.size() % 2 == 0) {	// 원소 짝수개
				half_idx = (deque.size() / 2) - 1;
			}
			else {// 원소 홀수개
				half_idx = deque.size() / 2;
			}
			
			// 중간지점 또는 중간지점보다 원소의 위치가 앞에 있는 경우 => 2번연산 수행
			if(target_idx <= half_idx) {
				// target_idx보다 앞에있는 원소들을 모두 뒤로보냄(2번연산)
				for(int j=0; j<target_idx; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count23++;
				}
			}
			// 중간지점보다 원소의 위치가 뒤에있는 경우 => 3번연산 수행
			else {
				// target_idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보냄
				for(int j=0; j<deque.size()-target_idx; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count23++;
				}
			}
			// 연산이 끝나면 맨 앞 원소를 삭제
			deque.pollFirst();
		}
		System.out.println(count23);
	}
}
